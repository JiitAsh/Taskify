import React, { useState, useContext } from "react";
import { UserContext } from "../UserContext"; // Import UserContext
import axios from "axios";

const CreateNewBid = ({ id }) => {
  const { username } = useContext(UserContext); // Get username from Context
  const [bidData, setBidData] = useState({
    amount: "",
    estimated_hours: "",
    proposal: "",
    task:{
        task_id: id
    }
  });
  
  // Handle input change
  const handleChange = (e) => {
    setBidData({ ...bidData, [e.target.name]: e.target.value });
  };

  // Handle form submission
  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
        console.log("Username from context:", username);
      const response = await axios.post(
        `http://localhost:8080/Api/User/CreateBid/${username}`, 
        {
          amount: bidData.amount,
          estimated_hours: Number(bidData.estimated_hours),
          proposal: bidData.proposal,
          task:{
            task_id:id // Task ID from prop
          }  
        }
      );

      if (response.status === 200) {
        alert("Bid submitted successfully!");
        setBidData({
          amount: "",
          estimated_hours: "",
          proposal: "",
        }); // Reset form
      }
    } catch (error) {
      console.error("Error submitting bid!", error);
      alert("Failed to submit bid. Please try again.");
    }
  };

  return (
    
    <div>
      <h2>Submit a New Bid</h2>
      <form onSubmit={handleSubmit}>
        <label>Amount:</label>
        <input
          type="text"
          name="amount"
          value={bidData.amount}
          onChange={handleChange}
          required
        />
        
        <label>Estimated Hours:</label>
        <input
          type="text"
          name="estimated_hours"
          value={bidData.estimated_hours}
          onChange={handleChange}
          required
        />

        <label>Proposal:</label>
        <textarea
          name="proposal"
          value={bidData.proposal}
          onChange={handleChange}
          required
        ></textarea>

        <button type="submit">Submit Bid</button>
      </form>
    </div>
  );
};

export default CreateNewBid;
