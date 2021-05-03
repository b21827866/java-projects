
public class imaging extends Decorator{

	public imaging(IExamination newIExamination) {
		super(newIExamination);
		// TODO Auto-generated constructor stub
	}
	public String getDescription() {
		return examination.getDescription() + " imaging";
		
	}
	public int getCost() {
		return examination.getCost() + 10;
		
	}
}
