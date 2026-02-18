function Abc({emp, userId}) {

    let uname = "Trupti";

    const myStyle = {
        backgroundColor: "crimson"
    }

    const emps = emp || Abc.defaultProps.emp;

    return (
        <>
            {
                userId && <p>Hello user id: {userId}</p>
            }

            <h1>This is ABC {uname} {userId}</h1>
            <table className="table table-dark table-striped w-50 mx-auto">
                <thead>
                    <tr>
                        <th style={myStyle}>Name</th>
                        <th>Age</th>
                    </tr>
                </thead>
                <tbody>
                    {emps.map((ele, idx) => {
                        return <tr>
                            <td>{ele.name}</td>
                            <td>{ele.age}</td>
                        </tr>
                    })}
                </tbody>
            </table>
        </>
    )
}

Abc.defaultProps = {
  emp: [
    {name: "Trupti", age: 20},
    {name: "abc", age: 21},
  ]
}


function Def() {

    let uname = "Trupti";

    return (
        <>
            <h1>This is DEF</h1>
            <h2>Hello</h2>
        </>
    )
}

export {Abc, Def};
