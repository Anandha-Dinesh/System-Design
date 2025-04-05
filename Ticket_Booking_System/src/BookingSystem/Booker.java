package BookingSystem;
import java.util.*;

public class Booker {
	static int LowerBerth =1;
	static int MiddleBerth = 1;
	static int UpperBerth = 1;
	static int RACList=1; 
	static int WaitingList =1;
	static Queue<Passenger> RACListQueue = new LinkedList<>();
	static Queue<Passenger> WaitingListQueue = new LinkedList<>();
	static List<Passenger> BookedTicket = new ArrayList<>();
	static List<Integer> LowerBerthPositions = new ArrayList<>();
	static HashMap<Integer,Passenger>passengerMap = new HashMap<>();
	static {
		for(int i=1;i<=LowerBerth;i++) {
			LowerBerthPositions.add(i);
		}
	}
	static List<Integer> MiddleBerthPositions = new ArrayList<>();
	static {
		for(int i=1;i<=MiddleBerth;i++) {
			MiddleBerthPositions.add(i);
		}
	}
	static List<Integer> UpperBerthPositions = new ArrayList<>();
	static {
		for(int i=1;i<=UpperBerth;i++) {
			UpperBerthPositions.add(i);
		}
	}
	static List<Integer> WaitingListPositions = new ArrayList<>();
	static {
		for(int i=1;i<=WaitingList;i++) {
			WaitingListPositions.add(i);
		}
	}
	static List<Integer> RACListPositions = new ArrayList<>();
	static {
		for(int i=1;i<=RACList;i++) {
			RACListPositions.add(i);
		}
	}
	
	public void BookTicket(Passenger passenger) {
		if(LowerBerth>0 || MiddleBerth>0 || UpperBerth>0) {
			if(passenger.BerthPreference.toUpperCase().equals("U")) {
				if(UpperBerth>0) {
					passenger.SeatNumber=UpperBerthPositions.get(0);
					passenger.Alloted=UpperBerthPositions.get(0)+"U";
					UpperBerthPositions.remove(0);
					UpperBerth--;
				}
				else if(MiddleBerth>0) {
					passenger.SeatNumber=MiddleBerthPositions.get(0);
					passenger.Alloted=MiddleBerthPositions.get(0)+"M";
					MiddleBerthPositions.remove(0);
					MiddleBerth--;
				}
				else {
					passenger.SeatNumber=LowerBerthPositions.get(0);
					passenger.Alloted=LowerBerthPositions.get(0)+"L";
					LowerBerthPositions.remove(0);
					LowerBerth--;
				}
				
				passengerMap.put(passenger.PassengerId,passenger);
				
				
			}
			else if(passenger.BerthPreference.toUpperCase().equals("M")) {
				if(MiddleBerth>0) {
					passenger.SeatNumber=MiddleBerthPositions.get(0);
					passenger.Alloted=MiddleBerthPositions.get(0)+"M";
					MiddleBerthPositions.remove(0);
					MiddleBerth--;
				}else if(UpperBerth>0) {
					passenger.SeatNumber=UpperBerthPositions.get(0);
					passenger.Alloted=UpperBerthPositions.get(0)+"U";
					UpperBerthPositions.remove(0);
					UpperBerth--;
				}
				
				else {
					passenger.SeatNumber=LowerBerthPositions.get(0);
					passenger.Alloted=LowerBerthPositions.get(0)+"L";
					LowerBerthPositions.remove(0);
					LowerBerth--;
				}
				
				passengerMap.put(passenger.PassengerId,passenger);
			}
			else if(passenger.BerthPreference.toUpperCase().equals("L")) {
				if(LowerBerth>0) {
					passenger.SeatNumber=LowerBerthPositions.get(0);
					passenger.Alloted=LowerBerthPositions.get(0)+"L";
					LowerBerthPositions.remove(0);
					LowerBerth--;
				}else if(UpperBerth>0) {
					passenger.SeatNumber=UpperBerthPositions.get(0);
					passenger.Alloted=UpperBerthPositions.get(0)+"U";
					UpperBerthPositions.remove(0);
					UpperBerth--;
				}
				else if(MiddleBerth>0) {
					passenger.SeatNumber=MiddleBerthPositions.get(0);
					passenger.Alloted=MiddleBerthPositions.get(0)+"M";
					MiddleBerthPositions.remove(0);
					MiddleBerth--;
				}
				passengerMap.put(passenger.PassengerId,passenger);
			}
			else {
				System.out.println("Please Select Valid Berth preference");
				return;
			}
			BookedTicket.add(passenger);
		}else {
			System.out.println("No Confirmed tickets available ");
			
			 if(RACList>0 ) {
				 System.out.println("Booking RAC Ticket ");
				passenger.SeatNumber= RACListPositions.get(0);
				passenger.Alloted=RACListPositions.get(0)+"RAC";
				RACList--;
				RACListPositions.remove(0);
				WaitingListQueue.add(passenger);
			}
			 else if(WaitingList>0) {
				 System.out.println("Booking Waiting List ");
				passenger.SeatNumber= WaitingListPositions.get(0);
				passenger.Alloted= WaitingListPositions.get(0)+"WL";
				WaitingList--;
				WaitingListPositions.remove(0);
				WaitingListQueue.add(passenger);
			}else {
				System.out.println("Cannot Book Ticket. No Tickets Available");
				return;
			}
		}
		
		System.out.println(passenger.Alloted +" Booked");
		
	
	}
	public void ViewTickets() {
		if(BookedTicket.size()==0) {
			System.out.println("No tickets have booked\n");
			return;
		}
		for(Passenger Ticket : BookedTicket) {			
			System.out.println("PassengerId : "+ Ticket.PassengerId
					+" Name : "+ Ticket.Name
					+" Age : "+ Ticket.Age
					+" Preference : "+Ticket.BerthPreference
					+" Alloted : "+Ticket.Alloted
					+" SeatNumber : "+Ticket.SeatNumber+"\n");
			
			
			
		}
	}
	public void AvailableTickets() {
		//if(LowerBerth>0 || MiddleBerth>0|| LowerBerth>0) {
			if(LowerBerth>0) System.out.println(LowerBerth + " Lower Berth Seats Available");
			if(MiddleBerth>0) System.out.println(MiddleBerth + " Middle Berth Seats Available");
			if(UpperBerth>0) System.out.println(UpperBerth + " Upper Berth Seats Available");
			if(RACList>0) System.out.println(RACList + " RAC Seats Available");
			if(WaitingList>0) System.out.println(WaitingList + " Waiting List Seats Available");
			System.out.println("\n");
		//}
	}
	public void Canceller(int ID) {
		if(!passengerMap.containsKey(ID)) {
			System.out.println("Unknown Passenger ID");
			return;
		}
		Passenger CancelledTicket = passengerMap.remove(ID);
		BookedTicket.remove(CancelledTicket);
		switch (CancelledTicket.BerthPreference.toUpperCase()) {
		case "U": {
			UpperBerth++;
			UpperBerthPositions.add(CancelledTicket.SeatNumber);
			System.out.println("Upper "+UpperBerth);
			break;
		}
		case "M": {
			MiddleBerth++;
			MiddleBerthPositions.add(CancelledTicket.SeatNumber);
			
			System.out.println("Middle "+MiddleBerth);
			break;
		}
		case "L": {
			LowerBerth++;
			LowerBerthPositions.add(CancelledTicket.SeatNumber);
			
			System.out.println("Lower"+LowerBerth);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + CancelledTicket.BerthPreference);
		}
		if(RACListQueue.size()>0) {
			System.out.println("Promoting RAC");
			Passenger PassengerFromRAC= RACListQueue.poll();
			WaitingListPositions.add(PassengerFromRAC.SeatNumber);
			BookTicket(PassengerFromRAC);
			RACList++;
		}
		if(WaitingListQueue.size()>0) {
			System.out.println("Promoting WL");
			Passenger PassengerFromWL = WaitingListQueue.poll();
			WaitingListPositions.add(PassengerFromWL.SeatNumber);
			BookTicket(PassengerFromWL);
			WaitingList++;
		}
		
	}
}
