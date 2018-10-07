package assignment.exercise6;

import java.util.ArrayList;
import java.util.Stack;

public class Tree{
    Node root;
    
    public Tree(){
        this.root = null;
    }
    
    public Node addRoot(int elem){
        if(this.root == null){
            Node newNode = new Node(null, elem, null, null);
            this.root = newNode;
            return newNode;
        }
        return this.root;
    }
    
    public Node add(Node parentNode, Integer elem){
        Node newNode = null;
        if(elem != null){
            newNode = new Node(parentNode, elem, null, null);
        }
        
        if(parentNode.left == null){
            parentNode.left = newNode;
        } else if(parentNode.right == null){
            parentNode.right = newNode;
        }
        return newNode;
    }
    
    public int LCA(int p, int q) {
        int lca = this.root.nameNode;
        boolean found = false;
        Node pNode = searchNode(p, this.root);
        Node qNode = searchNode(q, this.root);

        ArrayList<Integer> ancestorsP = fillAncestors(pNode);
        ArrayList<Integer> ancestorsQ = fillAncestors(qNode);
        
        for(int i = 0; i < ancestorsP.size() && !found; i++){
            for(int j = 0; j < ancestorsQ.size() && !found; j++){
                if(ancestorsP.get(i) == ancestorsQ.get(j)){
                    lca = ancestorsP.get(i);
                    found = true;
                }
            }
        }
        
        return lca;
    }
    
    public Node searchNode(int elem, Node startNode){
        
        if (startNode == null){
            return null;
        }

        Stack<Node> s = new Stack<Node>(); 
        Node current = startNode; 
  
        while (current != null || s.size() > 0){ 
            while (current !=  null){ 
                s.push(current); 
                current = current.left; 
            } 

            current = s.pop(); 
            
            if(current.nameNode == elem){
                return current;
            }
            
            current = current.right; 
        }
        
        return null;
    }
    
    public ArrayList<Integer> fillAncestors(Node n){
        Node aux = n;
        ArrayList<Integer> ancestors = new ArrayList<>();
        
        while(aux != null){
            ancestors.add(aux.nameNode);
            aux = aux.parent;
        }
        
        return ancestors;
    }
}
