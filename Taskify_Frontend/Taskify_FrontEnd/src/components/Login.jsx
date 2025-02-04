import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const Login = () => {
    const navigate = useNavigate();

    // State for login credentials
    const [credentials, setCredentials] = useState({
        username: "",  // Changed from email to username
        password: ""
    });

    // Handle input change
    const handleChange = (e) => {
        setCredentials({ ...credentials, [e.target.name]: e.target.value });
    };

    // Handle form submission
    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const res = await axios.post(`http://localhost:8080/Api/User/Signin`, null, {
                params: {
                    username: credentials.username,
                    password: credentials.password
                }
            });

            if (res.data === true) {  // Assuming backend returns true for successful login
                localStorage.setItem("token", "someAuthToken");  // Store auth token
                alert("Login successful!");
                navigate("/dashboard", {state: {username: credentials.username}}); // Redirect after login
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
            <h2>Login</h2>
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
                <button type="submit">Login</button>
            </form>
        </div>
    );
};

export default Login;
