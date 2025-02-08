import React from "react";
import { Link, useLocation } from "react-router-dom";
import "../styles/Dashboard.css"; // Import the CSS file

const Dashboard = () => {
  const location = useLocation();
  const username = location.state?.username || "Guest";

  return (
    <div className="dashboard-container">
      <h1 className="dashboard-title">Welcome, {username}</h1>
      <p className="dashboard-text">Select an option below:</p>

      <div className="dashboard-buttons">
        <Link to="/update" className="update-btn">
          Update User
        </Link>
        <Link to="/delete" className="delete-btn">
          Delete User
        </Link>
        <Link to="/logout" className="logout-btn">
          Logout
        </Link>
      </div>
    </div>
  );
};

export default Dashboard;
