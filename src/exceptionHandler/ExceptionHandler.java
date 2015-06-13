package exceptionHandler;

public class ExceptionHandler extends Exception {
	private static final long serialVersionUID = 1420672609912364060L;
	private int errorNum;
	private String errorMsg;
	
	public ExceptionHandler() {
		super();
		printmyproblem();
	}
	
	public ExceptionHandler(String errorMsg) {
		super();
		this.errorMsg = errorMsg;
		printmyproblem();
	}
	
	public ExceptionHandler(int errorNum) {
		super();
		this.errorNum = errorNum;
		printmyproblem();
	}
	
	public ExceptionHandler(int errorNum, String errorMsg) {
		super();
		this.errorNum = errorNum;
		this.errorMsg = errorMsg;
		printmyproblem();
	}
	
	public int getErrorNum() {
		return errorNum;
	}

	public void setErrorNum(int errorNum) {
		this.errorNum = errorNum;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	// Identify, set, and print out the error message
	public void printmyproblem() {
		switch(errorNum) {
		case 000:
			this.setErrorMsg("No Error");
			break;
		
		case 101:
			this.setErrorMsg("Missing Price for Automobile in Text File");
			break;
			
		case 202:
			this.setErrorMsg("Missing OptionSet data (or part of it)");
			break;
			
		case 303:
			this.setErrorMsg("Missing option data");
			break;
			
		case 404:
			this.setErrorMsg("Missing model name");
			break;
			
		case 505:
			this.setErrorMsg("No such file or directory");
			break;
			
		default:
			this.setErrorMsg("Error Not Found");
			break;
		}
		
		System.out.printf("FixProblems [Error Number = " + errorNum + ", Error Message = " + errorMsg + "]\n");
		
	}

	public String fixProblemReadFromConsole()
	{
		String a = "abc.txt";
		
		System.out.printf("Got here ---> Please Fix Problem Read From Console\n");
		return a;
	}
	
}