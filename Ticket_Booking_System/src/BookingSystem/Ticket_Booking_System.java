package BookingSystem;
import java.util.*;

public class Ticket_Booking_System {
	public static void main(String[] args) {
		boolean exit = true;
		Scanner sc = new Scanner(System.in);
		Booker booker = new Booker();
		while(exit) {
			System.out.println("1. Book Ticket \n"
					+ "2. Cancel Ticket \n"
					+ "3. View Booked Tickets \n"
					+ "4. View Remaining Tickets \n"
					+ "5. Exit"
			);
				int input =sc.nextInt();
				sc.nextLine();
			try {
				switch(input) {
				case 1:
					//Book Ticket function
					System.out.println("enter Name");
					String name =sc.nextLine();
					System.out.println("enter age");
					int age= sc.nextInt();
					sc.nextLine();
					System.out.println("enter Preference");
					String preference= sc.next().toUpperCase();
					booker.BookTicket(new Passenger(name,age,preference));
					break;
				case 2:
					// Cancel Ticket function
					System.out.println("Enter the id");
					int id = sc.nextInt();
					booker.Canceller(id);
					break;
				case 3:
					// view Booked Ticket function
					booker.ViewTickets();
					break;
				case 4:
					//View remaining tickets
					booker.AvailableTickets();
					exit=true;
					break;
				case 5:
					exit=false;
					break;
				}	
			} catch(Exception e) {
				System.out.println("Enter a valid input");
				exit=true;
				
			}
		}
		System.out.println("outside");
		sc.close();

	}

}
