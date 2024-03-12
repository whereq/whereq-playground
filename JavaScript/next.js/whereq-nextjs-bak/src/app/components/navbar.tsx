"use client"

import React from "react";
import { AppBar, Toolbar, Button } from "@mui/material";
import LoginModal from "./login-modal";

const Navbar: React.FC = () => {
  const [loginModalOpen, setLoginModalOpen] = React.useState(false);

  const handleLoginButtonClick = () => {
    setLoginModalOpen(true);
  };

  const handleCloseLoginModal = () => {
    setLoginModalOpen(false);
  };

  return (
    <>
      <AppBar position="fixed">
        <Toolbar>
          <Button color="inherit" onClick={handleLoginButtonClick}>
            Login
          </Button>
        </Toolbar>
      </AppBar>
      <LoginModal open={loginModalOpen} onClose={handleCloseLoginModal} />
    </>
  );
};

export default Navbar;
