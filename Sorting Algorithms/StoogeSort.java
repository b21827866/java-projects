import java.util.ArrayList;

public class StoogeSort {

    void stoogesort(ArrayList<Student> nums,int l,int h) {

        if (l >= h)
            return;

        // If first element is smaller swap them
        if (nums.get(l).id > nums.get(h).id) {
            int t = nums.get(l).id;
            nums.get(l).id = nums.get(h).id;
            nums.get(h).id = t;
        }

        // If there are more than 2 elements
        if (h - l + 1 > 2) {
            int t = (h - l + 1) / 3;
            // Recursively sort first 2/3 elements
            stoogesort(nums, l, h - t);
            // Recursively sort last 2/3 elements
            stoogesort(nums, l + t, h);
            // Recursively sort first 2/3 elements
            stoogesort(nums, l, h - t);
        }
    }
}