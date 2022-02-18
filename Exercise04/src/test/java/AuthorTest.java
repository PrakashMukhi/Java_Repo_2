import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthorTest {
    private Books book = new Books("Fifty Shades Darker", 2011, 3.87);
    private Author auhtor = new Author("Stephenie Meyer", book);

    @Test
    public void getName() {
        assertEquals("Stephenie Meyer", auhtor.getAuthorName());
    }

    @Test
    public void findBookInList() {
        assertEquals(true, auhtor.findBookInList("Fifty Shades Darker"));
    }
}
