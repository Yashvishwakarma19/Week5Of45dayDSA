class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

class LCAofBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        int curr = root.val;

        if (curr < p.val && curr < q.val) {
            // Both nodes are in right subtree
            return lowestCommonAncestor(root.right, p, q);
        }
        if (curr > p.val && curr > q.val) {
            // Both nodes are in left subtree
            return lowestCommonAncestor(root.left, p, q);
        }
        // Split point found, this is LCA
        return root;
    }

    public static void main(String[] args) {
        LCAofBST sol = new LCAofBST();

        // Example BST
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        TreeNode p = root.left; // 2
        TreeNode q = root.left.right; // 4

        TreeNode lca = sol.lowestCommonAncestor(root, p, q);
        System.out.println("Lowest Common Ancestor of " + p.val + " and " + q.val + " is: " + lca.val);
    }
}
