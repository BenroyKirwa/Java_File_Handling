package com.employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManagement {
    private List<Employee> employees;
    private String filePath;

    public EmployeeManagement(String filePath) {
        this.filePath = filePath;
        this.employees = new ArrayList<>();
        loadEmployees();
    }

    @SuppressWarnings("unchecked")  // Suppressing the unchecked cast warning since we know the file contains List<Employee>
    private void loadEmployees() {
        File file = new File(filePath);
        if (file.exists() && file.length() > 0) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                Object obj = ois.readObject();
                if (obj instanceof List<?>) {
                    List<?> list = (List<?>) obj;
                    // Verify that all elements are Employee objects
                    boolean allEmployees = list.stream().allMatch(item -> item instanceof Employee);
                    if (allEmployees) {
                        employees = (List<Employee>) list;
                        System.out.println("Current employees in the system:");
                        employees.forEach(System.out::println);
                    } else {
                        System.err.println("File contains invalid data");
                        employees = new ArrayList<>();
                    }
                } else {
                    System.err.println("File contains invalid data format");
                    employees = new ArrayList<>();
                }
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error loading employees: " + e.getMessage());
                employees = new ArrayList<>();
            }
        } else {
            try {
                file.createNewFile();
                System.out.println("New employee file created at: " + filePath);
            } catch (IOException e) {
                System.err.println("Error creating file: " + e.getMessage());
            }
        }
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        saveEmployees();
    }

    private void saveEmployees() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(employees);
            System.out.println("Employees saved successfully");
        } catch (IOException e) {
            System.err.println("Error saving employees: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide the file path as a command-line argument");
            return;
        }

        EmployeeManagement manager = new EmployeeManagement(args[0]);

        // Example usage:
        Employee newEmployee2 = new Employee("R009", "Jane Doe", 30000);
        Employee newEmployee = new Employee("E001", "John Doe", 50000.0);
        manager.addEmployee(newEmployee);
        manager.addEmployee(newEmployee2);
    }
}