package transportInfo;
import  transportInfo.ConfigureLines;

public class Line {
	//Should be in Class TransportInfo?
	public enum TransportType {TRAM, FERRY};
	public final int maxStops = 15;
		
	private int lineid;
	private TransportType type;
	private String endstop1;
	private String endstop2;
	private static Stop[] allStops;
	
	// Constructor
	public Line(int lineid, TransportType type, String[] stops) {
		this.lineid = lineid;
		this.type = type;
		this.endstop1 = stops[0];
		this.endstop2 = stops[1];
	}
	/**
	 * @return the lineid
	 */
	public int getLineNo() {
		return lineid;
	}
	/**
	 * @return the type
	 */
	public TransportType getType() {
		return type;
	}
	/**
	 * @return the start
	 */
	public String getEndstop1() {
		return endstop1;
	}
	/**
	 * @return the stop
	 */
	public String getEndstop2() {
		return endstop2;
	}
	/**
	 * @param allStops the allStops to set
	 */
	public void setAllStops(Stop[] allStops) {
		this.allStops = allStops;
	}

	public static Boolean ifStationIncluded(Stop somestop) {
		for(int i=0;i<allStops.length;i++) {
			if(somestop.getStopName()==allStops[i].getStopName()) {
				return true;
			}
		}
		return false;
	}
}
