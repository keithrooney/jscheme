package lexical.lang;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import lexical.lang.Token.Category;

public class EOSTest {

    @Test
    public void testEOS() {
        Token token = new EOS();
        assertNull(token.getLexeme());
        assertEquals(Category.EOS, token.getCategory());
    }
    
}
