class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BSTceil {
    public static TreeNode insert(TreeNode root, int key) {
        if (root == null) {
            return new TreeNode(key);
        }

        if (key < root.data) {
            root.left = insert(root.left, key);
        } else if (key > root.data) {
            root.right = insert(root.right, key);
        }
        // if key == root.data, do nothing (assuming unique values)
        return root;
    }

    public static int findCeil(TreeNode root, int key) {
        int ceil = -1;
        while (root != null) {
            if (root.data == key) {
                ceil = root.data;
                return ceil;
            }
            if (key > root.data) {
                root = root.right;
            } else {
                ceil = root.data;
                root = root.left;
            }
        }
        return ceil;
    }
    public static void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
    public static void main(String[] args) {
        TreeNode root = null;
        int[] arr = {8, 4, 12, 2, 6, 10, 14};
        for (int val : arr) {
            root = insert(root, val);
        }
        System.out.print("Inorder Traversal: ");
        inorder(root);
        System.out.println();

        int key = 5;
        int ceil = findCeil(root, key);
        if (ceil == -1) {
            System.out.println("No ceil found for " + key);
        } else {
            System.out.println("Ceil of " + key + " is " + ceil);
        }
    }
}
