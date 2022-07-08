import React, { useEffect, useState } from 'react'
import { Breadcrumb, Container, Row, Col } from 'react-bootstrap';
import logo from '../../../src/logo.svg';
export default function UserProfile() {
    const initialState = { email: "ansharma@miu.edu", password: "1234", role: "student", firstName: "Anjana", lastName: "Sharma" }
    const [userProfile, setUserProfile] = useState(initialState);

    // const username = getUsername();
    // useEffect(() => {
    //     get();
    // }, []);

    return (
        <Container>
            <Breadcrumb name="Basic Information" />
            <section className='content'>
                <Container fluid="lg">
                    <Row>
                        <Col md={{ span: 3 }}>
                            <img src={logo} alt="user-image" />
                        </Col>
                        <Col md={{ span: 6 }}>
                            <div className='row d-flex justify-content-center align-items-center h-100'>
                                <div className='card'>
                                    <div className='card-body p-4 text-block'>
                                        <div className='mb-5'>
                                            <p className="lead fw-normal mb-1">User Profile</p>
                                            <div className="p-4" style={{ backgroundColor: "#f8f9fa" }}>
                                                <p className="text-right">
                                                    {/* <Link to={`update/${userProfile?.id}`}><i className='fas fa-edit text-primary ml-2'></i></Link> */}
                                                </p>
                                                <p className="font-italic mb-1">
                                                    Name: {userProfile?.firstName + " " + userProfile?.lastName}
                                                </p>
                                                <p className="font-italic mb-1">
                                                    Role: {userProfile?.role}
                                                </p>
                                                <p className="font-italic mb-0">
                                                    Email: {userProfile?.email}
                                                </p>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </Col>
                    </Row>
                </Container>
            </section>
        </Container>
    )
}