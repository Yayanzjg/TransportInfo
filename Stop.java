package yang.java.basic;

public class Stop {
	public enum StopType{ENDSTOP,ORDINARY,CHANGE};

	private String stopName;
	private StopType type;
	
	public Stop(String stopName, StopType type) {
		this.stopName = stopName;
		this.type = type;
	}

	/**
	 * @return the stopName
	 */
	public String getStopName() {
		return this.stopName;
	}

}
