import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import "../styles/Register.css"; // Import updated styles
import logo from "../assets/images/favicon-taskify.png";

const Register = () => {
  const navigate = useNavigate();

  // State to manage form input values
  const [user, setUser] = useState({
    id: "", // Will be auto-generated by the backend
    firstname: "",
    lastname: "",
    username: "",
    phoneno: "",
    password: "",
    email: "",
    category: "CUSTOMER", // Default category
    deleteflag: false, // Default value
  });

  // State to manage errors
  const [error, setError] = useState("");

  // Handle input change
  const handleChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  // Handle form submission
  const handleSubmit = async (e) => {
    e.preventDefault();

    // Basic validation
    if (
      !user.firstname ||
      !user.lastname ||
      !user.username ||
      !user.password ||
      !user.email ||
      !user.phoneno
    ) {
      setError("All fields are required!");
      return;
    }

    try {
      const response = await axios.post(
        "http://localhost:8080/Api/User/Register",
        user
      );
      console.log("Registration successful:", response.data);
      alert("Registration successful! Redirecting to Sign In...");
      navigate("/login"); // Redirect to Signin page after successful registration
    } catch (err) {
      console.error("Error during registration:", err);
      setError("Failed to register. Please try again.");
    }
  };

  return (
    <div className="register-page">
      <div className="register-form-container">
        <div className="logo-container">
          <img src={logo} alt="Logo" className="logo" />
          <h1 className="logo-text">Taskify</h1>
        </div>
        <h2>Begin your journey</h2>
        {error && <p className="error-message">{error}</p>}
        <form onSubmit={handleSubmit}>
          <div className="form-group">
            <input
              type="text"
              name="firstname"
              placeholder="First Name"
              onChange={handleChange}
            />
          </div>
          <div className="form-group">
            <input
              type="text"
              name="lastname"
              placeholder="Last Name"
              onChange={handleChange}
            />
          </div>
          <div className="form-group">
            <input
              type="text"
              name="username"
              placeholder="Username"
              onChange={handleChange}
            />
          </div>
          <div className="form-group">
            <input
              type="text"
              name="phoneno"
              placeholder="Phone Number"
              onChange={handleChange}
            />
          </div>
          <div className="form-group">
            <input
              type="password"
              name="password"
              placeholder="Password"
              onChange={handleChange}
            />
          </div>
          <div className="form-group">
            <input
              type="email"
              name="email"
              placeholder="Email"
              onChange={handleChange}
            />
          </div>
          <div className="form-group">
            <select
              name="category"
              value={user.category}
              onChange={handleChange}
            >
              <option value="CUSTOMER">Customer</option>
              <option value="TASKER">Tasker</option>
              <option value="BOTH">Both</option>
            </select>
          </div>
          <button type="submit">Register</button>
        </form>
      </div>
    </div>
  );
};

export default Register;
