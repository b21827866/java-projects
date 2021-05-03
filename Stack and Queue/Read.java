import java.io.*;
import java.util.ArrayList;

public class Read {
    public static void reader(String commandtxt) {

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
        Queue queue = new Queue();
        for(int i = 0; i<lineQueue.size(); i++) {
            String [] dataQueue = lineQueue.get(i).split(" ");
            for(int j = 0; j<dataQueue.length; j++) {
                queue.add(Integer.parseInt(dataQueue[j]));
            }
        }



        String str2;
        ArrayList<String> command = new ArrayList<String>();


        try {
            FileInputStream fis2 = new FileInputStream(commandtxt);
            DataInputStream dis2 = new DataInputStream(fis2);
            BufferedReader br2 = new BufferedReader(new InputStreamReader(dis2));
            //error handling
            while((str2 = br2.readLine()) != null ) {
                command.add(str2);

            }
            dis2.close();
        }
        catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }


        for(int i = 0; i<command.size(); i++) {
            String[] commands = command.get(i).split(" ");
            if (commands[0].equals("Q") ){
                if (commands[1].equals("removeGreater")) {
                    queue.removeGreater(Integer.parseInt(commands[2]),queue.size());

                    try {
                        FileWriter writer1 = new FileWriter("queueOut.txt", true);
                        writer1.write("After removeGreater " +commands[2]+":" + "\n");
                        writer1.write(queue.printQueue() + "\n");

                        writer1.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (commands[1].equals("calculateDistance")) {
                    queue.calculateDistance(queue.size());

                    try {
                        FileWriter writer1 = new FileWriter("queueOut.txt", true);
                        writer1.write("After calculateDistance:" + "\n");
                        writer1.write("Total distance="+queue.calculateDistance(queue.size()) + "\n");

                        writer1.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (commands[1].equals("addOrRemove")) {
                    queue.addOrRemove(Integer.parseInt(commands[2]));
                    try {
                        FileWriter writer1 = new FileWriter("queueOut.txt", true);
                        writer1.write("After addOrRemove " +commands[2]+":" + "\n");
                        writer1.write(queue.printQueue() + "\n");

                        writer1.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (commands[1].equals("reverse")) {
                    queue.reverse(Integer.parseInt(commands[2]), queue.size());
                    try {
                        FileWriter writer1 = new FileWriter("queueOut.txt", true);
                        writer1.write("After reverse " +commands[2]+":" + "\n");
                        writer1.write(queue.printQueue() + "\n");

                        writer1.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (commands[1].equals("sortElements")) {
                    queue.sortElements(queue.size());
                    try {
                        FileWriter writer1 = new FileWriter("queueOut.txt", true);
                        writer1.write("After sortElements:" + "\n");
                        writer1.write(queue.printQueue() + "\n");

                        writer1.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (commands[1].equals("distinctElements")) {
                    queue.distinctElements(queue.size());
                    try {
                        FileWriter writer1 = new FileWriter("queueOut.txt", true);
                        writer1.write("After distinctElements:" + "\n");
                        writer1.write("Total distinct element="+queue.distinctElements(queue.size()) + "\n");

                        writer1.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


            }

            if (commands[0].equals("S") ){
                if (commands[1].equals("removeGreater")) {
                    stack.removeGreater(Integer.parseInt(commands[2]),stack.size());

                    try {
                        FileWriter writer1 = new FileWriter("stackOut.txt", true);
                        writer1.write("After removeGreater " +commands[2]+":" + "\n");
                        writer1.write(stack.printStack() + "\n");

                        writer1.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (commands[1].equals("calculateDistance")) {
                    stack.calculateDistance(stack.size());
                    try {
                        FileWriter writer1 = new FileWriter("stackOut.txt", true);
                        writer1.write("After calculateDistance:" + "\n");
                        writer1.write("Total distance="+stack.calculateDistance(stack.size()) + "\n");

                        writer1.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (commands[1].equals("addOrRemove")) {
                    stack.addOrRemove(Integer.parseInt(commands[2]));
                    try {
                        FileWriter writer1 = new FileWriter("stackOut.txt", true);
                        writer1.write("After addOrRemove " +commands[2]+":" + "\n");
                        writer1.write(stack.printStack() + "\n");

                        writer1.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (commands[1].equals("reverse")) {
                    stack.reverse(Integer.parseInt(commands[2]), stack.size());
                    try {
                        FileWriter writer1 = new FileWriter("stackOut.txt", true);
                        writer1.write("After reverse " +commands[2]+":" + "\n");
                        writer1.write(stack.printStack() + "\n");

                        writer1.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (commands[1].equals("sortElements")) {
                    stack.sortElements(stack.size());
                    try {
                        FileWriter writer1 = new FileWriter("stackOut.txt", true);
                        writer1.write("After sortElements:" + "\n");
                        writer1.write(stack.printStack() + "\n");

                        writer1.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (commands[1].equals("distinctElements")) {
                    stack.distinctElements(stack.size());
                    try {
                        FileWriter writer1 = new FileWriter("stackOut.txt", true);
                        writer1.write("After distinctElements:" + "\n");
                        writer1.write("Total distinct element="+stack.distinctElements(stack.size()) + "\n");

                        writer1.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
        PrintWriter writer;
        try {
            writer = new PrintWriter("stack.txt");
            writer.print("");
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        PrintWriter writer1;
        try {
            writer1 = new PrintWriter("queue.txt");
            writer1.print("");
            writer1.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            FileWriter writer2 = new FileWriter("stack.txt", true);
            writer2.write(stack.printStack());

            writer2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter writer3 = new FileWriter("queue.txt", true);
            writer3.write(queue.printQueue());

            writer3.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}
