import React, { useState } from "react";
import axios from "axios";
import "../styles/UpdateUser.css";
import logo from "../assets/images/favicon-taskify.png"; // Add your logo path

const UpdateUser = () => {
  const [user, setUser] = useState({
    username: "",
    password: "",
    newpassword: "",
  });

  const handleChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const token = localStorage.getItem("token");

    try {
      await axios.put("http://localhost:8080/Api/User/UpdatePassword", null, {
        params: {
          username: user.username,
          password: user.password,
          newpassword: user.newpassword,
        },
        headers: { Authorization: `Bearer ${token}` },
      });

      alert("Password updated successfully!");
    } catch (err) {
      console.error("Error updating password:", err);
      alert("Password update failed! Check your credentials.");
    }
  };

  return (
    <div className="update-container">
      <div className="update-box">
        <div className="logo">
          <img src={logo} alt="Taskify Logo" className="logo-img" />
          <h1 className="logo-name">Taskify</h1>
        </div>
        <h2>Update Password</h2>
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
            placeholder="Current Password"
            onChange={handleChange}
            required
          />
          <input
            type="password"
            name="newpassword"
            placeholder="New Password"
            onChange={handleChange}
            required
          />
          <button type="submit" className="update-btn">
            Update Password
          </button>
        </form>
      </div>
    </div>
  );
};

export default UpdateUser;
