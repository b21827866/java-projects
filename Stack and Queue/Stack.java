
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Stack {
    private static class Node {
        private int data;
        private Node next;
        private Node(int data) {
            this.data = data;
        }
    }

    private Node top;

    public void push(int data) {
        Node node = new Node(data);
        node.next = top;
        top = node;

    }
    public int pop() {
        int data = top.data;
        top = top.next;
        return data;
    }
    public int peek() {
        return top.data;
    }
    public boolean isEmpty() {
        return top == null;
    }

    ArrayList<Integer> siz = new ArrayList<Integer>();

    public int size() {
        siz.clear();
        int counter=0;

        while (top != null) {
            counter++;
            siz.add(top.data);
            pop();
            //System.out.println(counter);
        }

        for (int i = siz.size()-1; i >= 0 ; i--) {
            push(siz.get(i));
            //System.out.println(i);
        }
        siz.clear();

        return counter;
    }

    ArrayList<Integer> remov = new ArrayList<Integer>();

    public int removeGreater(int a,int size) {

        int data = top.data;
        int num = 0;
        while (num < size) {

            if (top.data > a) {
                pop();

            }
            else {
                remov.add(top.data);
                top = top.next;
            }
            num++;
        }
        for (int i = remov.size()-1; i >= 0 ; i--) {
            push(remov.get(i));
        }
        remov.clear();
        return data;
    }
    public int addOrRemove(int a) {
        int data = top.data;
        if(a >0) {
            while (a>0) {
                push((int) (Math.random() * ((49 - 2) + 1)));
                a--;
            }
        }
        if (a<0) {
            while (a<0) {
                pop();
                a++;
            }
        }
        return data;
    }
    ArrayList<Integer> rvrs = new ArrayList<Integer>();

    public int reverse(int a,int size) {
        int data = top.data;
        int num = 0;
        while (num < a) {
            rvrs.add(top.data);
            pop();

            num++;
        }
        for (int counter = 0; counter <rvrs.size(); counter++) {
            push(rvrs.get(counter));
        }
        rvrs.clear();

        return data;
    }
    ArrayList<Integer> srt = new ArrayList<Integer>();

    public int sortElements(int size) {
        int data = top.data;
        int num = 0;
        while (num < size) {
            srt.add(top.data);
            pop();
            num++;

        }
        Collections.sort(srt);
        for (int counter = srt.size()-1; counter >=0 ; counter--) {
            push(srt.get(counter));
        }
        srt.clear();
        return data;

    }
    ArrayList<Integer> distinct = new ArrayList<Integer>();

    public int distinctElements(int size) {
        int data = top.data;
        int num = 0;
        while (num < size) {

            distinct.add(top.data);
            top = top.next;
            num++;
        }
        for (int counter = distinct.size()-1; counter >=0 ; counter--) {
            push(distinct.get(counter));
        }
        //System.out.println(distinct);
        HashSet<Integer> hSet = new HashSet<Integer>(distinct);
        distinct.clear();
        return hSet.size();
    }
    ArrayList<Integer> calcu = new ArrayList<Integer>();

    public int calculateDistance(int size) {
        int data = top.data;
        int num = 0;
        while (num < size) {
            calcu.add(top.data);
            top = top.next;
            num++;

        }

        int distance = 0;
        for (int counter = 0; counter <calcu.size(); counter++) {

            for (int i = counter; i <calcu.size(); i++) {
                distance += Math.abs(calcu.get(counter) - calcu.get(i));

            }
        }
        for (int counter = calcu.size()-1; counter >=0 ; counter--) {
            push(calcu.get(counter));
        }
        calcu.clear();

        return distance;
    }




    public String printStack() {
        Node node = top;
        String out = "";
        while (node != null) {

            out += node.data + " ";
            node = node.next;
        }
        return out.substring(0, out.length() - 1);

    }
}
