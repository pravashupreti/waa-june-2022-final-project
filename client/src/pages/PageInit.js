import { useEffect } from "react";
import { BrowserRouter } from "react-router-dom";
import Header from "../components/header";
import Footer from "../components/Footer";
import Body from "./layout/Body";
import { useDispatch, useSelector } from "react-redux";
import { getUserProfile } from "../redux/reducers/UserProfile/actions";

// This component fetch all the required global data from server

function PageInit() {
  const dispatch = useDispatch();
  const userProfile = useSelector((state) => state.userProfile);

  useEffect(() => {
    dispatch(getUserProfile());
  }, []);
  return (
    <>
      <BrowserRouter>
        <Header></Header>
        <Body></Body>
        <Footer></Footer>
      </BrowserRouter>
    </>
  );
}

export default PageInit;
