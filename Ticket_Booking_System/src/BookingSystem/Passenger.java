package BookingSystem;

public class Passenger {
	static int id=1;
	String Name;
	int Age;
	String BerthPreference;
	int PassengerId;
	String Alloted;
	int SeatNumber;
	public Passenger(String Name,int Age,String BerthPreference){
		this.Name=Name;
		this.Age=Age;
		this.BerthPreference=BerthPreference;
		PassengerId=id++;
		Alloted="";
		SeatNumber=-1;
	}
}
