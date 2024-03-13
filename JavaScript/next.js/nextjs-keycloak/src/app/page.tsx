import { getServerSession } from 'next-auth'  
import { authOptions } from './api/auth/[...nextauth]/route'  
import Signin from './components/signin-with-keycloak'
import SignoutOfKeycloak from './components/signout-of-keycloak'  
export default async function Home() {  
  const session = await getServerSession(authOptions)  
  if (session) {  
    return <div>  
      <div>Your name is {session.user?.name}</div>  
      <div><SignoutOfKeycloak /> </div>  
    </div>  
  }  
  return (  
    <div>  
      <Signin />  
    </div>  
  )  
}