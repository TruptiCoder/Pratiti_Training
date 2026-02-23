import React from 'react'
import {FirstName, LastName} from "./UCRoot";

function ChildOfChildA() {
  return (
    <div>
        <h2>ChildOfChildA</h2>
        <FirstName.Consumer>
            {(fname) => {
                return (`First Name: ${fname}`);
            }}
        </FirstName.Consumer>
        <br />
        <LastName.Consumer>
            {(lname) => {
                return (`Last Name: ${lname}`);
            }}
        </LastName.Consumer>
        
        <h5>Full Name: {FirstName} {LastName}</h5>
    </div>
  )
}

export default ChildOfChildA;