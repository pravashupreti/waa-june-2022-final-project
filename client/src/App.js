import "./App.css";
import Footer from "./components/Footer";
import { BrowserRouter } from "react-router-dom";
import Header from "./components/header";

import Router from "./pages/Router";
import store from "./store";
import { Provider } from "react-redux";
import "./App.css";

const reduxStore = store.setup();

function App() {
  return (
    <div>
      <Provider store={reduxStore}>
        <BrowserRouter>
          <Header></Header>
          <Router></Router>
          <Footer></Footer>
        </BrowserRouter>
      </Provider>
    </div>
  );
}

export default App;
