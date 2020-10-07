package main.structures.graphs.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vertex {
    private String name;

    private List<Vertex> adjacent = new ArrayList<>();

    private List<Integer> distances = new ArrayList<>();

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

    public List<Integer> getDistances() {
        return distances;
    }

    public void connectWith(Vertex... adjacent) {
        for(Vertex vertex : adjacent) {
            this.adjacent.add(vertex);
            vertex.addAdjacent(this);
        }
    }

    public void connectWith(Vertex adjacent, int length) {
        this.adjacent.add(adjacent);
        adjacent.addAdjacent(this);

        this.distances.add(length);
        adjacent.distances.add(length);
    }

    public void connectWith(List<Vertex> adjacent, List<Integer> lengths) {
        for(int i = 0; i < adjacent.size(); i++) {
            if(!this.adjacent.contains(adjacent.get(i))) {
                this.adjacent.add(adjacent.get(i));
                this.distances.add(lengths.get(i));
            }
            if(!adjacent.get(i).getAdjacent().contains(this)) {
                adjacent.get(i).addAdjacent(this);
                adjacent.get(i).distances.add(lengths.get(i));
            }
        }
    }
}
