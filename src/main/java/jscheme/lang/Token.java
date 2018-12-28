package jscheme.lang;

import java.util.Objects;

public class Token {

    public enum Category {
        LPAREN, 
        RPAREN,
        OPERATOR,
        NUMBER,
        EOF
    }
    
	private String lexeme;
	
    private Category category;
	
	public Token(String lexeme, Category category) {
		this.lexeme = lexeme;
		this.category = category;
	}

	public String getLexeme() {
		return lexeme;
	}

	public Category getCategory() {
        return category;
    }

    @Override
	public String toString() {
	    StringBuilder representation = new StringBuilder();
	    representation.append("{");
	    representation.append("Lexeme=" + getLexeme());
	    representation.append(", ");
	    representation.append("Category=" + getCategory());
	    representation.append("}");
	    return representation.toString();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getLexeme(), getCategory());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		Token rhs = (Token) obj;
        return getLexeme() == rhs.getLexeme()
                && getCategory() == rhs.getCategory();
	}

}
