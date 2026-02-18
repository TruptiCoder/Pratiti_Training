import React, { useState } from 'react'

function Gender() {
    const [name, setName] = useState("")
    const [gender, setGender] = useState("");
  return (
    <div className="m-5 text-bg-dark p-5 rounded">
        <label htmlFor="name">Full Name: </label>
        <input className='form-control w-25 m-3' type="text" placeholder='Enter full name' value={name} id='name' onInput={(e) => setName(e.target.value)} />

        <label className='m-3'>Gender: </label>
        Male: <input className='form-check-control m-3' type="radio" name="gender" value="male" onChange={(e) => setGender(e.target.value)} />
        Female: <input type="radio" className='form-check-control m-3' name="gender" value="female" onChange={(e) => setGender(e.target.value)} />
        Other: <input type="radio" className='form-check-control m-3' name="gender" value="other" onChange={(e) => setGender(e.target.value)} />
        <p className='m-3'>Name: {gender == "male" && "Mr."} {gender == "female" && "Ms."} {name}</p>
    </div>
  )
}

export default Gender