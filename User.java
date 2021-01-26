package linnfaa.java.basic.kravochdesign;

public class User {
	private long id;
	private String startPoint;
	private String stopPoint;
	
	// constructor
	public User(long id, String startPoint, String stopPoint)
	{
		this.id = id;
		this.startPoint = startPoint;
		this.stopPoint = stopPoint;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the startPoint
	 */
	public String getStartPoint() {
		return startPoint;
	}

	/**
	 * @return the stopPoint
	 */
	public String getStopPoint() {
		return stopPoint;
	}
	
	public void getUserRoute()
	{
		TransportInfo.getUserRoute(this.id, this.startPoint, this.stopPoint);
	}
	
//	public String toString()
//	{
//		
//	}
	
	public static void main(String[] args) {
		
		Line[] availableTransportLines = ConfigureLines.populateLines();
		
		TransportInfo theTransportInfo = new TransportInfo(availableTransportLines);
	}
	
}
