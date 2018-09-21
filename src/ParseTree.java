import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParseTree<T> {

	public enum Label {
		prog, los, stat, whilestat, forstat, forstart, forarith, ifstat, elseifstat, assign, decl, possassign, print,
		type, expr, boolexpr, boolexprprime, boolop, booleq, boollog, relexpr, relexprprime, relop, arithexpr,
		arithexprprime, term, termprime, factor, printexpr, ID, num, charexpr, stringlit, boolconst, epsilon
	};

	class TreeNode {

		private Label label;
		private T token;
		private TreeNode parent;
		private List<TreeNode> children = new ArrayList<TreeNode>();

		public TreeNode(Label label, TreeNode parent) { //
			this.label = label;
			this.token = null;
			this.parent = parent;
		}
		
		public TreeNode(Label label) {
			this.label = label;
			this.token = null;
			this.parent = null;
		}

		public TreeNode(Label label, T token, TreeNode parent) {
			this.label = label;
			this.token = token;
			this.parent = parent;
		}

		public void addChild(TreeNode child) {
			children.add(child);
		}

		public Optional<T> getToken() {
			if (this.token == null) return Optional.<T>empty();
			return Optional.<T>of(this.token);
		}

		public TreeNode getParent() {
			return this.parent;
		}

		public List<TreeNode> getChildren() {
			return this.children;
		}
		
		public Label getLabel() {
			return this.label;
		}

		@Override
		public String toString() {
			return "TreeNode [label=" + label + ", token=" + token + ", parent=" + parent + ", children=" + children.size()
					+ "]";
		}
		
		

	}

	private TreeNode root;

	public ParseTree() {
		this.root = null;
	}

	public ParseTree(TreeNode root) {
		this.root = root;
	}

	public TreeNode getRoot() {
		return this.root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	@Override
	public String toString() {
		return "ParseTree [root=" + root + ", toString()=" + "]";
	}
	
	
}
