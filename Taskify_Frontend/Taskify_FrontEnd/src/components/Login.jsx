import React, { useState, useContext } from "react";
import axios from "axios";
import { Link, useNavigate } from "react-router-dom";
import { UserContext } from "../UserContext"; // Import Context
import "../styles/Login.css";
import logo from "../assets/images/favicon-taskify.png";

const Login = () => {
  const navigate = useNavigate();
  const { setUsername } = useContext(UserContext); // Access Context API

  const [credentials, setCredentials] = useState({
    username: "",
    password: "",
  });

  // Handle input change
  const handleChange = (e) => {
    setCredentials({ ...credentials, [e.target.name]: e.target.value });
  };

  // Handle form submission
  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const res = await axios.post(
        `http://localhost:8080/Api/User/Signin`, // API endpoint for signin
        null,
        {
          params: {
            username: credentials.username,
            password: credentials.password,
          },
        }
      );

      if (res.data === true) {
        setUsername(credentials.username); // Store username in context
        alert("Login successful!");
        navigate("/dashboard"); // Redirect to the dashboard on successful login
      } else {
        alert("Invalid Username or Password! Please try again.");
      }
    } catch (err) {
      console.error("Login Error:", err);
      alert("Login failed! Please check your credentials.");
    }
  };

  return (
    <div className="login-container">
      <div className="login-box">
        <div className="logo">
          <img src={logo} alt="Logo" className="logo-img" />
          <h2 className="logo-name">Taskify</h2>
        </div>
        <form onSubmit={handleSubmit}>
          <input
            type="text"
            name="username"
            placeholder="Username"
            onChange={handleChange}
            required
          />
          <input
            type="password"
            name="password"
            placeholder="Password"
            onChange={handleChange}
            required
          />
          <button type="submit" className="login-btn">
            Login
          </button>
        </form>
        <div className="signup-link">
          <p>
            New user?{" "}
            <Link to="/Register" className="signup-btn">
              Sign Up
            </Link>
          </p>
        </div>
      </div>
    </div>
  );
};

export default Login;
