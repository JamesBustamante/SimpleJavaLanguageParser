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
        String[] words = sourceCode.split("(?=\\})|(?=\\{)|(\\s+)|(?=\\()|(?=\\))|(?=(\"))|(?=(;))|(?<=\\w)(?=\\W)|(?<=\\W)(?=\\w)|^\\s*$. ");
        for (String word : words)
        	System.out.println(word);
		//Next is to match each word to a token.
        int i = 0;
        boolean isInQuotes = false; 
        boolean assigned = false;
        //System.out.println(words[1]);
        while (i < words.length) { //This while loop goes through each string in the array and matches to a token type
        	if (!(words[i].trim().isEmpty())) {
        		 System.out.println(words[i]);
				if (words[i].equals("public")) { // .Matches uses regex
					tokens.add(new Token(Token.TokenType.PUBLIC, "public"));
					assigned = true;
				}
				else if (words[i].equals("*")) {
					tokens.add(new Token(Token.TokenType.TIMES, "*"));
					assigned = true;
				}
				else if (words[i].equals("+")) {
					tokens.add(new Token(Token.TokenType.PLUS, "+"));
					assigned = true;
				}
				else if (words[i].equals("-")) {
					tokens.add(new Token(Token.TokenType.MINUS, "-"));
					assigned = true;
				}
				else if (words[i].equals("/")) {
					tokens.add(new Token(Token.TokenType.DIVIDE, "/"));
					assigned = true;
				}
				else if (words[i].equals("%")) {
					tokens.add(new Token(Token.TokenType.MOD, "%"));
					assigned = true;
				}
				else if (words[i].equals("=")) {
					tokens.add(new Token(Token.TokenType.ASSIGN, "="));
					assigned = true;
				}
				else if (words[i].equals("==")) {
					tokens.add(new Token(Token.TokenType.EQUAL, "=="));
					assigned = true;
				}
				else if (words[i].equals("!=")) {
					tokens.add(new Token(Token.TokenType.NEQUAL, "!="));
					assigned = true;
				}
				else if (words[i].equals("<")) {
					tokens.add(new Token(Token.TokenType.LT, "<"));
					assigned = true;
				}
				else if (words[i].equals("<=")) {
					tokens.add(new Token(Token.TokenType.LE, "<="));
					assigned = true;
				}
				else if (words[i].equals(">")) {
					tokens.add(new Token(Token.TokenType.GT, ">"));
					assigned = true;
				}
				else if (words[i].equals(">=")) {
					tokens.add(new Token(Token.TokenType.GE, ">="));
					assigned = true;
				}
				else if (words[i].equals("(")) {
					tokens.add(new Token(Token.TokenType.LPAREN, "("));
					assigned = true;
				}
				else if (words[i].equals(")")) {
					tokens.add(new Token(Token.TokenType.RPAREN, ")"));
					assigned = true;
				}
				else if (words[i].equals("{")) {
					tokens.add(new Token(Token.TokenType.LBRACE, "{"));
					assigned = true;
				}
				else if (words[i].equals("}")) {
					tokens.add(new Token(Token.TokenType.RBRACE, "}"));
					assigned = true;
				}
				else if (words[i].equals("&&")) {
					tokens.add(new Token(Token.TokenType.AND, "AND"));
					assigned = true;
				}
				else if (words[i].equals("||")) {
					tokens.add(new Token(Token.TokenType.OR, "||"));
					assigned = true;
				}
				else if (words[i].equals(";")) {
					tokens.add(new Token(Token.TokenType.SEMICOLON, ";"));
					assigned = true;
				}
				else if (words[i].equals("class")) {
					tokens.add(new Token(Token.TokenType.CLASS, "class"));
					assigned = true;
				}
				else if (words[i].equals("static")) {
					tokens.add(new Token(Token.TokenType.STATIC, "static"));
					assigned = true;
				}
				else if (words[i].equals("void")) {
					tokens.add(new Token(Token.TokenType.VOID, "void"));
					assigned = true;
				}
				else if (words[i].equals("main")) {
					tokens.add(new Token(Token.TokenType.MAIN, "main"));
					assigned = true;
				}
				else if (words[i].equals("String") && words[i + 1].equals("[]")) {
					tokens.add(new Token(Token.TokenType.STRINGARR, "String[]"));
					i++;
					assigned = true;
				} else if (words[i].equals("args")) {
					tokens.add(new Token(Token.TokenType.ARGS, "args"));
					assigned = true;
				}
				else if (words[i].equals("String") || words[i].equals("int") || words[i].equals("boolean")
						|| words[i].equals("char")) {
					tokens.add(new Token(Token.TokenType.TYPE, words[i]));
					assigned = true;
				}
				else if (words[i].equals("System") && words[i + 1].equals(".") && words[i + 2].equals("out")
						&& words[i + 3].equals(".") && (words[i + 4].equals("print") || words[i + 4].equals("println"))) {
					tokens.add(new Token(Token.TokenType.PRINT, "System.out.print"));
					i = i + 4;
					assigned = true;
				} else if (words[i].equals("while")) {
					tokens.add(new Token(Token.TokenType.WHILE, "while"));
					assigned = true;
				}
				else if (words[i].equals("for")) {
					tokens.add(new Token(Token.TokenType.FOR, "for"));
					assigned = true;
				}
				else if (words[i].equals("if")) {
					tokens.add(new Token(Token.TokenType.IF, "if"));
					assigned = true;
				}
				else if (words[i].equals("else")) {
					tokens.add(new Token(Token.TokenType.ELSE, "else"));
					assigned = true;
				}
				else if (words[i].equals("\"")) {
					tokens.add(new Token(Token.TokenType.DQUOTE, "\""));
					isInQuotes = true;
					i++;
					assigned = true;
				} else if (words[i].equals("\'")) {
					tokens.add(new Token(Token.TokenType.SQUOTE, "\'"));
					assigned = true;
				}
				else if (words[i].equals("true")) {
					tokens.add(new Token(Token.TokenType.TRUE, words[i]));
					assigned = true;
				}
				else if (words[i].equals("false")) {
					tokens.add(new Token(Token.TokenType.FALSE, words[i]));
					assigned = true;
				}
				else if (words[i].matches("^[0-9]*")) {
					tokens.add(new Token(Token.TokenType.NUM, words[i]));
					assigned = true;
				}
				else if (words[i].matches("^\\w{1}$") && words[i + 1].equals("\'")) {
					tokens.add(new Token(Token.TokenType.CHARLIT, words[i]));
					assigned = true;
				}
				else if (words[i].matches("[a-zA-Z][_a-zA-Z0-9]*")) {
					tokens.add(new Token(Token.TokenType.ID, words[i]));
					assigned = true;
				}
				if (assigned == false) {
	        		throw new LexicalException ("Lexical Exception, Invalid String");	
	        	}
				assigned = false;
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
        		assigned = true;
        	}
        	
        	
        	//assigned = false;
        	i++;

        }        
        
        System.out.println(tokens);
        
        
        
		return tokens;
	}

}
