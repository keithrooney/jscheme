package jscheme.lang;

public class Number extends Token {

    public Number(String lexeme) {
        super(lexeme, Category.NUMBER);
    }
    
}
