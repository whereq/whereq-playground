"use client"  
// import { signOut } from "next-auth/react";  
import federatedSignOut from "../utils/federated-signout";  
export default function signoutOfKeycloak() {  
  // Instead of calling the native signOut, call federatedSignOut to signout of keycloak
  // return <button onClick={() => signOut()}>  
    return <button onClick={() => federatedSignOut()}>  
    Signout of keycloak  
  </button>  
}