package jscheme.lang;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import jscheme.lang.RParen;
import jscheme.lang.Token;
import jscheme.lang.Token.Category;

public class RParenTest {

    @Test
    public void testRParen() {
        Token token = new RParen();
        assertEquals(")", token.getLexeme());
        assertEquals(Category.RPAREN, token.getCategory());
    }
    
}
