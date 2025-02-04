import React from "react";
import { Link } from "react-router-dom";

const Home = () => {
  return (
    <div className="container text-center mt-5">
      <Link to='/login' className="login-link">Login</Link>
      <br />
      <Link to='/register' className="register-link">New user?Sign up</Link>
    </div>
  );
};

export default Home;
