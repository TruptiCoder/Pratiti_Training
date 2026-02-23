import { test, expect } from "vitest";
import { render, screen } from "@testing-library/react";
import MyComp from "./MyComp";
import sum from "./sum";

test("test sum method", () => {
  expect(sum(2, 3)).toBe(5);
});

test("test MyComp renders text", () => {
  render(<MyComp />);
  expect(screen.getByText("trupti")).toBeInTheDocument();
});