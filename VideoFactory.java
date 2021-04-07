import java.util.Date;

public class VideoFactory {
	
	public static final int VHS = 1 ;
	public static final int CD = 2 ;
	public static final int DVD = 3 ;
	

	public static Video getInstance(String title, int videoType, int priceCode, Date registeredDate) {
		if(videoType == VHS) {
			return new VHS(title, videoType, priceCode, registeredDate);
		}
		else if(videoType==CD) {
			return new CD(title, videoType, priceCode, registeredDate);
		}
		else if(videoType==DVD) {
			return new DVD(title, videoType, priceCode, registeredDate);
		}
		else return new Video(title, videoType, priceCode, registeredDate);
	}

}
