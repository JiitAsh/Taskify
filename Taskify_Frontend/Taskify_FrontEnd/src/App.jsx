import React from "react";
import {
  BrowserRouter as Router,
  Route,
  Routes,
  Navigate,
} from "react-router-dom";
import Register from "./components/Register";
import Login from "./components/Login";
import Home from "./components/Home";
import UpdateUser from "./components/UpdateUser";
import DeleteUser from "./components/DeleteUser";
import Logout from "./components/Logout";
import Dashboard from "./components/Dashboard";
import AllTasks from "./serviceComponents/AllTasks";
import GetUserById from "./serviceComponents/GetUserById";
import GetBiddersByTaskId from "./serviceComponents/GetBiddersByTaskId";
import { UserProvider } from "./UserContext";
import CreateTask from "./serviceComponents/CreateTask";
import Notifications from "./serviceComponents/Notifications";
import CreateNewBid from "./serviceComponents/createNewBid";
const App = () => {
  // const  getUserId=()=>{

  // }
  return (
    <div>
      <UserProvider>
        <Router>
          <Routes>
            <Route path="/" element={<Navigate to="/home" />} />{" "}
            {/* Redirect to Home */}
            <Route path="/register" element={<Register />} />
            <Route path="/login" element={<Login />} />
            <Route path="/home" element={<Home />} />
            <Route path="/dashboard" element={<Dashboard />} />
            <Route path="/update" element={<UpdateUser />} />
            <Route path="/delete" element={<DeleteUser />} />
            <Route path="/logout" element={<Logout />} />
            <Route path="/login" element={<Login />} />
            <Route path="/dashboard" element={<Dashboard />} />
          </Routes>
        </Router>
        {/* // <GetUserById user_id={1}/> */}
        {/* // <GetBiddersByTaskId task_id={101}/> */}
        {/* <AllTasks /> */}
        {/* <CreateTask id={2}/> */}
        {/* < Notifications /> */}
        {/* <MyTasks/> */}
      </UserProvider>
    </div>
  );
};

export default App;
