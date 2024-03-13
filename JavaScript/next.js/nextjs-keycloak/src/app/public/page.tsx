import { getServerSession } from 'next-auth';
import { authOptions } from '../api/auth/[...nextauth]/route';
import SignoutOfKeycloak from '@/app/components/signout-of-keycloak';
import SigininWithKeycloak from '@/app/components/signin-with-keycloak';

export default async function Public() {
  const session = await getServerSession(authOptions)
  if (session) {
    return <div className='flex flex-col space-y-3 justify-center items-center h-screen'>
      <div>You are accessing a public page</div>
      <div>Your name is {session.user?.name}</div>
      <div>
        <SignoutOfKeycloak />
      </div>
    </div>
  }
  return (
    <div className='flex flex-col space-y-3 justify-center items-center h-screen'>
      <div>You are accessing a public page</div>
      <div>
        <SigininWithKeycloak />
      </div>
    </div>
  )
}
