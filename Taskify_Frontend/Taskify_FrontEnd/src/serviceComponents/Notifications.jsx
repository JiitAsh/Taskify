<<<<<<< HEAD
import React, { useEffect, useState } from "react";
import axios from "axios";
import CreateNewBid from "./CreateNewBid";
const Notifications = ({ user_id }) => {
  const [tasks, SetTasks] = useState([]);
  useEffect(() => {
    axios
      .get(`http://localhost:8080/Api/User/Notifications/${user_id}`)
      .then((response) => {
        SetTasks(response.data);
      })
      .catch((error) => {
        console.error("Error in fetching tasks!!", error);
      });
  }, []);
=======
import React, { useEffect, useState, useContext } from 'react'
import axios from "axios";
import CreateNewBid from './createNewBid';
import { UserContext } from '../UserContext'; // Import the custom hook

const Notifications = () => {
    const { username } = useContext(UserContext);
    const [tasks, SetTasks]=useState([]);
    useEffect(()=>{
        axios.get( `http://localhost:8080/Api/User/Notifications/${username}`)
        .then(response=>{
            SetTasks(response.data);
        })
        .catch(error=>{
            console.error("Error in fetching tasks!!", error);
        })
    }, [])
>>>>>>> 91742dbde9ae9941923ac744e0a1dfe6aafa4b05

  const createBid = (id) => {
    setSelectedTask(id);
  };
  return (
    <div>
      <h2>Task List</h2>
      <ul>
        {tasks.map((task) => (
          <li key={task.task_id}>
            <strong>{task.task_id}</strong>: {task.budget}:{task.location}:{" "}
            {task.createdAt}:{task.status}:{task.updatedAt}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Notifications;
