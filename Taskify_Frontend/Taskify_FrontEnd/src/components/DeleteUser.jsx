import React, { useState } from "react";
import axios from "axios";
import "../styles/DeleteUser.css"; // Import CSS file
import logo from "../assets/images/favicon-taskify.png"; // Add logo image path

const DeleteUser = () => {
  const [user, setUser] = useState({
    username: "",
    password: "",
  });

  const handleChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const token = localStorage.getItem("token");

    try {
      const res = await axios.put(
        "http://localhost:8080/Api/User/Delete",
        null,
        {
          params: {
            username: user.username,
            password: user.password,
          },
          headers: {
            Authorization: `Bearer ${token}`,
          },
        }
      );

      alert(res.data);
    } catch (err) {
      console.error("Delete Error:", err);
      alert("Failed to delete user! Check username and password.");
    }
  };

  return (
    <div className="delete-container">
      <div className="delete-box">
        <div className="logo">
          <img src={logo} alt="Logo" className="logo-img" />
          <h2 className="logo-name">Taskify</h2>
        </div>
        <h2>Delete Account</h2>
        <form onSubmit={handleSubmit}>
          <input
            type="text"
            name="username"
            placeholder="Username"
            value={user.username}
            onChange={handleChange}
            required
          />
          <input
            type="password"
            name="password"
            placeholder="Password"
            value={user.password}
            onChange={handleChange}
            required
          />
          <button type="submit" className="delete-btn">
            Delete Account
          </button>
        </form>
      </div>
    </div>
  );
};

export default DeleteUser;
