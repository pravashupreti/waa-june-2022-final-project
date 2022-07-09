import { Route, Routes } from "react-router-dom";
import BookDetails from "./BookDetails";
import BookForm from "./BookForm";
import BookList from "./BookList";
import Menu from "./Menu";
import NoMatch from "./NoMatch";
import RolesRoute from "./RolesRoute";
import SecretBooks from "./SecretBooks";

const BookBox = () => (
  <>
    <Menu />
    <Routes>
      <Route exact path="/" element={<BookList />}></Route>
      <Route exact path="/books/new" element={<BookForm />}></Route>
      <Route path="/books/:bookId" element={<BookDetails />}></Route>
      <Route
        path="/secret/*"
        element={<RolesRoute roles={["faculty"]} element={<SecretBooks />} />}
      ></Route>

      <Route path="*" element={<NoMatch />}></Route>
    </Routes>
  </>
);

export default BookBox;
