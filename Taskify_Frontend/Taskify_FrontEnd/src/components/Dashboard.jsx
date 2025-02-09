import React from "react";
import { Link, useLocation } from "react-router-dom";
import "../styles/Dashboard.css";
import Card from "./Card";

// Import service images
import moving from "../assets/images/moving.jpg";
import furnitureImage from "../assets/images/furniture.png";
import electricianImage from "../assets/images/electrician.jpg";
import plumbingImage from "../assets/images/plumbing.jpeg";
import cleaning from "../assets/images/cleaning.jpg";
import AllServices from "../services/AllServices";

const Dashboard = () => {
  const location = useLocation();
  const username = location.state?.username || "Guest";

  return (
    <div className="dashboard-container">
      {/* Dashboard Header */}
      <div className="dashboard-header">
        <h1 className="dashboard-title">Welcome, {username}</h1>
        <p className="dashboard-subtitle">
          Manage your tasks or explore our services:
        </p>
      </div>

      {/* Dashboard Buttons */}
      <div className="dashboard-buttons">
        <Link to="/my-tasks" className="dashboard-btn my-tasks-btn">
          My Tasks
        </Link>
        <Link to="/all-tasks" className="dashboard-btn all-tasks-btn">
          All Tasks
        </Link>
        <Link to="/update" className="dashboard-btn update-user-btn">
          Update User
        </Link>
        <Link to="/delete" className="dashboard-btn delete-user-btn">
          Delete User
        </Link>
        <Link to="/logout" className="dashboard-btn logout-btn">
          Logout
        </Link>
      </div>

      {/* Service Section */}
      <h2 className="service-heading">Our Services</h2>
      <div className="card-container">
        <AllServices />
        {/* <Card
          image={moving}
          title="Moving"
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
          text="Professional home and office cleaning services."
          link="/service/cleaning"
        /> */}
      </div>
    </div>
  );
};

export default Dashboard;
