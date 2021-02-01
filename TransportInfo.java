package TransportInfo;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Transportinfo {
	public static Stop[] calculateRoute(String startPoint,String stopPoint) {
		Stop[] route = {};
		Line[] allLines = ConfigureLines.populateLines();
		// to find out which line includes startpoint and stoppoint
		for(int i=0;i<allLines.length;i++) {
			//i=0 allLines[0] Line 3
			Line currentLine = allLines[i];
			Boolean startIncluded = currentLine.ifStopInLine(currentLine,startPoint);
			Boolean stopIncluded = currentLine.ifStopInLine(currentLine,stopPoint);

			if(startIncluded==true && stopIncluded==true) {
				System.out.println("You can take Line "+currentLine.getLineNo());
				int startIndex = currentLine.stopIndex(currentLine, startPoint);
				int stopIndex = currentLine.stopIndex(currentLine, stopPoint);
				if(startIndex<stopIndex) {
					route = Arrays.copyOfRange(currentLine.getAllStops(),startIndex,stopIndex+1);
				}
				else {
					List <Stop> list = Arrays.asList(currentLine.getAllStops());
					Collections.reverse(list); 
					Stop[] temp = list.toArray(new Stop[list.size()]);
					route = Arrays.copyOfRange(temp,stopIndex,startIndex+1);
				}
			}
			else {
				// TODO: if not a direct trip.
			}
		}	
		return route;
	}

	public static void printRoute(Stop[] stoparray) {
		System.out.println("The stops you will pass are:");
		for(int i=0;i<stoparray.length-1;i++) {
			System.out.print(stoparray[i].toString()+"-> ");
		}
		System.out.print(stoparray[stoparray.length-1].toString()+'\n');
	}
}