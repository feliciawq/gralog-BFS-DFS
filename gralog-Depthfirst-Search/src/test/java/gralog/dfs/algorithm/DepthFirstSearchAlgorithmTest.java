package test.java.gralog.dfs.algorithm;
import gralog.structure.*;
import org.junit.Test;

import java.util.*;

import static gralog.algorithm.ShortestPath.dijkstraShortestPath;
import static main.java.gralog.dfs.algorithm.DepthFirstSearchAlgorithm.depthFirstSearch;
import static org.junit.Assert.*;

public class DepthFirstSearchAlgorithmTest {
    @Test
    public void DepthFirstSearchAlgorithm() {
        UndirectedGraph result = new UndirectedGraph();
        // add vertex
        Vertex vertex0 = result.addVertex();
        vertex0.setId(0);
        //vertex0.setLabel("0");
        vertex0.setCoordinates(11,0);

        Vertex vertex1 = result.addVertex();
        vertex1.setId(1);
        //vertex1.setLabel("1");
        vertex1.setCoordinates(8,2);

        Vertex vertex2 = result.addVertex();
        vertex2.setId(2);
        //vertex2.setLabel("2");
        vertex2.setCoordinates(14,2);

        Vertex vertex3 = result.addVertex();
        vertex3.setId(3);
        //vertex3.setLabel("3");
        vertex3.setCoordinates(6,5);

        Vertex vertex4 = result.addVertex();
        vertex4.setId(4);
        //vertex4.setLabel("4");
        vertex4.setCoordinates(10,5);

        Vertex vertex5 = result.addVertex();
        vertex5.setId(5);
        //vertex5.setLabel("5");
        vertex5.setCoordinates(13,5);

        Vertex vertex6 = result.addVertex();
        vertex6.setId(6);
        //vertex6.setLabel("6");
        vertex6.setCoordinates(4,8);

        Edge edge1 = new Edge();
        edge1.setId(1);
        edge1.setSource(vertex0);
        edge1.setTarget(vertex1);
        edge1.setDirectedness(false);

        Edge edge2 = new Edge();
        edge2.setId(2);
        edge2.setSource(vertex0);
        edge2.setTarget(vertex2);
        edge2.setDirectedness(false);

        Edge edge3 = new Edge();
        edge3.setId(3);
        edge3.setSource(vertex1);
        edge3.setTarget(vertex3);
        edge3.setDirectedness(false);


        Edge edge5 = new Edge();
        edge5.setId(5);
        edge5.setSource(vertex1);
        edge5.setTarget(vertex4);
        edge5.setDirectedness(false);

        Edge edge6 = new Edge();
        edge6.setId(6);
        edge6.setSource(vertex2);
        edge6.setTarget(vertex5);
        edge6.setDirectedness(false);

        Edge edge7 = new Edge();
        edge7.setId(7);
        edge7.setSource(vertex3);
        edge7.setTarget(vertex6);
        edge7.setDirectedness(false);

        HashMap<Vertex, Vertex> prenode = new HashMap<>();
        HashMap<Vertex, Edge> edgeFromPrenode = new HashMap<>();

        depthFirstSearch(vertex0,prenode,edgeFromPrenode);



    }
}
