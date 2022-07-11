import { Link } from "react-router-dom";
import UserService from "../../services/UserService";

function Menu() {
  const adminMenu = [
    {
      id: 1,
      name: "Dashboard",
      icon: "none",
      url: "dashboard",
      active: false,
    },
    {
      id: 2,
      name: "Faculty",
      icon: "none",
      url: "faculty",
      active: false,
    },
    {
      id: 3,
      name: "Student",
      icon: "none",
      url: "student",
      active: false,
    },
    {
      id: 4,
      name: "Activity Logs",
      icon: "none",
      url: "activity-logs",
      active: false,
    },
  ];

  const studentMenu = [
    {
      id: 10,
      name: "Dashboard",
      icon: "none",
      url: "dashboard",
      active: false,
    },
    {
      id: 1,
      name: "Job Lists",
      icon: "none",
      url: "job-advertisements",
      active: false,
    },
    {
      id: 2,
      name: "My Profile",
      icon: "none",
      url: "profile",
      active: false,
    },
    {
      id: 3,
      name: "Create Job Ad",
      icon: "none",
      url: "job-advertisements/add",
      active: false,
    },
    {
      id: 4,
      name: "Job Applicant List",
      icon: "none",
      url: "job-applicant",
      active: false,
    },
    {
      id: 5,
      name: "Add Job History",
      icon: "none",
      url: "job-history/add",
      active: false,
    },
  ];

  const facultyMenu = [
    {
      id: 10,
      name: "Dashboard",
      icon: "none",
      url: "dashboard",
      active: false,
    },
    {
      id: 1,
      name: "Job List",
      icon: "none",
      url: "job-advertisements",
      active: false,
    },
    {
      id: 2,
      name: "My Profile",
      icon: "none",
      url: "profile",
      active: false,
    },
    {
      id: 3,
      name: "Student List",
      icon: "none",
      url: "student-list",
      active: false,
    },
  ];

  const adminRole = UserService.hasRole(["admin"]);
  const studentRole = UserService.hasRole(["student"]);
  const facultyRole = UserService.hasRole(["faculty"]);

  const logout = () => {
    UserService.doLogout();
  };

  return (
    <div className="col-2 side-menu">
      <div className="list-group">
        {/* Admin Menu */}
        {adminRole &&
          adminMenu.map((menu) => {
            return (
              <Link
                key={menu.id}
                to={"/admin/" + menu.url}
                className={
                  "list-group-item list-group-item-action " +
                  (menu.active ? "active" : "")
                }
              >
                {menu.name}
              </Link>
            );
          })}
        {/* Student Menu */}
        {studentRole &&
          studentMenu.map((menu) => {
            return (
              <Link
                key={menu.id}
                to={"/student/" + menu.url}
                className={
                  "list-group-item list-group-item-action " +
                  (menu.active ? "active" : "")
                }
              >
                {menu.name}
              </Link>
            );
          })}
        {/* Faculty Menu */}
        {facultyRole &&
          facultyMenu.map((menu) => {
            return (
              <Link
                key={menu.id}
                to={"/faculty/" + menu.url}
                className={
                  "list-group-item list-group-item-action " +
                  (menu.active ? "active" : "")
                }
              >
                {menu.name}
              </Link>
            );
          })}

        <a
          href="http://localhost:8081/realms/AMP/account/password"
          className="list-group-item list-group-item-action "
        >
          Change Password
        </a>
        <Link
          to="/logout"
          className="list-group-item list-group-item-action "
          onClick={logout}
        >
          Logout
        </Link>
      </div>
    </div>
  );
}

export default Menu;
