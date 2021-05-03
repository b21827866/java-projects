import java.util.Arrays;

public class Assignment implements Comparable {
    private String name;
    private String start;
    private int duration;
    private int importance;
    private boolean maellard;



    /*
            Getter methods
         */
    public String getName() { return name; }

    public String getStartTime() {
        return start;
    }

    public int getDuration() {
        return duration;
    }

    public int getImportance() {
        return importance;
    }

    public boolean isMaellard() {
        return maellard;
    }

    /**
     * Finish time should be calculated here
     *
     * @return calculated finish time as String
     */
    public String getFinishTime() {
        String [] datas = getStartTime().split(":");
        int finish = Integer.parseInt(datas[0]) + getDuration();
        if (finish < 10 ){
            return "0"+ String.valueOf(finish) + ":" + datas[1] ;
        }
        else {
            return String.valueOf(finish) + ":" + datas[1];
        }
    }

    /**
     * Weight calculation should be performed here
     *
     * @return calculated weight
     */
    public double getWeight() {
        double weight;
        Double importance= new Double(getImportance());
        Double duration= new Double(getDuration());

        if (isMaellard() == true){
            weight = importance*1001/duration;
        }
        else {
            weight = importance*1/duration;
        }

        return weight;
    }

    /**
     * This method is needed to use {@link java.util.Arrays#sort(Object[])} ()}, which sorts the given array easily
     *
     * @param o Object to compare to
     * @return If self > object, return > 0 (e.g. 1)
     * If self == object, return 0
     * If self < object, return < 0 (e.g. -1)
     */
    @Override
    public int compareTo(Object o) {
        Assignment a = (Assignment) o;
        String [] datas =getFinishTime().split(":");
        String [] datas1 =a.getFinishTime().split(":");
        return (Integer.parseInt(datas[0])*60 + Integer.parseInt(datas[1])) - (Integer.parseInt(datas1[0])*60 + Integer.parseInt(datas1[1]));

    }

    /**
     * @return Should return a string in the following form:
     * Assignment{name='Refill vending machines', start='12:00', duration=1, importance=45, maellard=false, finish='13:00', weight=45.0}
     */
    @Override
    public String toString() {

        return "Assignment{name='"+ getName()+ "', start='" + getStartTime()+"', duration="+ getDuration()+", importance="+ getImportance()+ ", maellard=" + isMaellard()+ ", finish='"+ getFinishTime()+"', weight="+ getWeight() +"}";
    }
}

