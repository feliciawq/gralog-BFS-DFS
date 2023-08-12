package main.java.gralog.bfs.algorithm;

import gralog.algorithm.Algorithm;
import gralog.algorithm.AlgorithmDescription;
import gralog.algorithm.AlgorithmParameters;
import gralog.progresshandler.ProgressHandler;
import gralog.structure.Edge;
import gralog.structure.Structure;
import gralog.structure.Vertex;
import main.java.gralog.bfs.structure.Node;

import javax.swing.tree.TreeNode;
import java.util.*;

@AlgorithmDescription(
        name = "Breadth-first search result display",
        text = "Show breadth-first search results",
        url = "https://en.wikipedia.org/wiki/Breadth-first_search"
)
public class BreadthFirstSearchAlgorithm extends Algorithm {

    public static List<Vertex> breadthFirstSearch(Vertex root,
                                                  HashMap<Vertex, Vertex> prenode,
                                                  HashMap<Vertex, Edge> edgeFromPrenode) {
        List<Vertex> traversalOrder = new ArrayList<>();
        Set<Vertex> visited = new HashSet<>();
        Queue<Vertex> queue = new LinkedList<>();
        prenode.put(root, null);
        edgeFromPrenode.put(root, null);

        // Adding root nodes to queues and access collections
        queue.offer(root);
        visited.add(root);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            traversalOrder.add(current);


            // Traverse the neighbors of the current vertex
            for (Edge edge : current.getIncidentEdges()) {
                if (edge.getSource() != current && edge.isDirected) // incoming (directed) edge
                    continue;

                Vertex other = edge.getTarget();
                if (other == current)
                    other = edge.getSource();

                if (prenode.containsKey(other)) // prenode already in the tree
                    continue;

                // Add 'other' to the queue and mark it as visited
                queue.offer(other);
                visited.add(other);
                prenode.put(other, current);
                edgeFromPrenode.put(other, edge);
            }
        }
        return traversalOrder;
    }





    public Object run(Structure s, AlgorithmParameters p, Set<Object> selection,
                      ProgressHandler onprogress) {
        HashMap<Vertex, Vertex> prenode = new HashMap<>();
        HashMap<Vertex, Edge> edgeFromPrenode = new HashMap<>();
        List<Vertex> traversalOrder = new ArrayList<>();
        Vertex v = selectedUniqueVertex(selection);
        if (v == null)
            return "Please select a vertex as the start point.";

        traversalOrder = breadthFirstSearch(v,prenode,edgeFromPrenode);


        // Output the traversal order
        StringBuilder output = new StringBuilder();
        output.append("The result of this traversal of the Breadth-first search algorithm is：");
        for (int i = 0; i < traversalOrder.size(); i++) {
            output.append(traversalOrder.get(i).getId());
            if (i < traversalOrder.size() - 1) {
                output.append("->");
            }
        }
        // Label = id
        for (int i = 0; i < traversalOrder.size(); i++) {
            Vertex vertex = traversalOrder.get(i);
            vertex.setLabel(String.valueOf(vertex.getId()));
        }
        // Remove the trailing "->"
        System.out.println(output.toString());

        // Output results in the front fx
        return output.toString();
    }


}
