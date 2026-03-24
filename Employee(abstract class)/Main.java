package hexaware;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> empList = new ArrayList<>();
        int choice = 0;
        while (choice != 7) {
            System.out.println(" MENU ");
            System.out.println("1. Add Temporary Employee");
            System.out.println("2. Add Permanent Employee");
            System.out.println("3. Display All");
            System.out.println("4. Calculate Salary");
            System.out.println("5. Search by ID");
            System.out.println("6. Update Employee");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    int id1 = sc.nextInt();
                    System.out.print("Name: ");
                    String name1 = sc.next();
                    System.out.print("Hours: ");
                    int h = sc.nextInt();
                    System.out.print("Rate: ");
                    int r = sc.nextInt();
                    TemporaryEmployee t = new TemporaryEmployee(id1, name1, h, r);
                    empList.add(t);
                    t.display();
                    break;
                case 2:
                    System.out.print("ID: ");
                    int id2 = sc.nextInt();
                    System.out.print("Name: ");
                    String name2 = sc.next();
                    System.out.print("Basic: ");
                    int b = sc.nextInt();
                    System.out.print("Bonus: ");
                    int bo = sc.nextInt();
                    PermanentEmployee p=new PermanentEmployee(id2, name2, b, bo);
                    empList.add(p);
                    p.display();
                    break;
                case 3:
                    for (Employee e : empList) {
                        e.display();
                        System.out.println();
                    }
                    break;
                case 4:
                    for (Employee e : empList) {
                        System.out.println("ID: " + e.empId + 
                                           " Salary: " + e.calculateSalary());
                    }
                    break;
                case 5:
                    System.out.print("Enter ID: ");
                    int sid = sc.nextInt();
                    boolean found = false;
                    for (Employee e : empList) {
                        if (e.empId == sid) {
                            e.display();
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Not found!");
                    }
                    break;
                case 6:
                    System.out.print("Enter ID: ");
                    int uid = sc.nextInt();
                    boolean foundUpdate = false;
                    for (Employee e : empList) {
                        if (e.empId == uid) {
                        	if (e instanceof TemporaryEmployee) {
                        	    TemporaryEmployee t1 = (TemporaryEmployee) e;

                        	    System.out.print("New Hours: ");
                        	    t1.hoursWorked = sc.nextInt();
                        	    System.out.print("New Rate: ");
                        	    t1.ratePerHour = sc.nextInt();
                        	}
                        	else if (e instanceof PermanentEmployee) {
                        	    PermanentEmployee p1 = (PermanentEmployee) e;

                        	    System.out.print("New Basic: ");
                        	    p1.basicSalary = sc.nextInt();
                        	    System.out.print("New Bonus: ");
                        	    p1.bonus = sc.nextInt();
                        	}
                            foundUpdate = true;
                            System.out.println("Updated!");
                            break;
                        }
                    }
                    if (!foundUpdate) {
                        System.out.println("Not found!");
                    }
                    break;

                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}