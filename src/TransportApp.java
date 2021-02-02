package TransportInfo;

public class TransportApp {
	public static void main(String[] args) {
		//Line[] lines = ConfigureLines.populateLines();
		//test case 1 user1 ID:1 Should take Tram Line 9
		User user1 = new User(1, "Hammarkullen", "Kungsten");
		user1.showPlan();
		Stop[] route1 = Transportinfo.calculateRoute(user1.startPoint, user1.stopPoint);
		Transportinfo.printRoute(route1);
		//test case 2 user1 ID:2 Should take Tram Line 3
		User user2 = new User(2, "Marklandsgatan", "Virginsgatan");
		user2.showPlan();
		Stop[] route2 = Transportinfo.calculateRoute(user2.startPoint, user2.stopPoint);
		Transportinfo.printRoute(route2);
	}
}
