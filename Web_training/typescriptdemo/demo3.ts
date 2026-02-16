interface Employee {
    display() : Employee;
}

class CEO implements Employee {
    // id: number;
    // name: string; // if don't want to write this then use private
    constructor(private id: number, private name: string) {
        this.id = id;
        this.name = name;
    }

    public display() : Employee {
        console.log(`Employee data is id: ${this.id} and name: ${this.name}`)
        return this;
    }
}

// function display(): Employee {
//     let e = new CEO(1, "Trupti");
//     return e;
// }

// let e1 = display();
// console.log(e1)

let e: Employee = new CEO(1, "Trupti");
let emp = e.display();