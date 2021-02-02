package TransportInfo;


public class User {
	private long id;
	String startPoint;
	String stopPoint;
	
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
	

	public void showPlan() {
		System.out.println(String.format("User %d plans to travel from %s to %s.", id, startPoint, stopPoint));
	}

}
