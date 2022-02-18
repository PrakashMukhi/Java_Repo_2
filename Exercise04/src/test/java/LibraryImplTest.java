import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class LibraryImplTest {
    private LibraryImpl library = new LibraryImpl();

    @Test
    public void testwrittenAllBooksInTheYear() {
        ArrayList<String> booksInGivenYear = new ArrayList<String>();
        booksInGivenYear.add("The Secret Garden");
        assertEquals(booksInGivenYear, library.writtenAllBooksInTheYear(1911));
    }

    @Test
    public void testgetAuthorsFromBookName() {
        ArrayList<String> booksAuthor = new ArrayList<String>();
        booksAuthor.add("E.L. James");
        assertEquals(booksAuthor, library.getAuthorsFromBookName("Fifty Shades Darker"));

    }

    @Test
    public void testWithNullfindAuthor() {
        assertEquals(null, library.findAuthor("Angelo"));
    }

    @Test
    public void testWithNotNullfindAuthor() {
        assertNotEquals(null, library.findAuthor("James Dashner"));
    }

}
