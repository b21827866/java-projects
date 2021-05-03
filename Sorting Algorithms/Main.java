import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

class Student {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
class Print{
    void printArray(ArrayList<Student> nums) {
        int n = nums.size();
        for (int i = 0; i < n; ++i)
            System.out.print(nums.get(i).id + "," +nums.get(i).name +" " );
        System.out.println();
    }
}
class Genarate{
    void genarator(ArrayList<Student> arr,ArrayList<Student> arr2,ArrayList<Student> arr3,ArrayList<Student> arr4,ArrayList<Student> arr5,int a){
        Random random = new Random();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //random string builder
        StringBuilder sb = new StringBuilder();

        Random random1 = new Random();
        //length of random string
        int length = 7;

        for(int i = 0; i < length; i++) {
            int index = random1.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        String str = sb.toString();

        System.out.println("Arraylist Size: " + a);
        for (int i =0;i<a;i++){
            int x =random.nextInt(10000);
            arr.add(new Student(x,str));
            arr2.add(new Student(x,str));
            arr3.add(new Student(x,str));
            arr4.add(new Student(x,str));
            arr5.add(new Student(x,str));
        }

    }

}

public class Main {

    public static void main(String args[])
    {
        Print print = new Print();
        Genarate gen = new Genarate();

        CombSort cs = new CombSort();
        GnomeSort gs = new GnomeSort();
        ShakerSort shs = new ShakerSort();
        StoogeSort sts = new StoogeSort();
        BitonicSort bs = new BitonicSort();

        ArrayList<Student> arr = new ArrayList<>();
        ArrayList<Student> arr2 = new ArrayList<>();
        ArrayList<Student> arr3 = new ArrayList<>();
        ArrayList<Student> arr4 = new ArrayList<>();
        ArrayList<Student> arr5 = new ArrayList<>();
        
        for (int i =0;i<10;i++) {

            gen.genarator(arr, arr2, arr3, arr4, arr5, 1024);


            long startTime = System.nanoTime();
            cs.CombSort(arr);
            long endTime = System.nanoTime();
            long timeElapsed = endTime - startTime;
            System.out.println("Comb Sort execution time in nanoseconds: " + timeElapsed);

            Collections.reverse(arr);

            long wstartTime = System.nanoTime();
            cs.CombSort(arr);
            long wendTime = System.nanoTime();
            long wtimeElapsed = wendTime - wstartTime;
            System.out.println("Comb Sort worst case execution time in nanoseconds: " + wtimeElapsed);

            /////////////////////////////////////

            long startTime2 = System.nanoTime();
            gs.gnomeSort(arr2);
            long endTime2 = System.nanoTime();
            long timeElapsed2 = endTime2 - startTime2;
            System.out.println("Gnome Sort execution time in nanoseconds: " + timeElapsed2);

            Collections.reverse(arr2);

            long wstartTime2 = System.nanoTime();
            gs.gnomeSort(arr2);
            long wendTime2 = System.nanoTime();
            long wtimeElapsed2 = wendTime2 - wstartTime2;
            System.out.println("Gnome Sort worst case execution time in nanoseconds: " + wtimeElapsed2);
            ///////////////////////////////////////

            long startTime3 = System.nanoTime();
            shs.shakerSort(arr3);
            long endTime3 = System.nanoTime();
            long timeElapsed3 = endTime3 - startTime3;
            System.out.println("Shaker Sort execution time in nanoseconds: " + timeElapsed3);

            Collections.reverse(arr3);

            long wstartTime3 = System.nanoTime();
            shs.shakerSort(arr3);
            long wendTime3 = System.nanoTime();
            long wtimeElapsed3 = wendTime3 - wstartTime3;
            System.out.println("Shaker Sort worst case execution time in nanoseconds: " + wtimeElapsed3);
            /////////////////////////////////////

            long startTime4 = System.nanoTime();
            sts.stoogesort(arr4, 0, arr4.size() - 1);
            long endTime4 = System.nanoTime();
            long timeElapsed4 = endTime4 - startTime4;
            System.out.println("Stooge Sort execution time in nanoseconds: " + timeElapsed4);

            Collections.reverse(arr4);

            long wstartTime4 = System.nanoTime();
            sts.stoogesort(arr4, 0, arr4.size() - 1);
            long wendTime4 = System.nanoTime();
            long wtimeElapsed4 = wendTime4 - wstartTime4;
            System.out.println("Stooge Sort worst case execution time in nanoseconds: " + wtimeElapsed4);
            ///////////////////////////////////////

            long startTime5 = System.nanoTime();
            bs.sort(arr5, arr5.size(), 1);
            long endTime5 = System.nanoTime();
            long timeElapsed5 = endTime5 - startTime5;
            System.out.println("Bitonic Sort execution time in nanoseconds: " + timeElapsed5);

            Collections.reverse(arr5);

            long wstartTime5 = System.nanoTime();
            bs.sort(arr5, arr5.size(), 1);
            long wendTime5 = System.nanoTime();
            long wtimeElapsed5 = wendTime5 - wstartTime5;
            System.out.println("Bitonic Sort worst case execution time in nanoseconds: " + wtimeElapsed5);

            System.out.println();
            arr.clear();
            arr2.clear();
            arr3.clear();
            arr4.clear();
            arr5.clear();
        }


    }

}
