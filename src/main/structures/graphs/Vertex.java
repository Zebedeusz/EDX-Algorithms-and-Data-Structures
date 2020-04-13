package main.structures.graphs;

import java.util.List;

public class Vertex {
    private String name;

    private List<Vertex> adjacent;

    public Vertex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addAdjacent(Vertex adjacent) {
        this.adjacent.add(adjacent);
    }

    public List<Vertex> getAdjacent() {
        return adjacent;
    }

    public void setAdjacent(List<Vertex> adjacent) {
        this.adjacent = adjacent;
    }
}
