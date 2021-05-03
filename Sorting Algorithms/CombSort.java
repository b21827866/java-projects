import java.util.ArrayList;

class CombSort {

    void CombSort(ArrayList<Student> nums) {
        int gap = nums.size();
        float shrink = 1.3f;
        boolean swapped = false;

        while (gap > 1 || swapped) {
            if (gap > 1) {
                gap = (int) (gap / shrink);
            }

            swapped = false;

            for (int i = 0; gap + i < nums.size(); i++) {
                if (nums.get(i).id > nums.get(i + gap).id) {
                    swap(nums, i, i + gap);
                    swapped = true;
                }
            }
        }
    }

    private static void swap(ArrayList<Student> nums, int x, int y) {
        Integer temp = nums.get(x).id;
        nums.get(x).id = nums.get(y).id;
        nums.get(y).id = temp;
    }
}