
/**
 * @author Emran Abbamacha
 */

public class TreeNode<T> {

	protected T data = null;
	protected TreeNode<T> left = null;
	protected TreeNode<T> right = null;

	/**
	 * Create a new TreeNode with left and right child set to null and data set to
	 * the dataNode
	 * 
	 * @param dataNode - the data to be stored in the TreeNode
	 */
	public TreeNode(T dataNode) {
		this.data = dataNode;
	}

	/**
	 * Used for making deep copies
	 * 
	 * @param node - node to make copy of
	 */
	public TreeNode(TreeNode<T> node) {
		this.data = node.getData();
		this.left = node.left;
		this.right = node.right;
	}

	/**
	 * Return the data within this TreeNode
	 * 
	 * @return the data within the TreeNode
	 */
	public T getData() {
		return data;
	}
}
