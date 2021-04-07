import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Control {

	private List<Customer> customers = new ArrayList<Customer>() ;
	private List<Video> videos = new ArrayList<Video>() ;

	public List<Customer> listCustomers()
	{
		return customers;
	}

	public List<Video> listVideos()
	{
		return videos;
	}
	
	public void addCustomer(String name)
	{
		Customer customer = new Customer(name) ;
		customers.add(customer) ;
	}
	
	public void addVideo(String title, int videoType, int priceCode)
	{
		Date registeredDate = new Date();
		Video video = new Video(title, videoType, priceCode, registeredDate) ;
		videos.add(video) ;
	}
	
	public Customer findCustomer(String customerName)
	{
		Customer foundCustomer = null ;
		for ( Customer customer: customers ) {
			if ( customer.getName().equals(customerName)) {
				foundCustomer = customer ;
				break ;
			}
		}
		return foundCustomer;
	}
	
	public Video findVideo(String videoTitle) {
		Video foundVideo = null ;
		for ( Video video: videos ) {
			if ( video.getTitle().equals(videoTitle) && video.isRented() == false ) {
				foundVideo = video ;
				break ;
			}
		}
		return foundVideo;
	}
	
	public void rentVideo(Customer customer, Video video)
	{
		Rental rental = new Rental(video) ;
		video.setRented(true);

		customer.addRental(rental);
	}
	
	public void returnVideo(Customer customer, String videoTitle)
	{
		List<Rental> customerRentals = customer.getRentals() ;
		for ( Rental rental: customerRentals ) {
			Video video = rental.getVideo();
			if ( video.getTitle().equals(videoTitle) && video.isRented() ) {
				rental.returnVideo();
				video.setRented(false);
				break ;
			}
		}
	}
	
	public void clearRentals(Customer customer)
	{
		customer.clearRentals();
	}

	public void init() {
		Customer james = new Customer("James") ;
		Customer brown = new Customer("Brown") ;
		customers.add(james) ;
		customers.add(brown) ;

		Video v1 = VideoFactory.getInstance("v1", VideoFactory.CD, Video.REGULAR, new Date());
		Video v2 = VideoFactory.getInstance("v2", VideoFactory.DVD, Video.NEW_RELEASE, new Date());
		videos.add(v1) ;
		videos.add(v2) ;

		Rental r1 = new Rental(v1) ;
		Rental r2 = new Rental(v2) ;

		james.addRental(r1) ;
		james.addRental(r2) ;
	}
}
