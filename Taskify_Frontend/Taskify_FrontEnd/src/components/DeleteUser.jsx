import React, { useState } from "react";
import axios from "axios";

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
        "http://localhost:8080/Api/User/Delete", // Ensure this URL is correct
        null, // No request body, only params
        {
          params: {
            username: user.username,  // Send username as query parameter
            password: user.password,  // Send password as query parameter
          },
          headers: {
            Authorization: `Bearer ${token}`, // Add token to headers for authentication
          },
        }
      );

      alert(res.data); // Show success message
    } catch (err) {
      console.error("Delete Error:", err);
      alert("Failed to delete user! Check username and password.");
    }
  };

  return (
    <div className="delete-container">
      <h2>Delete Account</h2>
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
        <button type="submit">Delete Account</button>
      </form>
    </div>
  );
};

export default DeleteUser;
