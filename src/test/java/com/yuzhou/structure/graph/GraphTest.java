package com.yuzhou.structure.graph;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GraphTest {
    @Test
    public void should_get_shortest_path_in_graph_widely() throws Exception {
        Graph<String> graph = new Graph<>();

        // add vertex
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");

        // add adjacent vertex
        graph.addAdjacentVertexes("A", "B");
        graph.addAdjacentVertexes("A", "C");
        graph.addAdjacentVertexes("B", "A");
        graph.addAdjacentVertexes("B", "D");
        graph.addAdjacentVertexes("B", "E");
        graph.addAdjacentVertexes("C", "A");
        graph.addAdjacentVertexes("C", "F");
        graph.addAdjacentVertexes("D", "B");
        graph.addAdjacentVertexes("E", "B");
        graph.addAdjacentVertexes("E", "F");
        graph.addAdjacentVertexes("F", "C");
        graph.addAdjacentVertexes("F", "E");

        assertEquals("A -> B -> D", graph.widelySearchShortestPath("D"));
        assertEquals("A -> C -> F", graph.widelySearchShortestPath("F"));
        assertEquals("A -> B -> E", graph.widelySearchShortestPath("E"));
        assertEquals("A -> B", graph.widelySearchShortestPath("B"));
        assertEquals("A -> C", graph.widelySearchShortestPath("C"));
        assertEquals("A", graph.widelySearchShortestPath("A"));

        Exception exception = assertThrows(Exception.class, () -> graph.widelySearchShortestPath("NoExist"));
        assertEquals("can not find shortest distinct", exception.getMessage());
    }

    @Test
    public void should_get_possible_paths_in_graph_deeply() throws Exception {
        Graph<String> graph = new Graph<>();

        // add vertex
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");

        // add adjacent vertex
        graph.addAdjacentVertexes("A", "B");
        graph.addAdjacentVertexes("A", "C");
        graph.addAdjacentVertexes("B", "A");
        graph.addAdjacentVertexes("B", "D");
        graph.addAdjacentVertexes("B", "E");
        graph.addAdjacentVertexes("C", "A");
        graph.addAdjacentVertexes("C", "F");
        graph.addAdjacentVertexes("D", "B");
        graph.addAdjacentVertexes("E", "B");
        graph.addAdjacentVertexes("E", "F");
        graph.addAdjacentVertexes("F", "C");
        graph.addAdjacentVertexes("F", "E");

        List<String> possiblePaths = graph.deeplySearchAllPossiblePath("A", "E");
        assertEquals("[A -> B -> E, A -> C -> F -> E]", possiblePaths.toString());
    }
}