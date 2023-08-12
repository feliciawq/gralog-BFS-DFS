package main.java.gralog.bfs.gengrator;
import gralog.algorithm.AlgorithmParameters;
import gralog.generator.Generator;
import gralog.generator.GeneratorDescription;
import gralog.structure.*;


@GeneratorDescription(
        name = "Undirected Graph for BFS",
        text = "Construct a undirected graph for the breadth-first search algorithm",
        url = "https://en.wikipedia.org/wiki/Breadth-first_search")
public class GeneratorUndirectedGraph extends Generator {
    @Override
    public Structure generate(AlgorithmParameters algorithmParameters) throws Exception {
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
        vertex4.setCoordinates(12,5);

        Vertex vertex5 = result.addVertex();
        vertex5.setId(5);
        //vertex5.setLabel("5");
        vertex5.setCoordinates(16,5);

        Vertex vertex6 = result.addVertex();
        vertex6.setId(6);
        //vertex6.setLabel("6");
        vertex6.setCoordinates(4,8);

        Vertex vertex7 = result.addVertex();
        vertex7.setId(7);
        //vertex7.setLabel("7");
        vertex7.setCoordinates(8,8);

        Vertex vertex8 = result.addVertex();
        vertex8.setId(8);
        //vertex8.setLabel("8");
        vertex8.setCoordinates(14,8);

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
        edge5.setSource(vertex2);
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

        Edge edge8 = new Edge();
        edge8.setId(8);
        edge8.setSource(vertex3);
        edge8.setTarget(vertex7);
        edge8.setDirectedness(false);

        Edge edge9 = new Edge();
        edge9.setId(9);
        edge9.setSource(vertex4);
        edge9.setTarget(vertex8);
        edge9.setDirectedness(false);


        result.addEdge(edge1);
        result.addEdge(edge2);
        result.addEdge(edge3);
        result.addEdge(edge5);
        result.addEdge(edge6);
        result.addEdge(edge7);
        result.addEdge(edge8);
        result.addEdge(edge9);



        return result;
    }


}
