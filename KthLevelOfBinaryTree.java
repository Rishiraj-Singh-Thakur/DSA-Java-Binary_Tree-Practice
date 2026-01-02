import java.util.*;

public class KthLevelOfBinaryTree {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static void KthLevel(Node root ,int k){
        Queue<Node> q = new LinkedList<>();
        Queue<Node> arr = new LinkedList<>();

        q.add(root);
        q.add(null);
        int count =1;

        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                    count++;
                    continue;
                }
            }
            if(count == k){
                while(curr != null){
                    arr.add(curr);
                    curr = q.remove();
                }
                break;
            }
                if(curr.left !=null){
                    q.add(curr.left);

                }
                if(curr.right !=null){
                    q.add(curr.right);
                }
        }
        while(!arr.isEmpty()){
            System.out.print(arr.remove().data +" ");
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        KthLevel(root , 3);
    }
}
