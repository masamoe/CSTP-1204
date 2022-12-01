import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import staff.Graph;
import staff.Vertex;
import graph.Algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class TwitterAnalysis {
    
    static String fileName = "datasets/twitter.txt";

    private static String writing = "";
   
    public static void main(String[ ] args) throws Exception {

        AdjacencyListGraph graph = new AdjacencyListGraph();
        graphing(graph);

        readInput(args[0], graph);

        results(args[1]);

    }

    //Scanner to be able to read the contents from the file, then using the contents make a graph with it
    public static void graphing (Graph graph) throws FileNotFoundException{
            
        
        File fileInUse = new File(fileName);

        try (Scanner scans = new Scanner(fileInUse)) {
            while (scans.hasNextLine()){
  

            String numsScan = scans.nextLine();

            String[] arr = numsScan.split("->");

          

            Vertex v1 = new Vertex(arr[0].trim());
            Vertex v2 = new Vertex(arr[1].trim());

            graph.addVertex(v1); 
            graph.addVertex(v2); 

            graph.addEdge(v1, v2);    
            
        } 

        }
     
    }
 

    public static void commonInfluencers (Graph graph, Vertex v1, Vertex v2){

        List<Vertex> common = new ArrayList<Vertex>();


        common = Algorithms.commonDownstreamVertices(graph, v1, v2);

        for (int i = 0; i < common.size(); i++){
            writing += common.get(i).toString() + "\n";
        }
    
    }

    public static void readInput (String commandsFile, Graph graph) throws IOException{
        
        try (BufferedReader read = new BufferedReader(new FileReader(commandsFile))) {
            String line;

            while ((line = read.readLine()) != null){

                String liness [] = line.split(" ");

                Vertex user1 = new Vertex(liness[1]);
                Vertex user2 = new Vertex(liness[2]);

                if (liness[0].contains("commonInfluencers")){
                    commonInfluencers(graph, user1, user2);
                }

                else if(liness[0].contains("numRetweets")){
      
                    numRetweets(graph, user1, user2);
                }
            }
        }

    }


    public static void numRetweets (Graph graph, Vertex v1, Vertex v2){

        writing += Algorithms.shortestDistance(graph, v1, v2)+ "\n";

    }


    public static void results(String resultsFile) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(resultsFile));
        writer.write(writing);
        
        writer.close();

    }

}

