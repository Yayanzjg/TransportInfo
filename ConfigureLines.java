package yang.java.basic;
import java.sql.Time;

//import javax.sound.sampled.Line;

//import yang.java.basic.Line;
import yang.java.basic.Line.TransportType;
import yang.java.basic.Stop.StopType;

/**
 * A helper class configuring some of the TransportInfo system This class is
 * mainly created to support system development and testing Proper configuration
 * will be done using a data base resource at system deployment
 */
public class ConfigureLines {

	/**
	 * This method is used to configure the Line objects in a Public Transport
	 * System In a future version this information will probably originate from a
	 * file or a database The Stop objects are ordered in "normal route", but the
	 * reverse order will apply for returning routes
	 * 
	 * @return a Line[] defining all lines supported by the system
	 */
	public static Line[] populateLines() {

		Line[] allLines = { new Line(3, TransportType.TRAM, new String[] { "Kålltorp", "Marklandsgatan" }),
				new Line(5, TransportType.TRAM, new String[] { "Länsmansgården", "Östra Sjukhuset" }),
				new Line(9, TransportType.TRAM, new String[] { "Angered", "Kungsten" }),
				new Line(11, TransportType.TRAM, new String[] { "Bergsjön", "Saltholmen" }),
				new Line(285, TransportType.FERRY, new String[] { "Lilla Bommen", "Klippan" }) };

		for (int i = 0; i < allLines.length; i++) {

			Line currentLine = allLines[i];

			switch (currentLine.getLineNo()) {
			case 3:
				Stop[] stopListLine3 = { new Stop("Virginsgatan", StopType.ENDSTOP),
						new Stop("Redbergsplatsen", StopType.ORDINARY), new Stop("Centralstationen", StopType.CHANGE),
						new Stop("Brunnsparken", StopType.CHANGE), new Stop("Järntorget", StopType.CHANGE),
						new Stop("Masthuggstorget", StopType.ORDINARY),
						new Stop("Vagnhallen Majorna", StopType.ORDINARY),
						new Stop("Marklandsgatan", StopType.ENDSTOP), };
				currentLine.setAllStops(stopListLine3);
				break;

			case 5:
				Stop[] stopListLine5 = { new Stop("Varmfrontsgatan", StopType.ENDSTOP),
						new Stop("Eketrägatan", StopType.ORDINARY), new Stop("Lilla Bommen", StopType.CHANGE),
						new Stop("Brunnsparken", StopType.CHANGE), new Stop("Valand", StopType.ORDINARY),
						new Stop("Korsvägen", StopType.CHANGE), new Stop("Liseberg", StopType.ORDINARY),
						new Stop("Östra Sjukhuset", StopType.ENDSTOP) };
				currentLine.setAllStops(stopListLine5);
				break;

			case 9:
				Stop[] stopListLine9 = { new Stop("Angered", StopType.ENDSTOP),
						new Stop("Hammarkullen", StopType.ORDINARY), new Stop("Centralstationen", StopType.CHANGE),
						new Stop("Brunnsparken", StopType.CHANGE), new Stop("Stenpiren", StopType.CHANGE),
						new Stop("Järntorget", StopType.CHANGE), new Stop("Masthuggstorget", StopType.ORDINARY),
						new Stop("Kungsten", StopType.ENDSTOP) };
				currentLine.setAllStops(stopListLine9);
				break;

			case 11:
				Stop[] stopListLine11 = { new Stop("Komettorget", StopType.ENDSTOP),
						new Stop("Kviberg", StopType.ORDINARY), new Stop("Gamlestads Torg", StopType.CHANGE),
						new Stop("Centralstationen", StopType.CHANGE), new Stop("Brunnsparken", StopType.CHANGE),
						new Stop("Järntorget", StopType.CHANGE), new Stop("Masthuggstorget", StopType.ORDINARY),
						new Stop("Mariaplan", StopType.ORDINARY), new Stop("Kungsten", StopType.ORDINARY),
						new Stop("Saltholmen", StopType.ENDSTOP), };
				currentLine.setAllStops(stopListLine11);
				break;

			case 285:
				Stop[] stopListLine285 = { new Stop("Lilla Bommen", StopType.CHANGE),
						new Stop("Stenpiren", StopType.CHANGE), new Stop("Lindholmspiren", StopType.ORDINARY),
						new Stop("Slottsberget", StopType.ORDINARY), new Stop("Eriksberg", StopType.ORDINARY),
						new Stop("Klippan", StopType.ENDSTOP) };
				currentLine.setAllStops(stopListLine285);
				break;
			default:
				System.out.format("Line no %d not yet supported!", i);
			}
		}
		return allLines;
	}

	/**
	 * This method will set up the time tables for some selected lines NB! There are
	 * 2 sets of info for each line defining two-way traffic
	 * 
	 * @param oneLine a Line to be serviced
	 * @return a 3-dim Time array for complete time tables for both directions Index
	 *         0 - Defines direction for Stops along the Line 0-normal order,
	 *         1-reversed order Index 1 - Defines full Time schedule Stop by Stop
	 *         for one vehicle in traffic starting at first Time, ending at last
	 *         Time Index 2 - Defines a Time (hour, min) at a specific Stop
	 */
//	public static Time[][][] setUpTimeTable(Line oneLine) {
//
//		int lineNo = oneLine.getLineNo();
//
//		Time[][][] timeTable = null;
//
//		switch (lineNo) {
//
//		case 3:
//			timeTable = new Time[][][] {
//					// normal route
//					{
//							// scheduled departure from every stop along the line first vehicle
//							{ new Time(9, 25), new Time(9, 31), new Time(9, 39), new Time(9, 41), new Time(9, 51),
//									new Time(9, 53), new Time(10, 0), new Time(10, 10) },
//							// scheduled departure from every stop along the line second vehicle
//							{ new Time(10, 25), new Time(10, 31), new Time(10, 39), new Time(10, 41), new Time(10, 51),
//									new Time(10, 53), new Time(11, 0), new Time(11, 10) } },
//					// reverse route
//					{
//							// scheduled departure from every stop along the line first vehicle
//							{ new Time(9, 14), new Time(9, 22), new Time(9, 30), new Time(9, 32), new Time(9, 43),
//									new Time(9, 45), new Time(9, 53), new Time(9, 59) },
//							// scheduled departure from every stop along the line second vehicle
//							{ new Time(10, 14), new Time(10, 22), new Time(10, 30), new Time(10, 32), new Time(10, 43),
//									new Time(10, 45), new Time(10, 53), new Time(10, 59) } } };
//
//			break;
//
//		case 5:
//			timeTable = new Time[][][] {
//					{ { new Time(9, 35), new Time(9, 41), new Time(9, 51), new Time(9, 53), new Time(9, 57),
//							new Time(10, 0), new Time(10, 2), new Time(10, 16) },
//							{ new Time(10, 35), new Time(10, 41), new Time(10, 51), new Time(10, 53), new Time(10, 57),
//									new Time(11, 0), new Time(11, 2), new Time(11, 16) } },
//					{ { new Time(9, 30), new Time(9, 46), new Time(9, 48), new Time(9, 51), new Time(9, 55),
//							new Time(9, 57), new Time(10, 6), new Time(10, 15) },
//							{ new Time(10, 30), new Time(10, 46), new Time(10, 48), new Time(10, 51), new Time(10, 55),
//									new Time(10, 57), new Time(11, 6), new Time(11, 15) } } };
//			break;
//
//		case 9:
//			timeTable = new Time[][][] {
//					{ { new Time(9, 35), new Time(9, 41), new Time(9, 51), new Time(9, 53), new Time(9, 57),
//							new Time(10, 0), new Time(10, 2), new Time(10, 16) },
//							{ new Time(10, 35), new Time(10, 41), new Time(10, 51), new Time(10, 53), new Time(10, 57),
//									new Time(11, 0), new Time(11, 2), new Time(11, 16) } },
//					{ { new Time(9, 30), new Time(9, 46), new Time(9, 48), new Time(9, 51), new Time(9, 55),
//							new Time(9, 57), new Time(10, 6), new Time(10, 15) },
//							{ new Time(10, 30), new Time(10, 46), new Time(10, 48), new Time(10, 51), new Time(10, 55),
//									new Time(10, 57), new Time(11, 6), new Time(11, 15) } } };
//			break;
//
//		case 11:
//			timeTable = new Time[][][] {
//					{ { new Time(8, 42), new Time(8, 55), new Time(9, 0), new Time(9, 5), new Time(9, 7),
//							new Time(9, 15), new Time(9, 17), new Time(9, 25), new Time(9, 29), new Time(9, 39) },
//							{ new Time(9, 42), new Time(9, 55), new Time(10, 0), new Time(10, 5), new Time(10, 7),
//									new Time(10, 15), new Time(10, 17), new Time(10, 25), new Time(10, 29),
//									new Time(10, 39) } },
//					{ { new Time(9, 15), new Time(9, 25), new Time(9, 29), new Time(9, 38), new Time(9, 40),
//							new Time(9, 49), new Time(9, 51), new Time(9, 59), new Time(10, 01), new Time(10, 14) },
//							{ new Time(10, 15), new Time(10, 25), new Time(10, 29), new Time(10, 38), new Time(10, 40),
//									new Time(10, 49), new Time(10, 51), new Time(10, 59), new Time(11, 01),
//									new Time(11, 14) } } };
//			break;
//
//		case 285:
//			timeTable = new Time[][][] {
//					{ { new Time(9, 0), new Time(9, 6), new Time(9, 12), new Time(9, 17), new Time(9, 22),
//							new Time(9, 27) },
//							{ new Time(10, 0), new Time(10, 6), new Time(10, 12), new Time(10, 17), new Time(10, 22),
//									new Time(10, 27) } },
//					{ { new Time(8, 50), new Time(8, 55), new Time(9, 0), new Time(9, 6), new Time(9, 12),
//							new Time(9, 17) },
//
//							{ new Time(10, 0), new Time(10, 5), new Time(10, 10), new Time(10, 16), new Time(10, 22),
//									new Time(10, 27) } } };
//			break;
//
//		default:
//			System.out.format("Line no %d not yet supported!", lineNo);
//		}
//
//		return timeTable;
//	}
}