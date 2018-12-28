package jscheme;

import jscheme.lang.Token;
import jscheme.lang.Token.Category;

public class Parser {

    private Lexer lexer;

    private Token next;
    
    public Parser() {

    }

    public void parse() {
        program();
    }
    
    private void program() {
        next();
        operation();
        expect(Category.EOF);
    }

    private void operation() {
        expect(Category.LPAREN);
        if(is(Category.OPERATOR)) {
            expect(Category.OPERATOR);
            operation0();
        }
        expect(Category.RPAREN);
    }
    
    private void operation0() {
        if(is(Category.LPAREN) || is(Category.NUMBER)) {
            if(is(Category.LPAREN)) {
                operation();
            } else {
                numbers();
            }
            operation0();
        }
    }
    
    private void numbers() {
        if(is(Category.NUMBER)) {
            expect(Category.NUMBER);
            numbers();
        }
    }
    
    private void expect(Category category) {
        if(!is(category)) {
            throw new RuntimeException("Parse Failure\nExpected: " + category + "\nActual: " + next.toString());
        }
        next();
    }
    
    private boolean is(Category category) {
        return category == next.getCategory();
    }

    public void next() {
        next = lexer.getToken();
    }
    
    public Lexer getLexer() {
        return lexer;
    }

    public void setLexer(Lexer lexer) {
        this.lexer = lexer;
    }

}
