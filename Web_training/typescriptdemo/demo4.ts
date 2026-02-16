interface Student {
    rollNo: number;
    name: string;
}

const st = [
    { rollNo: 1, name: "Trupti" },
    { rollNo: 2, name: "Shweta" },
];

let s: Student[] = st
// console.log(s);

function displayStudents(students: Student[]) {
    students.forEach((val) => {
        console.log(val.rollNo, val.name);
    })
}

displayStudents(st);

// Type casting
let x : unknown = "hello"
console.log((x as string).length);