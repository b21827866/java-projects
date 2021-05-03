import java.util.ArrayList;
import java.util.Arrays;

public class Scheduler {

    private Assignment[] assignmentArray;
    private Integer[] C;
    private Double[] max;
    private ArrayList<Assignment> solutionDynamic;
    private ArrayList<Assignment> solutionGreedy;

    /**
     * @throws IllegalArgumentException when the given array is empty
     */
    public Scheduler(Assignment[] assignmentArray) throws IllegalArgumentException {
        if (assignmentArray.length == 0){
            throw new IllegalArgumentException();
        }
        else {
            this.assignmentArray = assignmentArray;
            this.C = new Integer[assignmentArray.length];



            //System.out.println(assignmentArray[1].getFinishTime());
            //System.out.println(binarySearch(5));
            calculateC();
            //System.out.println(Arrays.toString(C));
            //Arrays.stream(assignmentArray).forEach(System.out::println);

            this.max = new Double[assignmentArray.length];
            //base case
            for(int i = 1; i<assignmentArray.length; i++) {
                max[i] = 0.0;
            }
            solutionGreedy = new ArrayList<Assignment>();
            solutionDynamic = new ArrayList<Assignment>();
            calculateMax(assignmentArray.length-1);
            //System.out.println(Arrays.toString(max));


        }

        // Should be instantiated with an Assignment array
        // All the properties of this class should be initialized here
    }

    /**
     * @param index of the {@link Assignment}
     * @return Returns the index of the last compatible {@link Assignment},
     * returns -1 if there are no compatible assignments
     */
    private int binarySearch(int index) {
        int low = 0, high = index - 1;
        //System.out.println(assignmentArray[0].getFinishTime());

        while (low <= high){		//Iterative binary search
            int mid = (low + high) / 2;		//integer division (floor)
            String [] datas = assignmentArray[index].getStartTime().split(":");
            String [] datas1 = assignmentArray[mid].getFinishTime().split(":");
            if (Integer.parseInt(datas1[0])*60 + Integer.parseInt(datas1[1])<= Integer.parseInt(datas[0])*60+Integer.parseInt(datas[1]) ) {
                String [] datas2 = assignmentArray[mid+1].getFinishTime().split(":");
                if (Integer.parseInt(datas2[0])*60+Integer.parseInt(datas2[1]) <= Integer.parseInt(datas[0])*60+Integer.parseInt(datas[1]))
                    low = mid + 1;

                else
                    return mid;
            }
            else
                high = mid - 1;
        }
        return -1;

    }


    /**
     * {@link #C} must be filled after calling this method
     */
    private void calculateC() {
        for (int i=0; i<assignmentArray.length; i++){
            C[i] = binarySearch(i);
        }
    }


    /**
     * Uses {@link #assignmentArray} property
     *
     * @return Returns a list of scheduled assignments
     */
    public ArrayList<Assignment> scheduleDynamic() {
        findSolutionDynamic(assignmentArray.length-1);
        solutionDynamic.sort(Assignment::compareTo);
        return solutionDynamic;
    }

    /**
     * {@link #solutionDynamic} must be filled after calling this method
     */
    private void findSolutionDynamic(int i) {
        System.out.println("findSolutionDynamic(" + i + ")");
        if (i==0){
            System.out.println("Adding " + assignmentArray[i].toString()+ " to the dynamic schedule");
            solutionDynamic.add(assignmentArray[i]);
            return;
        }
        else{
            if (C[i] != -1) {
                if (assignmentArray[i].getWeight() + max[C[i]] >= max[i - 1]) {
                    System.out.println("Adding " + assignmentArray[i].toString()+ " to the dynamic schedule");
                    solutionDynamic.add(assignmentArray[i]);
                    findSolutionDynamic(C[i]);
                    return;

                }
                else{
                    findSolutionDynamic(i-1);
                    return;
                }

            }
            if (C[i] == -1){
                if (assignmentArray[i].getWeight() >= max[i - 1]) {
                    System.out.println("Adding " + assignmentArray[i].toString() + " to the dynamic schedule");
                    solutionDynamic.add(assignmentArray[i]);

                    //findSolutionDynamic(C[i]);
                    return;
                }
                else{
                    findSolutionDynamic(i-1);
                    return;
                }
            }

        }


        if (i>=0){
            if (C[i] != -1) {
                if (assignmentArray[i].getWeight() + max[C[i]] >= max[i - 1]) {
                    //System.out.println(i);

                    findSolutionDynamic(C[i]);

                }
            }
            if (C[i] == -1){
                if (assignmentArray[i].getWeight() >= max[i - 1]) {
                    //System.out.println(i);

                    findSolutionDynamic(C[i]);
                }
            }
            else {
                findSolutionDynamic(i-1);
                //System.out.println(i);
            }
        }

    }

    /**
     * {@link #max} must be filled after calling this method
     */
    private Double calculateMax(int i) {


        if (i == 0) {
            System.out.println("calculateMax(" + i +"): Zero");
            max[i] = assignmentArray[i].getWeight();
            return max[i];
        }
        else {
            if (max[i] == 0.0){
                System.out.println("calculateMax(" + i +"): Prepare");
                if (C[i] == -1){
                    Double case3 = assignmentArray[i].getWeight();
                    Double case4 = calculateMax(i-1);
                    if(case3 >= case4){
                        max[i] = case3;
                        return max[i];
                    }
                    else{
                        max[i] = case4;
                        return max[i];
                    }

                }
                else {
                    Double case1 = assignmentArray[i].getWeight() + calculateMax(C[i]);
                    Double case2 = calculateMax(i-1);
                    if(case1 >= case2){

                        max[i] = case1;
                        return max[i];
                    }
                    else {
                        max[i] = case2;
                        return max[i];
                    }
                }
            }
            else{
                System.out.println("calculateMax(" + i +"): Present");
                return max[i];
            }


        }

    }

    /**
     * {@link #solutionGreedy} must be filled after calling this method
     * Uses {@link #assignmentArray} property
     *
     * @return Returns a list of scheduled assignments
     */
    public ArrayList<Assignment> scheduleGreedy() {
        int finish = 0; // finish time of previous task

        for (int i = 0; i< assignmentArray.length; i++) {
            String [] datas = assignmentArray[i].getStartTime().split(":");
            String [] datas1 = assignmentArray[i].getFinishTime().split(":");

            if (Integer.parseInt(datas[0])*60 + Integer.parseInt(datas[1]) >= finish) { // task i doesn’t conflict with previous?
                //append task i to S // ...add it to the schedule
                System.out.println("Adding " + assignmentArray[i].toString() + " to the greedy schedule");

                solutionGreedy.add(assignmentArray[i]);
                finish = Integer.parseInt(datas1[0])*60 + Integer.parseInt(datas1[1]); // ...and update the previous finish time
            }
        }
        solutionDynamic.sort(Assignment::compareTo);
        return solutionGreedy;
    }
}
