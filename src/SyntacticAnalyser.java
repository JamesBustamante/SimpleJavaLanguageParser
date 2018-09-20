import java.util.ArrayList;
import java.util.List;

public class SyntacticAnalyser {
	static int i; //Counter
	static ParseTree<Token> parseTree = new ParseTree<Token>(); // The object parseTree is used to set the root of the tree
	static ParseTree<Token>.TreeNode root = parseTree.new TreeNode(ParseTree.Label.prog); // Store A single Node (with parse tree)
	static List<ParseTree<Token>.TreeNode> nodes = new ArrayList<ParseTree<Token>.TreeNode>(); // Store An Array List of Nodes 
	
	public static ParseTree<Token> parse(List<Token> tokens) throws SyntaxException {
		//ParseTree<Token> parseTree = new ParseTree<Token>();
		// ParseTree<Token> parseTree = new ParseTree();
		// ParseTree is used to set up the tree
		// The object parseTree is used to set the root of the tree

		 
		

		// ParseTree<Token>.TreeNode allows for the creation of nodes that link to the
		// tree (ParseTree)
		parseTree.setRoot(root); // Root of the node
		ParseTree<Token>.TreeNode node1 = parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(0), root);
		// We set the root of the node
		nodes.add(node1);
		nodes.add(root);
		//root.addChild(node1);
		//System.out.println(root.toString());
		//System.out.println(node1.toString());
		//System.out.println(nodes);
		
		i = 0;
		progNT(tokens);
		System.out.println(parseTree);
		return parseTree;
		// We Return parseTree as it contains all of the nodes of the tree
	}

	public static void progNT(List<Token> tokens) throws SyntaxException {
		if (tokens.get(i).getType().equals(Token.TokenType.PUBLIC)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
			root.addChild(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		if (tokens.get(i).getType().equals(Token.TokenType.CLASS)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
			root.addChild(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		if (tokens.get(i).getType().equals(Token.TokenType.ID)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.ID, tokens.get(i), root));
			root.addChild(parseTree.new TreeNode(ParseTree.Label.ID, tokens.get(i), root));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		if (tokens.get(i).getType().equals(Token.TokenType.LBRACE)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
			root.addChild(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		if (tokens.get(i).getType().equals(Token.TokenType.PUBLIC)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
			root.addChild(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		if (tokens.get(i).getType().equals(Token.TokenType.STATIC)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
			root.addChild(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		if (tokens.get(i).getType().equals(Token.TokenType.VOID)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
			root.addChild(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		if (tokens.get(i).getType().equals(Token.TokenType.MAIN)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
			root.addChild(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		if (tokens.get(i).getType().equals(Token.TokenType.LPAREN)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
			root.addChild(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		if (tokens.get(i).getType().equals(Token.TokenType.STRINGARR)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
			root.addChild(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		if (tokens.get(i).getType().equals(Token.TokenType.ARGS)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
			root.addChild(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		if (tokens.get(i).getType().equals(Token.TokenType.RPAREN)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
			root.addChild(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		if (tokens.get(i).getType().equals(Token.TokenType.LBRACE)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
			root.addChild(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		if (!(tokens.get(i).getType().equals(Token.TokenType.RBRACE))) {
			losNT(tokens);
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		if (tokens.get(i).getType().equals(Token.TokenType.RBRACE)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
			root.addChild(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		if (tokens.get(i).getType().equals(Token.TokenType.RBRACE)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
			root.addChild(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
		} else {throw new SyntaxException("Syntax Exception");}
	}

	public static void losNT(List<Token> tokens) {
		
	}

	public static void statNT(List<Token> tokens) {

	}
	
	public static void whileNT(List<Token> tokens) {

	}
	
	public static void forNT(List<Token> tokens) {

	}
	
	public static void forStartNT(List<Token> tokens) {

	}
	
	public static void forArithNT(List<Token> tokens) {

	}
	
	public static void ifNT(List<Token> tokens) {

	}
	
	public static void elseIfNT(List<Token> tokens) {

	}
	
	public static void assignNT(List<Token> tokens) {

	}
	
	public static void declNT(List<Token> tokens) {

	}
	
	public static void possAssignNT(List<Token> tokens) {

	}
	
	public static void printNT(List<Token> tokens) {

	}
	
	public static void typeNT(List<Token> tokens) {

	}
	
	public static void exprNT(List<Token> tokens) {

	}
	
	public static void boolExprNT(List<Token> tokens) {

	}
	
	public static void boolExprPrimeNT(List<Token> tokens) {

	}
	
	public static void boolOpNT(List<Token> tokens) {

	}
	
	public static void boolEqNT(List<Token> tokens) {

	}
	
	public static void boolLogNT(List<Token> tokens) {

	}
	
	public static void relExprNT(List<Token> tokens) {

	}
	
	public static void relExprPrimeNT(List<Token> tokens) {

	}
	
	public static void relOpNT(List<Token> tokens) {

	}
	
	public static void arithExprNT(List<Token> tokens) {

	}
	
	public static void arithExprPrimeNT(List<Token> tokens) {

	}
	
	public static void termNT(List<Token> tokens) {

	}
	
	public static void termPrimeNT(List<Token> tokens) {

	}
	
	public static void factorNT(List<Token> tokens) {

	}
	
	public static void printExprNT(List<Token> tokens) {

	}
	
	
	

}
