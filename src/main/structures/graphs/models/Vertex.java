package main.structures.graphs.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vertex {
    private String name;

    private List<Vertex> adjacent = new ArrayList<>();

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

    public void setAdjacent(Vertex... adjacent) {
        this.adjacent = Arrays.asList(adjacent);
    }

    public void connectWith(Vertex... adjacent) {
        for(Vertex vertex : adjacent) {
            this.adjacent.add(vertex);
            vertex.addAdjacent(this);
        }
    }
}
