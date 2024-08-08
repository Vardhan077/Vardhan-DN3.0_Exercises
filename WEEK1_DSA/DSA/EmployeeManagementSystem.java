

// Main class
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(10);

        manager.addEmployee(new Employee(1, "Alice", "Developer", 70000));
        manager.addEmployee(new Employee(2, "Bob", "Manager", 85000));
        manager.addEmployee(new Employee(3, "Charlie", "Analyst", 60000));
        manager.addEmployee(new Employee(4, "David", "Designer", 65000));

        System.out.println("All employees:");
        manager.displayAllEmployees();

        System.out.println("\nSearching for employee with ID 3:");
        Employee employee = manager.searchEmployeeById(3);
        if (employee != null) {
            System.out.println("Found: " + employee);
        } else {
            System.out.println("Employee not found.");
        }

        System.out.println("\nDeleting employee with ID 2:");
        boolean isDeleted = manager.deleteEmployeeById(2);
        System.out.println("Deleted: " + isDeleted);

        System.out.println("\nAll employees after deletion:");
        manager.displayAllEmployees();
    }
}


class Employee {
    private int id;
    private String fullName;
    private String jobTitle;
    private double pay;

    public Employee(int employeeId, String name, String position, double salary) {
        this.id = employeeId;
        this.fullName = name;
        this.jobTitle = position;
        this.pay = salary;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public double getPay() {
        return pay;
    }

    @Override
    public String toString() {
        return "Employee ID: " + id + ", Name: " + fullName + ", Position: " + jobTitle + ", Salary: $" + pay;
    }
}

class EmployeeManager {
    private Employee[] employees;
    private int size;

    public EmployeeManager(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public void addEmployee(Employee employee) {
        if (size < employees.length) {
            employees[size++] = employee;
        } else {
            System.out.println("Array is full. Cannot add more employees.");
        }
    }

    public Employee searchEmployeeById(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    public void displayAllEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public boolean deleteEmployeeById(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId() == employeeId) {
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--size] = null;
                return true;
            }
        }
        return false;
    }
}