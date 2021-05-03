
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Queue {
    private static class Node{
        private int data;
        private Node next;
        private Node(int data) {
            this.data = data;
        }
    }
    private Node head;
    private Node tail;


    public boolean isEmpty() {
        return head == null;
    }
    public int peek()  {
        return head.data;
    }

    ArrayList<Integer> siz = new ArrayList<Integer>();

    public int size() {
        siz.clear();
        int counter=0;
        //int data = head.data;
        while (head != null) {
            counter++;
            siz.add(head.data);
            head = head.next;
            //System.out.println(counter);
        }

        for (int i = 0; i < siz.size(); i++) {
            add(siz.get(i));
            //System.out.println(i);
        }

        return counter;
    }

    public void add(int data) {
        Node node = new Node(data);
        if (tail != null) {
            tail.next = node;
        }
        tail = node;
        if (head == null) {
            head = node;
        }
    }
    public int remove() {
        int data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return data;
    }
    ArrayList<Integer> srt = new ArrayList<Integer>();

    public int sortElements(int size) {
        int data = head.data;
        int num = 0;
        while (num < size) {
            srt.add(head.data);
            remove();
            num++;

        }
        Collections.sort(srt);
        for (int counter = 0; counter < srt.size(); counter++) {
            add(srt.get(counter));
        }
        srt.clear();
        return data;

    }


    ArrayList<Integer> rvrs = new ArrayList<Integer>();

    public int reverse(int a,int size) {
        int data = head.data;
        int num = 0;
        while (num < a) {
            rvrs.add(head.data);
            remove();

            num++;
            }
        for (int counter = rvrs.size()-1; counter >=0; counter--) {
            add(rvrs.get(counter));
        }

        while (num >= a & num< size) {
            add(head.data);
            head = head.next;

            num++;
        }
        rvrs.clear();

        return data;

    }

    public int addOrRemove(int a) {
        int data = head.data;
        if(a >0) {
            while (a>0) {
                add((int) (Math.random() * ((49 - 2) + 1)));
                a--;
            }
        }
        if (a<0) {
            while (a<0) {
                remove();
                a++;
            }
        }
        return data;
    }
    ArrayList<Integer> distinct = new ArrayList<Integer>();

    public int distinctElements(int size) {
        int data = head.data;
        int num = 0;
        while (num < size) {
            add(head.data);
            distinct.add(head.data);
            head = head.next;
            num++;
        }
        HashSet<Integer> hSet = new HashSet<Integer>(distinct);
        distinct.clear();
        return hSet.size();
    }
    ArrayList<Integer> calcu = new ArrayList<Integer>();

    public int calculateDistance(int size) {
        int data = head.data;
        int num = 0;
        while (num < size) {
            calcu.add(head.data);
            add(head.data);
            head = head.next;
            num++;

        }

        int distance = 0;
        for (int counter = 0; counter <calcu.size(); counter++) {

            for (int i = counter; i <calcu.size(); i++) {
                distance += Math.abs(calcu.get(counter) - calcu.get(i));

            }
        }
        calcu.clear();


        return distance;
    }


    public int removeGreater(int a,int size) {

        int data = head.data;
        int num = 0;
        while (num < size) {

            if (head.data > a) {
                remove();

            }
            else {
                add(head.data);
                head = head.next;
            }
            num++;
        }

        return data;
    }

    public String printQueue() {
        Node node = head;
        String out = "";
        while (node != null) {
            out += node.data + " ";
            node = node.next;
        }
        return out.substring(0, out.length() - 1);
    }

}
