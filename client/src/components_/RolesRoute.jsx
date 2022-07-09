import PropTypes from "prop-types";
import { Route, Routes } from "react-router-dom";
import UserService from "../services/UserService";
import NotAllowed from "./NotAllowed";

const RolesRoute = ({ roles, element, ...rest }) => {
  return (
    <Routes>
      <Route
        path="*"
        {...rest}
        element={UserService.hasRole(roles) ? element : <NotAllowed />}
      ></Route>
    </Routes>
  );
};
RolesRoute.propTypes = {
  roles: PropTypes.arrayOf(PropTypes.string).isRequired,
};

export default RolesRoute;
