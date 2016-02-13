package lexical.lang;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import lexical.lang.Number;
import lexical.lang.Token.Category;

public class NumberTest {

    @Test
    public void testNumber() {
        Number number = new Number("12332");
        assertEquals("12332", number.getLexeme());
        assertEquals(Category.NUMBER, number.getCategory());
    }
    
}
