package jscheme;

import jscheme.lang.EOF;
import jscheme.lang.LParen;
import jscheme.lang.Number;
import jscheme.lang.Operator;
import jscheme.lang.RParen;
import jscheme.lang.Token;

public class Lexer {

	private Scanner scanner;

	private static int next;

	public Token getToken() {
		skipWhitespaces();
		next = scanner.read();
		while ((next != -1) && (next != 65535)) {
			char cur = (char) next;
			switch (cur) {
			case '(':
				return new LParen();
			case ')':
				return new RParen();
            case '+':
            case '-':
                return new Operator(String.valueOf(cur));
            }
            StringBuilder builder = new StringBuilder();
			if(Character.isDigit(cur)) {
			    builder.append(cur);
			    while(Character.isDigit(scanner.next())) {
			        builder.append((char) scanner.read());
			    }
			    return new Number(builder.toString());
			}
		}
		return new EOF();
	}

	private void skipWhitespaces() {
		while (Character.isWhitespace(scanner.next())) {
		    scanner.read();
		};
	}

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

}
