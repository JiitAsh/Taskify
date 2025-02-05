import React from "react";
import { Link } from "react-router-dom";
import "./Home.css"; // Import CSS file

const Home = () => {
  return (
    <div className="home-container">
      <div className="box">
        <h1 className="welcome-text">Let finish the work—Join us today!</h1>
        <div className="button-group">
          <Link to="/login" className="login-button">
            Login
          </Link>
          <p className="signup-text">
            New user?{" "}
            <Link to="/register" className="signup-link">
              Sign up
            </Link>
          </p>
        </div>
      </div>
    </div>
  );
};

export default Home;
