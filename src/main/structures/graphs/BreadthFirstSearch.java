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
            Vertex vertexToCheck = verticesToCheck.pop();
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
}
