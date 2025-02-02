package tests;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
// import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
// import java.util.HashSet;
import java.util.List;
// import java.util.Set;

import org.junit.Before;
// import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import graph.*;
import staff.Graph;
import staff.Vertex;

@RunWith(Parameterized.class)
public class SocialNetworkAnalysisTest {
    static Graph aGraph;

    public SocialNetworkAnalysisTest(Graph anInterface) {
        SocialNetworkAnalysisTest.aGraph = anInterface;
    }

    @Before
    public void readTwitterfile() throws InstantiationException, IllegalAccessException {
        SocialNetworkAnalysisTest.aGraph = aGraph.getClass().newInstance();

        // The name of the file to open.
        String fileName = "C:/Users/Jake/Documents/GitHub/Software-Analysis/A2 and A3/src/datasets/twitter.txt";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                String[] arr = line.split("->");
                Vertex v1 = new Vertex(arr[0].trim());
                Vertex v2 = new Vertex(arr[1].trim());
                aGraph.addVertex(v1);
                aGraph.addVertex(v2);

                aGraph.addEdge(v1, v2);
            }

            // Always close files.
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }

    @Test
    public void RetweetsTest() {
        Vertex followed = new Vertex("84200495");
        Vertex follower = new Vertex("38571755");

        int distance = -1;
        try {
            distance = Algorithms.shortestDistance(aGraph, follower, followed);
        } catch (Exception e) {
            fail("There should be a path from a to b");
        }
        // Test the returned distance
        // 84200495 to 38571755 (backward): 84200495 -> 14139971 -> 30070014 ->
        // 38571755
        assertEquals(3, distance);
        try {
            distance = Algorithms.shortestDistance(aGraph, follower, follower);
            fail("An Exception should be thrown. No one can follow him/herself");
        } catch (Exception e) {
            // Test that an exception should be thrown
        }

    }

    @Test
    public void CommonInfluencersTest() {

        Vertex follower = new Vertex("38571755");
        Vertex followed = new Vertex("84200495");

        List<Vertex> intersectionList = Algorithms.commonInfluencers(aGraph, followed, follower);
        System.out.println(intersectionList.size());

        // Test the size if the commonDownStream
        assertEquals(68412, intersectionList.size());
    }

    @Parameterized.Parameters
    public static Collection<Object[]> instancesToTest() {

        return Arrays.asList(new Object[] { new AdjacencyListGraph() }, new Object[] { new AdjacencyMatrixGraph() });
    }
}
