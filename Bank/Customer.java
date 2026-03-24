package hexaware;
import java.util.*;

class Customer {
    private int accountNumber;
    private String name;
    private double balance;
    private String accountType;
    private String email;
    
    public Customer(int accountNumber, String name, double balance, String accountType, String email) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
        this.accountType = accountType;
        this.email = email;
    }

    public int getAccountNumber(){
    	return accountNumber; 
    	}
    public String getName(){ 
    	return name; 
    	}
    public double getBalance(){ 
    	return balance; 
    	}
    public String getAccountType(){
    	return accountType; 
    	}
    public String getEmail(){ 
    	return email; 
    	}
    public void setAccountNumber(int accountNumber){
    	this.accountNumber = accountNumber; 
    	}
    public void setName(String name){
    	this.name = name; 
    	}
    public void setBalance(double balance){
    	this.balance = balance; 
    	}
    public void setAccountType(String accountType){
    	this.accountType = accountType;
    	}
    public void setEmail(String email){
    	this.email = email; 
    	}
}

class BankSystem{

    static ArrayList<Customer> list = new ArrayList<>();
    public static void createCustomer(Customer c) {
        list.add(c);
    }
    public static Customer searchCustomer(int accNo){
        for (Customer c : list) {
            if (c.getAccountNumber()==accNo) {
                return c;
            }
        }
        return null;
    }
    public static void deposit(int accNo, double amt) {
        Customer c = searchCustomer(accNo);
        if (c!=null) {
            c.setBalance(c.getBalance() + amt);
        }
    }
    public static void withdraw(int accNo, double amt) {
        Customer c = searchCustomer(accNo);
        if (c!=null && c.getBalance()>=amt) {
            c.setBalance(c.getBalance()-amt);
        }
    }
    public static void balance(int accNo) {
        Customer c = searchCustomer(accNo);
        if (c!=null) {
            System.out.println("Balance: "+c.getBalance());
        }
    }
    public static void transfer(int from, int to, double amt) {
        Customer c1 = searchCustomer(from);
        Customer c2 = searchCustomer(to);

        if (c1!=null && c2!=null && c1.getBalance()>=amt) {
            c1.setBalance(c1.getBalance()-amt);
            c2.setBalance(c2.getBalance()+amt);
        }
    }
    public static void display() {
        for (Customer c : list) {
            System.out.println("no "+c.getAccountNumber() + " name " +
                               c.getName() + " balance " +
                               c.getBalance());
        }
    }
    public static void main(String[] args) {

        createCustomer(new Customer(1, "A", 50000, "Savings", "a@gmail.com"));
        createCustomer(new Customer(2, "B", 30000, "Current", "b@gmail.com"));

        deposit(1, 1000);
        withdraw(2, 500);
        transfer(1, 2, 1000);

        balance(1);
        display();
    }
}