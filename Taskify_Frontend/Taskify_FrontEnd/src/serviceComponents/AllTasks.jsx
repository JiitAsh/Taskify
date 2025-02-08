import React, { useEffect, useState } from "react";
import axios from "axios";
import CreateNewBid from "./createNewBid";
import "../servicestyle/AllTasks.css"; // Import the CSS file

const AllTasks = () => {
  const [tasks, setTasks] = useState([]);
  const [selectedTask, setSelectedTask] = useState(null);

  useEffect(() => {
    axios
      .get("http://localhost:8080/Api/User/BrowseTasks")
      .then((response) => {
        setTasks(response.data);
      })
      .catch((error) => {
        console.error("Error in fetching tasks!!", error);
      });
  }, []);

  const createBid = (id) => {
    setSelectedTask(id);
  };

  return (
    <div className="container">
      <h2 className="heading">Task List</h2>

      <div className="task-grid">
        {tasks.map((task) => (
          <div key={task.task_id} className="task-card">
            <h3 className="task-title">Task ID: {task.task_id}</h3>
            <p className="task-details">
              <strong>Budget:</strong> ₹{task.budget}
            </p>
            <p className="task-details">
              <strong>Location:</strong> {task.location}
            </p>
            <p className="task-details">
              <strong>Created At:</strong>{" "}
              {new Date(task.createdAt).toLocaleString()}
            </p>
            <p className="task-details">
              <strong>Status:</strong>{" "}
              <span
                className={`task-status ${
                  task.status === "Open" ? "status-open" : "status-closed"
                }`}
              >
                {task.status}
              </span>
            </p>
            <p className="task-details">
              <strong>Last Updated:</strong>{" "}
              {new Date(task.updatedAt).toLocaleString()}
            </p>

            <button
              className="bid-button"
              onClick={() => createBid(task.task_id)}
            >
              Bid for the Task
            </button>
          </div>
        ))}
      </div>

      {selectedTask && <CreateNewBid id={selectedTask} />}
    </div>
  );
};

export default AllTasks;
