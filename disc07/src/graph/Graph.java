package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

	/**
	 * This implements a Directed Graph using adjacency lists
     * Values of the nodes will be the indices of the matrix. 
	 */
	public int[][] adj;

	public Graph(int[][] num) {
		adj = num;
	}

	public void addEdge(int start, int e) {
	    adj[start][e] = 1; 
	    adj[e][start] = 1; 
	} 

	public void addDirEdge(int start, int e) {
	    adj[start][e] = 1; 
	} 

    /** 
     * Execute Breadth-First Search starting at the given node of the graph
     * When multiple out degrees exist, prioritize smaller numbers
     * Return a string containing the data in the nodes concatenated together 
     * (no spaces)
     */
	public String BFS(int g) {
		//TODO
	}
	
    /** 
     * Execute Depth-First Search starting at the given node of the graph
     * When multiple out degrees exist, prioritize larger numbers
     * Return a string containing the data in the nodes concatenated together 
     * (no spaces)
     */
	public String DFS(int g) {
		//TODO
	}

    /** 
     * Given a node, simply return if a crcle exists in the reachable graph
     */
	public boolean hasCycle(int g) {
		//TODO
	}
}
