// TODO -- create header comments

import java.util.Scanner;
import javax.swing.JOptionPane;

// TODO -- create the Booking class (separate file: Booking.java)


public class NemoReefToursMenu extends Booking
{
	final int ENTER_BOOKING = 1;
	final int DISPLAY_BOOKINGS = 2;
	final int DISPLAY_STATISTICS = 3;
	final int SEARCH_BOOKINGS = 4;
	final int SORT_BOOKINGS = 5;
	final int EXIT = 6;

	// TODO -- decare any further constants

	Booking b = new Booking();// TODO -- declare array of booking objects
	int index=0;// TODO -- declare variable for the current booking entered (integer)


	Scanner inputMenuChoice = new Scanner(System.in);



	private int getMenuItem()
	{
		System.out.println("\nPlease select from the following");
		System.out.println(ENTER_BOOKING + ". Enter booking name and number of passengers");
		System.out.println(DISPLAY_BOOKINGS + ". Display all booking names, number of passengers and charges");
		System.out.println(DISPLAY_STATISTICS + ". Display Statistics");
		System.out.println(SEARCH_BOOKINGS + ". Search for booking");
		System.out.println(SORT_BOOKINGS + ". Sort the bookings");
		System.out.println(EXIT + ". Exit the application");
		System.out.print("Enter choice==> ");

		String choice = inputMenuChoice.nextLine();
		while (choice.equals("") || !isStringNumeric(choice))
		{
			JOptionPane.showMessageDialog(null, "Error - Menu selection name cannot be blank and must be numeric",
											"Input Menu Choice", JOptionPane.ERROR_MESSAGE);

			System.out.print("Enter choice==> ");

			choice = inputMenuChoice.nextLine();
		}

		return Integer.parseInt(choice);
	}


	private boolean isStringNumeric(String str)
	{
		for (int i = 0; i < str.length(); i++)
		{
			if (!Character.isDigit(str.charAt(i)))
				return false;
		}

		return true;
	}


	private void processBookings()
	{
		int choice = getMenuItem();
		while (choice != EXIT)
		{
			switch (choice)
			{
				case ENTER_BOOKING:
					enterBooking();
					break;
				case DISPLAY_BOOKINGS:
					displayAllBookings();
					break;
				case DISPLAY_STATISTICS:
					displayStatistics();
					break;
				case SEARCH_BOOKINGS:
					searchBookings();
					break;
				case SORT_BOOKINGS:
					sortBookings();
					break;
				default:
					System.out.println("ERROR choice not recognised");
			}
			choice = getMenuItem();
		}
	}


	private void enterBooking()
	{
		//displayHeading();
		b.setName(index);
		index++;
		// TODO -- check if maximum bookings has been reached (do this after getting the other functionality working)

		// TODO -- read in the booking name via a dialog (as a string)
		// TODO -- create validation loop (do this after getting the other functionality working)

		// TODO -- read in the number of passengers via a dialog and convert into an integer
		// TODO -- create validation loop (do this after getting the other functionality working)

		// TODO -- add the data to the array (use the new keyword and the parameterised constructor in Booking class)

		// TODO -- display the booking name, number of passengers and the charge

		// TODO -- increment the current booking variable for the next entry
	}


	/*private void displayHeading()
	{
		System.out.printf("%-30s%-17s%-6s\n", "Booking Name", "Passengers", "Charge");
	}*/


	private void displayAllBookings()
	{
		if(index==0)
			System.out.println("Must enter at least one input");
		else
			b.displayData(index);
		// TODO -- check if there has been a booking entered (do this after getting the other functionality working)
		// TODO -- display all of the entries entered so far (just display the current entries not the whole array, use the current booking variable as the termination condition)
	}


	private void displayStatistics()
	{b.getStat(index);
		// TODO -- check if there has been a booking entered (do this after getting the other functionality working)
		// TODO -- loop though the current entries in the array and calculate and display the statistics
	}


	private void searchBookings()
	{b.searchData(index);
		// TODO -- check if there has been a booking entered (do this after getting the other functionality working)
		// TODO -- read the search key using a dialog
		// TODO -- loop though the current entries in the array to search for the search key
		// TODO -- display the found item or report it has not been found
	}

	private void sortBookings()
	{
		b.sortData(index);
		// TODO -- check if there has been two bookings entered (do this after getting the other functionality working)
		// TODO -- sort the entries
		// TODO -- display the sorted list
	}


	public static void main(String [] args)
	{
		NemoReefToursMenu app = new NemoReefToursMenu();

		app.processBookings();
	}
}