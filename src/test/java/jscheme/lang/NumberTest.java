package jscheme.lang;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import jscheme.lang.Number;
import jscheme.lang.Token.Category;

public class NumberTest {

    @Test
    public void testNumber() {
        Number number = new Number("12332");
        assertEquals("12332", number.getLexeme());
        assertEquals(Category.NUMBER, number.getCategory());
    }
    
}
