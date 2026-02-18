import "./App.css";
// import * as x from './Abc.js';
import { Abc, Def } from "./Abc.js";
import A from "./A.js";
import B from "./B.js";

function App() {
    const employees = [
        { name: "John", age: 20 },
        { name: "Jane", age: 20 },
        { name: "Jack", age: 21 },
        { name: "Josh", age: 50 },
    ];

    let name = "Trupti Balbudhe"

    return (
        <div className="App">
            {/* <x.Abc />
      <x.Def /> */}

            {/* <h3>ABC with props</h3>
            <Abc emp={employees} userId={100} />
            <h3>ABC without props</h3> */}
            {/* <Abc />
            <Def /> */}

            <A>
                <p>Para of A {name}</p>
            </A>
            <B name={"Trupti"} age={20} />
        </div>
    );
}

export default App;

// class App extends React.Component {
//   render() {
//     return (
//       <div className='App'>
//         <h1>Hello world</h1>
//         <p>This is a paragraph</p>
//       </div>
//     );
//   }
// }
