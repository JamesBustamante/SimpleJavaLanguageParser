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
			root.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		if (tokens.get(i).getType().equals(Token.TokenType.CLASS)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
			root.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		if (tokens.get(i).getType().equals(Token.TokenType.ID)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.ID, root));
			root.addChild(nodes.get(nodes.size()-1));
			idNT(tokens);
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		if (tokens.get(i).getType().equals(Token.TokenType.LBRACE)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
			root.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		if (tokens.get(i).getType().equals(Token.TokenType.PUBLIC)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
			root.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		if (tokens.get(i).getType().equals(Token.TokenType.STATIC)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
			root.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		if (tokens.get(i).getType().equals(Token.TokenType.VOID)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
			root.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		if (tokens.get(i).getType().equals(Token.TokenType.MAIN)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
			root.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		if (tokens.get(i).getType().equals(Token.TokenType.LPAREN)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
			root.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		if (tokens.get(i).getType().equals(Token.TokenType.STRINGARR)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
			root.addChild(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		if (tokens.get(i).getType().equals(Token.TokenType.ARGS)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
			root.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		if (tokens.get(i).getType().equals(Token.TokenType.RPAREN)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
			root.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		if (tokens.get(i).getType().equals(Token.TokenType.LBRACE)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
			root.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		if (!(tokens.get(i).getType().equals(Token.TokenType.RBRACE))) { //Enter los
			nodes.add(parseTree.new TreeNode(ParseTree.Label.los, root));
			root.addChild(nodes.get(nodes.size()-1));
			losNT(tokens);
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		if (tokens.get(i).getType().equals(Token.TokenType.RBRACE)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
			root.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		if (tokens.get(i).getType().equals(Token.TokenType.RBRACE)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
			root.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
	}

	public static void losNT(List<Token> tokens) throws SyntaxException {
		ParseTree<Token>.TreeNode losParent = nodes.get(nodes.size()-1); //Parent: LOS
		//Matches the first of los
		//Not epsilon
		System.out.println(tokens.get(i).getStringValue());
		if (tokens.get(i).getStringValue().matches(";|while|for|if|System\\.out\\.print|[(]|int|boolean|char") || tokens.get(i).getType().equals(Token.TokenType.ID)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.stat, losParent));
			losParent.addChild(nodes.get(nodes.size()-1));
			statNT(tokens);
			System.out.println("NEXT");
			losNT(tokens);
		} else if (tokens.get(i).getType().equals(Token.TokenType.RBRACE)){ //Checks for epsilon using follow of los
			
		} 
		else {throw new SyntaxException("Syntax Exception");}
		
	}

	public static void statNT(List<Token> tokens) throws SyntaxException {
		ParseTree<Token>.TreeNode statParent = nodes.get(nodes.size() - 1);
		if (tokens.get(i).getType().equals(Token.TokenType.WHILE)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.whilestat, statParent));
			statParent.addChild(nodes.get(nodes.size()-1));
			whileNT(tokens);
		} else if (tokens.get(i).getType().equals(Token.TokenType.FOR)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.forstat, statParent));
			statParent.addChild(nodes.get(nodes.size()-1));
			forNT(tokens);
		} else if (tokens.get(i).getType().equals(Token.TokenType.IF)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.ifstat, statParent));
			statParent.addChild(nodes.get(nodes.size()-1));
			ifNT(tokens);
		} else if (tokens.get(i).getType().equals(Token.TokenType.ID)) {
			System.out.println("NEXTss");
			nodes.add(parseTree.new TreeNode(ParseTree.Label.ID, statParent));
			statParent.addChild(nodes.get(nodes.size()-1));
			assignNT(tokens);
		} else if (tokens.get(i).getType().equals(Token.TokenType.TYPE)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.decl, statParent));
			statParent.addChild(nodes.get(nodes.size()-1));
			declNT(tokens);
		} else if (tokens.get(i).getType().equals(Token.TokenType.PRINT)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.print, statParent));
			statParent.addChild(nodes.get(nodes.size()-1));
			printNT(tokens);
			System.out.println("HEREE");
		} else if (tokens.get(i).getType().equals(Token.TokenType.SEMICOLON)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.stat,tokens.get(i), statParent));
			statParent.addChild(nodes.get(nodes.size()-1));
			System.out.println("SEMI");
			i++;
		} else {
			throw new SyntaxException("Syntax Exception");
		}

	}
	
	public static void whileNT(List<Token> tokens) throws SyntaxException {
		ParseTree<Token>.TreeNode whileParent = nodes.get(nodes.size() - 1);
		if (tokens.get(i).getType().equals(Token.TokenType.WHILE)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.whilestat, tokens.get(i), whileParent));
			whileParent.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;

		if (tokens.get(i).getType().equals(Token.TokenType.LPAREN)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.whilestat, tokens.get(i), whileParent));
			whileParent.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		
		if (tokens.get(i).getType().equals(Token.TokenType.ID) || tokens.get(i).getType().equals(Token.TokenType.NUM) || tokens.get(i).getValue().get().matches("true|false|\\(")) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.boolexpr, whileParent));
			whileParent.addChild(nodes.get(nodes.size()-1));
			boolExprNT(tokens);
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		
		if (tokens.get(i).getType().equals(Token.TokenType.RPAREN)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.whilestat, tokens.get(i), whileParent));
			whileParent.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		
		if (tokens.get(i).getType().equals(Token.TokenType.LBRACE)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.whilestat, tokens.get(i), whileParent));
			whileParent.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		
		if (tokens.get(i).getValue().get().matches(";|while|for|if|system\\.out\\.print|\\(|int|boolean|char")) { //FIXED
			nodes.add(parseTree.new TreeNode(ParseTree.Label.los, tokens.get(i), whileParent));
			whileParent.addChild(nodes.get(nodes.size()-1));
			losNT(tokens);
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		
		if (tokens.get(i).getType().equals(Token.TokenType.RBRACE)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.whilestat, tokens.get(i), whileParent));
			whileParent.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		
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
	
	public static void declNT(List<Token> tokens) throws SyntaxException {
		ParseTree<Token>.TreeNode declParent = nodes.get(nodes.size() - 1);
		if (tokens.get(i).getType().equals(Token.TokenType.TYPE)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.type, declParent));
			declParent.addChild(nodes.get(nodes.size()-1));
			System.out.println("NsT");
			typeNT(tokens);
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		
		if (tokens.get(i).getType().equals(Token.TokenType.ID)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.ID, tokens.get(i), declParent));
			declParent.addChild(nodes.get(nodes.size()-1));
			idNT(tokens);
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		
		
		if (tokens.get(i).getType().equals(Token.TokenType.ASSIGN)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.possassign, declParent));
			declParent.addChild(nodes.get(nodes.size()-1));
			possAssignNT(tokens);
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
	}
	
	public static void possAssignNT(List<Token> tokens) throws SyntaxException {
		ParseTree<Token>.TreeNode possAssignParent = nodes.get(nodes.size() - 1);
		if (tokens.get(i).getType().equals(Token.TokenType.ASSIGN)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.possassign,tokens.get(i), possAssignParent));
			possAssignParent.addChild(nodes.get(nodes.size()-1));
			i++;
			if (tokens.get(i).getValue().get().matches("true|false|\\(") || tokens.get(i).getType().equals(Token.TokenType.NUM) || tokens.get(i).getType().equals(Token.TokenType.ID)) {
				nodes.add(parseTree.new TreeNode(ParseTree.Label.possassign, tokens.get(i), possAssignParent));
				possAssignParent.addChild(nodes.get(nodes.size()-1));
				exprNT(tokens);
			} else {throw new SyntaxException("Syntax Exception");}

		} else if (tokens.get(i).getType().equals(Token.TokenType.SEMICOLON)) { //Epsilon
			
		} 
		else {throw new SyntaxException("Syntax Exception");}
		i++;
	}
	
	public static void printNT(List<Token> tokens) throws SyntaxException {
		ParseTree<Token>.TreeNode printParent = nodes.get(nodes.size() - 1);
		if (tokens.get(i).getType().equals(Token.TokenType.PRINT)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.print, tokens.get(i), printParent));
			printParent.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		
		if (tokens.get(i).getType().equals(Token.TokenType.LPAREN)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.print, tokens.get(i), printParent));
			printParent.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		
		if (tokens.get(i).getType().equals(Token.TokenType.DQUOTE)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.print, tokens.get(i), printParent));
			printParent.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		
		if (tokens.get(i).getType().equals(Token.TokenType.STRINGLIT)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.stringlit, printParent));
			printParent.addChild(nodes.get(nodes.size()-1));
			stringLitNT(tokens);
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		
		if (tokens.get(i).getType().equals(Token.TokenType.DQUOTE)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.print, tokens.get(i), printParent));
			printParent.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		
		if (tokens.get(i).getType().equals(Token.TokenType.RPAREN)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.print, tokens.get(i), printParent));
			printParent.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
	}
	
	public static void typeNT(List<Token> tokens) throws SyntaxException {
		ParseTree<Token>.TreeNode typeParent = nodes.get(nodes.size() - 1);
		if (tokens.get(i).getType().equals(Token.TokenType.TYPE)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.print, tokens.get(i), typeParent));
			typeParent.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
	}
	
	public static void exprNT(List<Token> tokens) throws SyntaxException {
		/// Next part to complete
		ParseTree<Token>.TreeNode exprParent = nodes.get(nodes.size() - 1);
		if (tokens.get(i).getValue().get().matches("true|false|\\(")) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.expr, exprParent));
			exprParent.addChild(nodes.get(nodes.size()-1));
			boolExprNT(tokens);
		} else if (tokens.get(i).getType().equals(Token.TokenType.NUM) || tokens.get(i).getType().equals(Token.TokenType.ID)) { //Arith Expr
			nodes.add(parseTree.new TreeNode(ParseTree.Label.expr, exprParent));
			exprParent.addChild(nodes.get(nodes.size()-1));
			arithExprNT(tokens);
		} else if (tokens.get(i).getStringValue().matches("[']")) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.expr, exprParent)); //char Expr
			exprParent.addChild(nodes.get(nodes.size()-1));
			charExprNT(tokens);
		} 
		else {throw new SyntaxException("Syntax Exception");}
		i++;
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
	
	public static void idNT(List<Token> tokens) {
		nodes.add(parseTree.new TreeNode(ParseTree.Label.ID,tokens.get(i), nodes.get(nodes.size()-1)));
		nodes.get(nodes.size()-2).addChild(nodes.get(nodes.size()-1));
	}
	
	public static void stringLitNT(List<Token> tokens) {
		nodes.add(parseTree.new TreeNode(ParseTree.Label.ID,tokens.get(i), nodes.get(nodes.size()-1)));
		nodes.get(nodes.size()-2).addChild(nodes.get(nodes.size()-1));
	}
	
	public static void charNT(List<Token> tokens) {
		nodes.add(parseTree.new TreeNode(ParseTree.Label.ID,tokens.get(i), nodes.get(nodes.size()-1)));
		nodes.get(nodes.size()-2).addChild(nodes.get(nodes.size()-1));
	}
	
	
	public static void charExprNT(List<Token> tokens) throws SyntaxException {
		ParseTree<Token>.TreeNode charExprParent = nodes.get(nodes.size() - 1);
	
		if (tokens.get(i).getType().equals(Token.TokenType.SQUOTE)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.print, tokens.get(i), charExprParent));
			charExprParent.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		
		if (tokens.get(i).getType().equals(Token.TokenType.CHARLIT)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.print, charExprParent));
			charExprParent.addChild(nodes.get(nodes.size()-1));
			charNT(tokens);
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		
		if (tokens.get(i).getType().equals(Token.TokenType.SQUOTE)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.print, tokens.get(i), charExprParent));
			charExprParent.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
	}
	
	

}
