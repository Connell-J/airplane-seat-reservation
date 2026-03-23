package proj1fa24;

/**
 * <p>Title: Project#1 - Airline Reservations</p>
 *
 * <p>Description: Project1 application class - Tests the methods defined for the airplane class which also 
 * 	calls methods to the seat class  </p>
 *
 * @author Jesse_Connell
 */

import javax.swing.JOptionPane;

public class Project1 {

	public static void main(String args[]) {

		boolean cont = true;// loop control variable

		//Prompts the user to enter the amount of seats they want to use for the size of their airplane
		String planeSeats = JOptionPane.showInputDialog("Please enter the amount of seats");

		//parses the string into an integer
		int planeSeatNum = Integer.parseInt(planeSeats);

		//makes a new plane object using the int that gets parsed
		Airplane plane1 = new Airplane(planeSeatNum);

		// an array of strings is declared which is later used for the options.
		String[] chocies = {"Make a Reservation", "Cancel a Reservation", "Display a Seating Chart", "Quit"};

		/**dialog boxes are created with the options from the choices string array and returns an int
		 * based of which choice int is returned.
		 */

		while(cont) {
			int choice = JOptionPane.showOptionDialog(null, "Welcome, please enter a choice", "Main Menu", JOptionPane.DEFAULT_OPTION, 
					JOptionPane.QUESTION_MESSAGE, null, chocies, chocies[0]);

			//if statement that does different things based on which value is stored in choice
			/** Choice = 0 runs with the "Make a Reservation" part of the main menu and checks if the class is full
			 *  if not, it will display all of the available seats for that class. It then asks the user for a
			 *   seat number, if that seat number is valid, it will assign the seat.
			 */

			if(choice == 0 ) 
			{
				boolean run = false;
				while(!run)
				{
					String seatType = JOptionPane.showInputDialog("Please enter seat type ");

					if (plane1.isClassFull(seatType)) 
					{
						JOptionPane.showMessageDialog(null, "The " + seatType + " class seats are full.");

						break;
					}
					else

						JOptionPane.showMessageDialog(null, plane1.availableSeats(seatType));

					String seatNum = JOptionPane.showInputDialog("Please enter the seat number");
					int seatNumber = Integer.parseInt(seatNum);		

					if(plane1.assignSeat(seatNumber) == 1) 
					{
						JOptionPane.showMessageDialog(null, "Reservation succesfull.");
						cont = false;
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Seat is occupied, please select another seat");
					}

				}
			}
			/**
			 * Choice = 1 runs the cancelReservation method by prompting the user for a number that is
			 * stored as a string and parsed to an in, the program then checks if that seat is occupied.
			 */

			else if(choice == 1)
			{
				//stores a string for the number of the cancelled seat.
				String canceledSeatNum = JOptionPane.showInputDialog("What seat number would you like to cancel");

				//parses that string into an integer
				int canceledSeatNumber  = Integer.parseInt(canceledSeatNum);

				//passes the an int to the cancelReservation method and it shows a message based on the int returned.
				if(plane1.cancelReservation(canceledSeatNumber) == 1)
				{
					JOptionPane.showMessageDialog(null, "Reservation cancelled");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Seat is not occupied or does not exist.");
				}
			}

			/**
			 * choice = 3 displays the seating chart option to show all of the current seats in the airplane,
			 * occupied or not.
			 */
			else if(choice == 2)
			{
				//displays the state of the plane in a dialog box
				JOptionPane.showMessageDialog(null,	plane1);
			}

			/**
			 * choice 4 does not require any code as the dialog option ends and the programs terminates.
			 */
			else if(choice ==3)
			{
				// set the loop control variable to false to exit the menu.
				cont = false;
			}
		}
		
		/**
		 * 
		 * 				CODE TESTED OUTPUT FOR BOTH CLASSES
		 * 
		 *   // Create an instance of Airplane with 10 seats
		 *   
        Airplane plane = new Airplane(10);

        // Test: availableSeats() - should show all seats as available initially
		 * 
        System.out.println("\nAvailable Seats (Before Reservation):");

        System.out.println(plane.availableSeats("First"));

        System.out.println(plane.availableSeats("Coach"));

        // Test: assignSeat() - try reserving a seat and check if it works
		 * 
        System.out.println("\nReserving seat number 1 (First class):");

        if (plane.assignSeat(1) == 1) 
        {
            System.out.println("Seat 1 reserved successfully.");
        } 
        else 
        {
            System.out.println("Failed to reserve seat 1.");
        }

        // Check the status of seats after reservation
		 * 
        System.out.println("\nAvailable Seats (After Reservation):");

        System.out.println(plane.availableSeats("First"));

        System.out.println(plane.availableSeats("Coach"));

        // Test: isClassFull() - check if the class is full (should be false)
		 * 
        System.out.println("\nChecking if First class is full:");

        if (plane.isClassFull("First")) 
        {
            System.out.println("First class is full.");
        } 
        else 
        {
            System.out.println("First class is not full.");
        }

        // Test: reserve another seat
		 * 
        System.out.println("\nReserving seat number 2 (First class):");

        if (plane.assignSeat(2) == 1) '
        {
            System.out.println("Seat 2 reserved successfully.");
        } 
        else 
        {
            System.out.println("Failed to reserve seat 2.");
        }

        // Test: cancelReservation() - cancel the reservation for seat number 1
		 * 
        System.out.println("\nCancelling reservation for seat number 1:");
        if (plane.cancelReservation(1) == 1) 
        {
            System.out.println("Seat 1 reservation cancelled successfully.");
        } 
        else 
        {
            System.out.println("Failed to cancel reservation for seat 1.");
        }

        // Check the status of seats after cancellation
		 * 
        System.out.println("\nAvailable Seats (After Cancellation):");

        System.out.println(plane.availableSeats("First"));

        System.out.println(plane.availableSeats("Coach"));

        // Test: coachOccAmt() and firstOccAmt() - check the number of occupied seats in both classes
		 * 
        System.out.println("\nNumber of occupied Coach seats: " + plane.coachOccAmt());

        System.out.println("Number of occupied First class seats: " + plane.firstOccAmt());

        // Test: isClassFull() - fill all the first class seats and check again
		 * 
        System.out.println("\nReserving remaining First class seats to fill the class:");

        plane.assignSeat(3);
        plane.assignSeat(4);

        System.out.println("\nChecking if First class is full now:");

        if (plane.isClassFull("First")) 
        {
            System.out.println("First class is full.");
        }
         else
          {
            System.out.println("First class is not full.");
        }

        // Test: toString() - print the seating chart
		 * 
        System.out.println("\nSeating Chart:");
        System.out.println(plane.toString());

		 */
	}
}

