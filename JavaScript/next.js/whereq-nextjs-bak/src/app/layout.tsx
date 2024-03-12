import React from "react";
import { Box, Container } from "@mui/material";
import Navbar from "./components/navbar";
import Footer from "./components/footer";

const Layout: React.FC<{ children: React.ReactNode }> = ({ children }) => {
  return (
    <>
      <Navbar />
      <Box mt={8} display="flex" minHeight="calc(100vh - 64px)">
        <Box width="20%" bgcolor="lightblue">
          Left Panel
        </Box>
        <Box width="80%" bgcolor="lightgrey" overflow="auto">
          {children}
        </Box>
      </Box>
      <Footer />
    </>
  );
};

export default Layout;
