package jscheme.lang;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import jscheme.lang.LParen;
import jscheme.lang.Token;
import jscheme.lang.Token.Category;

public class LParenTest {

    @Test
    public void testLParen() {
        Token token = new LParen();
        assertEquals("(", token.getLexeme());
        assertEquals(Category.LPAREN, token.getCategory());
    }
    
}
