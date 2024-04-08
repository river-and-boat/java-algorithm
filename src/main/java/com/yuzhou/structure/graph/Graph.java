package com.yuzhou.structure.graph;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 无相图
 */
public class Graph<T extends Comparable<T>> {
    private final Map<T, List<T>> vertexMap = new HashMap<>();

    public void addVertex(T value) {
        if (!vertexMap.containsKey(value)) {
            vertexMap.put(value, new ArrayList<>());
        }
    }

    public void addAdjacentVertexes(T value, T adjacentVertex) throws Exception {
        if (!vertexMap.containsKey(value)) {
            throw new Exception("should initialize a vertex first");
        }
        List<T> av = vertexMap.get(value);
        if (av.stream().anyMatch(t -> t.compareTo(adjacentVertex) == 0)) {
            // 已经存在待添加的相邻节点
            return;
        }
        av.add(adjacentVertex);
    }

    public String widelySearchShortestPath(T target) throws Exception {
        Map<T, String> shortestPathMap = new HashMap<>();
        widelySearchShortestPath(target, shortestPathMap);

        if (!shortestPathMap.containsKey(target)) {
            throw new Exception("can not find shortest distinct");
        }

        System.out.println("a possible path to given vertex " + target + ":");
        String shortestPath = shortestPathMap.get(target);
        String formatShortestPath = shortestPath.substring(0, shortestPath.lastIndexOf(" ->"));
        System.out.println(formatShortestPath);
        return formatShortestPath;
    }

    private void widelySearchShortestPath(T target, Map<T, String> shortestDistinct) throws Exception {
        Deque<T> deque = new LinkedBlockingDeque<>();
        Set<T> visited = new HashSet<>();

        for (T t : vertexMap.keySet()) {
            if (!visited.contains(t)) {
                deque.addFirst(t);
            }
            while (!deque.isEmpty()) {
                T item = deque.pollLast();
                if (!shortestDistinct.containsKey(item)) {
                    shortestDistinct.put(item, item + " -> ");
                }
                visited.add(item);
                if (item.compareTo(target) == 0) {
                    return;
                }
                List<T> neighbors = vertexMap.get(item);
                neighbors.forEach(neighbor -> {
                    if (!visited.contains(neighbor)) {
                        if (!shortestDistinct.containsKey(neighbor)) {
                            String prePath = shortestDistinct.get(item);
                            shortestDistinct.put(neighbor, prePath + neighbor + " -> ");
                        }
                        deque.addFirst(neighbor);
                    }
                });
            }
        }
    }

    public List<String> deeplySearchAllPossiblePath(T start, T target) throws Exception {
        List<String> possiblePaths = new ArrayList<>();
        Set<T> visited = new HashSet<>();
        if (!vertexMap.containsKey(start)) {
            throw new Exception("given start vertex not exist");
        }
        deeplySearchPossiblePaths(start, target, visited, "", possiblePaths);
        for (T t : vertexMap.keySet()) {
            if (!visited.contains(t)) {
                deeplySearchPossiblePaths(t, target, visited, "", possiblePaths);
            }
        }
        return possiblePaths.stream().filter(s -> s.startsWith(start.toString())).toList();
    }

    private void deeplySearchPossiblePaths(T node, T target, Set<T> visited, String path, List<String> possiblePaths) {
        if (node != target) {
            visited.add(node);
        }
        if (node.compareTo(target) == 0) {
            possiblePaths.add(path + node);
            return;
        }
        path += node + " -> ";
        List<T> neighbors = vertexMap.get(node).stream().filter(t -> !visited.contains(t)).toList();
        if (neighbors.isEmpty()) {
            return;
        }
        String finalPath = path;
        neighbors.forEach(neighbor -> deeplySearchPossiblePaths(neighbor, target, visited, finalPath, possiblePaths));
    }
}
