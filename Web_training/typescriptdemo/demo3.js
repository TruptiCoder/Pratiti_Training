var CEO = /** @class */ (function () {
    function CEO(id, name) {
        this.id = id;
        this.name = name;
    }
    CEO.prototype.display = function () {
        console.log("Employee data is id: ".concat(this.id, " and name: ").concat(this.name));
        return this;
    };
    return CEO;
}());
// function display(): Employee {
//     let e = new CEO(1, "Trupti");
//     return e;
// }
// let e1 = display();
// console.log(e1)
var e = new CEO(1, "Trupti");
var emp = e.display();
