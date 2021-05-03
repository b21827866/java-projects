import java.util.ArrayList;

public class GnomeSort {
    void gnomeSort(ArrayList<Student> nums) {
        int i = 1;
        int j = 2;

        while (i < nums.size()) {
            if (nums.get(i - 1).id <= nums.get(i).id) {
                i = j;
                j++;
            } else {
                int tmp = nums.get(i - 1).id;
                nums.get(i - 1).id = nums.get(i).id;
                nums.get(i--).id = tmp;
                i = (i == 0) ? j++ : i;
            }
        }
    }
}
