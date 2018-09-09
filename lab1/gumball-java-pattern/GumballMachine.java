

public class GumballMachine {
 
	State soldOutState;
	State noQuarterState;
	State hasQuarterState;
	State soldState;
	
	enum GumballMachineType {TYPEA, TYPEB, TYPEC}
    private GumballMachineType machineType;
 
	State state = soldOutState;
	int count = 0;
 
	public GumballMachine(int numberGumballs) {
		soldOutState = new SoldOutState(this);
		noQuarterState = new NoQuarterState(this);
		hasQuarterState = new HasQuarterState(this);
		soldState = new SoldState(this);

		this.count = numberGumballs;
 		if (numberGumballs > 0) {
			state = noQuarterState;
		} 
	}
 
	public void insertQuarter(Coins coin) {
		state.insertQuarter();
	}
 
	public void ejectQuarter() {
		state.ejectQuarter();
	}
 
	public void turnCrank() {
		state.turnCrank();
		state.dispense();
	}

	void setState(State state) {
		this.state = state;
	}
 
	void releaseBall() {
		System.out.println("A gumball comes rolling out the slot...");
		if (count != 0) {
			count = count - 1;
		}
	}
 
	int getCount() {
		return count;
	}
 
	void refill(int count) {
		this.count = count;
		state = noQuarterState;
	}

    public State getState() {
        return state;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }
 
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\nMighty Gumball, Inc.");
		result.append("\nJava-enabled Standing Gumball Model #2004");
		result.append("\nInventory: " + count + " gumball");
		if (count != 1) {
			result.append("s");
		}
		result.append("\n");
		result.append("Machine is " + state + "\n");
		return result.toString();
	}
	
	public boolean isValidQuarter(Coins coin)
	{
		setMachineType(coin);
		boolean isValidQuarter = false;
		if (( coin.getTotal() == 25 & machineType == GumballMachineType.TYPEA) ||
		        ( coin.getTotal() == 50 & (machineType == GumballMachineType.TYPEB || machineType == GumballMachineType.TYPEC)))
			isValidQuarter =  true;
		return isValidQuarter;
	}
	
	public void setMachineType(Coins coin)
    {
    	if(coin.getInsert_quarter()>0)
        	machineType = GumballMachineType.TYPEA;
        else if(coin.getInsert_firstQuarter()>0 || coin.getInsert_secondQuarter()>0)
        	machineType = GumballMachineType.TYPEB;
        else
        	machineType = GumballMachineType.TYPEC;
    }
}
