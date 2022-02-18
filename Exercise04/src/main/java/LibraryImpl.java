import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;





/*
 * This is libraryImpl class which implements the library interface and its mehtods
 */
public class LibraryImpl implements Library {
    // instance for the list of author
    private ArrayList<Author> authorList = new ArrayList<Author>();
    // csv file path
    private static final String filename_path = "src/main/resources/Books.csv" ;

    public LibraryImpl() {
        try (Reader reader = Files.newBufferedReader(Paths.get(filename_path));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withDelimiter('\t')
                     .withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {
            for (CSVRecord csvRecord : csvParser) {
                // to get specific columns record from csv
                String authors = csvRecord.get("authors");
                String title = csvRecord.get("original_title");
                float year = Float.parseFloat(csvRecord.get("original_publication_year"));
                Double rating = Double.parseDouble(csvRecord.get("average_rating"));
                System.out.println("Authors:" + authors);
                System.out.println("Books:" + title);
                System.out.println("year:" + year);
                System.out.println("rating:" + rating);

                Books book = new Books(title, (int) year, rating);

                String[] authorValues = authors.split(",");

                for (String s : authorValues) {
                    Author author = findAuthor(s);
                    // if author is not present in the library add it to the list
                    if (author == null) {
                        authorList.add(new Author(s, book));
                        System.out.println();
                    }
                    // else add the book in to the booksList of author
                    else {
                        author.addBook(book);
                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * return type void
     * input parameter:no of choice used to select criteria,name of author
     * method take the books of given author and sort it depend on given
     * choice
     */
    public void displayRecordsOfBookUsingCriteria(int choice, String authorName) {
        Author author = findAuthor(authorName);
        if (author == null) {
            System.out.println("This author is not available in library");

        } else {
            ArrayList<Books> books = author.getAllBooks();
            if (choice == 1) {
                books.sort(Comparator.comparing(Books::getTitle));
            }
            if (choice == 2) {
                books.sort(Comparator.comparing(Books::getTitle));
                Collections.reverse(books);

            }
            if (choice == 3) {
                books.sort(Comparator.comparing(Books::getPublicationYear));

            }
            if (choice == 4) {
                books.sort(Comparator.comparing(Books::getPublicationYear));
                Collections.reverse(books);
            }
            if (choice == 5) {
                books.sort(Comparator.comparing(Books::getRating));
            }
            if (choice == 6) {
                books.sort(Comparator.comparing(Books::getRating));
                Collections.reverse(books);
            }

            System.out.println("Books of Given Author using criteria number " + choice + ":");
            for (int i = 0; i < books.size(); i++) {
                Books book = books.get(i);
                System.out.println("No. of Book :" + (i + 1));
                System.out.println("Name of Book :" + book.getTitle());
                System.out.println("Publication year of Book :" + book.getPublicationYear());
                System.out.println("Rating of Book :" + book.getRating());

            }
        }

    }

    /*
     * return type:List of String that is authors name list
     * input param:Name of book
     * This method returns the list of authors of given book
     */
    @Override
    public ArrayList<String> getAuthorsFromBookName(String bname) {
        ArrayList<String> authorsForBook = new ArrayList<String>();
        for (int i = 0; i < authorList.size(); i++) {

            if (authorList.get(i).findBookInList(bname)) {
                authorsForBook.add(authorList.get(i).getAuthorName());
            }

        }
        return authorsForBook;

    }

    /*
     * return type:List of String
     * input param:year of the book
     * it will return the list of books which is written in given year
     */
    @Override
    public ArrayList<String> writtenAllBooksInTheYear(int year) {
        ArrayList<String> booksInGivenYear = new ArrayList<String>();
        ArrayList<Books> booksList = new ArrayList<Books>();
        if (year < 0 || year > 9999) {
            System.out.println("Please enter the Valid Year");
            booksInGivenYear = null;
            return booksInGivenYear;
        } else {
            for (int i = 0; i < authorList.size(); i++) {
                booksList = authorList.get(i).getAllBooks();
                for (Books b : booksList) {
                    if (b.getPublicationYear() == year) {
                        if (!booksInGivenYear.contains(b.getTitle())) {
                            booksInGivenYear.add(b.getTitle());
                        }

                    }
                }
            }
            return booksInGivenYear;
        }
    }

    /*
     * @return type:void
     * Prolific author having max no of book published
     */
    @Override
    public void profilicAuthor() {
        int max = authorList.get(0).getBooksList().size();
        String prolificAuthor = "";
        for (int i = 1; i < authorList.size(); i++) {
            int curBookCount = authorList.get(i).getBooksList().size();
            if (curBookCount > max) {
                prolificAuthor = "";
                prolificAuthor = authorList.get(i).getAuthorName();
                max = curBookCount;
            } else if (curBookCount == max) {
                prolificAuthor = prolificAuthor + "," + authorList.get(i).getAuthorName();
            }
        }
        System.out.println("Prolific Author: " + prolificAuthor + " has been published " + max + " books");

    }

    /*
     * @return type author object
     * input param:name of author
     * to find the author from the author List
     */
    @Override
    public Author findAuthor(String authorName) {
        Author authorobj = null;
        for (int i = 0; i < authorList.size(); i++) {
            Author author = authorList.get(i);
            if (author.getAuthorName().equals(authorName)) {
                authorobj = author;

            }
        }
        return authorobj;

    }

}