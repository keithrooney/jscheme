package syntactic;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import lexical.Lexer;
import lexical.lang.Token;
import lexical.lang.Token.Category;

public class ParserTest {

    private static final Token LPAREN = new Token("(", Category.LPAREN);
    
    private static final Token RPAREN = new Token(")", Category.RPAREN);

    private static final Token OPERATOR = new Token("+", Category.OPERATOR);
    
    private static final Token NUMBER = new Token("12", Category.NUMBER);
    
    private static final Token EOS = new Token(null, Category.EOS);

    private Parser parser;
    
    private Lexer mockLexer;

    @Before
    public void before() {
        parser = new Parser();
        mockLexer = Mockito.mock(Lexer.class);
        parser.setLexer(mockLexer);
        assertEquals(mockLexer, parser.getLexer());
    }
    
    /**
     * ()
     */
    @Test
    public void testParseMatchingParenthesis() {
        Mockito.when(mockLexer.getToken())
               .thenReturn(LPAREN)
               .thenReturn(RPAREN)
               .thenReturn(EOS);
        parser.parse();
        Mockito.verify(mockLexer, Mockito.times(4)).getToken();
    }

    /**
     * (operator)
     */
    @Test
    public void testParseMatchingParenthesisWithOperand() {
        Mockito.when(mockLexer.getToken())
               .thenReturn(LPAREN)
                   .thenReturn(OPERATOR)
               .thenReturn(RPAREN)
               .thenReturn(EOS);
        parser.parse();
        Mockito.verify(mockLexer, Mockito.times(5)).getToken();
    }
    
    /**
     * (operator number number number number)
     */
    @Test
    public void testParseConsecutiveNumbers() {
        Mockito.when(mockLexer.getToken())
               .thenReturn(LPAREN)
                   .thenReturn(OPERATOR)
                   .thenReturn(NUMBER)
                   .thenReturn(NUMBER)
                   .thenReturn(NUMBER)
                   .thenReturn(NUMBER)
                   .thenReturn(NUMBER)
               .thenReturn(RPAREN)
               .thenReturn(EOS);
        parser.parse();
        Mockito.verify(mockLexer, Mockito.times(10)).getToken();
    }
    
    @Test
    public void testParseNestedOperations() {
        Mockito.when(mockLexer.getToken())
               .thenReturn(LPAREN)
                   .thenReturn(OPERATOR)
                   .thenReturn(LPAREN)
                       .thenReturn(OPERATOR)
                       .thenReturn(NUMBER)
                       .thenReturn(NUMBER)
                   .thenReturn(RPAREN)
                   .thenReturn(LPAREN)
                       .thenReturn(OPERATOR)
                       .thenReturn(NUMBER)
                       .thenReturn(NUMBER)
                       .thenReturn(NUMBER)
                   .thenReturn(RPAREN)
               .thenReturn(RPAREN)
               .thenReturn(EOS);
        parser.parse();
        Mockito.verify(mockLexer, Mockito.times(16)).getToken();
    }

    @Test
    public void testParseComplexOperation() {
        Mockito.when(mockLexer.getToken())
               .thenReturn(LPAREN)
                   .thenReturn(OPERATOR)
                   .thenReturn(NUMBER)
                   .thenReturn(LPAREN)
                       .thenReturn(OPERATOR)
                       .thenReturn(NUMBER)
                       .thenReturn(NUMBER)
                   .thenReturn(RPAREN)
                   .thenReturn(LPAREN)
                       .thenReturn(OPERATOR)
                       .thenReturn(NUMBER)
                       .thenReturn(NUMBER)
                       .thenReturn(NUMBER)
                   .thenReturn(RPAREN)
                   .thenReturn(NUMBER)
                   .thenReturn(NUMBER)
                   .thenReturn(LPAREN)
                       .thenReturn(OPERATOR)
                       .thenReturn(NUMBER)
                       .thenReturn(NUMBER)
                       .thenReturn(NUMBER)
                   .thenReturn(RPAREN)
               .thenReturn(RPAREN)
               .thenReturn(EOS);
        parser.parse();
        Mockito.verify(mockLexer, Mockito.times(25)).getToken();
    }

    
}
