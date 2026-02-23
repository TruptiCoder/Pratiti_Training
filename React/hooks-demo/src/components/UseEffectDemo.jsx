import{ useEffect, useState } from "react";

function UseEffectDemo() {
  const [count, setCount] = useState(0);
  const [count2, setCount2] = useState(0);
  
  useEffect(() => {
    console.log("UseEffectDemo mounted");
    setTimeout(() => {
      setCount(count + 1);
    }, 2000)

    return () => {
      console.log("UseEffectDemo unmounted")
    }
  }, [count2])

  return <div className="m-5 p-5">
    <h1>Hooks demo: component loaded {count} times</h1>
    <button className="btn btn-danger px-5" onClick={() => setCount2(count2 + 1)}>{count2}</button>
  </div>
}

export default UseEffectDemo;
