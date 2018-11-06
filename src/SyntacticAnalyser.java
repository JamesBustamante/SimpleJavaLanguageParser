import java.util.ArrayList;
import java.util.List;

public class SyntacticAnalyser {
	static int i; //Counter
	static ParseTree<Token> parseTree = new ParseTree<Token>(); // The object parseTree is used to set the root of the tree
	static ParseTree<Token>.TreeNode root = parseTree.new TreeNode(ParseTree.Label.prog); // Store A single Node (with parse tree)
	static List<ParseTree<Token>.TreeNode> nodes = new ArrayList<ParseTree<Token>.TreeNode>(); // Store An Array List of Nodes 
	
	static ParseTree<Token>.TreeNode LOS = parseTree.new TreeNode(ParseTree.Label.los, root);
	
	public static ParseTree<Token> parse(List<Token> tokens) throws SyntaxException {
		//ParseTree<Token> parseTree = new ParseTree<Token>();
		// ParseTree<Token> parseTree = new ParseTree();
		// ParseTree is used to set up the tree
		// The object parseTree is used to set the root of the tree

		 
		//

		// ParseTree<Token>.TreeNode allows for the creation of nodes that link to the
		// tree (ParseTree)
		parseTree.setRoot(root); // Root of the node1
//		root.addChild(LOS);
//		LOS.addChild(parseTree.new TreeNode(ParseTree.Label.los, root));
//		LOS.addChild(parseTree.new TreeNode(ParseTree.Label.los, root));
//		ParseTree<Token>.TreeNode node2 = parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(0), LOS);
//		LOS.addChild(node2);
//		node2.addChild(parseTree.new TreeNode(ParseTree.Label.arithexprprime));
//		node2.addChild(parseTree.new TreeNode(ParseTree.Label.boolconst));
//		node2.addChild(parseTree.new TreeNode(ParseTree.Label.boolconst));
//		node2.addChild(parseTree.new TreeNode(ParseTree.Label.boolconst));
//		System.out.println(LOS.getChildren() + " Test");
//		System.out.println(parseTree.getRoot().getChildren() + " Test");
		
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
		System.out.println(parseTree.getRoot().getChildren() + " Test");
		//System.out.println(nodes.get(nodes.size()-4).getParent());
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
			//LOS.addChild(child);
//			ParseTree<Token>.TreeNode single = parseTree.new TreeNode(ParseTree.Label.booleq, root);
//			nodes.add(single);
//			root.addChild(single);
//			single.addChild(parseTree.new TreeNode(ParseTree.Label.boolop, root));
			nodes.add(parseTree.new TreeNode(ParseTree.Label.prog, root));
			root.addChild(nodes.get(nodes.size()-1));

//			nodes.get(nodes.size()-1).addChild(parseTree.new TreeNode(ParseTree.Label.booleq, tokens.get(i), root));
//			nodes.get(nodes.size()-1).addChild(parseTree.new TreeNode(ParseTree.Label.booleq, tokens.get(i), root));
//			System.out.println(parseTree.getRoot().getChildren() + "  rr");
			losNT(tokens);
			System.out.println(nodes.get(nodes.size()-1).getParent() + "=======================");
		} else {throw new SyntaxException("Syntax Exception");}

		if (tokens.get(i).getType().equals(Token.TokenType.RBRACE)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
			root.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		System.out.println(tokens.get(i) + "117");
		if (tokens.get(i).getType().equals(Token.TokenType.RBRACE)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.prog, tokens.get(i), root));
			root.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
	}

	public static void losNT(List<Token> tokens) throws SyntaxException {
		ParseTree<Token>.TreeNode losParent = nodes.get(nodes.size()-1); //Parent: LOS
		//Matches the first of los
		//Not epsilon
		System.out.println(tokens.get(i).getStringValue()); //Next token string
		if (tokens.get(i).getStringValue().matches(";|while|for|if|System\\.out\\.print|[(]|int|boolean|char") || tokens.get(i).getType().equals(Token.TokenType.ID)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.stat, losParent));
			losParent.addChild(nodes.get(nodes.size()-1));
			statNT(tokens);
			System.out.println("NEXT " + tokens.get(i));
			nodes.add(parseTree.new TreeNode(ParseTree.Label.prog, root));
			losParent.addChild(nodes.get(nodes.size()-1));
			losNT(tokens);
		} else if (tokens.get(i).getType().equals(Token.TokenType.RBRACE)){ //Checks for epsilon using follow of los
			System.out.println("NEXT e" + tokens.get(i));
		} 
		else {throw new SyntaxException("Syntax Exception");}
		
	}

	public static void statNT(List<Token> tokens) throws SyntaxException {
		ParseTree<Token>.TreeNode statParent = nodes.get(nodes.size() - 1);
		System.out.println(nodes.get(nodes.size()-1).getParent().getParent() + "=======================g");
		if (tokens.get(i).getType().equals(Token.TokenType.WHILE)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.whilestat, statParent));
			statParent.addChild(nodes.get(nodes.size()-1));
			whileNT(tokens);
			System.out.println(tokens.get(i) + "148");
		} else if (tokens.get(i).getType().equals(Token.TokenType.FOR)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.forstat, statParent));
			statParent.addChild(nodes.get(nodes.size()-1));
			forNT(tokens);
		} else if (tokens.get(i).getType().equals(Token.TokenType.IF)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.ifstat, statParent));
			statParent.addChild(nodes.get(nodes.size()-1));
			ifNT(tokens);
			System.out.println(tokens.get(i) + "156");
		} else if (tokens.get(i).getType().equals(Token.TokenType.ID)) {
			System.out.println("NEXTss");
			nodes.add(parseTree.new TreeNode(ParseTree.Label.ID, statParent));
			statParent.addChild(nodes.get(nodes.size()-1));
			assignNT(tokens);
		} else if (tokens.get(i).getType().equals(Token.TokenType.TYPE)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.decl, statParent));
			statParent.addChild(nodes.get(nodes.size()-1));
			declNT(tokens);
			nodes.add(parseTree.new TreeNode(ParseTree.Label.stat,tokens.get(i), statParent));
			statParent.addChild(nodes.get(nodes.size()-1));
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
		System.out.println(statParent.getChildren() + "+++++++++++++++++++");
		System.out.println(nodes.get(nodes.size()-1).getParent().getParent().getChildren() + "=======================h");
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
		//System.out.println(tokens.get(i) + "203");
		//i++;
		System.out.println(tokens.get(i) + "205");
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
		System.out.println(tokens.get(i) + "217");
		if (tokens.get(i).getStringValue().matches(";|while|for|if|system\\.out\\.print|\\(|int|boolean|char") || tokens.get(i).getType().equals(Token.TokenType.ID)) { //FIXED
			nodes.add(parseTree.new TreeNode(ParseTree.Label.los, tokens.get(i), whileParent));
			whileParent.addChild(nodes.get(nodes.size()-1));
			losNT(tokens);
		} else {throw new SyntaxException("Syntax Exception");}
		System.out.println(tokens.get(i) + "224");
		
		if (tokens.get(i).getType().equals(Token.TokenType.RBRACE)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.whilestat, tokens.get(i), whileParent));
			whileParent.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		System.out.println(tokens.get(i+1) + "230");
	}
	
	public static void forNT(List<Token> tokens) throws SyntaxException {
		ParseTree<Token>.TreeNode forParent = nodes.get(nodes.size() - 1);
		if (tokens.get(i).getType().equals(Token.TokenType.FOR)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.forstat, tokens.get(i), forParent));
			forParent.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;

		if (tokens.get(i).getType().equals(Token.TokenType.LPAREN)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.forstat, tokens.get(i), forParent));
			forParent.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		
		if (tokens.get(i).getStringValue().matches("int|boolean|char|[;]") || tokens.get(i).getType().equals(Token.TokenType.ID)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.forstart, tokens.get(i), forParent));
			forParent.addChild(nodes.get(nodes.size()-1));
			forStartNT(tokens); 
		} else {throw new SyntaxException("Syntax Exception");}
		//i++;
		System.out.println(tokens.get(i) + "254");
		if (tokens.get(i).getType().equals(Token.TokenType.SEMICOLON)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.forstat, tokens.get(i), forParent));
			forParent.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		
		if (tokens.get(i).getStringValue().matches("true|false|\\(") || tokens.get(i).getType().equals(Token.TokenType.NUM) || tokens.get(i).getType().equals(Token.TokenType.ID)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.boolexpr, forParent));
			forParent.addChild(nodes.get(nodes.size()-1));
			boolExprNT(tokens);
		} else {throw new SyntaxException("Syntax Exception");}
		//i++;
		System.out.println(tokens.get(i) + "267");
		if (tokens.get(i).getType().equals(Token.TokenType.SEMICOLON)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.forstat, tokens.get(i), forParent));
			forParent.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		
		if (tokens.get(i).getStringValue().matches("\\)|\\(") || tokens.get(i).getType().equals(Token.TokenType.NUM) || tokens.get(i).getType().equals(Token.TokenType.ID)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.forarith, tokens.get(i), forParent));
			forParent.addChild(nodes.get(nodes.size()-1));
			forArithNT(tokens);
		} else {throw new SyntaxException("Syntax Exception");}
		//i++;
		System.out.println(tokens.get(i) + "280");
		if (tokens.get(i).getType().equals(Token.TokenType.RPAREN)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.forstat, tokens.get(i), forParent));
			forParent.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		
		if (tokens.get(i).getType().equals(Token.TokenType.LBRACE)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.forstat, tokens.get(i), forParent));
			forParent.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		

			nodes.add(parseTree.new TreeNode(ParseTree.Label.los, tokens.get(i), forParent)); //LOS
			forParent.addChild(nodes.get(nodes.size()-1));
			losNT(tokens);
		i++;
		
		if (tokens.get(i).getType().equals(Token.TokenType.RBRACE)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.forstat, tokens.get(i), forParent));
			forParent.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}


	}
	
	public static void forStartNT(List<Token> tokens) throws SyntaxException {
		ParseTree<Token>.TreeNode forStartParent = nodes.get(nodes.size() - 1);
		if (tokens.get(i).getStringValue().matches("int|boolean|char")) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.decl, forStartParent));
			forStartParent.addChild(nodes.get(nodes.size()-1));
			declNT(tokens); 
			System.out.println(tokens.get(i) + "313");
		} else if (tokens.get(i).getType().equals(Token.TokenType.ID)) { //Arith Expr
			nodes.add(parseTree.new TreeNode(ParseTree.Label.assign, forStartParent));
			forStartParent.addChild(nodes.get(nodes.size()-1));
			arithExprNT(tokens);
		} else if (tokens.get(i).getStringValue().matches("[;]")) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.epsilon, forStartParent)); //char Expr
			forStartParent.addChild(nodes.get(nodes.size()-1));
			i--;
		} 
		else {throw new SyntaxException("Syntax Exception");}
		System.out.println(tokens.get(i) + "324");
		i--;
	}
	
	public static void forArithNT(List<Token> tokens) throws SyntaxException {
		ParseTree<Token>.TreeNode forArithParent = nodes.get(nodes.size() - 1); 
		if (tokens.get(i).getStringValue().matches("\\(") || tokens.get(i).getType().equals(Token.TokenType.NUM) || tokens.get(i).getType().equals(Token.TokenType.ID)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.arithexpr, forArithParent));
			forArithParent.addChild(nodes.get(nodes.size()-1));
			System.out.println(tokens.get(i) + "333");
			arithExprNT(tokens);
		} else if (tokens.get(i).getStringValue().matches("[)]|[;]|[<]|[<>]=?|=|\\!\\=|\\&\\&|\\|")) { //Arith Expr
			nodes.add(parseTree.new TreeNode(ParseTree.Label.epsilon, forArithParent));
			forArithParent.addChild(nodes.get(nodes.size()-1));
			arithExprNT(tokens);
			}
		else {throw new SyntaxException("Syntax Exception"); }
	}
	
	public static void ifNT(List<Token> tokens) throws SyntaxException { ////
		ParseTree<Token>.TreeNode ifParent = nodes.get(nodes.size() - 1);
		if (tokens.get(i).getType().equals(Token.TokenType.IF)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.ifstat,tokens.get(i), ifParent));
			ifParent.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		
		if (tokens.get(i).getType().equals(Token.TokenType.LPAREN)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.ifstat,tokens.get(i), ifParent));
			ifParent.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		
		if (tokens.get(i).getType().equals(Token.TokenType.ID) || tokens.get(i).getType().equals(Token.TokenType.NUM) || tokens.get(i).getValue().get().matches("true|false|\\(")) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.boolexpr, ifParent));
			ifParent.addChild(nodes.get(nodes.size()-1));
			boolExprNT(tokens);
		} else {throw new SyntaxException("Syntax Exception");}
		//i++;
		System.out.println(tokens.get(i) + "356");
		if (tokens.get(i).getType().equals(Token.TokenType.RPAREN)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.ifstat,tokens.get(i), ifParent));
			ifParent.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		
		if (tokens.get(i).getType().equals(Token.TokenType.LBRACE)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.ifstat,tokens.get(i), ifParent));
			ifParent.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		System.out.println(tokens.get(i).getStringValue() + "368");
		if (tokens.get(i).getStringValue().matches(";|while|for|if|System\\.out\\.print|\\(|int|boolean|char")) { //FIXED
			nodes.add(parseTree.new TreeNode(ParseTree.Label.los, tokens.get(i), ifParent));
			ifParent.addChild(nodes.get(nodes.size()-1));
			losNT(tokens);
		} else {throw new SyntaxException("Syntax Exception");}
		//i++;
		System.out.println(tokens.get(i) + "375");
		if (tokens.get(i).getType().equals(Token.TokenType.RBRACE)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.ifstat,tokens.get(i), ifParent));
			ifParent.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
		i++; //FIX up
		System.out.println(tokens.get(i) + "382");
		if (tokens.get(i).getType().equals(Token.TokenType.ELSE) || tokens.get(i).getStringValue().matches(";|while|for|if|System\\.out\\.print|\\(|int|boolean|char")) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.elseifstat, ifParent));
			ifParent.addChild(nodes.get(nodes.size()-1));
			elseIfNT(tokens);
		} else {throw new SyntaxException("Syntax Exception");}
	}
	
	public static void elseIfNT(List<Token> tokens) throws SyntaxException {
		ParseTree<Token>.TreeNode elseIfParent = nodes.get(nodes.size() - 1);
		System.out.println(tokens.get(i) + "426");
		if (tokens.get(i).getType().equals(Token.TokenType.ELSE) && tokens.get(i+1).getType().equals(Token.TokenType.IF)) {	
			if (tokens.get(i).getType().equals(Token.TokenType.ELSE) || tokens.get(i+1).getType().equals(Token.TokenType.IF)) {
				nodes.add(parseTree.new TreeNode(ParseTree.Label.elseifstat,tokens.get(i), elseIfParent));
				elseIfParent.addChild(nodes.get(nodes.size()-1));
				elseQIfNT(tokens);
				} else {throw new SyntaxException("Syntax Exception");}

			System.out.println(tokens.get(i) + "435");
			if (tokens.get(i).getType().equals(Token.TokenType.LBRACE)) {
				nodes.add(parseTree.new TreeNode(ParseTree.Label.elseifstat,tokens.get(i), elseIfParent));
				elseIfParent.addChild(nodes.get(nodes.size()-1));
			} else {throw new SyntaxException("Syntax Exception");}
			i++;
			System.out.println(tokens.get(i) + "440");
			if (tokens.get(i).getStringValue().matches(";|while|for|if|system\\.out\\.print|\\(|int|boolean|char") || tokens.get(i).getType().equals(Token.TokenType.ID)) { //FIXED
				nodes.add(parseTree.new TreeNode(ParseTree.Label.los, tokens.get(i), elseIfParent));
				elseIfParent.addChild(nodes.get(nodes.size()-1));
				losNT(tokens);
			} else {throw new SyntaxException("Syntax Exception");}

			
			if (tokens.get(i).getType().equals(Token.TokenType.RBRACE)) {
				nodes.add(parseTree.new TreeNode(ParseTree.Label.elseifstat,tokens.get(i), elseIfParent));
				elseIfParent.addChild(nodes.get(nodes.size()-1));
			} else {throw new SyntaxException("Syntax Exception");}
			i++;
			System.out.println(tokens.get(i) + "453");
			if (tokens.get(i).getType().equals(Token.TokenType.ELSE) || tokens.get(i).getStringValue().matches(";|while|for|if|system\\.out\\.print|\\(|int|boolean|char")) {
				nodes.add(parseTree.new TreeNode(ParseTree.Label.elseifstat,tokens.get(i), elseIfParent));
				elseIfParent.addChild(nodes.get(nodes.size()-1));
				elseIfNT(tokens);
				} else {throw new SyntaxException("Syntax Exception");}
		} else if (tokens.get(i).getStringValue().matches(";|while|for|if|system\\.out\\.print|\\(|int|boolean|char")) { //FIXED
			nodes.add(parseTree.new TreeNode(ParseTree.Label.epsilon, tokens.get(i), elseIfParent));
			elseIfParent.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}

		
//		///
//		
//		if (tokens.get(i).getType().equals(Token.TokenType.ELSE) && !tokens.get(i+1).getType().equals(Token.TokenType.IF)) {
//			nodes.add(parseTree.new TreeNode(ParseTree.Label.elseifstat,tokens.get(i), elseIfParent));
//			elseIfParent.addChild(nodes.get(nodes.size()-1));
//			i++;
//			
//			if (tokens.get(i).getType().equals(Token.TokenType.LBRACE)) {
//				nodes.add(parseTree.new TreeNode(ParseTree.Label.elseifstat,tokens.get(i), elseIfParent));
//				elseIfParent.addChild(nodes.get(nodes.size()-1));
//			} else {throw new SyntaxException("Syntax Exception");}
//			i++;
//			
//			if (tokens.get(i).getStringValue().matches(";|while|for|if|system\\.out\\.print|\\(|int|boolean|char")) { //FIXED
//				nodes.add(parseTree.new TreeNode(ParseTree.Label.los, tokens.get(i), elseIfParent));
//				elseIfParent.addChild(nodes.get(nodes.size()-1));
//				losNT(tokens);
//			} else {throw new SyntaxException("Syntax Exception");}
//			i++;
//			
//			if (tokens.get(i).getType().equals(Token.TokenType.RBRACE)) {
//				nodes.add(parseTree.new TreeNode(ParseTree.Label.elseifstat,tokens.get(i), elseIfParent));
//				elseIfParent.addChild(nodes.get(nodes.size()-1));
//			} else {throw new SyntaxException("Syntax Exception");}
//			i++;
//			elseIfNT(tokens);
//		} else if (tokens.get(i).getType().equals(Token.TokenType.ELSE) && tokens.get(i+1).getType().equals(Token.TokenType.IF)) {
//			nodes.add(parseTree.new TreeNode(ParseTree.Label.elseifstat,tokens.get(i), elseIfParent));
//			elseIfParent.addChild(nodes.get(nodes.size()-1));
//			i++;
//			
//			nodes.add(parseTree.new TreeNode(ParseTree.Label.elseifstat,tokens.get(i), elseIfParent));
//			elseIfParent.addChild(nodes.get(nodes.size()-1));
//			i++;
//			
//			if (tokens.get(i).getType().equals(Token.TokenType.LPAREN)) {
//				nodes.add(parseTree.new TreeNode(ParseTree.Label.elseifstat,tokens.get(i), elseIfParent));
//				elseIfParent.addChild(nodes.get(nodes.size()-1));
//				i++;
//			}
//			
//			if (tokens.get(i).getType().equals(Token.TokenType.ID) || tokens.get(i).getType().equals(Token.TokenType.NUM) || tokens.get(i).getValue().get().matches("true|false|\\(")) {
//				nodes.add(parseTree.new TreeNode(ParseTree.Label.boolexpr, elseIfParent));
//				elseIfParent.addChild(nodes.get(nodes.size()-1));
//				boolExprNT(tokens);
//			} else {throw new SyntaxException("Syntax Exception");}
//			i++;
//			
//			if (tokens.get(i).getType().equals(Token.TokenType.RPAREN)) {
//				nodes.add(parseTree.new TreeNode(ParseTree.Label.elseifstat,tokens.get(i), elseIfParent));
//				elseIfParent.addChild(nodes.get(nodes.size()-1));
//				i++;
//			}
//			
//			if (tokens.get(i).getType().equals(Token.TokenType.LBRACE)) {
//				nodes.add(parseTree.new TreeNode(ParseTree.Label.elseifstat,tokens.get(i), elseIfParent));
//				elseIfParent.addChild(nodes.get(nodes.size()-1));
//				i++;
//			}
//			
//			if (tokens.get(i).getStringValue().matches(";|while|for|if|system\\.out\\.print|\\(|int|boolean|char")) { //FIXED
//				nodes.add(parseTree.new TreeNode(ParseTree.Label.los, tokens.get(i), elseIfParent));
//				elseIfParent.addChild(nodes.get(nodes.size()-1));
//				losNT(tokens);
//			} else {throw new SyntaxException("Syntax Exception");}
//			i++;
//			
//			if (tokens.get(i).getType().equals(Token.TokenType.RBRACE)) {
//				nodes.add(parseTree.new TreeNode(ParseTree.Label.elseifstat,tokens.get(i), elseIfParent));
//				elseIfParent.addChild(nodes.get(nodes.size()-1));
//				i++;
//			}
//			
//			if (tokens.get(i).getType().equals(Token.TokenType.RBRACE)) {
//				nodes.add(parseTree.new TreeNode(ParseTree.Label.elseifstat,tokens.get(i), elseIfParent));
//				elseIfParent.addChild(nodes.get(nodes.size()-1));
//				i++;
//			}
//			
//		} else if (tokens.get(i).getStringValue().matches(";|while|for|if|system\\.out\\.print|\\(|int|boolean|char")) { //FIXED
//			nodes.add(parseTree.new TreeNode(ParseTree.Label.epsilon, tokens.get(i), elseIfParent));
//			elseIfParent.addChild(nodes.get(nodes.size()-1));
//			i--;
//		}
//		else {throw new SyntaxException("Syntax Exception");}
//		i++;
		
		
	}
	
	public static void elseQIfNT(List<Token> tokens) throws SyntaxException {
		ParseTree<Token>.TreeNode elseQIfParent = nodes.get(nodes.size() - 1);
		if (tokens.get(i).getType().equals(Token.TokenType.ELSE)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.elseifstat,tokens.get(i), elseQIfParent));
			elseQIfParent.addChild(nodes.get(nodes.size()-1));
			} else {throw new SyntaxException("Syntax Exception");}
		i++;
		System.out.println(tokens.get(i));
		if (tokens.get(i).getType().equals(Token.TokenType.IF) || tokens.get(i+1).getType().equals(Token.TokenType.LBRACE)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.elseifstat,tokens.get(i), elseQIfParent));
			elseQIfParent.addChild(nodes.get(nodes.size()-1));
			possIfNT(tokens);
			} else {throw new SyntaxException("Syntax Exception");}
		System.out.println(tokens.get(i) + "574");
		
	}
	
	public static void possIfNT(List<Token> tokens) throws SyntaxException {
		ParseTree<Token>.TreeNode possIfParent = nodes.get(nodes.size() - 1);
		if (tokens.get(i).getType().equals(Token.TokenType.IF)) {
			if (tokens.get(i).getType().equals(Token.TokenType.IF)) {
				nodes.add(parseTree.new TreeNode(ParseTree.Label.ifstat,tokens.get(i), possIfParent));
				possIfParent.addChild(nodes.get(nodes.size()-1));
			} else {throw new SyntaxException("Syntax Exception");}
			i++;
			
			if (tokens.get(i).getType().equals(Token.TokenType.LPAREN)) {
				nodes.add(parseTree.new TreeNode(ParseTree.Label.ifstat,tokens.get(i), possIfParent));
				possIfParent.addChild(nodes.get(nodes.size()-1));
			} else {throw new SyntaxException("Syntax Exception");}
			i++;
			
			if (tokens.get(i).getType().equals(Token.TokenType.ID) || tokens.get(i).getType().equals(Token.TokenType.NUM) || tokens.get(i).getValue().get().matches("true|false|\\(")) {
				nodes.add(parseTree.new TreeNode(ParseTree.Label.boolexpr, possIfParent));
				possIfParent.addChild(nodes.get(nodes.size()-1));
				boolExprNT(tokens);
			} else {throw new SyntaxException("Syntax Exception");}
			
			if (tokens.get(i).getType().equals(Token.TokenType.RPAREN)) {
				nodes.add(parseTree.new TreeNode(ParseTree.Label.ifstat,tokens.get(i), possIfParent));
				possIfParent.addChild(nodes.get(nodes.size()-1));
			} else {throw new SyntaxException("Syntax Exception");}
			i++;
		} else if (tokens.get(i+1).getType().equals(Token.TokenType.LBRACE)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.epsilon,tokens.get(i), possIfParent));
			possIfParent.addChild(nodes.get(nodes.size()-1));
			i++; 
			} else {throw new SyntaxException("Syntax Exception");}
	}
	
	public static void assignNT(List<Token> tokens) throws SyntaxException {
		ParseTree<Token>.TreeNode assignParent = nodes.get(nodes.size() - 1);
		System.out.println(tokens.get(i) + "483");
		if (tokens.get(i).getType().equals(Token.TokenType.ID)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.ID, assignParent));
			assignParent.addChild(nodes.get(nodes.size()-1));
			idNT(tokens);
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		
		if (tokens.get(i).getType().equals(Token.TokenType.ASSIGN)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.assign,tokens.get(i), assignParent));
			assignParent.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		System.out.println(tokens.get(i) + "496");
		if (tokens.get(i).getValue().get().matches("\\(|[']|true|false") || tokens.get(i).getType().equals(Token.TokenType.NUM) || tokens.get(i).getType().equals(Token.TokenType.ID)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.expr, assignParent));
			assignParent.addChild(nodes.get(nodes.size()-1));
			exprNT(tokens);
		} else {throw new SyntaxException("Syntax Exception");}
		//i++; Error needs to be catched
	}
	
	public static void declNT(List<Token> tokens) throws SyntaxException {
		ParseTree<Token>.TreeNode declParent = nodes.get(nodes.size() - 1);
		System.out.println(tokens.get(i) + "505");
		if (tokens.get(i).getType().equals(Token.TokenType.TYPE)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.type, declParent));
			declParent.addChild(nodes.get(nodes.size()-1));
			System.out.println("NsT");
			typeNT(tokens);
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		System.out.println(tokens.get(i) + "510");
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
			System.out.println(tokens.get(i) + "524");
		} else {throw new SyntaxException("Syntax Exception");}

	}
	
	public static void possAssignNT(List<Token> tokens) throws SyntaxException {
		ParseTree<Token>.TreeNode possAssignParent = nodes.get(nodes.size() - 1);
		if (tokens.get(i).getType().equals(Token.TokenType.ASSIGN)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.possassign,tokens.get(i), possAssignParent));
			possAssignParent.addChild(nodes.get(nodes.size()-1));
			i++;
			System.out.println(tokens.get(i) + "528");
			if (tokens.get(i).getStringValue().matches("true|false|\\(") || tokens.get(i).getType().equals(Token.TokenType.NUM) || tokens.get(i).getType().equals(Token.TokenType.ID) || tokens.get(i).getType().equals(Token.TokenType.SQUOTE)) {
				nodes.add(parseTree.new TreeNode(ParseTree.Label.possassign, tokens.get(i), possAssignParent));
				possAssignParent.addChild(nodes.get(nodes.size()-1));
				exprNT(tokens);
			} else {throw new SyntaxException("Syntax Exception");}

		} else if (tokens.get(i).getType().equals(Token.TokenType.SEMICOLON)) { //Epsilon
			System.out.println(tokens.get(i) + "542");
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
		if (tokens.get(i).getStringValue().matches("true|false|\\(")) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.expr, exprParent));
			exprParent.addChild(nodes.get(nodes.size()-1));
			boolExprNT(tokens);
		} else if (tokens.get(i).getType().equals(Token.TokenType.NUM) || tokens.get(i).getType().equals(Token.TokenType.ID)) { //Arith Expr
			nodes.add(parseTree.new TreeNode(ParseTree.Label.expr, exprParent));
			exprParent.addChild(nodes.get(nodes.size()-1));
			System.out.println(tokens.get(i));
			arithExprNT(tokens);
			System.out.println(tokens.get(i) + "608");
		} else if (tokens.get(i).getStringValue().matches("[']")) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.expr, exprParent)); //char Expr
			exprParent.addChild(nodes.get(nodes.size()-1));
			charExprNT(tokens);
		} 
		else {throw new SyntaxException("Syntax Exception");}
	}

	public static void boolExprNT(List<Token> tokens) throws SyntaxException { ///HERE NOW
		ParseTree<Token>.TreeNode boolExprParent = nodes.get(nodes.size() - 1);
		if (tokens.get(i).getStringValue().matches("true|false|\\(") || tokens.get(i).getType().equals(Token.TokenType.NUM) || tokens.get(i).getType().equals(Token.TokenType.ID)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.relexpr,boolExprParent));
			boolExprParent.addChild(nodes.get(nodes.size()-1));
			System.out.println(tokens.get(i) + "624");
			relExprNT(tokens);
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		System.out.println(tokens.get(i) + "617");
		if (tokens.get(i).getStringValue().matches("[)]|[;]|[<]|[<>]=?|=|\\!\\=|\\&\\&|\\|[=]") || tokens.get(i).getStringValue().matches("[)]|[;]") || tokens.get(i).getType().equals(Token.TokenType.EQUAL)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.boolexprprime, boolExprParent));
			boolExprParent.addChild(nodes.get(nodes.size()-1));
			System.out.println(tokens.get(i) + "630");
			boolExprPrimeNT(tokens); 
		} else {throw new SyntaxException("Syntax Exception");}
		System.out.println(tokens.get(i) + "626");
	}
	
	public static void boolExprPrimeNT(List<Token> tokens) throws SyntaxException {
		ParseTree<Token>.TreeNode boolExprPrimeParent = nodes.get(nodes.size() - 1);
		System.out.println(tokens.get(i) + "627");
		if (tokens.get(i).getType().equals(Token.TokenType.EQUAL) || tokens.get(i).getType().equals(Token.TokenType.NEQUAL) || tokens.get(i).getType().equals(Token.TokenType.OR) || tokens.get(i).getType().equals(Token.TokenType.AND)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.boolop,boolExprPrimeParent));
			boolExprPrimeParent.addChild(nodes.get(nodes.size()-1));
			boolOpNT(tokens);
			i++;
			System.out.println(tokens.get(i) + "634");
			if (tokens.get(i).getStringValue().matches("true|false|\\(") || tokens.get(i).getType().equals(Token.TokenType.NUM) || tokens.get(i).getType().equals(Token.TokenType.ID)) { 
				nodes.add(parseTree.new TreeNode(ParseTree.Label.boollog,boolExprPrimeParent));
				boolExprPrimeParent.addChild(nodes.get(nodes.size()-1));
				System.out.println(tokens.get(i) + "636");
				relExprNT(tokens);
				i++;
				System.out.println(tokens.get(i) + "641");
				boolExprPrimeNT(tokens);
			} else {throw new SyntaxException("Syntax Exception");}
				
		} else if (tokens.get(i).getStringValue().matches("[)]|[;]|[<]|[<>]=?|=|\\!\\=|\\&\\&|\\|")|| tokens.get(i).getType().equals(Token.TokenType.SEMICOLON)) { 
			nodes.add(parseTree.new TreeNode(ParseTree.Label.epsilon,boolExprPrimeParent));
			boolExprPrimeParent.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
	}
	
	public static void boolOpNT(List<Token> tokens) throws SyntaxException {
		ParseTree<Token>.TreeNode boolOpParent = nodes.get(nodes.size() - 1);
		if (tokens.get(i).getType().equals(Token.TokenType.EQUAL) || tokens.get(i).getType().equals(Token.TokenType.NEQUAL)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.booleq,boolOpParent));
			boolOpParent.addChild(nodes.get(nodes.size()-1));
			boolEqNT(tokens);
		} else if (tokens.get(i).getType().equals(Token.TokenType.OR) || tokens.get(i).getType().equals(Token.TokenType.AND)) { 
			nodes.add(parseTree.new TreeNode(ParseTree.Label.boollog,boolOpParent));
			boolOpParent.addChild(nodes.get(nodes.size()-1));
			boolLogNT(tokens);
		} else {throw new SyntaxException("Syntax Exception");}
	}
	
	public static void boolEqNT(List<Token> tokens) throws SyntaxException {
		ParseTree<Token>.TreeNode boolEqParent = nodes.get(nodes.size() - 1);
		if (tokens.get(i).getType().equals(Token.TokenType.EQUAL)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.booleq,tokens.get(i), boolEqParent));
			boolEqParent.addChild(nodes.get(nodes.size()-1));
		} else if (tokens.get(i).getType().equals(Token.TokenType.NEQUAL)) { 
			nodes.add(parseTree.new TreeNode(ParseTree.Label.booleq,tokens.get(i), boolEqParent));
			boolEqParent.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
	}
	
	public static void boolLogNT(List<Token> tokens) throws SyntaxException {
		ParseTree<Token>.TreeNode boolLogParent = nodes.get(nodes.size() - 1);
		System.out.println(tokens.get(i) + "673");
		if (tokens.get(i).getType().equals(Token.TokenType.OR)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.boollog,tokens.get(i), boolLogParent));
			boolLogParent.addChild(nodes.get(nodes.size()-1));
		} else if (tokens.get(i).getType().equals(Token.TokenType.AND)) { 
			nodes.add(parseTree.new TreeNode(ParseTree.Label.boollog,tokens.get(i), boolLogParent));
			boolLogParent.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
	}
	
	public static void relExprNT(List<Token> tokens) throws SyntaxException {
		ParseTree<Token>.TreeNode relExprParent = nodes.get(nodes.size() - 1);
		System.out.println(tokens.get(i) + "686;");
		if (tokens.get(i).getType().equals(Token.TokenType.ID) || tokens.get(i).getType().equals(Token.TokenType.NUM) || tokens.get(i).getStringValue().matches("[)]|[;]|[<]|[<>]=?|=|\\!\\=|\\&\\&|\\|")) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.arithexpr, relExprParent));
			relExprParent.addChild(nodes.get(nodes.size()-1));
			System.out.println(tokens.get(i) + "704");
			arithExprNT(tokens);
			//i++;
			System.out.println(tokens.get(i) + "708");
			if (tokens.get(i).getType().equals(Token.TokenType.LT) || tokens.get(i).getType().equals(Token.TokenType.LE) || tokens.get(i).getType().equals(Token.TokenType.GT) || tokens.get(i).getType().equals(Token.TokenType.GE)) {
				nodes.add(parseTree.new TreeNode(ParseTree.Label.relop,relExprParent));
				relExprParent.addChild(nodes.get(nodes.size()-1));
				i++;
			} else {throw new SyntaxException("Syntax Exception");}
			
		} else if (tokens.get(i).getType().equals(Token.TokenType.TRUE)) { 
			nodes.add(parseTree.new TreeNode(ParseTree.Label.relexpr,tokens.get(i), relExprParent));
			relExprParent.addChild(nodes.get(nodes.size()-1));
			System.out.println(tokens.get(i) + "700");
		} else if (tokens.get(i).getType().equals(Token.TokenType.FALSE)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.relexpr,tokens.get(i), relExprParent));
			relExprParent.addChild(nodes.get(nodes.size()-1));
		} 
		else {throw new SyntaxException("Syntax Exception");}
	}
	
	public static void relExprPrimeNT(List<Token> tokens) throws SyntaxException {
		ParseTree<Token>.TreeNode relExprPrimeParent = nodes.get(nodes.size() - 1);
		if (tokens.get(i).getType().equals(Token.TokenType.LT) || tokens.get(i).getType().equals(Token.TokenType.LE) || tokens.get(i).getType().equals(Token.TokenType.GT) || tokens.get(i).getType().equals(Token.TokenType.GE)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.relop,relExprPrimeParent));
			relExprPrimeParent.addChild(nodes.get(nodes.size()-1));
		} else {throw new SyntaxException("Syntax Exception");}
		i++;
		if (tokens.get(i).getType().equals(Token.TokenType.PLUS) || tokens.get(i).getType().equals(Token.TokenType.MINUS) || tokens.get(i).getStringValue().matches("[)]|[;]|[<]|[<>]=?|=|\\!\\=|\\&\\&|\\|")) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.arithexprprime, relExprPrimeParent));
			relExprPrimeParent.addChild(nodes.get(nodes.size()-1));
			arithExprPrimeNT(tokens);
		} {throw new SyntaxException("Syntax Exception");}
	}
	
	public static void relOpNT(List<Token> tokens) throws SyntaxException {
		ParseTree<Token>.TreeNode relOpParent = nodes.get(nodes.size() - 1);
		if (tokens.get(i).getType().equals(Token.TokenType.LT)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.relop,tokens.get(i), relOpParent));
			relOpParent.addChild(nodes.get(nodes.size()-1));
		} else if (tokens.get(i).getType().equals(Token.TokenType.LE)) { 
			nodes.add(parseTree.new TreeNode(ParseTree.Label.relop,tokens.get(i), relOpParent));
			relOpParent.addChild(nodes.get(nodes.size()-1));
		} else if (tokens.get(i).getType().equals(Token.TokenType.GT)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.relop,tokens.get(i), relOpParent));
			relOpParent.addChild(nodes.get(nodes.size()-1));
		} else if (tokens.get(i).getType().equals(Token.TokenType.GE)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.relop,tokens.get(i), relOpParent));
			relOpParent.addChild(nodes.get(nodes.size()-1));
		} 
		else {throw new SyntaxException("Syntax Exception");}
		i++;
	}
	
	public static void arithExprNT(List<Token> tokens) throws SyntaxException {
		ParseTree<Token>.TreeNode arithExprParent = nodes.get(nodes.size() - 1);
		System.out.println(tokens.get(i) + "762");
		if (tokens.get(i).getValue().get().matches("\\(") || tokens.get(i).getType().equals(Token.TokenType.NUM) || tokens.get(i).getType().equals(Token.TokenType.ID)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.arithexpr, arithExprParent));
			arithExprParent.addChild(nodes.get(nodes.size()-1));
			System.out.println(tokens.get(i));
			termNT(tokens);
			System.out.println(tokens.get(i) + "743");
		} else {throw new SyntaxException("Syntax Exception");}

		System.out.println(tokens.get(i) + "746");
		if (tokens.get(i).getType().equals(Token.TokenType.SEMICOLON) || tokens.get(i).getType().equals(Token.TokenType.PLUS) || tokens.get(i).getType().equals(Token.TokenType.MINUS) || tokens.get(i).getStringValue().matches("[)]|[;]|[<]|[<>]=?|=|\\!\\=|\\&\\&|\\|") || tokens.get(i).getType().equals(Token.TokenType.EQUAL)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.arithexprprime, arithExprParent));
			arithExprParent.addChild(nodes.get(nodes.size()-1));
			arithExprPrimeNT(tokens);
			System.out.println(tokens.get(i) + "751");
		} else {throw new SyntaxException("Syntax Exception");}
		
	}
	
	public static void arithExprPrimeNT(List<Token> tokens) throws SyntaxException {
		ParseTree<Token>.TreeNode arithExprPrimeParent = nodes.get(nodes.size() - 1);
		System.out.println(tokens.get(i) + "758");
		if (tokens.get(i).getType().equals(Token.TokenType.PLUS)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.arithexprprime,tokens.get(i), arithExprPrimeParent));
			arithExprPrimeParent.addChild(nodes.get(nodes.size()-1));
			i++;
			System.out.println(tokens.get(i) + "789");
			termNT(tokens);
			System.out.println(tokens.get(i) + "791");
			arithExprPrimeNT(tokens);
		} else if (tokens.get(i).getType().equals(Token.TokenType.MINUS)) { 
			nodes.add(parseTree.new TreeNode(ParseTree.Label.arithexprprime, tokens.get(i), arithExprPrimeParent));
			arithExprPrimeParent.addChild(nodes.get(nodes.size()-1));
			i++;
			termNT(tokens);
			i++;
			arithExprPrimeNT(tokens);
		} else if (tokens.get(i).getStringValue().matches("[)]|[;]|[<]|[<>]=?|=|\\!\\=|\\&\\&|\\|") || tokens.get(i).getType().equals(Token.TokenType.EQUAL)) { 
			nodes.add(parseTree.new TreeNode(ParseTree.Label.epsilon, arithExprPrimeParent));
			arithExprPrimeParent.addChild(nodes.get(nodes.size()-1));
		} 
		else {throw new SyntaxException("Syntax Exception");}
	}
	
	public static void termNT(List<Token> tokens) throws SyntaxException {
		ParseTree<Token>.TreeNode termParent = nodes.get(nodes.size() - 1);
		System.out.println(tokens.get(i) + "809");
		if (tokens.get(i).getValue().get().matches("\\(") || tokens.get(i).getType().equals(Token.TokenType.NUM) || tokens.get(i).getType().equals(Token.TokenType.ID)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.factor, tokens.get(i), termParent));
			termParent.addChild(nodes.get(nodes.size()-1));
			factorNT(tokens);
		} else {throw new SyntaxException("Syntax Exception");}
		System.out.println(tokens.get(i) + "805");
		if (tokens.get(i).getStringValue().matches("\\(|[*]|[/]|[%]") || tokens.get(i).getStringValue().matches("[+]|[-]|[)]|[;]|[<]|[<>]=?|=|\\!\\=|\\&\\&|\\|") || tokens.get(i).getType().equals(Token.TokenType.EQUAL)) { //Follow
			nodes.add(parseTree.new TreeNode(ParseTree.Label.termprime, tokens.get(i), termParent));
			termParent.addChild(nodes.get(nodes.size()-1));
			termPrimeNT(tokens);
		} else {throw new SyntaxException("Syntax Exception");}
	}
	
	public static void termPrimeNT(List<Token> tokens) throws SyntaxException {
		ParseTree<Token>.TreeNode termPrimeParent = nodes.get(nodes.size() - 1);
		if (tokens.get(i).getType().equals(Token.TokenType.TIMES)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.factor, termPrimeParent));
			termPrimeParent.addChild(nodes.get(nodes.size()-1));
			factorNT(tokens);
			i++;
			termPrimeNT(tokens);
		} else if (tokens.get(i).getType().equals(Token.TokenType.DIVIDE)) { 
			nodes.add(parseTree.new TreeNode(ParseTree.Label.factor, termPrimeParent));
			termPrimeParent.addChild(nodes.get(nodes.size()-1));
			factorNT(tokens);
			i++;
			termPrimeNT(tokens);
		} else if (tokens.get(i).getType().equals(Token.TokenType.MOD)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.factor, termPrimeParent)); //char Expr
			termPrimeParent.addChild(nodes.get(nodes.size()-1));
			factorNT(tokens);
			i++;
			termPrimeNT(tokens);
		} else if (tokens.get(i).getStringValue().matches("[+]|[-]|[)]|[;]|[<]|[<>]=?|=|\\!\\=|\\&\\&|\\|") || tokens.get(i).getType().equals(Token.TokenType.EQUAL)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.epsilon, termPrimeParent)); //char Expr
			termPrimeParent.addChild(nodes.get(nodes.size()-1));
		} 
		else {throw new SyntaxException("Syntax Exception");}
	}
	
	public static void factorNT(List<Token> tokens) throws SyntaxException {
		ParseTree<Token>.TreeNode factorParent = nodes.get(nodes.size() - 1);
		System.out.println(tokens.get(i) + "826");
		if (tokens.get(i).getType().equals(Token.TokenType.LPAREN)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.factor,tokens.get(i), factorParent));
			factorParent.addChild(nodes.get(nodes.size()-1));
			arithExprNT(tokens);
			i++;
			if (tokens.get(i).getType().equals(Token.TokenType.RPAREN)) {
				nodes.add(parseTree.new TreeNode(ParseTree.Label.factor,tokens.get(i), factorParent));
				factorParent.addChild(nodes.get(nodes.size()-1));
				i++;
			}
		} else if (tokens.get(i).getType().equals(Token.TokenType.ID)) { 
			nodes.add(parseTree.new TreeNode(ParseTree.Label.ID, factorParent));
			factorParent.addChild(nodes.get(nodes.size()-1));
			idNT(tokens);
			i++;
		} else if (tokens.get(i).getType().equals(Token.TokenType.NUM)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.num, factorParent)); //char Expr
			factorParent.addChild(nodes.get(nodes.size()-1));
			System.out.println(tokens.get(i) + "855");
			numNT(tokens);
			i++;
			System.out.println(tokens.get(i) + "858");
		} 
		else {throw new SyntaxException("Syntax Exception");}
	}
	
	public static void printExprNT(List<Token> tokens) throws SyntaxException {
		ParseTree<Token>.TreeNode printExprParent = nodes.get(nodes.size() - 1);
		if (tokens.get(i).getStringValue().matches("true|false|\\(") || tokens.get(i).getType().equals(Token.TokenType.NUM) || tokens.get(i).getType().equals(Token.TokenType.ID)) {
			nodes.add(parseTree.new TreeNode(ParseTree.Label.boolexpr, printExprParent));
			printExprParent.addChild(nodes.get(nodes.size()-1));
			boolExprNT(tokens);
		} else if (tokens.get(i).getType().equals(Token.TokenType.DQUOTE)) { 
			nodes.add(parseTree.new TreeNode(ParseTree.Label.stringlit, printExprParent));
			printExprParent.addChild(nodes.get(nodes.size()-1));
			i++;
			stringLitNT(tokens);
			i++;
			if (tokens.get(i).getType().equals(Token.TokenType.DQUOTE)) { 
				nodes.add(parseTree.new TreeNode(ParseTree.Label.stringlit, printExprParent));
				printExprParent.addChild(nodes.get(nodes.size()-1));
			} else {throw new SyntaxException("Syntax Exception");}
		} 
		else {throw new SyntaxException("Syntax Exception");}
		i++;
	}
	
	
	public static void idNT(List<Token> tokens) {
		nodes.add(parseTree.new TreeNode(ParseTree.Label.ID,tokens.get(i), nodes.get(nodes.size()-1)));
		nodes.get(nodes.size()-2).addChild(nodes.get(nodes.size()-1));
	}
	
	public static void stringLitNT(List<Token> tokens) {
		nodes.add(parseTree.new TreeNode(ParseTree.Label.ID,tokens.get(i), nodes.get(nodes.size()-1)));
		nodes.get(nodes.size()-2).addChild(nodes.get(nodes.size()-1));
	}
	
	public static void numNT(List<Token> tokens) {
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
