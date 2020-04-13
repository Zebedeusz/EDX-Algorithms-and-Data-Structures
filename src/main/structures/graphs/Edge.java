package main.structures.graphs;

import java.util.Arrays;
import java.util.List;

public class Edge {
    private List<Vertex> endpoints;

    public Edge(Vertex... endpoints) {
        this.endpoints = Arrays.asList(endpoints);
    }

    public List<Vertex> getEndpoints() {
        return endpoints;
    }

    public void setEndpoints(List<Vertex> endpoints) {
        this.endpoints = endpoints;
    }
}
