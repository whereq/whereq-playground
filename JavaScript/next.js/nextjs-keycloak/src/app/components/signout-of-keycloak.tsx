"use client"  
import { signOut } from "next-auth/react";  
export default function signoutOfKeycloak() {  
  return <button onClick={() => signOut()}>  
    Signout of keycloak  
  </button>  
}