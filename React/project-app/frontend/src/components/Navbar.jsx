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
        className="text-bg-primary text-decoration-none p-2 rounded-5"
        to="/"
      >
        Emp
      </Link>
      {!user && (
        <Link
          className="text-decoration-none text-dark px-5 cursor-pointer"
          to="/login"
        >
          Login
        </Link>
      )}
      {user && (
        <Link
          className="text-decoration-none text-dark px-5 cursor-pointer"
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
