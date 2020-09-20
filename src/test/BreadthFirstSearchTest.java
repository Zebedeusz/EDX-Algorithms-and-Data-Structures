package test;

import main.structures.graphs.BreadthFirstSearch;
import main.structures.graphs.models.Vertex;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

@RunWith(value = JUnit4.class)
public class BreadthFirstSearchTest {
    private BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();

    @Test
    public void shouldReturnListWithOneElementGivenNotConnectedVertex() {
//        given
        Vertex vertex1 = new Vertex("A");

//        when
        List<Vertex> discovered = breadthFirstSearch.discover(vertex1);

//        then
        Assert.assertEquals(1, discovered.size());
        Assert.assertEquals(vertex1, discovered.get(0));
    }

    @Test
    public void shouldReturnAllVerticesConnectedToGivenOne() {
//        given
        Vertex vertex1 = new Vertex("A");
        Vertex vertex2 = new Vertex("B");
        Vertex vertex3 = new Vertex("C");
        Vertex vertex4 = new Vertex("D");

        vertex1.connectWith(vertex2, vertex3);
        vertex4.connectWith(vertex2, vertex3);

//        when
        List<Vertex> discovered = breadthFirstSearch.discover(vertex1);

//        then
        Assert.assertEquals(4, discovered.size());
        Assert.assertTrue(discovered.contains(vertex1));
        Assert.assertTrue(discovered.contains(vertex2));
        Assert.assertTrue(discovered.contains(vertex3));
        Assert.assertTrue(discovered.contains(vertex4));
    }

    @Test
    public void shouldReturnFoundVertexWhenItsInTheGraph() {
//        given
        Vertex vertex1 = new Vertex("A");
        Vertex vertex2 = new Vertex("B");
        Vertex vertex3 = new Vertex("C");
        Vertex vertex4 = new Vertex("D");

        vertex1.connectWith(vertex2, vertex3);
        vertex4.connectWith(vertex2, vertex3);

//        when
        Vertex found = breadthFirstSearch.find(vertex1, vertex4.getName());

//        then
        Assert.assertEquals(vertex4, found);
    }

    @Test
    public void shouldReturnNullWhenVertexNotInTheGraph() {
//        given
        Vertex vertex1 = new Vertex("A");
        Vertex vertex2 = new Vertex("B");
        Vertex vertex3 = new Vertex("C");
        Vertex vertex4 = new Vertex("D");
        Vertex vertex5 = new Vertex("E");

        vertex1.connectWith(vertex2, vertex3);
        vertex4.connectWith(vertex2, vertex3);

//        when
        Vertex found = breadthFirstSearch.find(vertex1, vertex5.getName());

//        then
        Assert.assertEquals(null, found);
    }
}
