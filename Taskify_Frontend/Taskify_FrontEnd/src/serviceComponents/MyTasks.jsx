<<<<<<< HEAD
import React, { useState, useEffect, useContext } from "react";
import axios from "axios";
import { UserContext } from "../UserContext";
import "../servicestyle/MyTasks.css"; // Import the new CSS file

const MyTasks = () => {
  const { username } = useContext(UserContext);
  const [tasks, setTasks] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    if (username) {
      axios
        .get(`http://localhost:8080/Api/User/BrowseTasks/${username}`)
        .then((response) => {
          setTasks(response.data);
          setLoading(false);
        })
        .catch((err) => {
          setError("Error fetching tasks: " + err.message);
          setLoading(false);
        });
    }
  }, [username]);

  if (loading) return <p className="loading-text">Loading tasks...</p>;
  if (error) return <p className="error-text">{error}</p>;

  return (
    <div className="my-tasks-container">
      <h2 className="tasks-title">My Tasks</h2>
      <p className="tasks-subheader">
        "You Post, They Bid, You Pay… Sounds Fun, Right?"
      </p>

      {tasks.length > 0 ? (
        <table className="tasks-table">
          <thead>
            <tr>
              <th>Title</th>
              <th>Description</th>
              <th>Category</th>
              <th>Location</th>
              <th>Task Type</th>
              <th>Budget</th>
              <th>Scheduled Date</th>
              <th>Status</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {tasks.map((task) => (
              <tr key={task.task_id}>
                <td>{task.task_title}</td>
                <td>{task.task_desc || "N/A"}</td>
                <td>{task.task_category || "N/A"}</td>
                <td>{task.location || "N/A"}</td>
                <td>{task.task_type || "N/A"}</td>
                <td>${task.budget || "N/A"}</td>
                <td>
                  {new Date(task.scheduledDate).toLocaleString() || "N/A"}
                </td>
                <td className={`status ${task.status.toLowerCase()}`}>
                  {task.status || "OPEN"}
                </td>
                <td>
                  <button className="view-bids-btn">View Bids</button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      ) : (
        <p className="no-tasks-text">No tasks found for this user.</p>
      )}
    </div>
  );
=======
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
>>>>>>> 91742dbde9ae9941923ac744e0a1dfe6aafa4b05
};

export default MyTasks;
