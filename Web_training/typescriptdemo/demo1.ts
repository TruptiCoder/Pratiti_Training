
let y:number = 10;
console.log(y);

class Hello {

}

// clouser
function myCoutner () {
    let counter = 0;
    return function() {
        counter++;
        console.log(counter);
        return counter;
    }
}

const add = myCoutner();
add()
add()
add()

// tsc demo1.ts to compile code to js file
// node demo1.ts to run directly via node