package proj1fa24;

/**
 * <p>Title: Project#1 - Airline Reservations</p>
 *
 * <p>Description: Airplane Class - defines those properties that are common to
 * 	  an airplane object which holds objects of the seat class. </p>
 *
 * @author Jesse_Connell
 */

public class Airplane {

	private int numFirst; //stores the number of first class seats
	private int numCoach; //stores the number of coach class seats
	private Seat[] seats; //stores a reference to an array of seat objects

	
	/**
	 * Airplane() – creates a default instance of the airplane class and initializes instance variables
	 */
	public Airplane()
	{
		numFirst = 4;
		numCoach = 6;
		seats = new Seat[numFirst + numCoach];
		for(int i = 0; i < seats.length; i++)
		{
			seats[i] = new Seat();
		}

	}

	/**
	 * Animal(int numSeats) – creates an instance of the animal class and assigns values based on
	 * 			 a random number generator.
	 */
	public Airplane(int numSeats)
	{
		seats = new Seat[numSeats];
		numFirst = (int)(numSeats * (0.40));
		numCoach = (int)(numSeats * (0.6));

		if(numSeats % (0.4) != 0)
		{
			numCoach++;
		}

		int i = 0;

		while(i < numFirst)
		{
			seats[i] = new Seat(i, "First");
			i++;
		}

		int j = seats.length - 1;

		while( j >= i)
		{

			seats[j] = new Seat(j, "Coach");
			j--;
		}
	}

	/**
	 * coachOccAmt() – iterates through the seats in the airplane and adds to a counter if the seat type is coach
	 * @return coachOccAmt
	 */
	public int coachOccAmt()
	{
		int coachOccAmt = 0;
		for(int i = 0; i <seats.length;i++)
		{
			if(seats[i].isEmpty() == false && seats[i].getType().equals("Coach"))
			{
				coachOccAmt++;
			}
		}
		return coachOccAmt;
	}

	/**
	 * firstOccAmt() – iterates through the seats in the airplane and adds to a counter if the seat type is first
	 * @return firstOccAmt
	 */
	public int firstOccAmt()
	{
		int firstOccAmt = 0;
		for(int i = 0; i <seats.length;i++)
		{
			if(seats[i].isEmpty() == false && seats[i].getType().equals("First"))
			{
				firstOccAmt++;
			}
		}
		return firstOccAmt;
	}

	/**
	 * isClassFull– passes a string as a param and runs the occupied amount method for each class to see if the 
	 *  number of occupied seats is equal to the number of seats in the class.
	 * @param String seatType
	 * @return false
	 */
	public boolean isClassFull(String seatType) 
	{
		if (seatType.equalsIgnoreCase("Coach")) 
		{

			return coachOccAmt() == numCoach;  

		}
		else if (seatType.equalsIgnoreCase("First")) 
		{
			return firstOccAmt() == numFirst;  
		}
		return false;
	}

	/**
	 * availableSeaats(String type)– passes an String as a param and concatenates all the seats that match the type.
	 * @param int seatNum
	 * @return 1 or 0.
	 */
	public String availableSeats(String type)
	{
		String available = "";

		for(int j = 0; j < seats.length; ++j)
		{

			if(seats[j].getType().equalsIgnoreCase(type) && seats[j].isEmpty() == true) 
			{
				available += seats[j].toString() + "\n\n";
			}
		}
		return available;
	}

	/**
	 * assignSeat(int i)– passes an int as a param and uses the isEmpty() method on the seat to determine if it can be
	 * assigned or not, if full.
	 * @param int seatNum
	 * @return 1 or 0.
	 */
	public int assignSeat(int i)
	{
		if( seats[i - 1].isEmpty() == true)
		{
			seats[i-1].reserveSeat();
			return 1;
		}
		else 
		{
			return 0;
		}
	}


	/**
	 * cancelReservation(int seatNum)– passes an int as a param and uses the cancelReservation method on the seat
	 * @param int seatNum
	 * @return 1 or 0.
	 */
	public int cancelReservation(int seatNum)
	{
		for(int i = 0;i <seats.length; ++i)
		{
			if ((seatNum -1) == seats[i].getSeatNum() && seats[i].isEmpty() == false)
			{
				seats[i].cancelReservation();
				return 1;
			}
		}

		return 0;
	}


	/**
	 * toString – returns a string containing the state of the airplane
	 * @return str
	 */
	
	public String toString()
	{
		String str = seats[0].toString();
		for(int i = 1; i <seats.length; ++i)
		{
			str += "\n\n" + seats[i].toString();
		}
		return str;
	}
}
