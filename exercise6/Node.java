package assignment.exercise6;

public class Node{
    public Node parent;
    public int nameNode;
    public Node left;
    public Node right;

    public Node(Node parent, int nameNode, Node left, Node right){
        this.parent = parent;
        this.nameNode = nameNode;
        this.left = left;
        this.right = right;
    }

}
