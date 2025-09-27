class TreeNode {
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

class Solution {
    public void solve(TreeNode root) {
        if (root == null) {
            return;
        }

        solve(root.left);
        solve(root.right);

        TreeNode leftSubtree = root.left;
        TreeNode rightSubtree = root.right;

        root.left = null;
        root.right = leftSubtree;

        TreeNode temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }
        temp.right = rightSubtree;
    }
}