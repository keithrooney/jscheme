package lexical.lang;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import lexical.lang.Token.Category;

public class RParenTest {

    @Test
    public void testRParen() {
        Token token = new RParen();
        assertEquals(")", token.getLexeme());
        assertEquals(Category.RPAREN, token.getCategory());
    }
    
}
