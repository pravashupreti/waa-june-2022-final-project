import {
  LIST_JOB_ADVERTISEMENT,
  ADD_JOB_ADVERTISEMENT,
  DELETE_JOB_ADVERTISEMENT,
} from "./actionsTypes";

import HttpService from "../../../services/HttpService";

export const allJobAdvertisement = () => ({
  type: LIST_JOB_ADVERTISEMENT,
  payload: {
    request: {
      url: "/job-advertisements",
    },
  },
});

export const addJobAdvertisement = (job) => {
  return {
    type: ADD_JOB_ADVERTISEMENT,
    payload: {
      request: {
        url: "/job-advertisements",
        method: HttpService.HttpMethods.POST,
        data: job,
      },
    },
  };
};

export const deleteJobAdvertisement = (job) => {
  return {
    type: DELETE_JOB_ADVERTISEMENT,
    payload: {
      job,
      request: {
        url: `/job-advertisements/${job.id}`,
        method: HttpService.HttpMethods.DELETE,
      },
    },
  };
};
