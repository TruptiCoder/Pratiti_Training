import { render, screen } from '@testing-library/react';
import App from './App';

// test('renders learn react link', () => {
//   render(<App />);
//   const linkElement = screen.getByText(/learn react/i);
//   expect(linkElement).toBeInTheDocument();
// });

test('check if my name trupti is present in app', () => {
  render(<App />);
  const myName = "trupti";
  const cName = screen.getByText(myName);
  expect(cName).toBeInTheDocument();
})

test("check is enter name exists", () => {
  render(<App />)
  const cText = screen.getByText("Enter name");
  expect(cText).toBeInTheDocument();
  const cLabelText = screen.getByText("Enter Name:");
  expect(cLabelText).toBeInTheDocument();
})

test("check is enter your name exists in placeholder", () => {
  render(<App />)
  const cText = screen.getByPlaceholderText("Enter your name");
  expect(cText).toBeInTheDocument();
})

// it is alias of test
it('check label test with querySelector', () => { 
  render(<App />)
  // const label = document.querySelector("label");
  // expect(label.textContent).toBe("Enter Name:")
  const label = screen.getByText("Enter Name:", {selector: "label"});
  expect(label).toBeInTheDocument();
})