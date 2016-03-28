package lexical;

import java.io.IOException;
import java.io.PushbackReader;

public class Scanner {

	private PushbackReader reader;
	
	public int next() {
	    int character = read();
	    pushback(character);
	    return character;
	}
	
	public int read() {
        int character = -1;
        try {
            character = getReader().read();
        } catch(IOException e) {
            
        }
        return character;
	}
	
	public void pushback(int curByte) {
		try {
			getReader().unread((char) curByte);
		} catch(IOException e) {
			
		}
	}
	
	public PushbackReader getReader() {
		return reader;
	}

	public void setReader(PushbackReader reader) {
		this.reader = reader;
	}

}
