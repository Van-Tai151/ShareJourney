import Home from "./components/Journey/Home";
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Header from "./components/Commons/Header";
// import Footer from "./components/Commons/Footer";

import Register from "./components/User/Register";
import Login from "./components/User/Login";
import { MyDispatchContext, MyUserContext } from "./configs/Contexts";
import { useReducer } from "react";
import MyUserReducer from "./configs/Reducers";
import cookie from "react-cookies";


const App = () => {
  const [user, dispatch] = useReducer(MyUserReducer, cookie.load("user") || null);
  return (
    <BrowserRouter>
      <MyUserContext.Provider value={user}>
        <MyDispatchContext.Provider value={dispatch}>
          <Header />
          <Routes>
            <Route path="/" element={<Home/>} />
            <Route path="/register" element={<Register />} />
            <Route path="/login" element={<Login />} />
          </Routes>
        </MyDispatchContext.Provider>
      </MyUserContext.Provider>
    </BrowserRouter>
  );
}

export default App;