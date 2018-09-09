
public class Coins {
	private int insert_quarter;
    private int insert_firstQuarter;
    private int insert_secondQuarter;
	private int nickles;
	private int dimes;
	private int quarters;
	private int total;
	
	public Coins(int quarter) {
		this.insert_quarter = quarter;
		this.total = this.insert_quarter;
	}
	public Coins(int frstquarter, int scndqurter) {
		this.insert_firstQuarter = frstquarter;
		this.insert_secondQuarter = scndqurter;
		this.total = this.insert_firstQuarter + this.insert_secondQuarter;
	}
	public Coins(int nickles, int dimes, int quarters) {
		super();
		this.nickles = nickles;
		this.dimes = dimes;
		this.quarters = quarters;
		this.total = 10* this.dimes + 5* this.nickles + this.quarters;
	}
	
	public int getNickles() {
		return nickles;
	}
	public void setNickles(int nickles) {
		this.nickles = nickles;
	}
	public int getDimes() {
		return dimes;
	}
	public void setDimes(int dimes) {
		this.dimes = dimes;
	}
	public int getQuarters() {
		return quarters;
	}
	public void setQuarters(int quarters) {
		this.quarters = quarters;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getInsert_quarter() {
		return insert_quarter;
	}
	public void setInsert_quarter(int insert_quarter) {
		this.insert_quarter = insert_quarter;
	}
	public int getInsert_firstQuarter() {
		return insert_firstQuarter;
	}
	public void setInsert_firstQuarter(int insert_firstQuarter) {
		this.insert_firstQuarter = insert_firstQuarter;
	}
	public int getInsert_secondQuarter() {
		return insert_secondQuarter;
	}
	public void setInsert_secondQuarter(int insert_secondQuarter) {
		this.insert_secondQuarter = insert_secondQuarter;
	}
	
	
}
