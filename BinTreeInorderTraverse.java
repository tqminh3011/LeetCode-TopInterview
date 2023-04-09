import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// Examples
//       1
//     3   7
//   5    6
// 8   4
public class BinTreeInorderTraverse {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new InputStreamReader(System.in));


        long start = System.currentTimeMillis();

        TreeNode leftChild2 = new TreeNode(5, new TreeNode(8), new TreeNode(4));
        TreeNode leftChild1 = new TreeNode(3, leftChild2, null);

        TreeNode rightChild1 = new TreeNode(7, new TreeNode(6), null);
        TreeNode root = new TreeNode(1, leftChild1, rightChild1);

        List<Integer> treeList = iterativeInorderTraversal(root);
        System.out.format("Executed in %sms%n", (System.currentTimeMillis() - start));

        System.out.format("Result=%s %n", treeList);
    }

    // Own solution, beats 100% in time (0ms)
    public static List<Integer> recursiveInorderTraversal(TreeNode root) {
        // CRITICAL POINT:
        // In-order: Left nodes (subtree) -> root -> right subtree
        // Pre-order: Root -> left subtree -> right subtree
        // Post-order: Left subtree -> right subtree -> root

        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        List<Integer> left = recursiveInorderTraversal(root.left);
        List<Integer> right = recursiveInorderTraversal(root.right);

        result.addAll(left);
        result.add(root.val);
        result.addAll(right);

        return result;
    }

    /**
     *  Refer to this visualization for better understanding:
     *  <img src="../img/leetcode_94_using_stack_and_iterative.png"/>
     *
     * @param root
     * @return
     */
    public static List<Integer> iterativeInorderTraversal(TreeNode root) {
        // CRITICAL POINT:
        // In-order: Left nodes (subtree) -> root -> right subtree
        // Pre-order: Root -> left subtree -> right subtree
        // Post-order: Left subtree -> right subtree -> root


        //        1
        //     3     7
        //   5      6
        // 8   4

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode iteration = root;

        while(iteration != null || !stack.isEmpty()) {
            while (iteration != null) {
                stack.push(iteration);
                iteration = iteration.left;
            }

            iteration = stack.pop();
            result.add(iteration.val);
            iteration = iteration.right;
        }

        return result;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }


}