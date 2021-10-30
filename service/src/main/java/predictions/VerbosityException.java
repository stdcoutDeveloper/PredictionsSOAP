package predictions;

public class VerbosityException extends Exception {

	private static final long serialVersionUID = -4786508294943139666L;

	private String details;

	public VerbosityException(String reason, String details) {
		super(reason);
		this.details = details;
	}

	public String getFaultInfo() {
		return this.details;
	}
}