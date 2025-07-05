
class Node{
    int val;
    Node left,right;

    Node(int val){
        this.val = val;
        left = right = null;
    }
}
public class BSTsearching{
    public Node searchEle(Node head,int val){
        while(head != null && head.val != val){
            head = val < head.val ?head.left:head.right;
        }
        return head;
    }
    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(7);
        head.left.left = new Node(1);
        head.left.right = new Node(3);

        BSTsearching ss = new BSTsearching();

        int searchVal = 7;
        Node result = ss.searchEle(head,searchVal);

        if (result != null) {
            System.out.println("Value found: " + result.val);
        } else {
            System.out.println("Value not found in BST");
        }
        
    }
}