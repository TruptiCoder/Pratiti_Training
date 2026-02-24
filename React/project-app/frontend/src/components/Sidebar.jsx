import { useStore } from "../store.js";
import Info from "./Info";

function Sidebar({ employee }) {
  const user = useStore((state) => state.user);

  const offcanvasId = `offcanvas-${employee.id}`;

  return (
    <>
      <button
        className="btn btn-primary"
        type="button"
        data-bs-toggle="offcanvas"
        data-bs-target={`#${offcanvasId}`}
        aria-controls={offcanvasId}
      >
        View Profile
      </button>

      <div
        className="offcanvas offcanvas-end"
        tabIndex="-1"
        id={offcanvasId}
        aria-labelledby="offcanvasExampleLabel"
      >
        <div className="offcanvas-header">
          <h5 className="offcanvas-title" id="offcanvasExampleLabel">
            Total Employees: 3
          </h5>
          <button
            type="button"
            className="btn-close"
            data-bs-dismiss="offcanvas"
            aria-label="Close"
          ></button>
        </div>
        <div className="offcanvas-body">
          <Info employee={employee} user={user} />
        </div>
      </div>
    </>
  );
}

export default Sidebar;
