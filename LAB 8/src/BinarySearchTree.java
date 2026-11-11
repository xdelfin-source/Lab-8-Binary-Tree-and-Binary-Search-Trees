import java.util.List;

/**
 * Ordered inventory index backed by a binary search tree.
 *
 * Starter structure only. Every operation throws
 * UnsupportedOperationException until the BUILD phase.
 */
public class BinarySearchTree {

    private BSTNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    /**
     * Returns the current root. Used by tests and diagnostics.
     */
    public BSTNode getRoot() {
        return root;
    }

    /**
     * Inserts a key/value pair, or replaces the value when the key exists.
     * TODO: implement during the BUILD phase.
     */
    public void put(int key, String value) {
        throw new UnsupportedOperationException("TODO: implement put");
    }

    /**
     * Returns the value for the key, or null when the key is absent.
     * TODO: implement during the BUILD phase.
     */
    public String get(int key) {
        throw new UnsupportedOperationException("TODO: implement get");
    }

    /**
     * Deletes the entry with the given key.
     * Returns true when an entry was removed.
     * TODO: implement during the BUILD phase.
     */
    public boolean delete(int key) {
        throw new UnsupportedOperationException("TODO: implement delete");
    }

    /**
     * Returns keys in the inclusive range [low, high], in ascending order.
     * An inverted range (low > high) must return an empty list.
     * TODO: implement during the BUILD phase.
     */
    public List<Integer> rangeSearch(int low, int high) {
        throw new UnsupportedOperationException("TODO: implement rangeSearch");
    }

    /**
     * Returns all keys in ascending order.
     * TODO: implement during the BUILD phase.
     */
    public List<Integer> inOrder() {
        throw new UnsupportedOperationException("TODO: implement inOrder");
    }

    /**
     * Returns tree height using: empty = -1, single leaf = 0.
     * TODO: implement during the BUILD phase.
     */
    public int height() {
        throw new UnsupportedOperationException("TODO: implement height");
    }
}
