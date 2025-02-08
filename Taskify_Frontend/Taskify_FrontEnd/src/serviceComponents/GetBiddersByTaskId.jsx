import React, { useState, useEffect } from 'react';
import axios from 'axios';

const GetBiddersByTaskId = ({ task_id }) => {
    const [bidders, setBidders] = useState([]);

    // Fetch bidders when the component mounts or task_id changes
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

    // Handle bid selection
    const handleBid = async (bid_id) => {
        try {
            // PUT request to choose the bid
            const response = await axios.put(`http://localhost:8080/Api/User/choosebid/${bid_id}`);
            
            // You can handle response if necessary, e.g., update the UI
            console.log('Bid selected:', response.data);
            console.log(bid_id + "button clicked!!");
            
            // Optionally, you can update the bidders list or give feedback to the user
            // For example, you could mark the selected bidder:
            setBidders(prevBidders => 
                prevBidders.map(bidder => 
                    bidder.bid_id === bid_id ? { ...bidder, selected: true } : bidder
                )
            );
        } catch (error) {
            console.error("Error in selecting bid:", error);
        }
    };

    return (
        <div>
            <h2>Task List</h2>
            {bidders.length > 0 ? (
                <ul>
                    {bidders.map((eachBidder, index) => (
                        <li key={eachBidder.bid_id && eachBidder.bidder_id ? `${eachBidder.bid_id}-${eachBidder.bidder_id}` : index}>
                            <strong>{eachBidder.bidder || "Unknown Bidder"}</strong>: {eachBidder.amount || "N/A"} : {eachBidder.estimatedHours || "N/A"} : {eachBidder.proposal || "N/A"} : {eachBidder.username || "N/A"}
                            <button onClick={() => handleBid(eachBidder.bid_id)}>
                                
                                {eachBidder.selected ? "Bid Selected" : "Select Bidder"}
                            </button>
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
