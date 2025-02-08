import React from "react";
import { Link } from "react-router-dom";
import "../styles/Home.css"; // Import the CSS file
import Navbar from "./Navbar"; // Import Navbar component
import Footer from "./Footer";
import Card from "./Card";

// Importing images
import moving from "../assets/images/moving.jpg";
import furnitureImage from "../assets/images/furniture.png";
import electricianImage from "../assets/images/electrician.jpg";
import plumbingImage from "../assets/images/plumbing.jpeg";
import cleaning from "../assets/images/cleaning.jpg";

const Home = () => {
  return (
    <>
      {/* Navbar */}
      <Navbar />

      {/* Hero Section */}
      <section className="hero">
        <div className="hero-content">
          <h1>Welcome to Taskify</h1>
          <p>Your go-to platform for seamless task management.</p>
        </div>
      </section>

      {/* Service Cards */}
      <main className="main-content">
        <div className="card-container">
          <Card
            image={moving}
            title="Moving Houses"
            text="Reliable and affordable moving services to help you relocate with ease."
            link="/service/moving"
          />

          <Card
            image={furnitureImage}
            title="Furniture"
            text="Furniture assembly, repair, and custom design services."
            link="/service/furniture"
          />
          <Card
            image={electricianImage}
            title="Electrician"
            text="Expert electrical services for residential and commercial needs."
            link="/service/electrician"
          />
          <Card
            image={plumbingImage}
            title="Plumbing"
            text="Reliable plumbing services for any issues, big or small."
            link="/service/plumbing"
          />
          <Card
            image={cleaning}
            title="Cleaning"
            text="Reliable Cleaning services for Home."
            link="/service/cleaning"
          />
        </div>
      </main>

      {/* Footer */}
      <Footer />
    </>
  );
};

export default Home;
