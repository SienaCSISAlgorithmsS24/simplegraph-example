
/**
 * SimpleDirectedListGraph: a very simple directed graph stored with adjacency
 * lists
 *
 * @author Jim Teresco and Copilot
 * @version Spring 2024
 */

import java.util.LinkedList;

public class SimpleDirectedListGraph
{

    // array of vertices
    private Vertex[] vertices;

    // inner class to represent a vertex
    private class Vertex
    {
        // adjacency list for this vertex
        private LinkedList<Integer> adjList;

        // constructor
        public Vertex()
        {
            adjList = new LinkedList<Integer>();
        }
    }
    /**
     * Constructor
     */
    public SimpleDirectedListGraph(int numVerts)
    {
        vertices = new Vertex[numVerts];
        for (int i = 0; i < numVerts; i++) {
            vertices[i] = new Vertex();
        }
    }

    // add an edge to the graph, complexity is O(1)
    public void addEdge(int u, int v) {
        vertices[u].adjList.add(v);
    }

    // remove an edge from the graph, complexity is O(|V|)
    // print an error message if the edge doesn't exist
    public void removeEdge(int u, int v) {
        // check for existence of edge
        if (!vertices[u].adjList.contains(Integer.valueOf(v))) {
            System.err.println("Edge " + u + " -> " + v + " does not exist");
            return;
        }
        vertices[u].adjList.remove(Integer.valueOf(v));
    }

    // toString method to print the graph, complexity is O(|V|^2)
    public String toString() {
        String result = "";
        for (int u = 0; u < vertices.length; u++) {
            for (int v : vertices[u].adjList) {
                result += u + " -> " + v + "\n";
            }
        }
        return result;
    }

    // add a new vertex, complexity is O(|V|)
    public void addVertex() {
        Vertex[] newVertices = new Vertex[vertices.length+1];
        for (int i = 0; i < vertices.length; i++) {
            newVertices[i] = vertices[i];
        }
        newVertices[vertices.length] = new Vertex();
        vertices = newVertices;
    }

    // main method to test the class
    public static void main(String[] args) {
        SimpleDirectedListGraph g = new SimpleDirectedListGraph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        System.out.println(g);
        g.removeEdge(1, 2);
        System.out.println(g);
    }
}
