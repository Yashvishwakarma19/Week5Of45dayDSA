class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BSTfloor {
   public static TreeNode insert(TreeNode root,int key){
            if(root == null) return new TreeNode(key);
            if(key < root.data){
                root.left = insert(root.left,key);
            }else if(key > root.data){
                root.right = insert(root.right,key);
            }
            return root;
   }
   public static int findFloor(TreeNode root,int key){
        int floor = -1;
        while(root != null){
            if(root.data == key){
                floor = root.data;
                return floor;
            }
            if(key < root.data){
                root = root.left;
            }else{
                floor = root.data;
                root = root.right;
            }
        }
        return floor;
   }
   public static void inorder(TreeNode root){
    if(root != null){
        inorder(root.left);
        System.out.print(root.data+" ");
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
        int floor = findFloor(root, key);
        if (floor == -1) {
            System.out.println("No floor found for " + key);
        } else {
            System.out.println("Floor of " + key + " is " + floor);
        }
    }
}
