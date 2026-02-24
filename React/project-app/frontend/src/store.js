import { create } from 'zustand'

export const useStore = create((set) => ({
  employees: [],
  user: null,
  removeUser: () => set({ user: null }),
  updateUser: (newUser) => set({ user: newUser }),
  setEmployees: (employees) => set({ employees }),
  removeEmployee: (id) => set((state) => ({
    employees: state.employees.filter(emp => emp.id !== id)
  })),
}))