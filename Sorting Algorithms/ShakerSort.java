import java.util.ArrayList;

class ShakerSort {
    void shakerSort(ArrayList<Student> nums) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i <= nums.size() - 2; i++) {
                if (nums.get(i).id > nums.get(i+1).id) {
                    //if two elements are in the wrong order
                    int temp = nums.get(i).id;
                    nums.get(i).id = nums.get(i+1).id;
                    nums.get(i+1).id = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            swapped = false;
            for (int i = nums.size() - 2; i >= 0; i--) {
                if (nums.get(i).id > nums.get(i+1).id) {
                    int temp = nums.get(i).id;
                    nums.get(i).id = nums.get(i+1).id;
                    nums.get(i+1).id = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }
}