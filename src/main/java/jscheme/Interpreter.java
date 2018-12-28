package jscheme;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;
import java.io.Reader;
import java.io.StringReader;

public class Interpreter implements Closeable {

    private Lexer lexer;
    
    private Scanner scanner;

    private Parser parser;

    public Interpreter(String input) throws IOException {
        initialize(input);
    }
    
    private PushbackReader create(String input) throws FileNotFoundException {
        Reader reader;
        File file = new File(input);
        if(file.exists()) {
            reader = new FileReader(file);
        } else {
            reader = new StringReader(input);
        }
        return new PushbackReader(reader);
    }
    
    private void initialize(String input) throws IOException {
        scanner = new Scanner();
        scanner.setReader(create(input));
        
        lexer = new Lexer();
        lexer.setScanner(scanner);
        
        parser = new Parser();
        parser.setLexer(lexer);
    }

    public void close() throws IOException {
        scanner.getReader().close();
    }
    
}
