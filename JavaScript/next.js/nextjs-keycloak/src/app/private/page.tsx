import { getServerSession } from 'next-auth';
import SignoutOfKeycloak from '@/app/components/signout-of-keycloak';
import { authOptions } from "@/lib/auth/auth-options";

export default async function Private() {
  const session = await getServerSession(authOptions)
  if (session) {
    return <div className='flex flex-col space-y-3 justify-center items-center h-screen'>
      <div>You are accessing a private page</div>
      <div>Your name is {session.user?.name}</div>
      <div>
        <signoutOfKeycloak />
      </div>
    </div>
  }
}
