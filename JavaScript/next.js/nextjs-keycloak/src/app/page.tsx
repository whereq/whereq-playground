import { getServerSession } from 'next-auth'  
import { authOptions } from "@/lib/auth/auth-options";
import SigninWithKeycloak from './components/signin-with-keycloak'
import SignoutOfKeycloak from './components/signout-of-keycloak';
import KeycloakClient from './components/keycloak-client';

export default async function Home() {  
  const session = await getServerSession(authOptions)  
  console.log("session", session);
  if (session) {  
    return <div>  
      <div>Your name is {session.user?.name}</div>  
      <div><SignoutOfKeycloak /></div>
      <div>
        <KeycloakClient />
      </div>
    </div>  
  }  
  return (  
    <>
      <div>
        <SigninWithKeycloak />
      </div>
      <div>
        <KeycloakClient />
      </div>
    </>
  )
}