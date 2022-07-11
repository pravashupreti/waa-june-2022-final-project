import { Button } from "bootstrap";
import React, { useState, useEffect } from "react";
import { Form, Row } from "react-bootstrap";
import { useDispatch, useSelector } from "react-redux";
import { allJobAdvertisement } from "../../redux/reducers/JobAdvertisement/actions";

export default function JobFilter(props) {
  const dispatch = useDispatch();
  const { jobAdvertisement } = useSelector((state) => state.jobAdvertisement);

  useEffect(() => {
    dispatch(allJobAdvertisement());
  }, []);

  const [filterForm, setFilterForm] = useState({});

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFilterForm({
      ...filterForm,
      [name]: value,
    });
  };

  const handleFilter = (e) => {
    e.preventDefault();
    let filteredData = filterChanged();
    if (filteredData) props.handleFilterChange(filteredData);
  };

  const filterChanged = () => {
    let filteredData = filterByTitle([].concat(jobAdvertisement));
    filteredData = filterByCity(filteredData);
    filteredData = filterByState(filteredData);
    filteredData = filterByTags(filteredData);

    return filteredData;
  };

  const filterByTitle = (data) => {
    if (!filterForm.title) return data;

    return data.filter((x) => {
      return x.description
        .toLowerCase()
        .includes(filterForm.title.toLowerCase());
    });
  };

  const filterByCity = (data) => {
    if (!filterForm.city) return data;

    return data.filter((x) => {
      return x.address.city
        .toLowerCase()
        .includes(filterForm.city.toLowerCase());
    });
  };

  const filterByState = (data) => {
    if (!filterForm.state) return data;

    return data.filter((x) => {
      return x.address.state
        .toLowerCase()
        .includes(filterForm.state.toLowerCase());
    });
  };

  const filterByTags = (data) => {
    return data;
  };

  const cityList = [
    ...new Set(jobAdvertisement.map((data) => data.address?.city)),
  ];

  const stateList = [
    ...new Set(jobAdvertisement.map((data) => data.address?.state)),
  ];

  useEffect(() => {
    let filteredData = filterChanged();
    if (filteredData) props.handleFilterChange(filteredData);
  }, [jobAdvertisement]);

  return (
    <div className="card filter-form">
      <Form onSubmit={handleFilter}>
        <Row>
          <Form.Group className="mb-3 col-3">
            <Form.Label htmlFor="name" className="form-label">
              Title
            </Form.Label>
            <Form.Control
              type="text"
              className="form-control"
              id="title"
              onChange={handleChange}
              name="title"
            />
          </Form.Group>

          <Form.Group className="mb-2 col-2">
            <Form.Label htmlFor="state" className="form-label">
              State
            </Form.Label>
            <Form.Select
              className="form-select"
              id="state"
              onChange={handleChange}
              name="state"
            >
              <option value="">Select</option>

              {stateList.map((state, index) => {
                return (
                  <option key={index} value={state}>
                    {state}
                  </option>
                );
              })}
            </Form.Select>
          </Form.Group>

          <Form.Group className="mb-3 col-3">
            <Form.Label htmlFor="city" className="form-label">
              City
            </Form.Label>
            <Form.Select
              className="form-select"
              id="city"
              onChange={handleChange}
              name="city"
            >
              <option value="">Select</option>
              {cityList.map((city, index) => {
                return (
                  <option key={index} value={city}>
                    {city}
                  </option>
                );
              })}
            </Form.Select>
          </Form.Group>

          <Form.Group className="mb-2 col-2">
            <Form.Label htmlFor="tagName" className="form-label">
              Tag Name
            </Form.Label>
            <Form.Control
              type="text"
              className="form-control"
              id="tagName"
              onChange={handleChange}
              name="tagname"
            />
          </Form.Group>

          <Form.Group className="mb-2 col-2">
            <Form.Label htmlFor="tagName" className="form-label"></Form.Label>
            <Form.Control type="submit" className="form-control" />
          </Form.Group>
        </Row>
      </Form>
    </div>
  );
}
