/**
 * A node in the ordered inventory index.
 *
 * Starter structure only: tree algorithms live in BinarySearchTree.
 */
public class BSTNode {

    public int key;
    public String value;
    public BSTNode left;
    public BSTNode right;

    public BSTNode(int key, String value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
