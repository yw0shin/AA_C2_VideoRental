import java.util.Date;

public class Rental {
	private Video video ;
	private int status ; // 0 for Rented, 1 for Returned
	//Refactoring (상수로 정의)
	public static final int RENDTED = 0 ;
	public static final int RETURNED = 1 ;
	
	public static final int DEFAULT_POINT = 1 ;
	public static final int NEW_RELEASE_POINT = 2 ;
	
	
	private Date rentDate ;
	private Date returnDate ;

	public Rental(Video video) {
		this.video = video ;
		status = RENDTED ; 	//Refactoring (상수로 정의)
		rentDate = new Date() ;
	}

	public Video getVideo() {
		return video;
	}


	public void setVideo(Video video) {
		this.video = video;
	}

	public int getStatus() {
		return status;
	}

	public void returnVideo() {
		if ( status == RENDTED ) {	//Refactoring (상수로 정의)
			this.status = RETURNED;
			returnDate = new Date() ;
		}
	}
	public Date getRentDate() {
		return rentDate;
	}

	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}


	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
	

	public int getDaysRentedLimit() {
		//int limit = 0 ; //refactoring 
		long diff =0 ;
		int daysRented ;
		daysRented = getDaysRented();
		
		if ( daysRented <= 2) return 0 ;
		else return video.getRentLimit();

//@refactoring : using polymorphism		
//		switch ( video.getVideoType() ) {
//			case Video.VHS: limit = 5 ; break ;
//			case Video.CD: limit = 3 ; break ;
//			case Video.DVD: limit = 2 ; break ;
//		}
		
	}

	//@refactoring
	public int getDaysRented() {
		long diff;
		int daysRented;
		if (getStatus() == RETURNED) { // returned Video (Refactoring)
			diff = returnDate.getTime() - rentDate.getTime();
		} else { // not yet returned
			diff = new Date().getTime() - rentDate.getTime();
		}
		daysRented = (int) (diff / (1000 * 60 * 60 * 24)) + 1; //refactoring : 공통 부분 빼냄 
		return daysRented;
	}
	
	//@refactroing 
	public int getRentalCharge() {
		int rentalCharge = 0;
		int daysRented = this.getDaysRented();
		
		
		//video ismethod 
		switch (this.getVideo().getPriceCode()) {
		case Video.REGULAR:
			rentalCharge += 2;
			if (daysRented > 2)
				rentalCharge += (daysRented - 2) * 1.5;
			break;
		case Video.NEW_RELEASE:
			rentalCharge = daysRented * 3;
			break;
		}
		
		return rentalCharge;
	}
	
	//@refactoring 
	public int getRentalPoint() {
		int rentalPoint;
		
		if ((this.getVideo().getPriceCode() == Video.NEW_RELEASE) )
			rentalPoint = NEW_RELEASE_POINT;
		else rentalPoint = DEFAULT_POINT; 
		
		if ( this.getDaysRented() > this.getDaysRentedLimit() )
			rentalPoint -= Math.min(rentalPoint, this.getVideo().getLateReturnPointPenalty()) ;
		
		return rentalPoint;
	}
	
}
