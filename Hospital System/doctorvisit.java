
public class doctorvisit extends Decorator{

	public doctorvisit(IExamination newIExamination) {
		super(newIExamination);
		// TODO Auto-generated constructor stub
	}
	public String getDescription() {
		return examination.getDescription() + " doctorvisit";
		
	}
	public int getCost() {
		return examination.getCost() + 15;
		
	}
}
