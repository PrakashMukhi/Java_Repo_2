import java.util.ArrayList;
import java.util.List;

public class Author {

    /*
     * fields for author entity
     */
    private String authorName;
    private ArrayList<Books> booksList = new ArrayList<Books>();

    public Author(String authorName, Books book) {
        super();
        this.authorName = authorName.trim().replaceAll("\\s+", " ");
        this.addBook(book);

    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public List<Books> getBooksList() {
        return booksList;
    }

    public void setBooksList(ArrayList<Books> booksList) {
        this.booksList = booksList;
    }

    /*
     * @return type:void Add a new book to an authors list
     */
    public void addBook(Books book) {
        this.booksList.add(book);
    }

    /*
     * @return type is List . it will return list of books.
     */
    public ArrayList<Books> getAllBooks() {
        return booksList;
    }

    /*
     * @return type boolean
     * input param: name of book
     * this method return true if book is present in the list of books else return false if not present
     */

    public boolean findBookInList(String bname) {
        for (Books book : this.booksList) {
            if (book.getTitle().equals(bname)) {
                return true;
            }
        }
        return false;
    }

}
