
public class Customer {

	private int clock;
	private int transactionTime;
	private int numberOfArrivals;

	public Customer(int clock, int transactionTime, int numberOfArrivals) {
		this.clock = clock;
		this.transactionTime = transactionTime;
		this.numberOfArrivals = numberOfArrivals;
	}

	public int getTransactionTime() {
		// TODO Auto-generated method stub
		return transactionTime;
	}

	public int getArrivalTime() {
		// TODO Auto-generated method stub
		return numberOfArrivals;
	}

	public int getClock() {
		// TODO Auto-generated method stub
		return clock;
	}

	public String getCustomerNumber() {
		// TODO Auto-generated method stub
		return null;
	}

}
