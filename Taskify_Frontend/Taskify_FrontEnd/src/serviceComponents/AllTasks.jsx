import React, { useEffect, useState } from "react";
import axios from "axios";
import CreateNewBid from "./CreateNewBid";
import "../servicestyle/AllTasks.css"; // Updated CSS file

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

      <table className="task-table">
        <thead>
          <tr>
            <th>Task Title</th>
            <th>Task Description</th>
            <th>Task Category</th>
            <th>Location</th>
            <th>Budget (₹)</th>
            <th>Scheduled Date</th>
            <th>Must Haves</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {tasks.map((task) => (
            <tr key={task.task_id}>
              <td>{task.task_title}</td>
              <td>{task.task_desc}</td>
              <td>
                {task.task_category === "remote" ? "Remote" : "In-Person"}
              </td>
              <td>{task.location}</td>
              <td>{task.budget}</td>
              <td>{new Date(task.scheduledDate).toLocaleDateString()}</td>
              <td>{task.mustHaves}</td>
              <td>
                <button
                  className="bid-button"
                  onClick={() => createBid(task.task_id)}
                >
                  Bid for Task
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>

      {selectedTask && <CreateNewBid id={selectedTask} />}
    </div>
  );
};

export default AllTasks;
