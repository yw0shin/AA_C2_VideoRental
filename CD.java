import java.util.Date;

public class CD extends Video {
	private int penalty = 2;
	private final int RENT_LIMT = 3;

	public CD(String title, int videoType, int priceCode, Date registeredDate) {
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
