class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
        left = right = null;
    }
}
public class deleteBST {
    // Function to delete a node in BST
    public Node deleteNode(Node root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            //When Node to be deleted found

            // Case 1: No child
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case 2: One child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Case 3: Two children
            // Find inorder successor (smallest in right subtree)
            Node successor = findMin(root.right);
            root.val = successor.val;
            root.right = deleteNode(root.right, successor.val);
        }
        return root;
    }
    // Helper function to find minimum value node in a subtree
    public Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    // Inorder traversal to display BST
    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }
    public static void main(String[] args) {
        deleteBST tree = new deleteBST();

        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(7);
        root.right.right = new Node(9);

        System.out.print("Original BST (Inorder): ");
        tree.inorder(root);
        System.out.println();

        // Delete node with value 3 (has two children)
        root = tree.deleteNode(root, 3);

        System.out.print("BST after deleting 3: ");
        tree.inorder(root);
        System.out.println();

        // Delete node with value 8 (has two children)
        root = tree.deleteNode(root, 8);

        System.out.print("BST after deleting 8: ");
        tree.inorder(root);
        System.out.println();

        // Delete node with value 2 (leaf)
        root = tree.deleteNode(root, 2);

        System.out.print("BST after deleting 2: ");
        tree.inorder(root);
        System.out.println();
    }
}
