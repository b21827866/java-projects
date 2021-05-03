
abstract class Decorator implements IExamination{
	protected IExamination examination;
	public Decorator(IExamination newIExamination) {
		examination = newIExamination;
		
	}
	
	public String getDescription() {
		return examination.getDescription();
		
	}
	public int getCost() {
		return examination.getCost();
		
	}
}
