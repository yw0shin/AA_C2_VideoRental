import java.util.Date;

//VHS�� subclassing�����ν� Polymorphism �̿��ϱ� ����
//getLateReturnPointPenalty,  getRentLimit�� polymorphism���� �ݿ�
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
