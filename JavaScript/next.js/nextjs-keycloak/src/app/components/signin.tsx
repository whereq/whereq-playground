"use client"  
import { signIn } from "next-auth/react";  
export default function Signin() {  
  return <button onClick={() => signIn("keycloak")}>  
    Signin with keycloak  
  </button>  
}