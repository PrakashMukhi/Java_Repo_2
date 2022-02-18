import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BooksTest {
    private Books book = new Books("The Secret Garden", 1911, 4.12);

    @Test
    public void testgetTitle() {
        assertEquals("The Secret Garden", book.getTitle());
    }

    @Test
    public void testgetYearOfPublication() {
        assertEquals(1911, book.getPublicationYear());
    }

    @Test
    public void testgetRating() {
        // one extra argument should added to compare two doubles values
        double delta = 0;
        // Asserts the two doubles values are equal to within a positive delta
        assertEquals(4.12, book.getRating(), delta);

    }
}
