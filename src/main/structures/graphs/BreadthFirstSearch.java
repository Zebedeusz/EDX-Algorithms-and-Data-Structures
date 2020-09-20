package main.structures.graphs;

import main.structures.graphs.models.Vertex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BreadthFirstSearch {
    public List<Vertex> discover(Vertex source) {
        List<Vertex> discovered = new ArrayList<>();

        LinkedList<Vertex> verticesToCheck = new LinkedList<Vertex>();
        verticesToCheck.add(source);

        while (!verticesToCheck.isEmpty()) {
            Vertex vertexToCheck = verticesToCheck.removeFirst();
//            to change to DepthFirstChange: Vertex vertexToCheck = verticesToCheck.removeLast();
            if(discovered.contains(vertexToCheck)) {
                continue;
            }
            discovered.add(vertexToCheck);
            List<Vertex> adjacentVertices = vertexToCheck.getAdjacent();
            if(adjacentVertices != null) {
                for (Vertex adjacentVertex : adjacentVertices) {
                    if(!discovered.contains(adjacentVertex)) {
                        verticesToCheck.add(adjacentVertex);
                    }
                }
            }
        }
        return discovered;
    }
    public Vertex find(Vertex source, String nameToFind) {
        List<Vertex> discovered = new ArrayList<>();

        LinkedList<Vertex> verticesToCheck = new LinkedList<Vertex>();
        verticesToCheck.add(source);

        while (!verticesToCheck.isEmpty()) {
            Vertex vertexToCheck = verticesToCheck.pop();
            if(discovered.contains(vertexToCheck)) {
                continue;
            }
            if(vertexToCheck.getName().equals(nameToFind)) {
                return vertexToCheck;
            }
            discovered.add(vertexToCheck);
            List<Vertex> adjacentVertices = vertexToCheck.getAdjacent();
            if(adjacentVertices != null) {
                for (Vertex adjacentVertex : adjacentVertices) {
                    if(!discovered.contains(adjacentVertex)) {
                        verticesToCheck.add(adjacentVertex);
                    }
                }
            }
        }
        return null;
    }
}
