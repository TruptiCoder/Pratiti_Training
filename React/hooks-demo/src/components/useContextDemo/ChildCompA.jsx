import React from 'react'
import ChildOfChildA from './ChildOfChildA';

function ChildCompA() {
  return (
    <div>
        <h2>ChildCompA</h2>
        <hr />
        <ChildOfChildA />
    </div>
  )
}

export default ChildCompA