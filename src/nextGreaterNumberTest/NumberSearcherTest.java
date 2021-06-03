package nextGreaterNumberTest;

import static org.junit.Assert.*;
import nextGreaterNumber.NumberSearcher;

import org.junit.Test;

public class NumberSearcherTest
{
    @Test
    public void testIsValidateNumber()
    {
        // a normal numerical string
        String a = "12345";
        assertTrue(NumberSearcher.isValidateNumber(a));
        
        // empty string
        String b = "";
        assertFalse(NumberSearcher.isValidateNumber(b));
        
        // non numerical string
        String c = "abc";
        assertFalse(NumberSearcher.isValidateNumber(c));
        
        String c2 = "$%#";
        assertFalse(NumberSearcher.isValidateNumber(c2));
        
        // null string
        String d = null;
        assertFalse(NumberSearcher.isValidateNumber(d));
    }

    /**
     * findNextGreaterNumber() will only be executed after the number string be
     * validated so will only include valid numbers in this test case
     */
    @Test
    public void testFindNextGreaterNumber()
    {
        // a normal number finding
        String a = "12345";
        assertEquals(NumberSearcher.findNextGreaterNumber(a), "12354");

        // a number which is already max
        String b = "54321";
        assertNull(NumberSearcher.findNextGreaterNumber(b));

        // a number with only 1 digit
        String c = "1";
        assertNull(NumberSearcher.findNextGreaterNumber(c));
    }
}
