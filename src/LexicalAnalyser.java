import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

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

		System.out.println(sourceCode);
		return null;
	}

}
