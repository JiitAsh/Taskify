import React, { useState, useEffect, useContext } from 'react';
import axios from 'axios';
import { UserContext } from '../UserContext'; // Import the custom hook

const MyTasks = () => {
    const { username } = useContext(UserContext); // Access the username from context
    const [tasks, setTasks] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        if (username) {
            // Fetch tasks for the user using the username from the context
            axios.get(`http://localhost:8080/Api/User/BrowseTasks/${username}`)
                .then((response) => {
                    setTasks(response.data); // Set the fetched tasks data
                    setLoading(false); // Set loading to false after data is fetched
                })
                .catch((err) => {
                    setError('Error fetching tasks: ' + err.message); // Handle errors
                    setLoading(false); // Set loading to false in case of error
                });
        }
    }, [username]); // Dependency on username to re-fetch data when it changes

    if (loading) return <p>Loading tasks...</p>;
    if (error) return <p>{error}</p>;

    return (
        <div>
            <h2>Task List for {username}</h2>
            {tasks.length > 0 ? (
                <ul>
                    {tasks.map((task) => (
                        <li key={task.task_id}>
                            <h3>{task.task_title}</h3>
                            <p><strong>Description:</strong> {task.task_desc || "N/A"}</p>
                            <p><strong>Category:</strong> {task.task_category || "N/A"}</p>
                            <p><strong>Location:</strong> {task.location || "N/A"}</p>
                            <p><strong>Task Type:</strong> {task.task_type || "N/A"}</p>
                            <p><strong>Budget:</strong> ${task.budget || "N/A"}</p>
                            <p><strong>Scheduled Date:</strong> {new Date(task.scheduledDate).toLocaleString() || "N/A"}</p>
                            <p><strong>Must Haves:</strong> {task.mustHaves || "N/A"}</p>
                            <p><strong>Status:</strong> {task.status || "OPEN"}</p>
                            <p><strong>Created At:</strong> {new Date(task.createdAt).toLocaleString() || "N/A"}</p>
                            <p><strong>Updated At:</strong> {new Date(task.updatedAt).toLocaleString() || "N/A"}</p>
                            <p><strong>Message:</strong> {task.message || "N/A"}</p>
                            <p><strong>Assigned User:</strong> {task.username || "N/A"}</p>
                            <p><strong>User Info:</strong> {task.user?.username || "N/A"}</p>
                        </li>
                    ))}
                </ul>
            ) : (
                <p>No tasks found for this user.</p>
            )}
        </div>
    );
};

export default MyTasks;
