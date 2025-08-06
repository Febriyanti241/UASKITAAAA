import java.util.*;

public class Library {
    private List<Book> books;
    private List<Member> members;
    
    public Library() {
        this.books = new ArrayList<Book>(); 
        this.members = new ArrayList<Member>(); 
    }
    
    public int getBookCount(){
        return this.books.size(); // Remove this line and implement it correctly
    }

    public void addBook(Book book) {
        if(book!=null){
            books.add(book);
        }
    }

    // TODO: Implement getMembers method
    // this method should return a new (different List) than the List in this object.
    // Make sure you copy the values to a new List before return it.
    public List<Book> getBooks(){
        return new ArrayList<>(this.books); // Remove this line and implement it correctly
    }

    public int getMemberCount(){
        return this.members.size(); // Remove this line and implement it correctly
    }

    public void addMember(Member member) {
        if (member !=null){
            members.add(member);

        }
    }

    // TODO: Implement getMembers method
    // this method should return a new (different List) than the List in this object.
    // Make sure you copy the values to a new List before return it.
    public List<Member> getMembers(){
        return new ArrayList<>(this.members); // Remove this line and implement the method
    }
    
    // TODO: Implement findBookByIsbn method
    public Book findBookByIsbn(String isbn) {
        // Your code here - use loop to find book with matching ISBN
        for(Book book : this.books){
            if(book.getIsbn().equals(isbn)){
                return book;
            }
        }
        return null; // Remove this line and implement the method
    }
    
    // TODO: Implement findMemberById method
    public Member findMemberById(String memberId) {
        // Your code here
        for(Member member : this.members){
            if(member.getMemberId().equals(memberId)){
                return member;
            }
        }
        return null; // Remove this line and implement the method
    }
    
    // TODO: Implement borrowBook method
    // Find member and book, then call member's borrowBook method
    public boolean borrowBook(String memberId, String isbn) {
        // Your code here
        Member member = findMemberById(memberId);
        Book book = findBookByIsbn(isbn);
        if ((member != null && book!= null) && book.isAvailable() ){
            member.addBorrowedBooks(book);
            book.setAvailable(false);
            return true;
        }
        return false; // Remove this line and implement the method
    }
    
    // TODO: Implement returnBook method
    // Find member and book, then call member's returnBook method
    public boolean returnBook(String memberId, String isbn) {
        // Your code here
        Member member = findMemberById(memberId);
        Book book = findBookByIsbn(isbn);
        if (member != null && book!= null){
            for (Book borrow: member.getBorrowedBooks()){
                if (borrow.equals(book)){
                    member.removeBorrowedBook(book);
                    book.setAvailable(true);
                    return true;
                }
            }
        }
        return false; // Remove this line and implement the method
    }
    
    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println("- " + book);
            }
        }
    }
}
