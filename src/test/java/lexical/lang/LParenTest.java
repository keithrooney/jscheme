package lexical.lang;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import lexical.lang.Token.Category;

public class LParenTest {

    @Test
    public void testLParen() {
        Token token = new LParen();
        assertEquals("(", token.getLexeme());
        assertEquals(Category.LPAREN, token.getCategory());
    }
    
}
