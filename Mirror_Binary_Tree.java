public class Mirror_Binary_Tree {
    static class Node{
        int data;
        Node left ,right;
        Node(int data){
            this.data = data;
        }
    }
    public static Node MirrorTree(Node root){
        if(root == null){
            return null;
        }
        Node left = MirrorTree(root.left);
        Node right = MirrorTree(root.right);

        root.left = right;
        root.right = left;
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
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right= new Node(7);

        MirrorTree(root);
        inorder(root);
        System.out.print("null");
    }
}
