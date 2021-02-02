package TransportInfo;

//TODO: While loop for user input with start & stop stations?
public class TransportApp {
	public static void main(String[] args) {
		//Line[] lines = ConfigureLines.populateLines();
		//test case 1 user1 ID:1 Should take Tram Line 9
		TransportInfo Info = new TransportInfo();
		User user1 = new User(1, "Korsvägen", "Masthugget");
		user1.showPlan();
//		Stop[] route1 = TransportInfo.calculateRoute(user1.startPoint, user1.stopPoint);
		Stop[] route1 = Info.calculateRoute(user1.startPoint, user1.stopPoint);
//		Info.printRoute(route1);
		//test case 2 user1 ID:2 Should take Tram Line 3
		User user2 = new User(2, "Marklandsgatan", "Virginsgatan");
		user2.showPlan();
//		Stop[] route2 = TransportInfo.calculateRoute(user2.startPoint, user2.stopPoint);
		Stop[] route2 = Info.calculateRoute(user2.startPoint, user2.stopPoint);
		Info.printRoute(route2);
	}
}
