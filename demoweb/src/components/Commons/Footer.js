import { useContext, useEffect, useState } from "react";
import { Badge, Button, Col, Container, Form, Image, Nav, Navbar, NavDropdown, Row } from "react-bootstrap";
import { Link, useNavigate } from "react-router-dom";
import APIs, { endpoints } from "../../configs/API";
import { MyDispatchContext, MyUserContext } from "../../configs/Contexts";
import MySpinner from "./MySpinner";

const Footer = () => {
    return (
        <h1>Danh muc</h1>
    );
}
    export default Footer;