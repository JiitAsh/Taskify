import React, { useEffect, useState } from 'react'
import axios from "axios";
import CreateNewBid from './createNewBid';
const Notifications = ({user_id}) => {
    const [tasks, SetTasks]=useState([]);
    useEffect(()=>{
        axios.get( `http://localhost:8080/Api/User/Notifications/${user_id}`)
        .then(response=>{
            SetTasks(response.data);
        })
        .catch(error=>{
            console.error("Error in fetching tasks!!", error);
        })
    }, [])

    const createBid=(id)=>{
        setSelectedTask(id);
    }
  return (
    <div>
            <h2>Task List</h2>
            <ul>
                {tasks.map(task => (
                    <li key={task.task_id}>
                        <strong>{task.task_id}</strong>: {task.budget}:{task.location}: {task.createdAt}:{task.status}:{task.updatedAt}
                    </li>
                ))}
            </ul>
        </div>
  )
}

export default Notifications;