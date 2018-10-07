package assignment.exercise6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class AssignmentExercise6{
    public static void main(String[] args){
        ArrayList<Integer> root = new ArrayList(Arrays.asList(3,5,1,6,2,0,8,null,null,7,4));
        int p = 5, q = 4;
        
        Queue<Node> queue = new LinkedList();
        Tree t = new Tree();
        Node nodeRoot = t.addRoot(root.get(0));
        queue.add(nodeRoot);
        
        for(int i = 1; i < root.size(); i += 2){
            Node parentNode = queue.poll();
            Node child1 = t.add(parentNode, root.get(i));
            Node child2 = t.add(parentNode, root.get(i+1));
            
            queue.add(child1);
            queue.add(child2);
        }
        
        System.out.println(t.LCA(p, q));
    }
}
