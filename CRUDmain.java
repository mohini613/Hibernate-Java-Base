package CRUDopreJavaBase;

import java.util.Scanner;

public class CRUDmain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudCRUD studCrud = new StudCRUD();  // Instantiate StudCRUD to perform operations
        
        while (true) {
            System.out.println("Choose an operation:");
            System.out.println("1. Create Employee");
            System.out.println("2. Read Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    CRUD newEmployee = new CRUD();  // Correct the instance name
                    System.out.println("Enter Employee ID:");
                    newEmployee.setStudId(scanner.nextInt());
                    System.out.println("Enter Employee Name:");
                    newEmployee.setStudeName(scanner.next());
                    System.out.println("Enter Employee Marks:");
                    newEmployee.setMarks(scanner.nextDouble());
                    System.out.println("Enter Employee Subjects:");
                    newEmployee.setSubjects(scanner.next());
                    System.out.println("Enter Employee Department:");
                    newEmployee.setDepartment(scanner.next());
                    studCrud.createEmployee(newEmployee);  // Call the create method from StudCRUD
                    System.out.println("Employee Created!");
                    break;
                case 2:
                    System.out.println("Enter Employee ID:");
                    int id = scanner.nextInt();
                    CRUD employee = studCrud.readEmployee(id);  // Call the read method from StudCRUD
                    if (employee != null) {
                        System.out.println("Employee Details: " + employee.getStudeName() + ", " + employee.getMarks() + ", " + employee.getSubjects() + ", " + employee.getDepartment());
                    } else {
                        System.out.println("Employee not found!");
                    }
                    break;
                case 3:
                    System.out.println("Enter Employee ID to update:");
                    int updateId = scanner.nextInt();
                    CRUD updateEmployee = studCrud.readEmployee(updateId);  // Read the existing employee
                    if (updateEmployee != null) {
                        System.out.println("Enter new Employee Name:");
                        updateEmployee.setStudeName(scanner.next());
                        System.out.println("Enter new Employee Marks:");
                        updateEmployee.setMarks(scanner.nextDouble());
                        System.out.println("Enter new Employee Subjects:");
                        updateEmployee.setSubjects(scanner.next());
                        System.out.println("Enter new Employee Department:");
                        updateEmployee.setDepartment(scanner.next());
                        studCrud.updateEmployee(updateEmployee);  // Call the update method from StudCRUD
                        System.out.println("Employee Updated!");
                    } else {
                        System.out.println("Employee not found!");
                    }
                    break;
                case 4:
                    System.out.println("Enter Employee ID to delete:");
                    int deleteId = scanner.nextInt();
                    studCrud.deleteEmployee(deleteId);  // Call the delete method from StudCRUD
                    System.out.println("Employee Deleted!");
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
