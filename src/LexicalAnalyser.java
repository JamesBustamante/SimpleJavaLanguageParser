import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

public class LexicalAnalyser {

	public static void main(String args[]) throws FileNotFoundException, IOException, LexicalException, SyntaxException {
		try(BufferedReader br = new BufferedReader(new FileReader("src/tester.txt"))) {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    String code = sb.toString();
		    List<Token> tokens = analyse(code);
		    SyntacticAnalyser.parse(tokens);
		}
	}
	
	public static List<Token> analyse(String sourceCode) throws LexicalException {

		//System.out.println(sourceCode);
		List<Token> tokens = new ArrayList<Token>();
        Token token = new Token();
        //String value = "";
        String[] words = sourceCode.split("(\\s+)|(?=\\()|(?=\\))|(?=(\"))|(?=(;))|(?<=\\w)(?=\\W)|(?<=\\W)(?=\\w)|^\\s*$. ");
//        for (String word : words)
//        	System.out.println(word);
		//Next is to match each word to a token.
        int i = 0;
        boolean isInQuotes = false; 
        //System.out.println(words[1]);
        while (i < words.length) { //This while loop goes through each string in the array and matches to a token type
        	if (!(words[i].trim().isEmpty())) {
        		 System.out.println(words[i]);
        		 if (words[i].equals("public")) //.Matches uses regex
        			tokens.add(new Token(Token.TokenType.PUBLIC,"public"));
        		 else if (words[i].equals("+"))
         			tokens.add(new Token(Token.TokenType.PLUS,"+"));
        		 else if (words[i].equals("+"))
        			tokens.add(new Token(Token.TokenType.PLUS,"+"));
        		 else if (words[i].equals("-"))
         			tokens.add(new Token(Token.TokenType.MINUS,"-"));
        		 else if (words[i].equals("/"))
         			tokens.add(new Token(Token.TokenType.DIVIDE,"/"));
        		 else if (words[i].equals("%"))
          			tokens.add(new Token(Token.TokenType.MOD,"%"));
        		 else if (words[i].equals("="))
           			tokens.add(new Token(Token.TokenType.ASSIGN,"="));
        		 else if (words[i].equals("=="))
           			tokens.add(new Token(Token.TokenType.EQUAL,"=="));
        		 else if (words[i].equals("!="))
           			tokens.add(new Token(Token.TokenType.NEQUAL,"!="));
        		 else if (words[i].equals("<"))
           			tokens.add(new Token(Token.TokenType.LT,"<"));
        		 else if (words[i].equals("<="))
           			tokens.add(new Token(Token.TokenType.LE,"<="));
        		 else if (words[i].equals(">"))
           			tokens.add(new Token(Token.TokenType.GT,">"));
        		 else if (words[i].equals(">="))
           			tokens.add(new Token(Token.TokenType.GE,">="));
        		 else if (words[i].equals("("))
           			tokens.add(new Token(Token.TokenType.LPAREN,"("));
        		 else if (words[i].equals(")"))
            			tokens.add(new Token(Token.TokenType.RPAREN,")"));
        		 else if (words[i].equals("{"))
            			tokens.add(new Token(Token.TokenType.LBRACE,"{"));
        		 else if (words[i].equals("}"))
            			tokens.add(new Token(Token.TokenType.RBRACE,"}"));
        		 else if (words[i].equals("&&"))
            			tokens.add(new Token(Token.TokenType.AND,"AND"));
        		 else if (words[i].equals("||"))
            			tokens.add(new Token(Token.TokenType.OR,"||"));
        		 else if (words[i].equals(";"))
            			tokens.add(new Token(Token.TokenType.SEMICOLON,";"));
        		 else if (words[i].equals("class"))
            			tokens.add(new Token(Token.TokenType.CLASS,"class"));
        		 else if (words[i].equals("static"))
            			tokens.add(new Token(Token.TokenType.STATIC,"static"));
        		 else if (words[i].equals("void"))
            			tokens.add(new Token(Token.TokenType.VOID,"void"));
        		 else if (words[i].equals("main"))
            			tokens.add(new Token(Token.TokenType.MAIN,"main"));
        		 else if (words[i].equals("String") && words[i+1].equals("[]")) {
            			tokens.add(new Token(Token.TokenType.STRINGARR,"String[]"));
            			i++;
        		 }
        		 else if (words[i].equals("args"))
         			tokens.add(new Token(Token.TokenType.ARGS,"args"));
        		 else if (words[i].equals("String")|| words[i].equals("int")||words[i].equals("boolean")|| words[i].equals("char"))
        			 tokens.add(new Token(Token.TokenType.TYPE,words[i]));
        		 else if (words[i].equals("System") && words[i+1].equals(".") && 
        				 words[i+2].equals("out") && words[i+3].equals(".") && words[i+4].equals("println")) {
          			tokens.add(new Token(Token.TokenType.PRINT,"System.out.println"));
          			i = i + 4;
        		 }
        		 else if (words[i].equals("while"))
          			tokens.add(new Token(Token.TokenType.WHILE,"while"));
        		 else if (words[i].equals("for"))
          			tokens.add(new Token(Token.TokenType.FOR,"for"));
        		 else if (words[i].equals("if"))
          			tokens.add(new Token(Token.TokenType.IF,"if"));
        		 else if (words[i].equals("else"))
          			tokens.add(new Token(Token.TokenType.ELSE,"else"));
        		 else if (words[i].equals("\"")) {
          			tokens.add(new Token(Token.TokenType.DQUOTE,"\""));
          			isInQuotes = true; 
          			i++;
          			}
        		 else if (words[i].equals("\'"))
          			tokens.add(new Token(Token.TokenType.SQUOTE,"\'"));
        		 else if (words[i].equals("true"))
            			tokens.add(new Token(Token.TokenType.TRUE,words[i]));
        		 else if (words[i].equals("false"))
            			tokens.add(new Token(Token.TokenType.FALSE,words[i]));
        		 else if (words[i].matches("^\\w{1}$"))
        			 tokens.add(new Token(Token.TokenType.CHARLIT,words[i]));
        		 else if (words[i].matches("^[_a-z]\\w*$")) //Regular Expression Fix here
          			tokens.add(new Token(Token.TokenType.ID,words[i]));
        		 
        	}
        	if (isInQuotes) {
        		String value = "";
        		while (!(words[i].equals("\""))) {
        			value = value + words[i] + " ";
        			i++;
        		} 
        		value.trim();
        		tokens.add(new Token(Token.TokenType.STRINGLIT,value));
        		tokens.add(new Token(Token.TokenType.DQUOTE,"\""));
        		isInQuotes = false;
        	}
        	i++;

        }        
        
        System.out.println(tokens);
        
        
        
		return tokens;
	}

}
