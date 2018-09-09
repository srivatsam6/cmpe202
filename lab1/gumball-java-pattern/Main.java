

public class Main {

	public static void main(String[] args) {
		GumballMachine gumballMachine = new GumballMachine(5);

		System.out.println(gumballMachine);

		gumballMachine.insertQuarter(new Coins(25) );//One quarter
		gumballMachine.turnCrank();

		System.out.println(gumballMachine);

		gumballMachine.insertQuarter(new Coins(25, 25));//Two quarters
		gumballMachine.turnCrank();
		gumballMachine.insertQuarter(new Coins(3, 1, 25));//3 nickles, 1 dime, 1 quarter
		gumballMachine.turnCrank();

		System.out.println(gumballMachine);
	}
}
