import React, { createContext, useState } from 'react'
import ChildCompA from './ChildCompA';

const FirstName = createContext("");
const LastName = createContext("");

function UCRoot() {

    const [fname, setFname] = useState("");
    const [lname, setLname] = useState("");

  return (
    <div className='my-5 p-5 text-bg-light rounded w-50 mx-auto d-flex flex-column'>
        <h1>User Context Demo</h1>
        Fname: <input className='form-control my-2' type="text" value={fname} onChange={(e) => setFname(e.target.value)} />
        Lname: <input className='form-control my-2' type="text" value={lname} onChange={(e) => setLname(e.target.value)} />

        <p className='m-2'>Result: {fname} {lname}</p>

        <hr />

        <FirstName.Provider value={fname}>
            <LastName.Provider value={lname}>
                <ChildCompA />
            </LastName.Provider>
        </FirstName.Provider>
    </div>
  )
}

export default UCRoot
export {FirstName, LastName}