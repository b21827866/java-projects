import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {


    /**
     * Propogated {@link IOException} here
     * {@link #readFile} and {@link #writeOutput} methods should be called here
     * A {@link Scheduler} instance must be instantiated here
     */
    public static void main(String[] args) throws IOException {
       try {
           Assignment[] assignmentArray = Main.readFile(args[0]);
           Arrays.sort(assignmentArray);
           Scheduler sc = new Scheduler(assignmentArray);
           //System.out.println(sc.scheduleGreedy().get(0).getName());
           Main.writeOutput("solution_dynamic.json",sc.scheduleDynamic());
           Main.writeOutput("solution_greedy.json",sc.scheduleGreedy());

       }
       catch (IllegalArgumentException x){
           x.printStackTrace();
       }



    }

    /**
     * @param filename json filename to read
     * @return Returns a list of {@link Assignment}s obtained by reading the given json file
     * @throws FileNotFoundException If the given file does not exist
     */
    private static Assignment[] readFile(String filename) throws FileNotFoundException {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(filename));
        Assignment[] assignments = new Gson().fromJson(reader, Assignment[].class);


        return assignments;
    }

    /**
     * @param filename  json filename to write
     * @param arrayList a list of {@link Assignment}s to write into the file
     * @throws IOException If something goes wrong with file creation
     */
    private static void writeOutput(String filename, ArrayList<Assignment> arrayList) throws IOException {
        Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
        Writer w = new FileWriter(filename);
        gson.toJson(arrayList,w);
        try{
            w.close();
        }
        catch(IOException ex){
            System.out.println("Error");
        }
    }
}