package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import graph.Graph;

public class Tests {

    @Test
    public void testBasic() {
        Graph g = new Graph(new int[10][10]);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        String s = g.BFS(0);
        assertEquals("0123", s);
        String s2 = g.DFS(0);
        assertEquals("0213", s2);
        assertTrue(g.hasCycle(0));
    }

    @Test
    public void testGraph() {
        int[][] g1 = { { 0, 1, 0, 1, 1 }, { 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 0 }, 
            { 1, 1, 0, 0, 1 }, { 1, 0, 0, 1, 0 } };
        Graph g = new Graph(g1);
        assertEquals(g.BFS(0), "01342");
        assertEquals(g.DFS(0), "04312");
        assertTrue(g.hasCycle(1));
        assertTrue(g.hasCycle(0));
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Tests.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.getTestHeader() + ":" + failure.getTrace());
        }
    }
}
