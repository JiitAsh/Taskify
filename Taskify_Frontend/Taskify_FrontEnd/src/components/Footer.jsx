import React from "react";
import "../styles/Footer.css"; // Ensure you have a CSS file if needed for custom styles
import Favicon from "../assets/images/favicon-taskify.png";

const Footer = () => {
  return (
    <footer className="footer bg-light">
      <div className="container d-flex justify-content-between align-items-center">
        {/* Favicon (Logo) on the left */}
        <div className="footer-left d-flex align-items-center">
          <img
            src={Favicon} // Replace with the actual path to your favicon image
            width="30"
            alt="Favicon"
          />
          <span className="ms-2">
            © {new Date().getFullYear()} Made with Curiosity
          </span>
        </div>

        {/* Footer Links */}
        <div className="footer-links">
          <a href="#" className="footer-link">
            Contact Us
          </a>
          <a href="#" className="footer-link">
            About Us
          </a>
          <a href="#" className="footer-link">
            How It Works
          </a>
        </div>
      </div>
    </footer>
  );
};

export default Footer;
