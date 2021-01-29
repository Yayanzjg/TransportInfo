
/**
 * @author blomg
 */
package transportInfo;
import transportInfo.ConfigureLines;
import transportInfo.Line;
import transportInfo.User;

public class TransportInfo {

	private Line[] transportRoutes;
	private String userRoute[][];

	public TransportInfo(Line[] startStop) {
		startStop = transportRoutes;
	}

	public String[] calculateRoute(int id, String startPoint, String stopPoint) {
	
		Stop startStop = new Stop(startPoint,Stop.StopType.ORDINARY);
		Stop endStop = new Stop(stopPoint,Stop.StopType.ORDINARY);
		
		Boolean startIncluded = Line.ifStationIncluded(startStop);
		Boolean endIncluded = Line.ifStationIncluded(endStop);
		
//	Check for startPoint and stopPoint inside each line by calling object "Line"
//  Calculate if transfer needed ( are the stops on same line? Yes/No )		
		
	}

	public Line[][] getUserRoute(User user) {
		String UserLine[] = calculateRoute(user.getId(),user.getStartPoint(),user.getStopPoint());
		
		return UserLine;
	}

	public Line[][] getTransportRoute() {
		
	}

//	public String toString() {
//	
//	}
}