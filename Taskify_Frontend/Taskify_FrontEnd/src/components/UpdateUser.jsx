import React, { useState } from 'react';
import axios from 'axios';

const UpdateUser = () => {
    const [user, setUser] = useState({
        username: "",
        password: "",
        newpassword: ""  // Added new password field
    });

    // Handle input changes
    const handleChange = (e) => {
        setUser({ ...user, [e.target.name]: e.target.value });
    };

    // Handle form submission
    const handleSubmit = async (e) => {
        e.preventDefault();
        const token = localStorage.getItem("token"); // Assuming authentication token is stored

        try {
            await axios.put("http://localhost:8080/Api/User/UpdatePassword", null, {
                params: {
                    username: user.username,
                    password: user.password,
                    newpassword: user.newpassword  // Sending correct parameter
                },
                headers: { Authorization: `Bearer ${token}` } // If authentication is required
            });

            alert("Password updated successfully!");
        } catch (err) {
            console.error("Error updating password:", err);
            alert("Password update failed! Check your credentials.");
        }
    };

    return (
        <div className="update-container">
            <h2>Update Password</h2>
            <form onSubmit={handleSubmit}>
                <input type="text" name="username" placeholder="Username" onChange={handleChange} required />
                <input type="password" name="password" placeholder="Current Password" onChange={handleChange} required />
                <input type="password" name="newpassword" placeholder="New Password" onChange={handleChange} required />
                <button type="submit">Update Password</button>
            </form>
        </div>
    );
};

export default UpdateUser;
