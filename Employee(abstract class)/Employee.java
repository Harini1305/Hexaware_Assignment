package hexaware;

abstract class Employee {
 int empId;
 String name;

 Employee(int empId, String name) {
     this.empId = empId;
     this.name = name;
 }

 abstract int calculateSalary();

 void display() {
     System.out.println("ID: " + empId + ", Name: " + name);
 }
}
class TemporaryEmployee extends Employee {
 int hoursWorked;
 int ratePerHour;

 TemporaryEmployee(int empId, String name, int hoursWorked, int ratePerHour) {
     super(empId, name);
     this.hoursWorked = hoursWorked;
     this.ratePerHour = ratePerHour;
 }

 int calculateSalary() {
     return hoursWorked * ratePerHour;
 }

 void display() {
     super.display();
     System.out.println("Temporary");
     System.out.println("Hours: " + hoursWorked + ", Rate: " + ratePerHour);
     System.out.println("Salary: " + calculateSalary());
 }
}
class PermanentEmployee extends Employee {
 int basicSalary, bonus;

 PermanentEmployee(int empId, String name, int basicSalary, int bonus) {
     super(empId, name);
     this.basicSalary = basicSalary;
     this.bonus = bonus;
 }

 int calculateSalary() {
     return basicSalary + bonus;
 }

 void display() {
     super.display();
     System.out.println("Permanent");
     System.out.println("Basic: " + basicSalary + ", Bonus: " + bonus);
     System.out.println("Salary: " + calculateSalary());
 }
}