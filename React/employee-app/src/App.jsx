import "./App.css";
import { Button } from "react-bootstrap";
import toast, { Toaster } from "react-hot-toast";
import Calculator from "./components/Calculator";
import { useState } from "react";
import Apple from "./components/Apple";
import Orange from "./components/Orange";
import Fruits from "./components/Fruits";
import Gender from "./components/Gender";

function App() {
    function add(e) {
        toast.success(`${e.target.innerText} created successfully`);
    } 

    let [fruit, setFruit] = useState("apple");

    return (
        <>
            <div className="m-5 text-bg-dark p-5 rounded">
                <Toaster />
                <h1>Employee Manangement System</h1>
                <Button variant="primary" onClick={() => add(event)}>
                  Employee
                </Button>

                <div className="text-bg-info w-20 mx-auto rounded p-3 my-3">
                  <input type="text" name="fruit" id="fruit" value={fruit} onChange={(e) => setFruit(e.target.value)} /> tip: write apple or orange
                  {fruit.toLowerCase() == "apple" && <Apple />}
                  {fruit.toLowerCase() == "orange" && <Orange />}
                </div>
            </div>
            <Calculator />
            <Fruits />
            <Gender />
        </>
    );
}

export default App;
