
/**
 * @author blomg
 */
package transportInfo;
import transportInfo.ConfigureLines;
import transportInfo.Line;

public class Transportinfo {

	private Line[] transportRoutes;
	private String userRoute[][];

	public Transportinfo(Line[] startStop) {
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
		String UserLine[] = calculateRoute(user.id,user.startPoint,user.stopPoint);
		
		return UserLine;
	}

	public Line[][] getTransportRoute() {
		
	}

//	public String toString() {
//	
//	}
}