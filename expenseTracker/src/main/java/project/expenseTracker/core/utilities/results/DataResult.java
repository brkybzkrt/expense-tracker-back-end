package project.expenseTracker.core.utilities.results;

public class DataResult<T> extends Result{

	private T data;
	
	public DataResult(boolean success, T sendData) {
		
		super(success);
		this.data=sendData;
	}
	
	
	public DataResult(boolean success,T sendData,String message) {
		
		super(success,message);
		this.data=sendData;
	}
	
	
	public T getData() {
		
		return this.data;
	}
}
