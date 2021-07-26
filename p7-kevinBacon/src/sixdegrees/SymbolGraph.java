/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sixdegrees;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.TreeMap;

public class SymbolGraph {
    private TreeMap<String, Integer> st;  // string -> index
    private String[] keys;           // index  -> string
    private Graph G;

    /**  
     * Initializes a graph from a file using the specified delimiter.
     * Each line in the file contains
     * the name of a vertex, followed by a list of the names
     * of the vertices adjacent to that vertex, separated by the delimiter.
     * @param filename the name of the file
     * @param delimiter the delimiter between fields
     */
    public SymbolGraph(String filename, String delimiter) throws FileNotFoundException, IOException {
        st = new TreeMap<String, Integer>();

        // First pass builds the index by reading strings to associate
        // distinct strings with an index
        BufferedReader reader = new BufferedReader(new FileReader(
            new File(filename)));
        String line;
        while ((line = reader.readLine()) != null) {    
            String[] data = line.split(delimiter);
            for (String s: data) {
              //TODO
              //  process the symbols for each unique vertex here
              //      
            }
        }
        System.out.println("Done reading " + filename);

        // second pass builds the graph by connecting first vertex on each
        // line to all others
        G = new Graph(st.size());
        reader = new BufferedReader(new FileReader(
            new File(filename)));
        while ((line = reader.readLine()) != null) { 
            String[] data = line.split(delimiter);
            //TODO
            //add egdes from data[0], which the movie, to the cast of the movie
            //G.addEdge(v, w);
        }
    }

    /**
     * Does the graph contain the vertex named <tt>s</tt>?
     * @param s the name of a vertex
     * @return <tt>true</tt> if <tt>s</tt> is the name of a vertex, and <tt>false</tt> otherwise
     */
    public boolean contains(String s) {
		//TODO
	}

    /**
     * return the adjacent vertices of a vertex named source
     */
    public Bag<String> neighbors(String source){
		//TODO
	}

    /**
     * return a list of movie title, actors, or actresses 
     * if their names have s as a substring
     */
    public Bag<String> list(String s){
		//TODO
	}
    /**
     * Returns the integer associated with the vertex named <tt>s</tt>.
     * @param s the name of a vertex
     * @return the integer (between 0 and <em>V</em> - 1) associated with the vertex named <tt>s</tt>
     */
    public int index(String s) {
		//TODO
	}

    /**
     * Returns the name of the vertex associated with the integer <tt>v</tt>.
     * @param v the integer corresponding to a vertex (between 0 and <em>V</em> - 1) 
     * @return the name of the vertex associated with the integer <tt>v</tt>
     */
    public String name(int v) {
		//TODO
	}

    /**
     * Returns the graph associated with the symbol graph. It is the client's responsibility
     * not to mutate the graph.
     * @return the graph associated with the symbol graph
     */
    public Graph G() {
        return G;
    }
}
