# Implementing Authentication in Next.js Application with Keycloak

## Create and Init
```bash
yarn create next-app
```

```
success Installed "create-next-app@14.1.3" with binaries:
      - create-next-app
√ What is your project named? ... nextjs-keycloak
√ Would you like to use TypeScript? ... No / Yes
√ Would you like to use ESLint? ... No / Yes
√ Would you like to use Tailwind CSS? ... No / Yes
√ Would you like to use `src/` directory? ... No / Yes
√ Would you like to use App Router? (recommended) ... No / Yes
√ Would you like to customize the default import alias (@/*)? ... No / Yes
```

## Install  [next-auth](https://next-auth.js.org/)  as a dependency 
```bash
cd nextjs-keycloak
yarn add next-auth
```
## Implementation
### 1. Extend the `ProcessEnv` interface with the following steps.
In the root of the project, create a `types` folder, and then create a file named `node-env.d.ts` within this folder.

```
mkdir types
touch types/node-env.d.ts
```
|![Extend the ProcessEnv](./images/node-env.d.ts.png)|
|:-:|
|types/node-env.d.ts in the root of the project|

- Extend the `ProcessEnv` with the code below
```typescript
// types/node-env.d.ts
declare namespace NodeJS {
  export interface ProcessEnv {
    KEYCLOAK_CLIENT_ID: string
    KEYCLOAK_CLIENT_SECRET: string
    KEYCLOAK_ISSUER: string
  }
}
```

### 2. Create `.env.local` to load environment variables
In the root of the project, create a `.env.local` file to add the environment variables defined in `types/node-env.d.ts`.

`KEYCLOAK_CLIENT_ID`, `KEYCLOAK_CLIENT_SECRET` and `KEYCLOAK_ISSUER` are configured in `Keycloak`, they will be used to fetch access token from `Keycloak`. 

`NEXTAUTH_URL` and `NEXTAUTH_SECRET` are essential for configuring of `next-auth`. 
To know more, check this [NextAuth Environment Variables](https://next-auth.js.org/configuration/options#environment-variables).
**.env.local**
```
KEYCLOAK_CLIENT_ID="Vegeta"
KEYCLOAK_CLIENT_SECRET="mPs1i3ngKZHgAnVfkf87faRBt58KzHOt"
KEYCLOAK_ISSUER="http://localhost:8080/realms/whereq"
NEXTAUTH_URL="http://localhost:3000"
NEXTAUTH_SECRET=YpeSrq7KUsCAfQFZn4txgmUO/YMkHw2VW5idf59ljaI=
```

**NOTE**: the secret `NEXTAUTH_SECRET` is used to sign and encrypt cookies, it can be created by the command below
```bash
openssl rand -base64 32
```

### 3. Configure the  `authOptions`  with  `KeycloakProvider`  for  `next-auth`  and initialize route handler.

The code below will configure Keycloak provider from the environment variables.
```typescript
// src/app/api/auth/[...nextauth]/route.ts
import { AuthOptions } from "next-auth";
import NextAuth from "next-auth";
import KeycloakProvider from "next-auth/providers/Keycloak"
export const authOptions: AuthOptions = {
  providers: [
    KeycloakProvider({
      clientId: process.env.KEYCLOAK_CLIENT_ID,
      clientSecret: process.env.KEYCLOAK_CLIENT_SECRET,
      issuer: process.env.KEYCLOAK_ISSUER
    })
  ]
}
const handler = NextAuth(authOptions);
export { handler as GET, handler as POST }
```

## The first initial test with `next-auth` native `signin` library

Run the application
```bash
yarn dev
```

Once the application started, go to [http://localhost:3000/api/auth/signin](http://localhost:3000/api/auth/signin)
**NOTE**: the route `signin` is provided by `next-auth` library  

If everything works as expected, the `next-auth` sign-in page will be shown

|![NextAuth sign-in page](./images/next-auth-signin-library.png)|
|:-:|
|The sign-in page provided by `next-auth` library|

Click the sign-in button `Sign-in with Keycloak`, the route will be redirected to `Keycloak` sign-in page
|![Keycloak Sign-in](./images/keycloak-signin-page.png)|
|:-:|
|`Keycloak` sign-in page|

### 4. Setup Basic React Server component

Let’s setup a basic server component which will show protected data when authenticated and would prompt login when unauthenticated.

Modify  `src/app/page.tsx`  with the following code.
```typescript
// src/app/page.tsx  
import { getServerSession } from 'next-auth'  
import { authOptions } from './api/auth/[...nextauth]/route'  
import Login from '../components/Login'  
import Logout from '../components/Logout'  
export default async function Home() {  
  const session = await getServerSession(authOptions)  
  if (session) {  
    return <div>  
      <div>Your name is {session.user?.name}</div>  
      <div><Logout /> </div>  
    </div>  
  }  
  return (  
    <div>  
      <Login />  
    </div>  
  )  
}
```

Also create the  `Login`  and  `Logout`  component by creating the following files.

mkdir src/components &&  touch src/components/Login.tsx && touch src/components/Logout.tsx

Add the following contents to Login and Logout component.
```typescript
// src/components/Login.tsx  
"use client"  
import { signIn } from "next-auth/react";  
export default function Login() {  
  return <button onClick={() => signIn("keycloak")}>  
    Signin with keycloak  
  </button>  
}

// src/components/Logout.tsx  
"use client"  
import { signOut } from "next-auth/react";  
export default function Logout() {  
  return <button onClick={() => signOut()}>  
    Signout of keycloak  
  </button>  
}
```

> Notice the  `_use client_`  directive . This directive is a convention to declare a boundary between a Server and Client Component module graph.

### Demo so far
- Step 1. Open the application at [http://localhost:3000/](http://localhost:3000/)
Click the sign-in button `Signin with Keycloak`, the route will be redirected to `Keycloak` sign-in page

|![Keycloak Sign-in](./images/1st-round-demo-1.png)|
|:-:|
|`Keycloak` sign-in page|


- Step 2. Sign-in in `Keycloak`
Sign in to `Keycloak` with the user `foo.bar` which has already been created in `Keycloak`. In this scenario, the `Google Provider` has also been configured in `Keycloak`, allowing you to sign in with your Google account if desired.

|![Keycloak Sign-in](./images/1st-round-demo-2.png)|
|:-:|
|Sign-in in `Keycloak`|

- Step 3. Sign-out 
Upon signing in, the name associated with the signed-in account will be displayed on the page alongside the `Signout of keycloak` button.

|![Keycloak Sign-out](./images/1st-round-demo-3.png)|
|:-:|
|Sign-out|

- Step 4. After Sign-out
Click the `Signout of keycloak` button to log out. You will then be redirected to the sign-in page.

|![Keycloak Sign-in](./images/1st-round-demo-1.png)|
|:-:|
|`Keycloak` sign-in page|


## One step futher
There is one thing that might catch your attention: at `Step 4` above, when you click the "Sign out of Keycloak" button to log out of the current account right after signed in, you will be redirected to the sign-in page. Then, if you click the "Sign in with Keycloak" button again, you will be redirected directly to `Step 3`, "Sign out of Keycloak," with your account information shown on the page. This bypasses `Step 2`, "Sign in with Keycloak." Why does this happen?


## Refreshing access token
### JWT session strategy
By default, `next-auth` employs a JWT session strategy. This means that all the session data required for user authentication is stored in the browser as **encrypted cookies**. The encryption of these cookies is based on the `NEXTAUTH_SECRET` configuration(**Configured in `.env.local`**). With the JWT session strategy, `next-auth` allows the storage of session data such as access tokens, refresh tokens, ID tokens, as well as session metadata like name and image, in the user's browser as encrypted cookies. This approach eliminates the need for a database to store session-related information.

### Storing tokens and session metadata in Browser side
We will utilize [callbacks](https://next-auth.js.org/configuration/callbacks), which hook into different stages of the authentication lifecycle to incorporate our specific requirements.

To achieve this, we'll include `jwt` and `session` callbacks in the `authOptions`. These callbacks will assist us in storing tokens and session metadata.

```typescript
// src/app/api/auth/[...nextauth]/route.ts
export const authOptions: AuthOptions = {
  ...
  ...
  session: {
    maxAge: 60 * 30
  },
  callbacks: {
    async jwt({ token, account }) {
      if (account) {
        token.idToken = account.id_token
        token.accessToken = account.access_token
        token.refreshToken = account.refresh_token
        token.expiresAt = account.expires_at
      }
      return token
    },
    async session({ session, token }) {
      session.accessToken = token.accessToken
      return session
    }
  }
}
```

# Terms:
## Federated Sign-out
Federated sign-out is the situation where a user has used an external identity provider to log into `Keycloak`, and then the user logs out of that external identity provider via a workflow unknown to the application/website. When the user signs out, it will be useful for the application/website to be notified so that it can sign the user out of IdentityServer and all of the applications that use IdentityServer.

# Troubleshooting:
## [Unable to connect to establish a TCP connection (ECONNREFUSED) #40702](https://github.com/nodejs/node/issues/40702)

### Issue:
```
https://next-auth.js.org/errors#signin_oauth_error connect ECONNREFUSED ::1:8080 {
  error: {
    message: 'connect ECONNREFUSED ::1:8080',
    stack: 'Error: connect ECONNREFUSED ::1:8080\n' +
      '    at TCPConnectWrap.afterConnect [as oncomplete] (node:net:1494:16)\n' +
      '    at TCPConnectWrap.callbackTrampoline (node:internal/async_hooks:130:17)',
    name: 'Error'
  },
  providerId: 'keycloak',
  message: 'connect ECONNREFUSED ::1:8080'
}
```

### Solution:
Start the server with the following options.
```
NODE_OPTIONS='--dns-result-order=ipv4first' npm run dev
```

## Type error: Type'OmitWithTag<typeof ...

### Issue:
```
.next/types/app/api/auth/[...nextauth]/route.ts:8:13
Type error: Type 'OmitWithTag<typeof import("C:/Users/googo/whereq/git/whereq-playground/JavaScript/next.js/nextjs-keycloak/src/app/api/auth/[...nextauth]/route"), "dynamic" | "config" | "generateStaticParams" | ... 12 more ... | "PATCH", "">' does not satisfy the constraint '{ [x: string]: never; }'.
  Property 'authOptions' is incompatible with index signature.
    Type 'AuthOptions' is not assignable to type 'never'.

   6 |
   7 | // Check that the entry is a valid entry
>  8 | checkFields<Diff<{
     |             ^
   9 |   GET?: Function
  10 |   HEAD?: Function
  11 |   OPTIONS?: Function
error Command failed with exit code 1.
info Visit https://yarnpkg.com/en/docs/cli/run for documentation about this command.
```

**NOTE**: This issue is only occurred when build with `next` version **14** and above.

**package.json**
```json
  "dependencies": {
    "next": "14.1.3",
    "next-auth": "^4.24.7",
    "react": "^18",
    "react-dom": "^18"
  },
```

### Solution:
[Enable the `ignoreBuildErrors` option](https://nextjs.org/docs/pages/api-reference/next-config-js/typescript)

So far I'd rather say this is a workaround instead of a solution.

If you have `next.config.mjs` in the project root folder, then

```typescript
// next.config.mjs
/** @type {import('next').NextConfig} */
const nextConfig = {
  typescript: {
    // !! WARN !!
    // Dangerously allow production builds to successfully complete even if
    // your project has type errors.
    // !! WARN !!
    ignoreBuildErrors: true,
  },
};

export default nextConfig;
```

If you have `next.config.js` in the project root folder, then

```typescript
// next.config.js
module.exports = {
  typescript: {
    // !! WARN !!
    // Dangerously allow production builds to successfully complete even if
    // your project has type errors.
    // !! WARN !!
    ignoreBuildErrors: true,
  },
}
```

# References:
[NextAuth.js Example](https://next-auth-example.vercel.app/)
[NextAuth Environment Variables](https://next-auth.js.org/configuration/options#environment-variables)
[Federated Sign-out](https://identityserver4.readthedocs.io/en/latest/topics/signout_federated.html#:~:text=Federated%20sign%2Dout%20is%20the,a%20workflow%20unknown%20to%20IdentityServer.)
[How to implement single sign-out in Keycloak with Spring Boot](https://developers.redhat.com/articles/2022/12/07/how-implement-single-sign-out-keycloak-spring-boot)
[Implementing Authentication in Next.js v13 Application with Keycloak(Part — 1)](https://medium.com/inspiredbrilliance/implementing-authentication-in-next-js-v13-application-with-Keycloak-part-1-f4817c53c7ef)
[Implementing Authentication in Next.js v13 Application with Keycloak(Part — 2)](https://medium.com/inspiredbrilliance/implementing-authentication-in-next-js-v13-application-with-Keycloak-part-2-6f68406bb3b5)