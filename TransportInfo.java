
/**
 * @author blomg
 */
package transportInfo;
import transportInfo.ConfigureLines;
import transportInfo.Line;
import transportInfo.User;

public class TransportInfo {

	public static int MAX_NUMBER_ROUTES = 5;
	
	private Line[] transportRoutes;
	private String userRoute[][];

	public TransportInfo(Line[] startStop) {
		startStop = transportRoutes;
	}

	public String[] calculateRoute(int id, String startPoint, String stopPoint) {
	
		Stop startStop = new Stop(startPoint,Stop.StopType.ORDINARY);
		Stop endStop = new Stop(stopPoint,Stop.StopType.ORDINARY);
		
		Boolean startIncluded = false;
		Boolean endIncluded = false;
		int k = 0;
		int j = 0;
		int LineStart[] = new int[MAX_NUMBER_ROUTES];
		int LineEnd[] = new int[MAX_NUMBER_ROUTES];
		
		for(int i=0;i<transportRoutes.length;i++) {	
			
		startIncluded = transportRoutes[i].ifStationIncluded(startStop);
		// ask kjell for static warning
		
			if(startIncluded) {
				LineStart[k++] = i;
			}
		}
		k = 0;
		/*** CHECKING FOR SINGLE BUSS? ***/
		for(int i=0;i<LineStart.length;i++) {
			endIncluded = transportRoutes[LineStart[k++]].ifStationIncluded(endStop);
			
			if(endIncluded) {
				LineEnd[j++] = i;
			}
		}
		
		for(int i=0;i<transportRoutes.length;i++) {
			
		}
		
//	Check for startPoint and stopPoint inside each line by calling object "Line"
//  Calculate if transfer needed ( are the stops on same line? Yes/No )		
		
	}

	public static void getUserRoute(User user) {
		String UserLine[] = calculateRoute(user.getId(),user.getStartPoint(),user.getStopPoint());
		
		
		// Print the calculated route here? or in main? or toString?
		
//		return UserLine;
	}

	public Line[] getTransportRoutes() {
		return transportRoutes;
	}

//	public String toString() {
//	
//	}
}