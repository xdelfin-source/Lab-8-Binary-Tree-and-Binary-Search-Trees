# CpE 211 Lab 1: Ordered Inventory Index — Agent Log

## Phase 1: PLAN

### Scope
Planning only. No implementation or test files are created or modified in `LAB 8/src/` or `LAB 8/test/` during this phase.

### Insertion sequence
`40, 20, 70, 10, 30, 55, 85, 60`

Resulting binary search tree:

```text
        40
       /  \
     20    70
    / \   /  \
  10  30 55  85
          \
          60
```

### Height convention and calculation

- Empty tree height: `-1`
- Single leaf height: `0`
- Height is the number of edges on the longest path from the node to a leaf.

| Node(s) | Height |
|---|---|
| `10`, `30`, `60`, `85` | `0` |
| `20`, `55` | `1` |
| `70` | `2` |
| `40` (current root) | `3` |

### Leaves
`10, 30, 60, 85`

### Theoretical trace: deleting root `40`

1. Root `40` has two children, so find its in-order successor: the minimum key in the right subtree.
2. Move right to `70`, then left to `55`. Node `55` has no left child, so `55` is the successor.
3. Swap/copy the successor’s key and value into the root position; the root key becomes `55`.
4. Remove the original `55` node from `70`’s left link.
5. Node `55` has right child `60`, so reattach `60` as `70`’s new left child.
6. Resulting tree:

```text
        55
       /  \
     20    70
    / \   /  \
  10  30 60  85
```

Resulting root height: `2`.

### Complexity invariants

Let `h` be tree height, `n` the number of nodes, and `k` the number of entries returned by a range search.

| Operation | Complexity | Notes |
|---|---|---|
| `put` | `O(h)` | Typically `O(log n)` when balanced; worst case `O(n)` when degenerate. |
| `get` | `O(h)` | Typically `O(log n)` when balanced; worst case `O(n)` when degenerate. |
| `delete` | `O(h)` | Typically `O(log n)` when balanced; worst case `O(n)` when degenerate. |
| Range search | `O(h + k)` | `k` = number of reported entries. |
| Traversal | `O(n)` | Visits every node exactly once. |

## Phase 2: TEST

### Test-first setup
The student-authored tests were written in `LAB 8/test/LabTestRunner.java` before any BST operation was implemented. `LAB 8/src/BinarySearchTree.java` contains only starter structure: method signatures that throw `UnsupportedOperationException` with `TODO` messages. No tree algorithm logic exists in `src/` yet.

### Test 1: `testRootDeletionSuccessorWithRightChild()`
- Insertion inputs, in order: `40, 20, 70, 55, 60`
- Action: `tree.delete(40)`
- Expected behavior:
  - `delete(40)` returns `true`.
  - The new root key is `55` (the in-order successor).
  - The successor's right child `60` is reattached as the left child of `70`.
  - `inOrder()` returns `[20, 55, 60, 70]`.
- Why this case was chosen: deleting a two-child root exercises the successor path, and this shape specifically covers the case where the successor (`55`) has a right child (`60`). It verifies that `60` is not dropped and that the reattachment to `70`'s left link is correct.

### Test 2: `testInvertedRangeSearch()`
- Input tree: the same keys `40, 20, 70, 55, 60`
- Action: `tree.rangeSearch(60, 20)` with `low > high`
- Expected behavior: an empty list.
- Why this case was chosen: it verifies inverted-boundary handling. An implementation that assumes `low <= high` could wrongly return keys, recurse incorrectly, or throw instead of returning an empty result.

### Expected red-phase result
Both tests are expected to fail against the starter TODOs. Because the tree cannot be populated without `put`, the first missing operation encountered is `put`, which throws `UnsupportedOperationException("TODO: implement put")`.

### Observed red-phase result
Command:

```powershell
javac -d "LAB 8/out" "LAB 8/src/BSTNode.java" "LAB 8/src/BinarySearchTree.java" "LAB 8/test/LabTestRunner.java"
java -cp "LAB 8/out" LabTestRunner
```

Compilation succeeded. Test output:

```text
FAIL: testRootDeletionSuccessorWithRightChild
      java.lang.UnsupportedOperationException: TODO: implement put
FAIL: testInvertedRangeSearch
      java.lang.UnsupportedOperationException: TODO: implement put

SUMMARY: 0 passed, 2 failed
```

Exit code: `1`. This is the expected red phase: the tests compile, and both fail at the first unimplemented source operation.
