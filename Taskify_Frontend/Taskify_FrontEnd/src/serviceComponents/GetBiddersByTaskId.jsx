import React, { useState, useEffect } from 'react';
import axios from 'axios';

const GetBiddersByTaskId = ({ task_id }) => {
    const [bidders, setBidders] = useState([]);

    useEffect(() => {
        axios.get(`http://localhost:8080/Api/User/MyTask/${task_id}`)
            .then(response => {
                console.log("API Response:", response.data); 
                setBidders(response.data);
            })
            .catch(error => {
                console.error("Error in fetching bidder details!!", error);
            });
    }, [task_id]);

    return (
        <div>
            <h2>Task List</h2>
            {bidders.length > 0 ? (
                <ul>
                    {bidders.map((eachBidder, index) => (
                        <li key={eachBidder.bid_id && eachBidder.bidder_id ? `${eachBidder.bid_id}-${eachBidder.bidder_id}` : index}>
                            <strong>{eachBidder.bidder || "Unknown Bidder"}</strong>: {eachBidder.amount || "N/A"} : {eachBidder.estimatedHours || "N/A"} : {eachBidder.proposal || "N/A"} : {eachBidder.username || "N/A"}
                        </li>
                    ))}
                </ul>
            ) : (
                <p>No bidders found for this task.</p>
            )}
        </div>
    );
};

export default GetBiddersByTaskId;
