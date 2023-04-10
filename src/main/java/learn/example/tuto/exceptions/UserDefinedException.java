package learn.example.tuto.exceptions;

public class UserDefinedException extends Exception{

	public UserDefinedException(String msg) {
		super(msg);
	}
	
	public UserDefinedException(String msg,Throwable t) {
		super(msg,t);
	}
}
