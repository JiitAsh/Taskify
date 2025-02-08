import React from 'react'

const AllServices = () => {

    const handleClick=(e)=>{
        const title=e.target.value;
        const type=e.target.value;
        <CreateTask task_title={title} task_type={type}/>
    }
  return (
    <div>
        <button onClick={()=>{handleClick(e)}}>Cleaning</button>
        <button onClick={()=>{handleClick(e)}}>Moving</button>
        <button onClick={()=>{handleClick(e)}}>Plumbing</button>
        <button onClick={()=>{handleClick(e)}}>Electrical</button>
        <button onClick={()=>{handleClick(e)}}>Painting</button>
    </div>
  )
}

export default AllServices