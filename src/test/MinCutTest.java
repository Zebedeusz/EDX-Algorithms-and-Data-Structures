package test;

import main.structures.graphs.models.Edge;
import main.structures.graphs.MinCut;
import main.structures.graphs.models.Vertex;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(value = JUnit4.class)
public class MinCutTest {

    private MinCut graphUtils = new MinCut();

    @Test
    public void shouldReturnCorrectMinCutCase1() {
//        given
        List<Edge> edges = new ArrayList<>();
        Vertex vertex1 = new Vertex("A");
        Vertex vertex2 = new Vertex("B");
        Vertex vertex3 = new Vertex("C");
        Vertex vertex4 = new Vertex("D");
        edges.add(new Edge(vertex1, vertex2));
        edges.add(new Edge(vertex1, vertex3));
        edges.add(new Edge(vertex2, vertex3));
        edges.add(new Edge(vertex3, vertex4));

//        when
        List<Edge> minCut = graphUtils.calculate(edges);

//        then
        Assert.assertEquals(1, minCut.size());
        List<Vertex> endpoints = minCut.get(0).getEndpoints();
        Assert.assertTrue(endpoints.get(0).getName().equals(vertex4.getName()) ||
                endpoints.get(1).getName().equals(vertex4.getName()));
    }

    @Test
    public void shouldReturnCorrectMinCutCase2() {
//        given
        List<Edge> edges = new ArrayList<>();
        Vertex vertex1 = new Vertex("A");
        Vertex vertex2 = new Vertex("B");
        Vertex vertex3 = new Vertex("C");
        Vertex vertex4 = new Vertex("D");
        Vertex vertex5 = new Vertex("E");
        Vertex vertex6 = new Vertex("F");
        Vertex vertex7 = new Vertex("G");
        Vertex vertex8 = new Vertex("H");
        edges.add(new Edge(vertex1, vertex2));
        edges.add(new Edge(vertex1, vertex5));
        edges.add(new Edge(vertex1, vertex6));
        edges.add(new Edge(vertex2, vertex3));
        edges.add(new Edge(vertex2, vertex5));
        edges.add(new Edge(vertex2, vertex6));
        edges.add(new Edge(vertex3, vertex4));
        edges.add(new Edge(vertex3, vertex7));
        edges.add(new Edge(vertex3, vertex8));
        edges.add(new Edge(vertex4, vertex7));
        edges.add(new Edge(vertex4, vertex8));
        edges.add(new Edge(vertex5, vertex6));
        edges.add(new Edge(vertex6, vertex7));
        edges.add(new Edge(vertex7, vertex8));

//        when
        List<Edge> minCut = graphUtils.calculate(edges);

//        then
        Assert.assertEquals(1, minCut.size());
        System.out.println(minCut.get(0).getEndpoints().stream().map(Vertex::getName).collect(Collectors.joining("-")));
    }

    @Test
    public void shouldReturnTheSameListGivenListOfSizeOne() {
//        given
        List<Edge> edges = new ArrayList<>();
        Vertex vertex1 = new Vertex("A");
        Vertex vertex2 = new Vertex("B");
        edges.add(new Edge(vertex1, vertex2));

//        when
        List<Edge> minCut = graphUtils.calculate(edges);

//        then
        Assert.assertEquals(1, minCut.size());
        List<Vertex> endpoints = minCut.get(0).getEndpoints();
        Assert.assertTrue(endpoints.get(0) == vertex1);
        Assert.assertTrue(endpoints.get(1) == vertex2);
    }

    @Test
    public void shouldReturnTheSameListGivenEmptyList() {
//        given
        List<Edge> edges = new ArrayList<>();

//        when
        List<Edge> minCut = graphUtils.calculate(edges);

//        then
        Assert.assertEquals(0, minCut.size());
    }
}
