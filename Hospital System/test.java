
public class test extends Decorator{

	public test(IExamination newIExamination) {
		super(newIExamination);
		// TODO Auto-generated constructor stub
	}
	public String getDescription() {
		return examination.getDescription() + " test";
		
	}
	public int getCost() {
		return examination.getCost() + 7;
		
	}
}
