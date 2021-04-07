import java.util.Date;

public class DVD extends Video {
	private int penalty = 3;
	private final int RENT_LIMT = 2;

	public DVD(String title, int videoType, int priceCode, Date registeredDate) {
		super(title, videoType, priceCode, registeredDate);
	}
	
	@Override
	public int getLateReturnPointPenalty() {
		return this.penalty;
	}
	
	@Override
	public int getRentLimit() {
		return this.RENT_LIMT;
	}

}
