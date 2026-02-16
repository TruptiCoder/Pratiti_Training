let isActive = true; // infer : TS assums to be a boolean
let isSafe: boolean = false; // explicit

// default return type is any
// types can be: never, void, any, number, string, boolean, object, etc
// ...rest is similar to spread operator in JS
function add (i: number, j: string = "abc", k?: number, ...rest: number[]) : number {
    console.log(i + j);
    console.log(k);
    console.log(rest);
    return 0;
}

add(35, "hehehe", 5, 1, 2, 3, 5);

let numbers: readonly number[] = [1, 2, 3, 4]; // readonly => immutable