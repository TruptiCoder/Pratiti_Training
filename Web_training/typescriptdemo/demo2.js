var isActive = true; // infer : TS assums to be a boolean
var isSafe = false; // explicit
function add(i, j) {
    console.log(i + j);
}
add(35, 123);
