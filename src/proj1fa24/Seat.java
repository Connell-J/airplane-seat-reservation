package proj1fa24;

/**
 * <p>Title: Project#1 - Airline Reservations</p>
 *
 * <p>Description: Seat Class - defines those properties that are common to
 * 	  seats in an airplane </p>
 *
 * @author Jesse_Connell
 */

public class Seat {


	private String seatType; // stores the seat class type
	private boolean occupied; // stores a boolean for the occupied status of the seat
	private int seatNum; // stores the seat's number


	/**
	 * Seat() – creates an instance of the seat class and initializes instance variables
	 */
	public Seat()
	{
		seatType = "Coach";
		occupied = false;
		seatNum = 1;
	}

	/**
	 * Seat() – creates an instance of the seat class and initializes instance variables
	 * @param seatNum - this.seatNum
	 * @param type -this.seatType
	 */
	public Seat( int seatNum, String type) 
	{
		this.seatNum = seatNum;
		this.seatType = type;
		occupied = false;

	}

	/**
	 * getType() – returns the seatType string
	 * @return seatType
	 */
	public String getType()
	{
		return seatType;
	}
	/**
	 * getSeatNum() – returns the seat number
	 * @return seatNum
	 */
	public int getSeatNum()
	{
		return seatNum;
	}

	/**
	 * isEmpty() – checks if the occupied variable is true or false
	 * @return boolean
	 */
	public boolean isEmpty()
	{
		if(occupied == true)
			return false;

		else 

		{
			return true;

		}
	}

	/**
	 * reserveSeat() – changes the occupied boolean to true
	 *
	 */
	public void reserveSeat()
	{
		this.occupied = true;
	}

	/**
	 * cancelReservation() – changes the occupied boolean to false
	 *
	 */
	public void cancelReservation()
	{
		this.occupied = false;
	}
	
	/**
	 * toString – returns a string containing the seat number, type and whether its available or not.
	 * @return returns a string.
	 */

	public String toString()
	{
		if(isEmpty() == false)
			return "Seat number: " + (seatNum +1) + "\nType: " + seatType + "\nAvailability: " + "Occupied";
		else
			return "Seat number: " + (seatNum+1) + "\nType: " + seatType + "\nAvailability: " + "Available";
	}
}
