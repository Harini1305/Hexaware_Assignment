package LibraryManagementSystem;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
public class LibrarySystem {
	    static List<Book> books = new ArrayList<>();
	    static List<Member> members = new ArrayList<>();
	    static Scanner sc = new Scanner(System.in);
	    static void createMember() {
	        System.out.print("Enter Member ID: ");
	        int id = sc.nextInt();
	        sc.nextLine();
	        System.out.print("Enter Name: ");
	        String name = sc.nextLine();
	        members.add(new Member(id, name));
	        System.out.println("Member created!");
	    }
	    static void addBook() {
	        System.out.print("Enter Book ID: ");
	        int id = sc.nextInt();
	        sc.nextLine();
	        System.out.print("Enter Title: ");
	        String title = sc.nextLine();
	        System.out.print("Enter Author: ");
	        String author = sc.nextLine();
	        books.add(new Book(id, title, author));
	        System.out.println("Book added!");
	    }
	    static Book findBook(int id) {
	        for (Book b : books)
	            if (b.getId() == id) return b;
	        return null;
	    }
	    static Member findMember(int id) {
	        for (Member m : members)
	            if (m.getId() == id) return m;
	        return null;
	    }
	    static void issueBook() {
	        System.out.print("Enter Member ID: ");
	        int mid = sc.nextInt();
	        System.out.print("Enter Book ID: ");
	        int bid = sc.nextInt();
	       Member m = findMember(mid);
	        Book b = findBook(bid);
	        if (m == null || b == null) {
	            System.out.println("Invalid member/book!");
	            return;
	        }
	        if (b.isIssued()) {
	            System.out.println("Book already issued!");
	            return;
	        }
	        LocalDate today = LocalDate.now();
	        LocalDate due = today.plusDays(7);
	        m.getIssuedBooks().add(b);
	        m.getIssueDates().put(bid, today);
	        m.getDueDates().put(bid, due);
	        b.setIssued(true);
	        System.out.println("Book issued! Due date: " + due);
	    }
	    static void returnBook() {
	        System.out.print("Enter Member ID: ");
	        int mid = sc.nextInt();
	        System.out.print("Enter Book ID: ");
	        int bid = sc.nextInt();
	        Member m = findMember(mid);
	        Book b = findBook(bid);
	        if (m == null || b == null || !b.isIssued()) {
	            System.out.println("Invalid return!");
	            return;
	        }
	        LocalDate today = LocalDate.now();
	        LocalDate due = m.getDueDates().get(bid);
	        long lateDays = ChronoUnit.DAYS.between(due, today);
	        int fine = 0;
	        if (lateDays > 0) {
	            if (lateDays <= 5)
	                fine = (int) lateDays * 10;
	            else
	                fine = 5 * 10 + (int)(lateDays - 5) * 20;
	        }
	        m.getIssuedBooks().remove(b);
	        m.getIssueDates().remove(bid);
	        m.getDueDates().remove(bid);
	        b.setIssued(false);
	        System.out.println("Book returned!");
	        System.out.println("Fine: ₹" + fine);
	    }
	    static void removeBook() {
	        System.out.print("Enter Book ID to remove: ");
	        int id = sc.nextInt();

	        Book b = findBook(id);
	        if (b == null) {
	            System.out.println("Book not found!");
	            return;
	        }
	        books.remove(b);
	        System.out.println("Book removed!");
	    }
	    static void updateBook() {
	        System.out.print("Enter Book ID: ");
	        int id = sc.nextInt();
	        sc.nextLine();
	        Book b = findBook(id);
	        if (b == null) {
	            System.out.println("Book not found!");
	            return;
	        }
	        System.out.print("Enter new title: ");
	        b.setTitle(sc.nextLine());
	        System.out.print("Enter new author: ");
	        b.setAuthor(sc.nextLine());
	        System.out.println("Book updated!");
	    }

	    static void showBooks() {
	        for (Book b : books) {
	            System.out.println(
	                b.getId() + " | " +
	                b.getTitle() + " | " +
	                b.getAuthor() + " | " +
	                (b.isIssued() ? "Issued" : "Available")
	            );
	        }
	    }
	    static void removeMember() {
	        System.out.print("Enter Member ID to remove: ");
	        int id = sc.nextInt();
	        Member m = findMember(id);
	        if (m == null) {
	            System.out.println("Member not found!");
	            return;
	        }
	       members.remove(m);
	        System.out.println("Member removed!");
	    }
	    public static void main(String[] args) {
	        while (true) {
	            System.out.println("\n1.Create Member\n2.Issue Book\n3.Return Book\n4.Add Book\n5.Remove Book\n6.Update Book\n7.Show Books\n8.Remove Member\n9.Exit");
	            System.out.println("Enter Choice: ");
	            int ch = sc.nextInt();
	            switch (ch) {
	                case 1 -> createMember();
	                case 2 -> issueBook();
	                case 3 -> returnBook();
	                case 4 -> addBook();
	                case 5 -> removeBook();
	                case 6 -> updateBook();
	                case 7 -> showBooks();
	                case 8 -> removeMember();
	                case 9 -> System.exit(0);
	                default -> System.out.println("Invalid choice!");
	            }
	        }
	    }
	}