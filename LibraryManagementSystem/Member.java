package LibraryManagementSystem;
import java.time.LocalDate;
import java.util.*;
public class Member {
		    private int id;
	    private String name;

	    private List<Book> issuedBooks = new ArrayList<>();
	    private Map<Integer, LocalDate> issueDates = new HashMap<>();
	    private Map<Integer, LocalDate> dueDates = new HashMap<>();

	    public Member(int id, String name) {
	        this.id = id;
	        this.name = name;
	    }

	    public int getId() { return id; }
	    public String getName() { return name; }

	    public List<Book> getIssuedBooks() { return issuedBooks; }
	    public Map<Integer, LocalDate> getIssueDates() { return issueDates; }
	    public Map<Integer, LocalDate> getDueDates() { return dueDates; }
	}

