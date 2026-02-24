import { useStore } from "../store.js";
import Sidebar from "./Sidebar";

function Card({ employee }) {
  const user = useStore((state) => state.user);
  const image = employee.image ? employee.image : "/placeholder.png";
  return (
    <div className="card m-3" style={{ width: "15rem" }}>
      <div className="card-body">
        <h6 className="card-title">Pratiti Technologies</h6>
      </div>
      <img src={image} className="card-img-top" />
      <div className="card-body">
        <h5 className="card-title">{employee.fullname}</h5>
        <p className="card-text">
          {employee.id}, {employee.designation}
        </p>
        {user.role == "admin" ? (
          <Sidebar employee={employee} user={user} />
        ) : (
          employee.fullname == user.fullname && (
            <Sidebar employee={employee} user={user} />
          )
        )}
      </div>
    </div>
  );
}

export default Card;
