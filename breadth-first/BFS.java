import java.util.*;

public class BFS{

    public class Graph{
        public Node[] nodes;
    }
    public static class Node{
        public String name;
        public Node[] children = {};
        public boolean marked;

        public Node(String n){
            name = n;
        }
    }

    public static void main(String args[]){
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");

        Node[] aChildren = {b, c};
        Node[] bChildren = {d, e};
        Node[] cChildren = {f};

        a.children = aChildren;
        b.children = bChildren;
        c.children = cChildren;

        bfs(a);
    }


    public static void bfs(Node root){
        Queue<Node> queue = new LinkedList<Node>();
        root.marked = true;
        queue.add(root);

        while (!queue.isEmpty()){
            Node n = queue.remove();
            visit(n);
            int len = n.children.length;
            if (len>0){
                for (int i=0; i<len; i++){
                    if (n.children[i].marked == false){
                        n.children[i].marked = true;
                        queue.add(n.children[i]);
                    }
                }
            }
        }
    }

    public static void visit(Node n){
        System.out.println(n.name);
    }

}
