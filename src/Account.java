import java.util.Date;

public class Account {
	
	private int id;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated;
	
	public Account() {
		this.id = 0;
		this.balance = 0;
		this.annualInterestRate = 0;
		this.dateCreated = new Date();
	}
	
	public Account(int id, double balance) {
		super();
		this.id = id;
		this.balance = balance;
	}
	
	//Accessors
	public int getid() {
	      return id;
	}
	
	public double getbalance() {
		return balance;
	}
	
	public double getannualInterestRate() {
		return annualInterestRate;
	}
	
	public Date getdateCreated() {
		return dateCreated;
	}
	
	//Mutators
	public void setid(int id) {
		this.id = id;
	}
	
	public void setbalance(double balance) {
		this.balance = balance;
	}
	
	public void setannualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	
	public double getMonthlyInterestRate() {
		return (annualInterestRate / 12);
	}
	
	public void withdraw(double amount) throws InsufficientFundsException {
		if (amount > balance) {
			throw new InsufficientFundsException(balance - amount);
		}
		
		balance = balance - amount;
	}
	
	public void deposit(double amount) {
		balance = balance + amount;
	}
	
}
