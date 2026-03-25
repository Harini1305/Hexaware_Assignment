package examples;
import java.util.Scanner;


	class InvalidAgeException extends Exception {
	    public InvalidAgeException(String message) {
	        super(message);
	    }
	}

	public class exceptionHandling {

	    public static void main(String[] args) {
	        Scanner s = new Scanner(System.in);

	        try {
	            System.out.print("Enter your age: ");
	            int age = s.nextInt();

	            if (age < 0 ) {
	                throw new InvalidAgeException("Age must be  above 0");
	            }

	            System.out.println("Valid age");

	        } catch (InvalidAgeException e) {
	            System.out.println(e.getMessage());
	        } 
	    }
	}
