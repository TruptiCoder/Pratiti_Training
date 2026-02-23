import { useReducer } from "react";

const initialScore = [
  {
    id: 1,
    score: 0,
    name: "John",
  },
  {
    id: 2,
    score: 0,
    name: "Sally",
  },
];

const reducer = (state, action) => {
  switch (action.type) {
    case "INCREASE":
      return state.map((player) => {
        if (player.id === action.id) {
          return { ...player, score: player.score + 1 };
        } else {
          return player;
        }
      });
    default:
      return state;
  }
};

function UseReducer() {
  const [score, dispatch] = useReducer(reducer, initialScore);

  const handleIncrease = (player) => {
    dispatch({ type: "INCREASE", id: player.id });
  };

  return (
    <div className="m-5 p-5 text-bg-light rounded d-flex flex-column align-items-center">
      <h3>Use Reducer Demo</h3>
      <div>
        {score.map((player) => (
          <div className="d-inline mx-2" key={player.id}>
            <label>
              <input
                className="btn btn-primary px-3 m-2"
                type="button"
                onClick={() => handleIncrease(player)}
                value={player.name}
              />
              {player.score}
            </label>
          </div>
        ))}
      </div>
    </div>
  );
}

export default UseReducer;
