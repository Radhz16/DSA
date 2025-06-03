import java.util.*;
import java.util.LinkedList;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data=data;
    }
}
public class BinaryTree {
    public static void inOrder(Node root){
        if(root == null) return;
        System.out.print(root.data+" ");
        inOrder(root.left);
        inOrder(root.right);
        
    }
    public static void PostOrder(Node root){
        if(root == null) return;
        PostOrder(root.left);
        PostOrder(root.right);
        System.out.print(root.data+" ");

    }
    public static void PreOrder(Node root){
        if(root == null) return;
        PreOrder(root.left);
        System.out.print(root.data+" ");
        PreOrder(root.right);

    }

    public static void LevelOrder(Node root){
        if(root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node n = q.poll();
            System.out.print(n.data+" ");
            if(n.left!=null) q.add(n.left);
            if(n.right!=null) q.add(n.right);
        }
    }

    public static void zigzag(Node root){
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(root);

        while(!s1.isEmpty() || !s2.isEmpty()){
            while(!s1.isEmpty()){
                Node t = s1.peek();
                s1.pop();
                System.out.print(t.data+" ");
                if(t.right!=null){
                    s2.push(t.right);
                }
                if(t.left!=null){
                    s2.push(t.left);
                }
            }
            while(!s2.isEmpty()){
                Node t = s2.peek();
                s2.pop();
                System.out.print(t.data+" ");
                if(t.left!=null){
                    s1.push(t.left);
                }
                if(t.right!=null){
                    s2.push(t.right);
                }
            }
        }
    }
    public static void main(String[] args) {
        Node a = new Node(12);
        a.right = new Node(14);
        a.left = new Node(11);
        a.right.right = new Node(20);

        System.out.println("Inorder traversal:");
        inOrder(a);
        System.out.println("\n");
        System.out.println("Postorder traversal:");
        PostOrder(a);
        System.out.println("\n");
        System.out.println("Preorder traversal");
        PreOrder(a);
        System.out.println("\n");
        System.out.println("Level Order traversal");
        LevelOrder(a);
        System.out.println("\n");
        System.out.println("Zig zag traversal");
        zigzag(a);

    }
    
}
