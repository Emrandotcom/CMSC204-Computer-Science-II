
/**
 * @author Emran Abbamacha
 */

import java.util.*;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {

	protected TreeNode<String> root = new TreeNode<>("");

	/**
	 * Constructor - calls the buildTree method
	 */
	public MorseCodeTree() {
		buildTree();
	}

	/**
	 * Returns a reference to the root
	 */
	@Override
	public TreeNode getRoot() {
		return this.root;
	}

	/**
	 * Sets the root of the MorseCodeTree
	 */
	@Override
	public void setRoot(TreeNode newNode) {
		this.root = newNode;
	}

	/**
	 * Adds element to the correct position in the tree based on the code This
	 * method will call the recursive method addNode
	 * 
	 * @param code - the code for the new node to be added, example ".-."
	 */
	@Override
	public LinkedConverterTreeInterface insert(String code, String result) {
		this.addNode(this.root, code, result);
		return this;
	}

	/**
	 * This is a recursive method that adds element to the correct position in the
	 * tree based on the code.
	 * 
	 * @param root   - the root of the tree for this particular recursive instance
	 *               of addNode
	 * @param code   - the code for this particular recursive instance of addNode
	 * @param letter - the data of the new TreeNode to be added
	 */
	@Override
	public void addNode(TreeNode root, String code, String letter) {
		TreeNode<String> newNode = new TreeNode<String>(letter);

		if (code.length() == 1) {
			if (code.equals(".")) {
				root.left = newNode;
			} else {
				root.right = newNode;
			}
		} else if (code.substring(0, 1).equals(".")) {
			this.addNode(root.left, code.substring(1), letter);
		} else {
			this.addNode(root.right, code.substring(1), letter);
		}
	}

	/**
	 * Fetch the data in the tree based on the code This method will call the
	 * recursive method fetchNode
	 * 
	 * @param code - the code that describes the traversals to retrieve the string
	 *             (letter)
	 * @return the string (letter) that corresponds to the code
	 */
	@Override
	public String fetch(String code) {
		return this.fetchNode(this.root, code);
	}

	/**
	 * This is the recursive method that fetches the data of the TreeNode that
	 * corresponds with the code A '.' (dot) means traverse to the left.
	 * 
	 * @param root - the root of the tree for this particular recursive instance of
	 *             addNode
	 * @param code - the code for this particular recursive instance of addNode
	 * @return the string (letter) that corresponds to the code
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		String letterToReturn = "";
		char[] charArray = code.toCharArray();
		char firstChar = charArray[0];

		if (charArray.length == 1) {
			if (firstChar == '.') {
				letterToReturn = root.left.getData();
			} else if (firstChar == '-') {
				letterToReturn = root.right.getData();
			}

		} else {
			TreeNode<String> newRoot = root;
			char[] copiedCharArray = Arrays.copyOfRange(charArray, 1, charArray.length);
			String newCode = String.valueOf(copiedCharArray);

			if (firstChar == '.')
				newRoot = root.left;
			else if (firstChar == '-')
				newRoot = root.right;

			letterToReturn = fetchNode(newRoot, newCode);
		}

		return letterToReturn;
	}

	/**
	 * This operation is not supported in the MorseCodeTree
	 * 
	 * @throws UnsupportedOperationException
	 * @param data - data of node to be deleted
	 */
	@Override
	public LinkedConverterTreeInterface delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Delete method is unsupported");
	}

	/**
	 * This operation is not supported in the MorseCodeTree
	 * 
	 * @throws UnsupportedOperationException
	 * @return reference to the current tree
	 */
	@Override
	public LinkedConverterTreeInterface update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Update method is unsupported");
	}

	/**
	 * This method builds the MorseCodeTree by inserting the nodes of the tree level
	 * by level based on the code.
	 */
	@Override
	public void buildTree() {
		insert(".", "e");
		insert("-", "t");
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
	}

	/**
	 * Returns an ArrayList of the items in the linked Tree in LNR (Inorder)
	 * Traversal order Used for testing to make sure tree is built correctly
	 * 
	 * @return an ArrayList of the items in the linked Tree
	 */
	@Override
	public ArrayList toArrayList() {
		ArrayList<String> arrayList = new ArrayList<>();
		LNRoutputTraversal(root, arrayList);
		return arrayList;
	}

	/**
	 * The recursive method to put the contents of the tree in an ArrayList in LNR
	 * (Inorder)
	 * 
	 * @param root - the root of the tree for this particular recursive instance
	 * @param list - the ArrayList that will hold the contents of the tree in LNR
	 *             order
	 */
	@Override
	public void LNRoutputTraversal(TreeNode root, ArrayList list) {
		if (root != null) {
			LNRoutputTraversal(root.left, list);
			list.add(root.getData());
			LNRoutputTraversal(root.right, list);
		}
	}

}
