import main.structures.graphs.DijkstraShortestPath;
import main.structures.graphs.models.Vertex;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.Map;

@RunWith(value = JUnit4.class)
public class DijkstraShortestPathTest {
    private DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath();

    @Test
    public void shouldReturnEmptyMapGivenOneElementGraph() {
//        given
        Vertex vertex1 = new Vertex("A");

//        when
        Map<Vertex, Integer> allLengths = dijkstraShortestPath.allLengths(vertex1);

//        then
        Assert.assertEquals(1, allLengths.size());
        Assert.assertNotNull(allLengths.get(vertex1));
    }

    @Test
    public void shouldReturnMapWithLengthsGivenSmallGraph() {
//        given
        Vertex vertex1 = new Vertex("A");
        Vertex vertex2 = new Vertex("B");
        Vertex vertex3 = new Vertex("C");
        Vertex vertex4 = new Vertex("D");

        vertex1.connectWith(vertex2, 1);
        vertex1.connectWith(vertex3, 2);
        vertex4.connectWith(vertex2, 3);
        vertex4.connectWith(vertex3, 7);

//        when
        Map<Vertex, Integer> allLengths = dijkstraShortestPath.allLengths(vertex1);

//        then
        Assert.assertEquals(4, allLengths.size());
        for(Vertex key : allLengths.keySet()) {
            System.out.print(key.getName());
            System.out.print(" : ");
            System.out.println(allLengths.get(key));
        }
    }

    @Test
    public void shouldReturnMapWithLengthsGivenBigGraph() {
//        given
        Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");
        Vertex vertexC = new Vertex("C");
        Vertex vertexD = new Vertex("D");
        Vertex vertexE = new Vertex("E");
        Vertex vertexF = new Vertex("F");
        Vertex vertexG = new Vertex("G");
        Vertex vertexH = new Vertex("H");
        Vertex vertexI = new Vertex("I");

        vertexA.connectWith(Arrays.asList(vertexI, vertexH, vertexE, vertexD), Arrays.asList(8, 6, 2, 4));
        vertexB.connectWith(Arrays.asList(vertexC), Arrays.asList(4));
        vertexC.connectWith(Arrays.asList(vertexD), Arrays.asList(3));
        vertexD.connectWith(Arrays.asList(vertexF), Arrays.asList(3));
        vertexE.connectWith(Arrays.asList(vertexG, vertexF), Arrays.asList(2, 2));
        vertexF.connectWith(Arrays.asList(vertexG), Arrays.asList(1));
        vertexG.connectWith(Arrays.asList(vertexH), Arrays.asList(1));
        vertexH.connectWith(Arrays.asList(vertexI), Arrays.asList(4));

//        when
        Map<Vertex, Integer> allLengths = dijkstraShortestPath.allLengths(vertexA);

//        then
        Assert.assertEquals(9, allLengths.size());
        for(Vertex key : allLengths.keySet()) {
            System.out.print(key.getName());
            System.out.print(" : ");
            System.out.println(allLengths.get(key));
        }
    }
}
