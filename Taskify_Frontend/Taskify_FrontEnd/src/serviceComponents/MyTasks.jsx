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
};

export default MyTasks;
