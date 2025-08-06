// TODO: You may need to extend or implement other class or interface
public class Book { 
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;
    
    // TODO: Complete the constructor
    public Book(String title, String author, String isbn) {
        this.title=title;
        this.author=author;
        this.isbn=isbn;
        this.isAvailable=true;
    }
    
    // TODO: Implement getter methods
    public String getTitle() {
        // Your code here
        return this.title; // Remove this line and return the title
    }
    
    public String getAuthor() {
        // Your code here
        return this.author; // Remove this line and return the author
    }
    
    public String getIsbn() {
        // Your code here
        return this.isbn; // Remove this line and return the isbn
    }
    
    public boolean isAvailable() {
        // Your code here
        return this.isAvailable; // Remove this line and return the availability status
    }
    
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }
    
    @Override
    public String toString() {
        return String.format("Book{title='%s', author='%s', isbn='%s', available=%s}", 
                           title, author, isbn, isAvailable);
    }

    // TODO: You may need to implements/overrides additional methods
    public boolean equals(Book other){
        if (other == null){
            return false;
        }
        else if (this.isbn==null&&other.getIsbn()==null){
            return true;
        }
        else if (this.isbn!=null&&this.isbn.equals(other.getIsbn())) {
            return true;
        }
        return false;
    }
}
