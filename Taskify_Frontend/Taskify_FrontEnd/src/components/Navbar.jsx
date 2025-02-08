import React from "react";
import { Link } from "react-router-dom";
import "../styles/Navbar.css"; // Link to your custom CSS
import logo from "../assets/images/favicon-taskify.png";

const Navbar = () => {
  return (
    <header>
      <nav className="navbar">
        <div className="navbar-container">
          <Link className="navbar-brand" to="/">
            Taskify
          </Link>
          <ul className="navbar-links">
            <li>
              <Link className="nav-link" to="/how-it-works">
                How It Works
              </Link>
            </li>
            <li>
              <Link className="nav-link" to="/login">
                Signup/Login
              </Link>
            </li>
          </ul>
        </div>
      </nav>
    </header>
  );
};

export default Navbar;
