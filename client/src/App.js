import "./App.css";

import store from "./redux/store";
import { Provider } from "react-redux";

import "./App.css";

import PageInit from "./pages/PageInit";

const reduxStore = store.setup();

function App() {
  return (
    <Provider store={reduxStore}>
      <PageInit />
    </Provider>
  );
}

export default App;
