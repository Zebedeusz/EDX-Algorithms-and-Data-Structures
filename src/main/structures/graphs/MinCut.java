package main.structures.graphs;

import main.structures.graphs.models.Edge;
import main.structures.graphs.models.Vertex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


public class MinCut {
    public List<Edge> calculate(List<Edge> edges) {
        List<Edge> minCutEdges = new ArrayList<>(edges);

        if (minCutEdges.size() < 2) {
            return minCutEdges;
        }

        while (countVertices(minCutEdges) > 2) {
//        randomly select an edge
            int edgeToRemoveIndex = (int) (Math.random() * (minCutEdges.size() - 1));
            Edge edgeToRemove = minCutEdges.get(edgeToRemoveIndex);

//        merge vertices that the edge connects
            List<String> verticesToMerge = edgeToRemove.getEndpoints().stream()
                    .map(Vertex::getName)
                    .collect(Collectors.toList());

//            sorting name of merged vertex to have it in alphabetical order
            String mergedVertexName = verticesToMerge.stream().collect(Collectors.joining());
            char[] sortedMergedVErtexNameCharsArray = mergedVertexName.toCharArray();
            Arrays.sort(sortedMergedVErtexNameCharsArray);
            mergedVertexName = new String(sortedMergedVErtexNameCharsArray);

            minCutEdges.remove(edgeToRemoveIndex);

            Vertex mergedVertex = new Vertex(mergedVertexName);

            for (Iterator<Edge> iterator = minCutEdges.iterator(); iterator.hasNext(); ) {
                Edge edge = iterator.next();
                List<Vertex> endpoints = edge.getEndpoints();
                for (Vertex endpoint : endpoints) {
                    for (String vertexToMerge : verticesToMerge) {
                        if (endpoint.getName().equals(vertexToMerge)) {
                            endpoints.set(endpoints.indexOf(endpoint), mergedVertex);
                            break;
                        }
                    }
                }
//            loop edge check-up
                if (endpoints.get(0).getName().equals(endpoints.get(1).getName())) {
                    iterator.remove();
                }
            }
        }

        minCutEdges = removeIdenticalEdges(minCutEdges);

        return minCutEdges;
    }

    private int countVertices(List<Edge> edges) {
        List<Vertex> allVertices = new ArrayList<>();
        for (Edge edge : edges) {
            allVertices.addAll(edge.getEndpoints());
        }

        return (int) allVertices.stream().distinct().count();
    }

    private List<Edge> removeIdenticalEdges(List<Edge> edges) {
        List<Edge> edgesCopy = new ArrayList<>(edges);

        for (int i = 0; i < edgesCopy.size(); i++) {
            for (int j = i + 1; j < edgesCopy.size(); j++) {
                List<Vertex> endpointsEdge1 = edgesCopy.get(i).getEndpoints();
                List<Vertex> endpointsEdge2 = edgesCopy.get(j).getEndpoints();

                if ((endpointsEdge1.get(0) == endpointsEdge2.get(0)
                        || endpointsEdge1.get(0) == endpointsEdge2.get(1))
                        && (endpointsEdge1.get(1) == endpointsEdge2.get(0) ||
                        endpointsEdge1.get(1) == endpointsEdge2.get(1))) {
                    edgesCopy.remove(j);
                    j--;
                }
            }
        }
        return edgesCopy;
    }
}
