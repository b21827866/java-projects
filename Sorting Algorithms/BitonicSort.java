import java.util.ArrayList;


public class BitonicSort {

    void compAndSwap(ArrayList<Student> nums, int i, int j, int dir) {
        if ((nums.get(i).id > nums.get(j).id && dir == 1) || (nums.get(i).id < nums.get(j).id && dir == 0)) {
            // Swapping elements
            int temp = nums.get(i).id;
            nums.get(i).id = nums.get(j).id;
            nums.get(j).id = temp;
        }
    }

    /*
     * It recursively sorts a bitonic sequence in ascending order, if dir = 1, and
     * in descending order otherwise (means dir=0). The sequence to be sorted starts
     * at index position low, the parameter cnt is the number of elements to be
     * sorted.
     */
    void bitonicMerge(ArrayList<Student> nums, int low, int cnt, int dir) {
        if (cnt > 1) {
            int k = cnt / 2;
            for (int i = low; i < low + k; i++)
                compAndSwap(nums, i, i + k, dir);
            bitonicMerge(nums, low, k, dir);
            bitonicMerge(nums, low + k, k, dir);
        }
    }

    /*
     * This funcion first produces a bitonic sequence by recursively sorting its two
     * halves in opposite sorting orders, and then calls bitonicMerge to make them
     * in the same order
     */
    void bitonicSort(ArrayList<Student> nums, int low, int cnt, int dir) {
        if (cnt > 1) {
            int k = cnt / 2;

            // sort in ascending order since dir here is 1
            bitonicSort(nums, low, k, 1);

            // sort in descending order since dir here is 0
            bitonicSort(nums, low + k, k, 0);

            // Will merge wole sequence in ascending order
            // since dir=1.
            bitonicMerge(nums, low, cnt, dir);
        }
    }


    void sort(ArrayList<Student> nums, int N, int up) {
        bitonicSort(nums, 0, N, up);
    }



}