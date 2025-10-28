

import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class SalesItemTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SalesItemTest
{
    /**
     * Default constructor for test class SalesItemTest
     */
    public SalesItemTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void testAddComment()
    {
        SalesItem salesite1 = new SalesItem("Cool Item", 12345);
        boolean result = salesite1.addComment("Alice", "Great product!", 5);
        assertTrue(result);
        assertEquals(1, salesite1.getNumberOfComments());
    }

    @Test
    public void testAddCommentDuplicateAuthor()
    {
        SalesItem salesite1 = new SalesItem("Cool Item", 12345);
        salesite1.addComment("Bob", "Good value.", 4); 
        boolean result = salesite1.addComment("Bob", "I changed my mind.", 3);
        assertFalse(result);
        assertEquals(1, salesite1.getNumberOfComments());
   }

    @Test
    public void testIllegalRating()
    {
        SalesItem salesite1 = new SalesItem("Cool Item", 12345);
        boolean resultLow = salesite1.addComment("Charlie", "Not good.", 0);
        assertFalse(resultLow);
        assertEquals(0, salesite1.getNumberOfComments());

        boolean resultHigh = salesite1.addComment("Dave", "Excellent!", 6);
        assertFalse(resultHigh);
        assertEquals(0, salesite1.getNumberOfComments());
    }
}