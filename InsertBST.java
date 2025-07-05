
class Node{
    int val;
    Node left,right;

    Node(int val){
        this.val = val;
        left = right = null;
    }
}
public class InsertBST{
     public Node searchEle(Node head, int val) {
        while (head != null && head.val != val) {
            head = val < head.val ? head.left : head.right;
        }
        return head;
    }
   public Node insertElement(Node head, int val){
    if(head == null) return new Node(val);

    if(val < head.val){
        head.left = insertElement(head.left,val);
    }else{
        head.right = insertElement(head.right,val);
    }
    // if val == head.val, no insertion (assuming BST does not allow duplicates)
    return head;
   }
    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(7);
        head.left.left = new Node(1);
        head.left.right = new Node(3);

        InsertBST ss = new InsertBST();

        head = ss.insertElement(head, 5);
        System.out.println("Inserted 5 in BST.");

        // Search the newly inserted value
        Node insertedResult = ss.searchEle(head, 5);
        if (insertedResult != null) {
            System.out.println("Value found after insertion: " + insertedResult.val);
        }
    }
}