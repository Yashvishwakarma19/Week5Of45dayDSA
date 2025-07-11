class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
        left = right = null;
    }
}
public class SortedArrayToBST {
    public Node sortedArrayToBST(int arr[], int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;        //middle element as a root
        Node node = new Node(arr[mid]);
        node.left = sortedArrayToBST(arr, start, mid - 1);

        node.right = sortedArrayToBST(arr, mid + 1, end);

        return node;
    }
    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }
    public static void main(String[] args) {
        SortedArrayToBST tree = new SortedArrayToBST();

        int arr[] = {-10, -3, 0, 5, 9};

        Node root = tree.sortedArrayToBST(arr, 0, arr.length - 1);

        System.out.print("Inorder traversal of constructed BST: ");
        tree.inorder(root);
    }
}
