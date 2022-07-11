import { useDispatch, useSelector } from "react-redux";
import React, { useEffect } from "react";
import { getUserProfile } from "../../redux/reducers/UserProfile/actions";
import { Breadcrumb, Container, Row, Col, Card } from "react-bootstrap";
import logo from "../../../src/logo.svg";

import JobHistoryInfo from "../../components/profiles/JobHistoryInfo";
import FileUploadPage from "../../pages/FileUploadPage";

function StudentProfile() {
  const dispatch = useDispatch();
  const userProfile = useSelector((state) => state.userProfile);

  useEffect(() => {
    dispatch(getUserProfile());
  }, []);

  const jobHistory = [
    {
      id: 1,
      title: "Software Engineer",
      location: "Iowa",
      aboutUs: "test",
    },
    {
      id: 2,
      title: "Software Project Manager",
      location: "Iowa",
      aboutUs: "test",
    },
  ];

  return (
    <Container>
      <Breadcrumb name="Basic Information" />
      <section className="content">
        <Container fluid="lg">
          <Row>
            <Col md={{ span: 3 }}>
              <img src={logo} alt="user-image" />
            </Col>
            <Col md={{ span: 6 }}>
              <div className="row d-flex justify-content-center align-items-center h-100">
                <div className="card">
                  <div className="card-body p-4 text-block">
                    <div className="mb-5">
                      <p className="lead fw-normal mb-1">User Profile</p>
                      <div
                        className="p-4"
                        style={{ backgroundColor: "#f8f9fa" }}
                      >
                        <p className="text-right">
                          {/* <Link to={`update/${userProfile?.id}`}><i className='fas fa-edit text-primary ml-2'></i></Link> */}
                        </p>
                        <p className="font-italic mb-1">
                          Name:{" "}
                          {userProfile?.firstName + " " + userProfile?.lastName}
                        </p>
                        <p className="font-italic mb-0">
                          Email: {userProfile?.email}
                        </p>
                        <p className="font-italic mb-0">
                          Address: {userProfile?.address}
                        </p>
                      </div>
                    </div>
                    <FileUploadPage />
                  </div>
                </div>
              </div>
            </Col>
          </Row>
          <br />

          <h3>Job History</h3>
          <div className="container">
            {jobHistory.map((history) => {
              return (
                <JobHistoryInfo
                  key={history.id}
                  title={history.title}
                  location={history.location}
                  aboutUs={history.aboutUs}
                ></JobHistoryInfo>
              );
            })}
          </div>
        </Container>
      </section>
    </Container>
  );
}

export default StudentProfile;
