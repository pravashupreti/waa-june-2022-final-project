import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { allJobAdvertisement } from "../../redux/reducers/JobAdvertisement/actions";
import JobFilter from "./JobFilter";
import JobListing from "./Listing";

export default function JobListings(props) {
  const dispatch = useDispatch();
  const { jobAdvertisement } = useSelector((state) => state.jobAdvertisement);

  useEffect(() => {
    dispatch(allJobAdvertisement());
  }, []);

  const [jobState, setJobState] = useState([]);

  let handleFilterChange = (data) => {
    setJobState(data);
  };

  return (
    <>
      <JobFilter handleFilterChange={handleFilterChange}></JobFilter>

      <div className="row">
        {jobState &&
          [...jobState]
            .sort((x, y) => (x.id < y.id ? 1 : -1))
            .map((job) => {
              return (
                <JobListing
                  key={job.id}
                  id={job.id}
                  title={job.title}
                  benefits={job.benefits}
                  description={job.description}
                  address={job.address}
                />
              );
            })}{" "}
      </div>
    </>
  );
}
