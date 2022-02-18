import java.util.ArrayList;

public interface Library {
    /*
     * to get the records of all books which is written by the author based on
     * criteria title asc/desc, year asc/desc, rating asc/desc
     */
    public void displayRecordsOfBookUsingCriteria(int choice, String authorName);

    /*
     * the most prolific author? maximum number of books which is written by the
     * author
     */
    public void profilicAuthor();

    /*
     * get the author list from their book name/title
     */
    public ArrayList<String> getAuthorsFromBookName(String bname);

    /*
     * get the list of books which is written in the given year
     */

    public ArrayList<String> writtenAllBooksInTheYear(int year);

    /*
     * to find the author wheather it is present or not in the list of authors
     */
    public Author findAuthor(String authorName);

}


