package main.structures.graphs;

import main.structures.graphs.models.Vertex;

import java.util.*;

public class DijkstraShortestPath {
    public Map<Vertex, Integer> allLengths(Vertex source) {
        List<Vertex> processed = new ArrayList<>();
        processed.add(source);

        Map<Vertex, Integer> lengths = new HashMap<>();
        lengths.put(source, 0);

        boolean smthChecked = true;
        while (smthChecked) {
            smthChecked = false;
            Vertex closestVertex = null;
            int lengthToClosestVertex = 0;
            for (Vertex checkedV : processed) {
                for (Vertex checkedVAdj : checkedV.getAdjacent()) {
                    if (processed.contains(checkedVAdj)) {
                        continue;
                    }
                    smthChecked = true;
                    int lengthToCheckedVAdj = lengths.get(checkedV) +
                            checkedV.getDistances().get(checkedV.getAdjacent().indexOf(checkedVAdj));
                    if (closestVertex == null || lengthToCheckedVAdj < lengthToClosestVertex) {
                        closestVertex = checkedVAdj;
                        lengthToClosestVertex = lengthToCheckedVAdj;
                    }
                }
            }
            if (closestVertex != null) {
                processed.add(closestVertex);
                lengths.put(closestVertex, lengthToClosestVertex);
            }
        }
        return lengths;
    }
}
