package test;

public class InterfaceTest {
	public static void main(String args[]) {
		Animal2 m = new MammalInt();
		m.eat();
		m.travel();
	}
}

interface Animal2 {
	public void eat();

	public void travel();
}

class MammalInt implements Animal2 {

	public void eat() {
		System.out.println("Mammal eats");
	}

	public void travel() {
		System.out.println("Mammal travels");
	}

	public int noOfLegs() {
		return 0;
	}

}

interface Sports {
	public void setHomeTeam(String name);

	public void setVisitingTeam(String name);
}

// 文件名: Football.java
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

interface Hockey2 extends Football, Hockey {

}