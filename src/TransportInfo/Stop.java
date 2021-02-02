package TransportInfo;

public class Stop {
	public enum StopType{ENDSTOP,ORDINARY,CHANGE};
	private String stopName;
	private StopType type;
	//constructor
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

	@Override
	public String toString() {
		return String.format("%s ", stopName, type);
	}

}
