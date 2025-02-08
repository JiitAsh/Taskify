import React, { useEffect, useState } from 'react'
import axios from "axios";
import CreateNewBid from './createNewBid';
const AllTasks = () => {
    const [tasks, SetTasks]=useState([]);
    const [selectedTask, setSelectedTask] = useState(null);
    useEffect(()=>{
        axios.get("http://localhost:8080/Api/User/BrowseTasks")
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
                        <button onClick={()=>createBid(task.task_id)}>Bid for the task</button>
                    </li>
                ))}
            </ul>
            {selectedTask && <CreateNewBid id={selectedTask} />}
        </div>
  )
}

export default AllTasks;