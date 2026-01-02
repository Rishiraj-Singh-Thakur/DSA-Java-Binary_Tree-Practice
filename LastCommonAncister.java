import java.util.*;

public class LastCommonAncister {
    static class Node{
        int data ;
        Node left ,right;

        Node(int data ){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static boolean getPath(Node root , int n , ArrayList<Node> path){
        if(root == null){
            return false;
        }
        path.add(root);
        if(root.data == n){
            return true;
        }
        Boolean leftFound = getPath(root.left , n ,path);
        Boolean rightFound = getPath(root.right , n ,path);
        if(leftFound || rightFound){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
    public static Node LCN(Node root , int n1 ,int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i = 0 ;
        for(; i<path1.size() && i<path2.size() ; i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }
        return path1.get(i-1);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right= new Node(7);

        Node ans = LCN(root, 3, 4);
        System.out.println(ans.data);
    }
}
