
/**
 * SimpleDirectedMatrixGraph: a very simple directed graph stored
 * with an adjacency matrix
 *
 * @author Jim Teresco and Copilot
 * @version Spring 2024
 */
public class SimpleDirectedMatrixGraph
{

    // 2d array of booleans to represent the adjacency matrix
    // size is O(|V|^2)
    private boolean[][] adjMatrix;
    
    /**
     * Constructor
     */
    public SimpleDirectedMatrixGraph(int numVerts)
    {
        adjMatrix = new boolean[numVerts][numVerts];
    }

    // method to add an edge to the graph, complexity is O(1)
    public void addEdge(int u, int v) {
        adjMatrix[u][v] = true;
    }

    // method to remove an edge from the graph, complexity is O(1)
    public void removeEdge(int u, int v) {
        adjMatrix[u][v] = false;
    }

    // add a new vertex, complexity is O(|V|^2)
    public void addVertex() {
        boolean[][] newMatrix = new boolean[adjMatrix.length+1][adjMatrix.length+1];
        for (int u = 0; u < adjMatrix.length; u++) {
            for (int v = 0; v < adjMatrix.length; v++) {
                newMatrix[u][v] = adjMatrix[u][v];
            }
        }
        adjMatrix = newMatrix;
    }

    // toString method to print the graph, complexity is O(|V|^2)
    public String toString() {
        String result = "";
        for (int u = 0; u < adjMatrix.length; u++) {
            for (int v = 0; v < adjMatrix.length; v++) {
                if (adjMatrix[u][v]) {
                    result += u + " -> " + v + "\n";
                }
            }
        }
        return result;
    }

    // main method to test the class
    public static void main(String[] args) {
        SimpleDirectedMatrixGraph g = new SimpleDirectedMatrixGraph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        System.out.println(g);
        g.removeEdge(1, 2);
        System.out.println(g);
    }
}
