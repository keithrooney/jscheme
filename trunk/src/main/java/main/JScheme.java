package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;
import java.io.Reader;
import java.io.StringReader;

import lexical.Lexer;
import lexical.Scanner;
import syntactic.Parser;

public class JScheme {

    private Lexer lexer;
    
    private Scanner scanner;

    private Parser parser;

    public JScheme(String input) throws IOException {
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

    private void cleanup() throws IOException {
        scanner.getReader().close();
    }
    
    public void run() throws IOException {
        parser.parse();
        cleanup();
    }
    
    public static void main(String[] args) throws IOException {
        JScheme jScheme = new JScheme("/home/keith/Desktop/test.scm");
        jScheme.run();
    }
    
}
