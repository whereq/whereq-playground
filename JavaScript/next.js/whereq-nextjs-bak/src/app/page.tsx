import React from "react";
import Layout from "./layout";
import { Container } from "@mui/material";

const Home: React.FC = () => {
  return (
    <Layout>
      <Container>
        <h1>Main Content Area</h1>
        <p>Scrollable content...</p>
      </Container>
    </Layout>
  );
};

export default Home;
