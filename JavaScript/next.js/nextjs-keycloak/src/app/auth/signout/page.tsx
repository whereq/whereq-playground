import { authOptions } from "@/lib/auth/auth-options";
import SignoutOfKeycloak from "@/app/components/signout-of-keycloak";
import { getServerSession } from "next-auth";
import { redirect } from "next/navigation";


export default async function SignoutPage() {
  const session = await getServerSession(authOptions);
  if (session) {
    return (
      <div className="flex flex-col space-y-3 justify-center items-center h-screen">
        <div className="text-xl font-bold">Signout</div>
        <div>Are you sure you want to sign out?</div>
        <div>
          <SignoutOfKeycloak /> {/* Use the signoutOfKeycloak component */}
        </div>
      </div>
    )
  }
  return redirect("/api/auth/signin")
}
