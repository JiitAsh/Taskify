import React from "react";
import { Link } from "react-router-dom";
const Dashboard = ()     => {
    const username = location.state?.username || "Guest"; 
  return (
    <div className="container text-center mt-5">
      <h1>Welcome, {username}</h1>
      <p>Select an option below:</p>
      
      <div className="d-flex flex-column align-items-center gap-3 mt-4">
        <Link to="/update" className="btn btn-primary">
          Update User
        </Link>
        <br />
        <Link to="/delete" className="btn btn-danger">
          Delete User
        </Link>
        <br />
        <Link to="/logout" className="btn btn-secondary">
          Logout
        </Link>
      </div>
    </div>
  );
};

export default Dashboard;
