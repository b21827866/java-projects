import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class aas {


    //Queue queue = new Queue();
    //queue.add(4);



    String str;
    String str1;
    ArrayList<String> lineStack = new ArrayList<String>();
    ArrayList<String> lineQueue = new ArrayList<String>();

    try {
        FileInputStream fis = new FileInputStream("stack.txt");
        DataInputStream dis = new DataInputStream(fis);
        BufferedReader br = new BufferedReader(new InputStreamReader(dis));
        //error handling
        while((str = br.readLine()) != null ) {
            lineStack.add(str);

        }
        dis.close();
    }
    catch(Exception e) {
        System.out.println("Error: " + e.getMessage());
    }



    Stack stack = new Stack();

    for(int i = 0; i<lineStack.size(); i++) {
        String [] dataStack = lineStack.get(i).split(" ");
        for(int j = (dataStack.length)-1; j>=0; j--) {
            stack.push(Integer.parseInt(dataStack[j]));
        }
    }

    //stack.printStack();

    //System.out.println();

    try {
        FileInputStream fis1 = new FileInputStream("queue.txt");
        DataInputStream dis1 = new DataInputStream(fis1);
        BufferedReader br1 = new BufferedReader(new InputStreamReader(dis1));
        //error handling
        while((str1 = br1.readLine()) != null ) {
            lineQueue.add(str1);

        }
        dis1.close();
    }
    catch(Exception e) {
        System.out.println("Error: " + e.getMessage());
    }

}
}