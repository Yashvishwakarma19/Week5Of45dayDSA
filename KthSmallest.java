class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

class KthSmallest {
   int cnt = 0;
   int ans = -1;

   public int KthSmallest(TreeNode head, int k){
    inOrder(head,k);
    return ans;
   }
   public void inOrder(TreeNode node,int k){
    if(node == null) return;
    inOrder(node.left,k);

    cnt++;
    if(cnt == k){
        ans = node.val;
        return;
    }

    inOrder(node.right,k);
   }
    public static void main(String[] args) {
        KthSmallest sol = new KthSmallest();

        // Example BST
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);

        int k = 2; // Find 2nd smallest element

        System.out.println("Kth smallest element is: " + sol.KthSmallest(root, k));
    }
}
