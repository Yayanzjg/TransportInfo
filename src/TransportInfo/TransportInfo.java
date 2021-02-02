package TransportInfo;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TransportInfo {
	// Include Line[] allLines = ConfigureLines.populateLines();

	Line[] allLines;
	//	Stop[] route;

	public TransportInfo() {	
		this.allLines = ConfigureLines.populateLines();
		//		this.route = new stop[]; 
	}

	public Stop[] calculateRoute(String startPoint,String stopPoint) {
		// to find out which line includes startpoint and stoppoint
		Stop[] route = null;
		Line currentLine;
		int[] stopPosition = new int[] {-1,-1,-1,-1,-1};
		int[] startPosition = new int[]{-1,-1,-1,-1,-1};
		int k = 0, j =0;



		Boolean FoundOneLine = false;
		for(int i=0;!FoundOneLine && i<allLines.length;i++) {
			//i=0 allLines[0] Line 3
			currentLine = allLines[i];
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
				FoundOneLine = true;
			}
			else {
				// TODO: if not a direct trip.
				if(startIncluded && k<5) {
					startPosition[k++] = i;	
				} else if (stopIncluded && j<5) {
					stopPosition[j++] = i;					
				}				
			}
		}

		if(!FoundOneLine) {
			route = findTransferRoute(startPosition,stopPosition,startPoint,stopPoint);
		}

		return route;
	}

	private Stop[] findTransferRoute(int[] startPosition,int[] stopPosition,String startPoint, String stopPoint) {
		Stop[] route = null;

		// Find a stop with CHANGE type
		// Look for same stop in the next stop lines
		Boolean foundRoute = false;
		Stop transferStop = null;
		Line startLine = null;
		Line stopLine = null;
		for(int i=0;i<startPosition.length && !foundRoute;i++) {
			if(startPosition[i]>=0) {
				startLine = allLines[startPosition[i]];
				Stop[] startStops = startLine.getAllStops();
				for(int j=0;j<startStops.length && !foundRoute;j++) {
					transferStop = startStops[j];
					for(int k=0;k<stopPosition.length && !foundRoute;k++) {
						if(stopPosition[k]>=0) {
							stopLine = allLines[stopPosition[k]];
							if(stopLine.ifStopInLine(stopLine, transferStop.getStopName())) {
								// Could be saved as a Line array to save multiple routes for user to take
								foundRoute = true;
							}
						}
					}
				}
			}
		}
		// Take first half of start Line
		route = calcTransferRoute(startLine,stopLine,transferStop,startPoint,stopPoint);

		// take last half of stop line
		// Add them to route
		return route;
	}
	
	private Stop[] calcTransferRoute(Line startLine, Line stopLine, Stop transferStop,String startPoint, String stopPoint) {
		
		
		Stop[] route1;
		Stop[] route2;
		
		int startIndex = startLine.stopIndex(startLine, startPoint);
		int stopIndex = startLine.stopIndex(startLine, transferStop.getStopName());
		
		System.out.format("Take line no %d",startLine.getLineNo());
		if(startIndex<stopIndex) {
			route1 = Arrays.copyOfRange(startLine.getAllStops(),startIndex,stopIndex+1);
			System.out.format(" towards %s \n",startLine.getEndstop2());
		}
		else {
			System.out.format(" towards %s \n",startLine.getEndstop1());
			List <Stop> list = Arrays.asList(startLine.getAllStops());
			Collections.reverse(list); 
			Stop[] temp = list.toArray(new Stop[list.size()]);
			stopIndex = startLine.stopIndex(startLine, transferStop.getStopName());
			startIndex = startLine.stopIndex(startLine, startPoint);
			route1 = Arrays.copyOfRange(temp,startIndex,stopIndex+1);
		}
		printRoute(route1);

		 startIndex = stopLine.stopIndex(stopLine, transferStop.getStopName());
		 stopIndex = stopLine.stopIndex(stopLine, stopPoint);
		 
		 System.out.format("Change to line no %d",stopLine.getLineNo());
		if(startIndex<stopIndex) {
			route2 = Arrays.copyOfRange(stopLine.getAllStops(),startIndex,stopIndex+1);
			System.out.format(" towards %s \n",stopLine.getEndstop2());
			
		}
		else {
			System.out.format(" towards %s \n",stopLine.getEndstop1());
			List <Stop> list = Arrays.asList(stopLine.getAllStops());
			Collections.reverse(list); 
			Stop[] temp = list.toArray(new Stop[list.size()]);
			stopIndex = startLine.stopIndex(startLine, transferStop.getStopName());
			startIndex = startLine.stopIndex(startLine, startPoint);
			route2 = Arrays.copyOfRange(temp,startIndex,stopIndex+1);
		}
		printRoute(route2);

		Stop[] route = new Stop[route1.length + route2.length];
		
		System.arraycopy(route1, 0, route, 0, route1.length);
		System.arraycopy(route2, 0, route, route1.length, route2.length);
		
//		System.out.format("Take Line no %d to %s switch to line no %d \n"
//				,startLine.getLineNo(),transferStop.getStopName(),stopLine.getLineNo());
//		

		return route;
	}

	public void printRoute(Stop[] stoparray) {
		System.out.println("The stops you will pass are:");
		for(int i=0;i<stoparray.length-1;i++) {
			System.out.print(stoparray[i].toString()+"-> ");
		}
		System.out.print(stoparray[stoparray.length-1].toString()+'\n');
	}
}