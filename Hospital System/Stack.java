
public class Stack {
	int capacity = 2;
    int stack[] = new int[capacity];
    int top = 0;

    public void push(int data){
        stack[top]
    }

    public int pop(){
        int data = 0;
        if(isEmpty()){
            System.out.println("Stack is empty");
        }
        else {
            top--;
            data = stack[top];
            stack[top] = 0;
        }
        return data;
    }
    public int peek(){
        int data;
        data = stack[top-1];
        return data;
    }
    public int size(){
        return top;
    }
    public boolean isEmpty(){
        return top <= 0;
    }
    public void show(){
        for(int n : stack){
            System.out.print(n + " ");
        }
        System.out.println();
    }
}


/*

//Stack stack = new Stack();
int number;
String str;

ArrayList<Integer> lineStack = new ArrayList<Integer>();


try {
    FileInputStream fis = new FileInputStream("decimal.txt");
    DataInputStream dis = new DataInputStream(fis);
    BufferedReader br = new BufferedReader(new InputStreamReader(dis));
    //error handling
    while((str = br.readLine()) != null ) {
        lineStack.add(Integer.parseInt(str));

    }
    dis.close();
}
catch(Exception e) {
    System.out.println("Error: " + e.getMessage());
}
System.out.println(lineStack);
for(int i = 0; i<lineStack.size(); i++) {
    number = lineStack.get(i);
    Stack stack = new Stack();
    if (number == 0) {
        stack.push(0);
    }
    while (number > 0) {
        int digit = number % 8;
        stack.push(digit);
        number = number / 8;
    }
    stack.printStack();
    //System.out.println(stack.size());
    try {
        FileWriter writer = new FileWriter("octal.txt", true);

        writer.write("\n");
        writer.close();

    } catch (IOException e) {
        e.printStackTrace();
    }

    System.out.println();
}
//stack.printStack();
*/

