import React from "react";
import { Link } from "react-router-dom";

import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import "./index.css";
import UserService from "../../services/UserService";
import { useSelector } from "react-redux";

var FontAwesomeIcon = require("react-fontawesome");

export default function Header() {
  const userProfile = useSelector((state) => state.userProfile);

  return (
    <Navbar
      bg="primary"
      variant="dark"
      expand="lg"
      className="header-navigation"
    >
      <Container fluid>
        <Navbar.Brand as={Link} to="/">
          Alumni Management Portal
        </Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto"></Nav>

          <div className="notification-container">
            <FontAwesomeIcon
              name=""
              style={{ color: "white" }}
              className="fa-solid fa-bell"
              size="lg"
            />
          </div>

          <span className="navbar-text navbar-right">
            {userProfile?.firstName}
          </span>

          <button
            className="btn btn-info navbar-btn navbar-right"
            style={{ marginRight: 0 }}
            onClick={() => UserService.doLogout()}
          >
            Logout
          </button>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}
