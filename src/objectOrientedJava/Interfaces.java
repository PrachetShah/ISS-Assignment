package objectOrientedJava;

// Extending Multiple Java Interfaces

interface Sports {
	public void setHomeTeam(String name);
	public void setVisitingTeam(String name);
}

interface Football extends Sports {
	public void homeTeamScored(int points);
	public void visitingTeamScored(int points);
	public void endOfQuarter(int quarter);
}

interface Hockey extends Sports {
	public void homeGoalScored();
	public void visitingGoalScored();
	public void endOfPeriod(int period);
	public void overtimePeriod(int ot);
}

interface Event {
	public void organize();
}
public class Interfaces implements Hockey, Event {
	String homeTeam;
	public void setHomeTeam(String name) {
		this.homeTeam = name;
	}
	
	public String getHomeTeam(){
		return homeTeam;
	}

	public void setVisitingTeam(String name) {}

	public void homeGoalScored() {}

	public void visitingGoalScored() {}

	public void endOfPeriod(int period) {}

	public void overtimePeriod(int ot) {}

	public static void main(String[] args) {
		Interfaces hockeyDemo = new Interfaces();
		hockeyDemo.setHomeTeam("India");
		hockeyDemo.organize();
		System.out.println("Home Team is: " + hockeyDemo.getHomeTeam());
	}

	public void organize() {
		System.out.println("Match organized. ");
		
	}
}
