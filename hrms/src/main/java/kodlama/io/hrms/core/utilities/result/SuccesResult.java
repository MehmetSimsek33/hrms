package kodlama.io.hrms.core.utilities.result;

public class SuccesResult extends Result {

	
	
	public SuccesResult() 
	{
		super(true);
	}


	public SuccesResult(String message) 
	{
		super(true,message);
		
	}

}
