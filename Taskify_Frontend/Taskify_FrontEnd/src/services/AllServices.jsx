import React, { useState, useRef } from "react";
import CreateTask from "../serviceComponents/CreateTask";
import "../servicestyle/AllServices.css";

// Import service images
import cleaning from "../assets/images/cleaning.jpg";
import moving from "../assets/images/moving.jpg";
import plumbing from "../assets/images/plumbing.jpeg";
import electrician from "../assets/images/electrician.jpg";
import furniture from "../assets/images/furniture.png";

const services = [
  { title: "Cleaning", type: "Cleaning", image: cleaning },
  { title: "Moving", type: "Moving", image: moving },
  { title: "Plumbing", type: "Plumbing", image: plumbing },
  { title: "Electrical", type: "Electrical", image: electrician },
  { title: "Painting", type: "Painting", image: furniture },
];

const AllServices = () => {
  const [selectedTask, setSelectedTask] = useState(null);
  const createTaskRef = useRef(null); // Ref for scrolling

  const handleClick = (title, type) => {
    setSelectedTask({ task_title: title, task_type: type });

    // Scroll to the CreateTask section smoothly
    setTimeout(() => {
      createTaskRef.current?.scrollIntoView({
        behavior: "smooth",
        block: "start",
      });
    }, 100);
  };

  return (
    <div className="services-container">
      <h1 className="services-title">Select a Service</h1>
      <div className="services-grid">
        {services.map((service, index) => (
          <div
            key={index}
            className="service-card"
            onClick={() => handleClick(service.title, service.type)}
          >
            <img
              src={service.image}
              alt={service.title}
              className="service-img"
            />
            <h3 className="service-name">{service.title}</h3>
          </div>
        ))}
      </div>

      {selectedTask && (
        <div ref={createTaskRef} className="create-task-container">
          <CreateTask
            task_title={selectedTask.task_title}
            task_type={selectedTask.task_type}
          />
        </div>
      )}
    </div>
  );
};

export default AllServices;
