import java.util.Date;

//VHS를 subclassing함으로써 Polymorphism 이용하기 위함
//getLateReturnPointPenalty,  getRentLimit를 polymorphism으로 반영
public class VHS extends Video{
	private int penalty = 1;
	private final int RENT_LIMT = 5;

	public VHS(String title, int videoType, int priceCode, Date registeredDate) {
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
