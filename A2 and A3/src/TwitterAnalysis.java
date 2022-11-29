import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class TwitterAnalysis {
    
    //Filename
    public static String fileName = "/Users/bettymerid/Downloads/cstp-1204-main/Assignments/A2 and A3/datasets/twitter.txt";

    //Scanner to be able to read the contents from the file, then using the contents make a graph with it
    public static void main(String[] args) throws Exception {

        //Scanner to read through file 
        File fileInUse = new File(fileName);
        Scanner scans = new Scanner(fileInUse);

        while (scans.hasNextLine())
        System.out.println(scans.nextLine());

    }

    //make the statements for comoninfluencers, smth about queries
    public void smth (){
       // make vertexes for all the different numbers(points),
       // using addEdge make edges between every 2 numbers in the file
       // 


    }

    //make the statements for numretweets, smth about queries
    public void smth2 (){

    }



    // This is how to write to a file, it'll print out the outputs by using this to write a string to a new file
    public static void results() throws IOException {

        String str = "Hello";
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(str);
              
        writer.close();

    }

}

//use shortest distance to find common influencers 
//downstream shows you who that person follows
//Upstream shows who follows that person

//Use downstram to find common influencers

//retweets returns a number

//
