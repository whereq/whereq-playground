"use client"
import { authOptions } from "@/lib/auth/auth-options";
import { getServerSession } from "next-auth";
import { getSession } from "next-auth/react";
import KeycloakAdminClient from "@keycloak/keycloak-admin-client";

  
export default function keycloakClient() {  

  const handleButtonClick = async () => {
    const session = await getSession({}) ?? {} as { accessToken: string }; // Add type assertion for session object
    console.log('test');
    console.log(session.accessToken);
    const kcAdminClient = new KeycloakAdminClient({baseUrl: "http://localhost:8080", realmName: "whereq"});
    await kcAdminClient.auth({
      grantType: "client_credentials",
      clientId: "Vegeta",
      clientSecret: "A9xx9P5lEfvEQaqQUAPAb0Am6qNSV6AA",
    });

    if (session.accessToken) {
      kcAdminClient.users.find().then((info) => {
        console.log(info);
      });
    }
  };

  return <button onClick={handleButtonClick}>  
    keycloak client
  </button>  
}
