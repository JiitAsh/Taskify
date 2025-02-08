import React, { useState, useContext } from "react";
import { UserContext } from "../UserContext"; 
import axios from "axios";

const CreateTask = ({task_title, task_type}) => {
  const { username } = useContext(UserContext); // Get the logged-in user
  const [taskData, setTaskData] = useState({
    task_id: "", // Task ID (optional, if auto-generated by DB)
    task_title: task_title || "",
    task_desc: "",
    task_category: "",
    location: "",
    task_type: task_type || "",
    budget: "",
    scheduledDate: "",
    mustHaves: "",
    status: "OPEN", // Default status
  });

  // Handle input changes
  const handleChange = (e) => {
    setTaskData({ ...taskData, [e.target.name]: e.target.value });
  };

  // Handle form submission
  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post(
        `http://localhost:8080/Api/User/CreateTask/${username}`, 
        {
          ...taskData,
          task_id: taskData.task_id || null, // Send null if not manually provided
          budget: parseFloat(taskData.budget), // Convert budget to number
          scheduledDate: new Date(taskData.scheduledDate).toISOString(), // Format date properly
          createdAt: new Date().toISOString(), // Set current time
          updatedAt: new Date().toISOString(),
          user: { }, // Include user object
        }
      );

      if (response.status === 200) {
        alert("Task created successfully!");
        setTaskData({
          task_id: "",
          task_title: task_title,
          task_desc: "",
          task_category: "",
          location: "",
          task_type: task_type,
          budget: "",
          scheduledDate: "",
          mustHaves: "",
          status: "OPEN",
        }); // Reset form
      }
    } catch (error) {
      console.error("Error creating task!", error);
      alert("Failed to create task. Please try again.");
    }
  };

  return (
    <div>
      <h2>Create a New Task</h2>
      <form onSubmit={handleSubmit}>
        {/* <label>Task ID (Optional if auto-generated):</label>
        <input type="text" name="task_id" value={taskData.task_id} onChange={handleChange} /> */}

        <label>Task Title:</label>
        <input type="text" name="task_title" value={taskData.task_title} onChange={handleChange} required />

        <label>Task Description:</label>
        <textarea name="task_desc" value={taskData.task_desc} onChange={handleChange} required />

        <label>Task Category:</label>
        <input type="text" name="task_category" value={taskData.task_category} onChange={handleChange} required />

        <label>Location:</label>
        <input type="text" name="location" value={taskData.location} onChange={handleChange} required />

        <label>Task Type:</label>
        <input type="text" name="task_type" value={taskData.task_type} onChange={handleChange} required />

        <label>Budget:</label>
        <input type="text" name="budget" value={taskData.budget} onChange={handleChange} required />

        <label>Scheduled Date:</label>
        <input type="datetime-local" name="scheduledDate" value={taskData.scheduledDate} onChange={handleChange} required />

        <label>Must-Haves:</label>
        <input type="text" name="mustHaves" value={taskData.mustHaves} onChange={handleChange} />

        <label>Status:</label>
        <select name="status" value={taskData.status} onChange={handleChange}>
          <option value="OPEN">Open</option>
          <option value="IN_PROGRESS">In Progress</option>
          <option value="COMPLETED">Completed</option>
          <option value="CANCELLED">Cancelled</option>
        </select>

        <button type="submit">Create Task</button>
      </form>
    </div>
  );
};

export default CreateTask;
