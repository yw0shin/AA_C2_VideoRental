import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Customer {
	private String name;

	private List<Rental> rentals = new ArrayList<Rental>();

	public Customer(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Rental> getRentals() {
		return rentals;
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}
	
	public void clearRentals() {
		this.rentals.clear();
	}
		

	public String getReport() {
		String result = "Customer Report for " + getName() + "\n";

		List<Rental> rentals = getRentals();

		double totalCharge = 0;
		int totalPoint = 0;

		for (Rental each : rentals) {
			//SRP Violation ,long method, Feature Envy 위반하고 있으므로 Rental로 개별 Extract method시킨 상태
			
			result += "\t" + each.getVideo().getTitle() + "\tDays rented: " + each.getDaysRented() + "\tCharge: " + each.getRentalCharge()
					+ "\tPoint: " + each.getRentalPoint() + "\n";
			totalCharge += each.getRentalCharge();
			totalPoint += each.getRentalPoint() ;
		}

		result += "Total charge: " + totalCharge + "\tTotal Point:" + totalPoint + "\n";


		if ( totalPoint >= 10 ) {
			System.out.println("Congrat! You earned one free coupon");
		}
		if ( totalPoint >= 30 ) {
			System.out.println("Congrat! You earned two free coupon");
		}
		return result ;
	}
	
}
