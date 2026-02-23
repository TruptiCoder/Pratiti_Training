import React, { useEffect, useRef, useState } from 'react'

function UseRefDemo() {
  const inputElement = useRef();

  const focusInput = () => {
    // console.log(inputElement.current.value)
    inputElement.current.focus();
  };

  return (
    <div className='m-5 p-5 text-bg-dark rounded'>
      <input className='form-control w-25 d-inline mx-2' type="text" ref={inputElement} />
      <button className='btn btn-outline-primary' onClick={focusInput}>Print Input Value</button>
    </div>
  );
}

export default UseRefDemo