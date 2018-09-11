import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

public class LexicalAnalyser {

	public static void main(String args[]) throws FileNotFoundException, IOException, LexicalException {
		try(BufferedReader br = new BufferedReader(new FileReader("src/tester.txt"))) {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    String code = sb.toString();
		    analyse(code);
		}
	}
	
	public static List<Token> analyse(String sourceCode) throws LexicalException {

		//System.out.println(sourceCode);
		List<Token> tokens = new ArrayList<Token>();
        Token token = new Token();
        //String value = "";
        String[] words = sourceCode.split("(\\s+)|(?=\\()|(?=\\))|(?=(\"))|(?=(;))|(?<=\\w)(?=\\W)|(?<=\\W)(?=\\w)|^\\s*$. ");
        //String[] words = sourceCode.split("(?<=\\w)(?=\\W)|(?<=\\W)(?=\\w)");
        //String[] words = sourceCode.split("(?=\\()");
        for (String word : words)
        	System.out.println(word);
		//Next is to match each word to a token.
		return null;
	}

}
