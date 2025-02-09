import React, { useState, useEffect } from "react";
import axios from "axios";
import GetBiddersByTaskId from "./GetBiddersByTaskId";
import "../servicestyle/MyTasks.css"; // Import CSS

const MyTasks = () => {
  const [tasks, setTasks] = useState([]);
  const [selectedTask, setSelectedTask] = useState(null);

  useEffect(() => {
    axios
      .get("http://localhost:8080/Api/User/MyTasks")
      .then((response) => {
        setTasks(response.data);
      })
      .catch((error) => {
        console.error("Error in fetching tasks!!", error);
      });
  }, []);

  // Toggle the View Bids Section
  const handleViewBids = (task_id) => {
    setSelectedTask(selectedTask === task_id ? null : task_id);
  };

  return (
    <div className="container">
      <h2 className="heading">My Tasks</h2>

      <table className="task-table">
        <thead>
          <tr>
            <th>Task Title</th>
            <th>Description</th>
            <th>Category</th>
            <th>Location</th>
            <th>Budget</th>
            <th>Scheduled Date</th>
            <th>Must Haves</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {tasks.map((task) => (
            <tr key={task.task_id}>
              <td>{task.task_title}</td>
              <td>{task.task_desc}</td>
              <td>{task.task_category}</td>
              <td>{task.location}</td>
              <td>₹{task.budget}</td>
              <td>{new Date(task.scheduledDate).toLocaleDateString()}</td>
              <td>{task.mustHaves || "N/A"}</td>
              <td>
                <button
                  className="view-bids-btn"
                  onClick={() => handleViewBids(task.task_id)}
                >
                  {selectedTask === task.task_id ? "Hide Bids" : "View Bids"}
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>

      {/* Render Bidders Component when View Bids is clicked */}
      {selectedTask && <GetBiddersByTaskId task_id={selectedTask} />}
    </div>
  );
};

export default MyTasks;
