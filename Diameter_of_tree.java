public class Diameter_of_tree {
    static class Node{
        int data;
        Node left , right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int leftH = height(root.left);
        int rightH = height(root.right);

        return Math.max(leftH, rightH) +1 ;
    }

    public static int diameter(Node  root){
        if(root == null){
            return 0;
        }

        int leftD = diameter(root.left);
        int leftH = height(root.left);
        int rightD = diameter(root.right);
        int rightH = height(root.right);

        int selfD = leftH + rightH ;

        return Math.max(selfD, Math.max(leftD, rightD));
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.left.left = new Node(4);
        root.left.left.right = new Node(5);
        root.left.right = new Node(10);
        root.left.right.right = new Node(11);
        root.left.right.right.left = new Node(12);
        root.left.right.right.left.right = new Node(13);
        root.left.right.right.left.right.right = new Node(14);

        root.right = new Node(6);
        root.right.left = new Node(8);
        root.right.right = new Node(7);
        root.right.right.left = new Node(9);

        System.out.println(diameter(root));

    }
}
