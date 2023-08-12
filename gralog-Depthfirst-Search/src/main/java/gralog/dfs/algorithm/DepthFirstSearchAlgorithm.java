package main.java.gralog.dfs.algorithm;

import gralog.algorithm.Algorithm;
import gralog.algorithm.AlgorithmDescription;
import gralog.algorithm.AlgorithmParameters;
import gralog.progresshandler.ProgressHandler;
import gralog.structure.Edge;
import gralog.structure.Structure;
import gralog.structure.Vertex;

import javax.swing.tree.TreeNode;
import java.util.*;

@AlgorithmDescription(
        name = "Depth-first search result display",
        text = "Show depth-first search results",
        url = "https://en.wikipedia.org/wiki/Depth-first_search"
)
public class DepthFirstSearchAlgorithm extends Algorithm {
    public static List<Vertex> depthFirstSearch(Vertex root,
                                                HashMap<Vertex, Vertex> prenode,
                                                HashMap<Vertex, Edge> edgeFromPrenode) {
        List<Vertex> traversalOrder = new ArrayList<>();
        Set<Vertex> visited = new HashSet<>();
        Stack<Vertex> stack = new Stack<>();
        prenode.put(root, null);
        edgeFromPrenode.put(root, null);

        stack.push(root);

        while (!stack.isEmpty()) {
            Vertex current = stack.pop();

            if (!visited.contains(current)) {
                traversalOrder.add(current);
                visited.add(current);

                for (Edge edge : current.getIncidentEdges()) {
                    if (edge.getSource() != current && edge.isDirected) // incoming (directed) edge
                        continue;

                    Vertex other = edge.getTarget();
                    if (other == current)
                        other = edge.getSource();

                    if (!visited.contains(other)) {
                        prenode.put(other, current);
                        edgeFromPrenode.put(other, edge);
                        stack.push(other);
                    }
                }
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

        traversalOrder = depthFirstSearch(v,prenode,edgeFromPrenode);

        // Output the traversal order
        StringBuilder output = new StringBuilder();
        output.append("The result of this traversal of the Depth-first search algorithm is：");
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

        System.out.println(output.toString());

        // Output results in the front fx
        return output.toString();
    }
}
