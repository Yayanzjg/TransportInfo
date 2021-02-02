package TransportInfo;


class Line {
	public enum TransportType {TRAM, FERRY};
		
	private int lineId;
	private TransportType type;
	private String endstop1;
	private String endstop2;
	private Stop[] allStops;
	
	// Constructor
	public Line(int lineid, TransportType type, String[] stops) {
		this.lineId = lineid;
		this.type = type;
		this.endstop1 = stops[0];
		this.endstop2 = stops[1];
	}
	/**
	 * @return the lineId
	 */
	public int getLineNo() {
		return lineId;
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
	/**
	 * @return the allStops
	 */
	public Stop[] getAllStops() {
		return allStops;
	}
	@Override
	public String toString() {
		return String.format("Line [lineid=%d, type=%s, endstop1=%s, endstop2=%s]",lineId, type,
				endstop1, endstop2);
	}
	// to check if stop is in some line
	// input: Line someLine - the line to check
	// 		  String stopname - the name of the stop to check
	// output: true-included
	//		   false-not included
	public Boolean ifStopInLine(Line someLine, String stopname) {
		for(int i=0;i<someLine.allStops.length;i++) {
			if(stopname==someLine.allStops[i].getStopName()) {
				return true;
			}
		}
		return false;
	}
	// return the index of stop in some line
	// output: index of stop if found; -1 if not.
	public int stopIndex(Line someLine, String stopname) {
		for(int i=0;i<someLine.getAllStops().length;i++) {
			if(someLine.getAllStops()[i].getStopName()==stopname) {
				return i;
			}
		}
		return -1;
	}
}
