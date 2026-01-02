import java.nio.file.Paths;

public class Binary_Tree_Paths {
    static class Node{
        int data;
        Node left , right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }
    public static void paths(Node root ,String str){
        if(root == null){
            return;
        }
        str+=root.data;
        if(root.left == null && root.right == null){
            System.out.println(str);
        }
        str+="->";
        paths(root.left, str);
        paths(root.right, str);
    }
    public static Node insert(Node root , int val){
        if(root == null){
            return new Node(val);
        }
        if(root.data > val){
            root.left =  insert(root.left, val);
        }else {
            root.right = insert(root.right, val);
        }
        return root;
    }
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+"->");
        inorder(root.right);
    }
    public static void main(String[] args) {
        int values[] = {5,7,3,6,4,8,9,5,2};
        Node root = null;
        for(int val: values){
            root = insert(root , val);
        }
        String str ="";
        paths(root , str);
    }
}
