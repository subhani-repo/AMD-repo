
public class ErrorDetails {
	
	private String description;
	private Throwable baseException;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Throwable getBaseException() {
		return baseException;
	}

	public void setBaseException(Throwable baseException) {
		this.baseException = baseException;
	}
}
