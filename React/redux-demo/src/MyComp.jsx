import { useDispatch, useSelector } from "react-redux";
import { increment, decrement } from "./actions";

function MyComp() {
  const count = useSelector((state) => state.count);
  const dispatch = useDispatch();

  return (
    <div className="text-bg-dark rounded p-5 m-5">
      <h1>My Comp</h1>
      <p>count: {count}</p>
      <button
        className="btn btn-danger"
        title="Increment"
        onClick={() => dispatch(increment())}
      >
        Increment
      </button>
      <button
        className="btn btn-danger mx-5"
        title="Decrement"
        onClick={() => dispatch(decrement())}
      >
        Decrement
      </button>
    </div>
  );
}

export default MyComp;
