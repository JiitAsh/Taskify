import React, {useState} from 'react'
import CreateTask from '../serviceComponents/CreateTask';

const AllServices = () => {
    
  const [selectedTask, setSelectedTask]=useState(null);
    const handleClick=(title, type)=>{
      setSelectedTask({task_title:title, task_type:type})
    }
  return (
    <div>
        <button onClick={()=>{handleClick("Cleaning", "Cleaning")}}>Cleaning</button>
        <button onClick={()=>{handleClick("Moving", "Moving")}}>Moving</button>
        <button onClick={()=>{handleClick(e)}}>Plumbing</button>
        <button onClick={()=>{handleClick(e)}}>Electrical</button>
        <button onClick={()=>{handleClick(e)}}>Painting</button>


        {selectedTask && <CreateTask task_title={selectedTask.task_title} task_type={selectedTask.task_type}/>}
    </div>
  )
}

export default AllServices