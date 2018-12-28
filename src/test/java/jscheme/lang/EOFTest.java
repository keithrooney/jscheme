package jscheme.lang;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import jscheme.lang.Token;
import jscheme.lang.Token.Category;

public class EOFTest {

    @Test
    public void testEOF() {
        Token token = new EOF();
        assertNull(token.getLexeme());
        assertEquals(Category.EOF, token.getCategory());
    }
    
}
