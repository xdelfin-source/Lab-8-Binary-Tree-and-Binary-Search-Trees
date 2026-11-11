import java.util.Arrays;
import java.util.List;

/**
 * Student-authored tests for the ordered inventory index.
 * Written before the BST methods are implemented.
 */
public class LabTestRunner {

    private static int passed;
    private static int failed;

    public static void main(String[] args) {
        run("testRootDeletionSuccessorWithRightChild",
                LabTestRunner::testRootDeletionSuccessorWithRightChild);
        run("testInvertedRangeSearch",
                LabTestRunner::testInvertedRangeSearch);

        System.out.println();
        System.out.println("SUMMARY: " + passed + " passed, " + failed + " failed");
        if (failed > 0) {
            System.exit(1);
        }
    }

    /**
     * Deleting a two-child root must use the in-order successor.
     *
     * Tree after inserting 40, 20, 70, 55, 60:
     *
     *         40
     *        /  \
     *      20    70
     *           /
     *         55
     *           \
     *           60
     *
     * After delete(40), successor 55 becomes root and its right child 60
     * must be reattached as the left child of 70.
     */
    private static void testRootDeletionSuccessorWithRightChild() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.put(40, "forty");
        tree.put(20, "twenty");
        tree.put(70, "seventy");
        tree.put(55, "fifty-five");
        tree.put(60, "sixty");

        boolean removed = tree.delete(40);
        check(removed, "delete(40) should return true");

        BSTNode root = tree.getRoot();
        check(root != null, "root should not be null after deletion");
        check(root.key == 55, "root should be 55, but was " + root.key);
        check(root.right != null && root.right.key == 70,
                "70 should remain the root's right child");
        check(root.right.left != null && root.right.left.key == 60,
                "60 should be reattached as 70's left child");

        List<Integer> expected = Arrays.asList(20, 55, 60, 70);
        List<Integer> actual = tree.inOrder();
        check(expected.equals(actual),
                "inOrder() should be " + expected + ", but was " + actual);
    }

    /**
     * rangeSearch must treat low > high as an empty interval.
     */
    private static void testInvertedRangeSearch() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.put(40, "forty");
        tree.put(20, "twenty");
        tree.put(70, "seventy");
        tree.put(55, "fifty-five");
        tree.put(60, "sixty");

        List<Integer> result = tree.rangeSearch(60, 20);
        check(result != null && result.isEmpty(),
                "rangeSearch(60, 20) should return an empty list, but was " + result);
    }

    private static void run(String name, Runnable test) {
        try {
            test.run();
            passed++;
            System.out.println("PASS: " + name);
        } catch (Throwable failure) {
            failed++;
            System.out.println("FAIL: " + name);
            System.out.println("      " + failure);
        }
    }

    private static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }
}
