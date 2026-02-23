import sum from "./sum.js";

// test("test sum method", () => {
//     const addition = sum(5, 10);
//     expect(addition).toBe(15);
// })

let a;
let b;
let expected;

// beforeAll(() => {
//     console.log("Before all");
//     a = Math.random() * 100 + 1;
//     b = Math.random() * 100 + 1;
//     expected = a + b;
// })

beforeEach(() => {
    console.log("Before each");
    a = Math.random() * 100 + 1;
    b = Math.random() * 100 + 1;
    expected = a + b;
})

afterEach(() => {
    console.log("After each");
    a = 0;
    b = 0;
})

const test_sum1 = () => {
    expect(sum(a, b)).toBe(expected);
}

const test_sum2 = () => {
    expect(sum(a, b)).not.toBe(205);
}

// Grouping test cases
describe("test sum method", () => {
    test("test 1", test_sum1);
    test("test 2", test_sum2);
})

test.each([
    [1, 4, 5],
    [6, 11, 17],
    [5, 7, 12]
])("add(%i, %i)", (a, b, expected) => {
    expect(sum(a, b)).toBe(expected);
})