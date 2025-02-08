import React from "react";
import "../styles/Card.css";

const Card = ({ image, title, text, link }) => {
  return (
    <div className="card" style={{ width: "18rem" }}>
      <img
        className="card-img-top"
        src={image} // Dynamic image path
        alt={title} // Title
      />
      <div className="card-body">
        <h5 className="card-title">{title}</h5>
        <p className="card-text">{text}</p>
        <a href={link} className="btn btn-primary">
          Get Service
        </a>
      </div>
    </div>
  );
};

export default Card;
