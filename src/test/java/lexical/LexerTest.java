package lexical;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import lexical.Lexer;
import lexical.Scanner;
import lexical.lang.EOS;
import lexical.lang.LParen;
import lexical.lang.RParen;
import lexical.lang.Token;

public class LexerTest {

    private Lexer lexer;

    private Scanner mockScanner;

    @Before
    public void before() {
        lexer = new Lexer();
        mockScanner = Mockito.mock(Scanner.class);
        lexer.setScanner(mockScanner);
        assertEquals(mockScanner, lexer.getScanner());
    }
    
    @After
    public void after() {
        Mockito.verifyNoMoreInteractions(mockScanner);
    }
    
    @Test
    public void testGetTokenLParen() {
        Mockito.when(mockScanner.next()).thenReturn(40);
        Mockito.when(mockScanner.read()).thenReturn(40);
        Token token = lexer.getToken();
        assertTrue(token instanceof LParen);
        Mockito.verify(mockScanner).next();
        Mockito.verify(mockScanner).read();
    }

    @Test
    public void testGetTokenRParen() {
        Mockito.when(mockScanner.next()).thenReturn(41);
        Mockito.when(mockScanner.read()).thenReturn(41);
        Token token = lexer.getToken();
        assertTrue(token instanceof RParen);
        Mockito.verify(mockScanner).next();
        Mockito.verify(mockScanner).read();
    }
    
    @Test
    public void testGetTokenIsSkippingWhitespace() {
        Mockito.when(mockScanner.next()).thenReturn(32).thenReturn(32).thenReturn(-1);
        Mockito.when(mockScanner.read()).thenReturn(-1);
        Token token = lexer.getToken();
        assertTrue(token instanceof EOS);
        Mockito.verify(mockScanner, Mockito.times(3)).next();
        Mockito.verify(mockScanner, Mockito.times(3)).read();
    }
    
}
