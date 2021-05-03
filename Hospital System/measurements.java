
public class measurements extends Decorator{

	public measurements(IExamination newIExamination) {
		super(newIExamination);
		// TODO Auto-generated constructor stub
	}
	public String getDescription() {
		return examination.getDescription() + " measurements";
		
	}
	public int getCost() {
		return examination.getCost() + 5;
		
	}
}
