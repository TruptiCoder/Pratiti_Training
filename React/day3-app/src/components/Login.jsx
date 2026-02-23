import React, { useState } from "react";

function Login() {
    const [userInput, setUserInput] = useState({});
    const [msg, setMsg] = useState("");

    const handleSubmit = async (e) => {
        e.preventDefault();
        const res = await fetch("http://192.168.1.75:5050/auth/login", {
            method: "POST",
            headers: {
            "Content-Type": "application/json"
            },
            body: JSON.stringify({
                username: userInput.username,
                password: userInput.password
            })
        });
        const data = await res.json()
        if(data.success) setMsg("Login sucessfull")
        else setMsg("login failed");
        // setMsg(`Username: ${userInput.username} | Password: ${userInput.password}`);
        setUsername("");
        setPassword("");
    }

    return (
        <div className="m-5 p-5 text-bg-dark rounded">
            <h2 className="text-center">Login Component</h2>
            <p className="text-center">Login Form</p>
            <form onSubmit={handleSubmit} className="d-flex flex-column align-item-center mx-auto w-50">
                <div className="mb-3">
                    <label className="form-label" htmlFor="username">
                        User Name:{" "}
                    </label>
                    <input
                        type="text"
                        className="form-control"
                        name="username"
                        id="username"
                        value={userInput.username}
                        onChange={(e) => setUserInput({...userInput, [e.target.name]: e.target.value})}
                    />
                </div>
                <div className="mb-3">
                    <label className="form-label" htmlFor="password">
                        Password:
                    </label>
                    <input
                        className="form-control"
                        type="password"
                        name="password"
                        id="password"
                        value={userInput.password}
                        onChange={(e) => setUserInput({...userInput, [e.target.name]: e.target.value})}
                    />
                </div>
                <input
                    className="btn btn-primary align-self-end px-4"
                    type="submit"
                    value="Login"
                />
            </form>
            {msg && <p className="text-center mt-5 w-50 mx-auto text-bg-warning p-2 rounded">{msg}</p>}
        </div>
    );
}

export default Login;
