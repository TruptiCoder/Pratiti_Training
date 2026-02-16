var y = 10;
console.log(y);
var Hello = /** @class */ (function () {
    function Hello() {
    }
    return Hello;
}());
function myCoutner() {
    var counter = 0;
    return function () {
        counter++;
        console.log(counter);
        return counter;
    };
}
var add = myCoutner();
add();
add();
add();
