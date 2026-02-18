import { useState } from "react";
import toast from "react-hot-toast";

function Fruits() {
    const [fruits, setFruits] = useState([]);
    const [fruit, setFruit] = useState("");

    const addFruit = () => {
        setFruits((f) => [...f, fruit]);
        toast.success(`${fruit} is added!`);
        setFruit("");
    };

    return (
        <div className="m-5 text-bg-dark p-5 rounded">
            <h1>Fruits</h1>
            <div className="d-flex">
                <input
                    type="text"
                    className="form-control m-2 w-25"
                    value={fruit}
                    onInput={(e) => setFruit(e.target.value)}
                    placeholder="Enter a fruit name"
                />
                <button className="btn btn-success m-2" onClick={addFruit}>
                    Add Fruit
                </button>
                <select
                    className="form-control m-2 w-25"
                    name="fruits"
                    id="fruits"
                >
                    <option>Select</option>
                    {fruits.map((ele, idx) => (
                        <option key={idx}>{ele}</option>
                    ))}
                </select>
            </div>
        </div>
    );
}

export default Fruits;
