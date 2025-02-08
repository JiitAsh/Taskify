import React, { useState, useEffect } from 'react'
import axios from 'axios';
const GetUserById = ({user_id}) => {
    const [user, SetUser]=useState(null);

    useEffect(()=>{
        axios.get(`http://localhost:8080/Api/User/GetUser/${user_id}`)
        .then(response=>{
            SetUser(response.data);
        })
        .catch(error=>{
            console.error("Error in fetching tasks!!", error);
        })
    }, [user_id])
  return (
    <div>
            <h2>User Details</h2>
            {user ? (
                <div>
                    <p><strong>ID:</strong> {user.id}</p>
                    <p><strong>Name:</strong> {user.firstname}</p>
                    <p><strong>Name:</strong> {user.lastname}</p>
                    <p><strong>Name:</strong> {user.username}</p>
                    <p><strong>Email:</strong> {user.email}</p>
                    <p><strong>Email:</strong> {user.category}</p>
                </div>
            ) : (
                <p>Loading user data...</p>
            )}
    </div>
  )
}

export default GetUserById