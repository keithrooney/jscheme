package lexical;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.PushbackReader;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.mockito.Mockito;

import lexical.Scanner;

public class ScannerTest {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    private Scanner scanner;

    private PushbackReader mockReader;

    @Before
    public void before() throws IOException {
        scanner = new Scanner();
        mockReader = Mockito.mock(PushbackReader.class);
        scanner.setReader(mockReader);
        assertEquals(mockReader, scanner.getReader());
    }
    
    @After
    public void after() {
        Mockito.verifyNoMoreInteractions(mockReader);
    }
    
    @Test
    public void testNext() throws IOException {
        Mockito.when(mockReader.read()).thenReturn(43);
        assertEquals(43, scanner.next());
        Mockito.verify(mockReader).read();
        Mockito.verify(mockReader).unread(43);
    }
    
    @Test
    public void testRead() throws IOException {
        Mockito.when(mockReader.read()).thenReturn(40);
        assertEquals(40, scanner.read());
        Mockito.verify(mockReader).read();
    }
    
    @Test
    public void testPushback() throws IOException {
        scanner.pushback(48);
        Mockito.verify(mockReader).unread(48);
    }
    
}
