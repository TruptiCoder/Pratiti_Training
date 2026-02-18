import React, { useState } from "react";

function Calculator() {
    let [count, setCount] = useState(0);
    let [num1, setNum1] = useState(0);
    let [num2, setNum2] = useState(0);
    let [result, setResult] = useState(0);



    function increaseCounter() {
        setCount(count + 1);
    }

    function decrementCounter() {
        setCount(count - 1);
    }

    function handleCalc(sign) {
        if(sign == "+") {
            setResult(+num1 + +num2);
        }
        else if(sign == "-") {
            setResult(num1 - num2);
        }
        else if(sign == "*") {
            setResult(num1 * num2);
        }
        else if(sign == "/") {
            setResult(num1 / num2);
        }
    }

    return (
        <div className="m-5 p-5 text-bg-dark rounded d-flex align-items-center justify-content-center flex-column">
            <h1 className="text-warning">Calculator</h1>
            <p className="fs-3">Counter: {count}</p>
            <div>
                <button className="btn btn-primary mx-2" onClick={increaseCounter}>
                    Increase counter
                </button>
                <button className="btn btn-danger mx-2" onClick={decrementCounter}>
                    Decrement counter
                </button>
            </div>

            <input className="form-control w-25 m-3" type="number" name="num1" id="num1" value={num1} onChange={(e) => setNum1(e.target.value)}  />
            <input className="form-control w-25 m-3" type="number" name="num1" id="num1" value={num2} onInput={(e) => setNum2(e.target.value)}  />
            <div>
                <button className="btn btn-primary px-2 m-3" onClick={() => handleCalc("+")}>Addition</button>
                <button className="btn btn-warning px-2 m-3" onClick={() => handleCalc("-")}>Subtract</button>
                <button className="btn btn-danger px-2 m-3" onClick={() => handleCalc("*")}>Multiply</button>
                <button className="btn btn-success px-2 m-3" onClick={() => handleCalc("/")}>Division</button>
            </div>
            <p>Result: {result}</p>
        </div>
    );
}

export default Calculator;
