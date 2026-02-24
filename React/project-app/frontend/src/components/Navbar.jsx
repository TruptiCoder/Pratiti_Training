import { Link, useNavigate } from "react-router-dom";
import { useStore } from "../store.js";

function Navbar() {
  const navigate = useNavigate();
  const user = useStore((state) => state.user);
  const removeUser = useStore((state) => state.removeUser);

  const logout = () => {
    removeUser();
    navigate("/");
  };

  return (
    <nav className="navbar bg-body-tertiary px-5 py-3">
      <Link
        className="text-decoration-none p-3"
        style={{borderRadius: "50%", backgroundColor: "#c65cff", color: "white"}}
        to="/"
      >
        Emp
      </Link>
      {!user && (
        <Link
          className="btn btn-outline-danger text-decoration-none text-dark px-3 mx-5 cursor-pointer"
          to="/login"
        >
          Login
        </Link>
      )}
      {user && (
        <Link
          className="btn btn-outline-danger text-decoration-none text-dark px-3 mx-5 cursor-pointer"
          to="/"
          onClick={logout}
        >
          Logout
        </Link>
      )}
    </nav>
  );
}

export default Navbar;
