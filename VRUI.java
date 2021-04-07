import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class VRUI {
	private static Scanner scanner = new Scanner(System.in) ;
	private Control ctrl = new Control();

	public static void main(String[] args) {
		VRUI ui = new VRUI() ;

		boolean quit = false ;
		while ( ! quit ) {
			int command = ui.showCommand() ;
			switch ( command ) {
				case 0: quit = true ; break ;
				case 1: ui.listCustomers() ; break ;
				case 2: ui.listVideos() ; break ;
				case 3: ui.registerCustomer() ; break ;
				case 4: ui.registerVideo() ; break ;
				case 5: ui.rentVideo() ; break ;
				case 6: ui.returnVideo() ; break ;
				case 7: ui.getCustomerReport() ; break;
				case 8: ui.clearRentals() ; break ;
				case -1: ui.init() ; break ;
				default: break ;
			}
		}
		System.out.println("Bye");
	}

	public void listCustomers() {
		System.out.println("List of customers");
		List<Customer> customers = ctrl.listCustomers();
		
		for ( Customer customer: customers ) {
			System.out.println("Name: " + customer.getName() +
					"\tRentals: " + customer.getRentals().size()) ;
			for ( Rental rental: customer.getRentals() ) {

				System.out.print("\tTitle: " + rental.getVideo().getTitle() + " ") ;
				System.out.print("\tPrice Code: " + rental.getVideo().getPriceCode()) ;
			}
		}
		System.out.println("End of list");
	}
	
	public void listVideos() {
		System.out.println("List of videos");
		List<Video> videos = ctrl.listVideos();

		for ( Video video: videos ) {
			System.out.println("Price code: " + video.getPriceCode() +"\tTitle: " + video.getTitle()) ;
		}
		System.out.println("End of list");
	}

	public void registerCustomer() {
		System.out.println("Enter customer name: ") ;
		String name = scanner.next();
		ctrl.addCustomer(name);
	}

	public void registerVideo() {
		System.out.println("Enter video title to register: ") ;
		String title = scanner.next() ;

		System.out.println("Enter video type( 1 for VHD, 2 for CD, 3 for DVD ):") ;
		int videoType = scanner.nextInt();

		System.out.println("Enter price code( 1 for Regular, 2 for New Release ):") ;
		int priceCode = scanner.nextInt();

		ctrl.addVideo(title, videoType, priceCode);
	}

	public void rentVideo() {
		System.out.println("Enter customer name: ") ;
		String customerName = scanner.next() ;

		Customer foundCustomer = ctrl.findCustomer(customerName);
		if ( foundCustomer == null ) return ;

		System.out.println("Enter video title to rent: ") ;
		String videoTitle = scanner.next() ;

		Video foundVideo = ctrl.findVideo(videoTitle);
		if ( foundVideo == null ) return ;
		
		ctrl.rentVideo(foundCustomer, foundVideo);
	}

	public void returnVideo() {
		System.out.println("Enter customer name: ") ;
		String customerName = scanner.next() ;

		Customer foundCustomer = ctrl.findCustomer(customerName);
		if ( foundCustomer == null ) return ;

		System.out.println("Enter video title to return: ") ;
		String videoTitle = scanner.next() ;
		
		ctrl.returnVideo(foundCustomer, videoTitle);
	}

	public void getCustomerReport() {
		System.out.println("Enter customer name: ") ;
		String customerName = scanner.next() ;

		Customer foundCustomer = ctrl.findCustomer(customerName);

		if ( foundCustomer == null ) {
			System.out.println("No customer found") ;
		} else {
			String result = foundCustomer.getReport() ;
			System.out.println(result);
		}
	}

	public void clearRentals() {
		System.out.println("Enter customer name: ") ;
		String customerName = scanner.next() ;

		Customer foundCustomer = ctrl.findCustomer(customerName);

		if ( foundCustomer == null ) {
			System.out.println("No customer found") ;
		} else {
			System.out.println("Name: " + foundCustomer.getName() +
					"\tRentals: " + foundCustomer.getRentals().size()) ;
			for ( Rental rental: foundCustomer.getRentals() ) {
				System.out.print("\tTitle: " + rental.getVideo().getTitle() + " ") ;
				System.out.print("\tPrice Code: " + rental.getVideo().getPriceCode()) ;
			}

			ctrl.clearRentals(foundCustomer);
		}
	}
	
	private void init() {
		ctrl.init();
	}

	public int showCommand() {
		System.out.println("\nSelect a command !");
		System.out.println("\t 0. Quit");
		System.out.println("\t 1. List customers");
		System.out.println("\t 2. List videos");
		System.out.println("\t 3. Register customer");
		System.out.println("\t 4. Register video");
		System.out.println("\t 5. Rent video");
		System.out.println("\t 6. Return video");
		System.out.println("\t 7. Show customer report");
		System.out.println("\t 8. Show customer and clear rentals");

		int command = scanner.nextInt() ;

		return command ;

	}
}
