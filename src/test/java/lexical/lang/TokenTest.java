package lexical.lang;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import lexical.lang.Token;
import lexical.lang.Token.Category;

public class TokenTest {

    @Test
    public void testValidToken() {
        Token token = new Token("(", Category.LPAREN);
        assertEquals("(", token.getLexeme());
        assertEquals(Category.LPAREN, token.getCategory());
    }
    
    @Test
    public void testInvalidToken() {
        Token token = new Token(null, null);
        assertNull(token.getLexeme());
        assertNull(token.getCategory());
    }
    
    @Test
    public void testToString() {
        Token token = new Token(")", Category.RPAREN);
        String asString = "{Lexeme=), Category=RPAREN}";
        assertEquals(asString, token.toString());
    }
    
    @Test
    public void testHashCode() {
        Token token1 = new Token("(", Category.LPAREN);
        assertEquals(token1.hashCode(), token1.hashCode());
        
        Token token2 = new Token("(", Category.LPAREN);
        assertEquals(token1.hashCode(), token2.hashCode());
        
        Token token3 = new Token(")", Category.RPAREN);
        assertFalse(token1.hashCode() == token3.hashCode());
        assertFalse(token2.hashCode() == token3.hashCode());
    }
    
    @Test
    public void testEquals() {
        Token token1 = new Token("(", Category.LPAREN);
        assertFalse(token1.equals(null));
        assertTrue(token1.equals(token1));

        Token token2 = new Token("(", Category.LPAREN);
        assertTrue(token1.equals(token2));
        
        Token token3 = new Token(")", Category.RPAREN);
        assertFalse(token3.equals(token2));
        
        Object token4 = new Object();
        assertFalse(token3.equals(token4));
    }
    
}
