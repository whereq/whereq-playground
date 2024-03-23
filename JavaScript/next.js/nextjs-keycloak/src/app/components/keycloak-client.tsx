"use client"
import { authOptions } from "@/lib/auth/auth-options";
import { getServerSession } from "next-auth";
import { getSession } from "next-auth/react";
import KeycloakAdminClient from "@keycloak/keycloak-admin-client";

  
export default function keycloakClient() {  

  const handleButtonClick = async () => {
    const session = await getSession()
    const userId = session?.user?.id;
    const userEmail = session?.user?.email;
    // const kcAdminClient = new KeycloakAdminClient({baseUrl: "http://localhost:8080", realmName: "whereq"});
    const kcAdminClient = new KeycloakAdminClient({baseUrl: "https://keytomarvel.com", realmName: "whereq"});
    await kcAdminClient.auth({
      grantType: "client_credentials",
      clientId: "Vegeta",
      // clientSecret: "A9xx9P5lEfvEQaqQUAPAb0Am6qNSV6AA",
      clientSecret: "7nFInd42hPl1Uz9jkepZpCm7n0OPQVCK",
    });

    if (userId) {
      const userArray = await kcAdminClient.users.find({id: userId});
      if (userArray && userArray.length > 0) {
        console.log(userArray[0]);
        console.log(userArray[0].attributes);
        if (userArray[0].attributes && userArray[0].attributes.avatar && userArray[0].attributes.avatar.length > 0) {
          console.log(userArray[0].attributes.avatar[0]);
        }
      }
    }
  };

  return <button onClick={handleButtonClick}>  
    keycloak client
  </button>  
}
