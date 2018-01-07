package cli;

import java.util.ArrayList;
import java.util.Scanner;

import Jyve.*;

public class CLI {

	private final static String BACK_INPUT ="b";
	private final static String MENU_INPUT ="m";
	
	private Jyve jyve;
	private Scanner scanner;

	public CLI() {
		jyve = new Jyve();
		scanner = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		CLI cli = new CLI();
		cli.MainMenu();
	}
	
	private void MainMenu() {
		System.out.println("Main Menu");
		ArrayList<String> opt = new ArrayList<>();
		opt.add("User");
		opt.add("Venue");
		opt.add("Band");
		opt.add("Event");
		opt.add("Run Tests");
		
		switch(OptionInput(opt, false))
		{
		case "1":
			UserMenu(true);
			break;
		case "2":
			VenueMenu(true);
			break;
		case "3":
			BandMenu(true);
			break;
		case "4":
			EventMenu(true);
			break;
		default:
			MainMenu();
			break;
		}
	}

	private void UserMenu(boolean hasParent){
		System.out.println("User Menu");
		ArrayList<String> opt = new ArrayList<>();
		opt.add("List all");
		opt.add("Add Artist");
		opt.add("List Artist");
		opt.add("Search Artist");
		opt.add("Add Organizer");
		opt.add("List Organizer");
		opt.add("Search Organizer");
		opt.add("Add Fan");
		opt.add("List Fan");
		opt.add("Search Fan");
		opt.add("Attend Event");
		opt.add("Cancel Event Attendance");
		
		switch(OptionInput(opt, hasParent))
		{
		case "1":
			ListUsers("",true,true,true);
			UserMenu(true);
			break;
		case "2":
			AddUser(0);
			UserMenu(true);
			break;
		case "3":
			ListUsers("",true,false,false);
			UserMenu(true);
			break;
		case "4":
			System.out.println("Write the user name:");
			ListUsers(scanner.nextLine(),true,false,false);
			UserMenu(true);
			break;
		case "5":
			AddUser(1);
			UserMenu(true);
			break;
		case "6":
			ListUsers("",false,true,false);
			UserMenu(true);
			break;
		case "7":
			System.out.println("Write the user name:");
			ListUsers(scanner.nextLine(),false,true,false);
			UserMenu(true);
			break;
		case "8":
			AddUser(2);
			UserMenu(true);
			break;
		case "9":
			ListUsers("",false,false,true);
			UserMenu(true);
			break;
		case "10":
			System.out.println("Write the user name:");
			ListUsers(scanner.nextLine(),false,false,true);
			UserMenu(true);
			break;
		case "11":
			//TODO
			UserMenu(true);
			break;
		case "12":
			//TODO
			UserMenu(true);
			break;
		case "b":
			break;
		case "m":
			MainMenu();
			break;
		default:
			UserMenu(true);
			break;
		}
	}
	
	private void ListUsers(String search, boolean art, boolean org, boolean fan) {
		try {
		if(art) {
			System.out.println("==== Artists =====");
			if(search.equals("")) {
				for(Object a : jyve.GetArtistList()) {
					System.out.println(((Artist) a).name);
					System.out.println("\tinstrument: "+((Artist) a).instrument);
					System.out.println("\tmail: "+((Artist) a).mail);
					System.out.println("\tphone: "+((Artist) a).phone);
				}
			}else {
				Artist a = jyve.GetArtistByName(search);
				System.out.println(a.name);
				System.out.println("\tinstrument: "+a.instrument);
				System.out.println("\tmail: "+a.mail);
				System.out.println("\tphone: "+a.phone);
			}
		}
		if(org) {
			System.out.println("=== Organizers ===");
			if(search.equals("")) {
				for(Object a : jyve.GetOrganizerList()) {
					System.out.println(((Organizer) a).name);
					System.out.println("\tmail: "+((Organizer) a).mail);
					System.out.println("\tphone: "+((Organizer) a).phone);
				}
			}else {
				Organizer a = jyve.GetOrganizerByName(search);
				System.out.println(a.name);
				System.out.println("\tmail: "+a.mail);
				System.out.println("\tphone: "+a.phone);
			}
		}
		if(fan) {
			System.out.println("====== Fans ======");
			if(search.equals("")) {
				for(Object a : jyve.GetFanlist()) {
					System.out.println(((Fan) a).name);
					System.out.println("\tmail: "+((Fan) a).mail);
					System.out.println("\tphone: "+((Fan) a).phone);
				}
			}else {
				Fan a = jyve.GetFanByName(search);
				System.out.println(a.name);
				System.out.println("\tmail: "+a.mail);
				System.out.println("\tphone: "+a.phone);
			}
		}
		}catch(Exception e) {
			System.out.println("User(s) not found...");
		}
	}
	
	private void AddUser(int type) {
		String userType = "";
		switch(type) {
		case 0:
			userType="artist";
			break;
		case 1:
			userType="organizer";
			break;
		case 2:
			userType="fan";
			break;
		default:
			break;
		}
		
		System.out.println("Write the " + userType + " name:");
		String name = scanner.nextLine();
		System.out.println("Write a brief bio/description:");
		String bio = scanner.nextLine();
		System.out.println("Write the " + userType + " phone number (9 digits):");
		int phone = IntInput(9);
		System.out.println("Write the " + userType + " email:");
		String mail = scanner.nextLine();
		System.out.println("Write the " + userType + " address:");
		String address = scanner.nextLine();
		
		try {
			switch(type) {
			case 0:
				System.out.println("Write the " + userType + " instrument:");
				String instrument = scanner.nextLine();
				jyve.AddArtist(new Artist(name, bio, phone, mail, address, instrument));
				break;
			case 1:
				jyve.AddOrganizer(new Organizer(name, bio, phone, mail, address));
				break;
			case 2:
				jyve.AddFan(new Fan(name, bio, phone, mail, address));
				break;
			default:
				break;
			}
		}catch(Exception e) {
			System.out.println("User name already used or invalid info.");
		}
	}
	
	private void VenueMenu(boolean hasParent){
		System.out.println("User Menu");
		ArrayList<String> opt = new ArrayList<>();
		opt.add("List all");
		opt.add("Add Venue");
	}
	private void BandMenu(boolean hasParent){
		System.out.println("User Menu");
		ArrayList<String> opt = new ArrayList<>();
		opt.add("List all");
		opt.add("Add Band");
		opt.add("Add Artist");
		opt.add("List Artist");
	}
	private void EventMenu(boolean hasParent){
		System.out.println("User Menu");
		ArrayList<String> opt = new ArrayList<>();
		opt.add("List all");
		opt.add("Add Event");
		opt.add("Search Event by Name");
		opt.add("Search Event by Date");
		opt.add("Cancel Event");

		switch(OptionInput(opt, hasParent))
		{
		case "1":
			ListEvents();
			EventMenu(true);
			break;
		case "2":
			AddEvent();
			EventMenu(true);
			break;
		case "3":
			System.out.println("Write the event name:");
			ListEventsByName(scanner.nextLine());
			EventMenu(true);
			break;
		case "4":
			System.out.println("Write the event date (format dd-mm-yyyy):");
			ListEventsByDay(DateInput());
			EventMenu(true);
			break;
		case "5":
			System.out.println("Write the event name:");
			CancelEvent(scanner.nextLine());
			EventMenu(true);
			break;
		case "b":
			break;
		case "m":
			MainMenu();
			break;
		default:
			UserMenu(true);
			break;
		}
	}
	
	private void ListEvents() {
		System.out.println("===== Events =====");
		for(Object o : jyve.GetEventList()) {
			System.out.println("\n"+((Event) o).name);
			System.out.println("\tdate: "+((Event) o).date);
			System.out.println("\ttime: "+((Event) o).time);
			System.out.println("\tband: "+((Event) o).band);
			System.out.println("\tvenue: "+((Event) o).venue);
		}
	}

	private void ListEventsByName(String filter) {
		System.out.println("===== Events =====");
		Event e = jyve.GetEventByName(filter);
		System.out.println("\n"+ e.name);
		System.out.println("\tdate: "+e.date);
		System.out.println("\ttime: "+e.time);
		System.out.println("\tband: "+e.band);
		System.out.println("\tvenue: "+e.venue);
	}
	
	private void  AddEvent() {
		try {
			if(jyve.GetBandList().size()==0) {
				System.out.println("Warning: No band records were found. Add a band to the system before proceeding.");
				return;
			}
			if(jyve.GetVenueList().size()==0){
				System.out.println("Warning: No venue records were found. Add a venue to the system before proceeding.");
				return;
			}
			if(jyve.GetOrganizerList().size()==0){
				System.out.println("Warning: No organizer records were found. Add an organizer to the system before proceeding.");
				return;
			}

			System.out.println("Write the event name:");
			String name = scanner.nextLine();
			System.out.println("Write the time of the event (format hh):");
			int time = IntInput(2);
			System.out.println("Write the event date (format dd-mm-yyyy):");
			int[] dateTokens = DateInput();
			Date date = new Date(dateTokens[0],dateTokens[1],dateTokens[2]);
			System.out.println("Write the band name:");
			Band band = jyve.GetBandByName(scanner.nextLine());
			System.out.println("Write the venue name:");
			Venue venue = jyve.GetVenueByName(scanner.nextLine());
			System.out.println("Write the organizer name:");
			Organizer org = jyve.GetOrganizerByName(scanner.nextLine());
			
			jyve.AddEvent(new Event(name, date, time, venue, band, org));
			
		}catch(Exception e){
			System.out.println("Invalid details provided...");
		}
	}
	
	private void CancelEvent(String filter) {
		try {
			jyve.CancelEvent(filter);
		}catch(Exception e) {
			System.out.println("Event does not exist.");
		}
	}
	
	private void ListEventsByDay(int[] filter) {
		System.out.println("===== Events =====");
		for(Object o : jyve.GetEventsByDate(filter[0],filter[1],filter[2])) {
			System.out.println("\n"+((Event) o).name);
			System.out.println("\tdate: "+((Event) o).date);
			System.out.println("\ttime: "+((Event) o).time);
			System.out.println("\tband: "+((Event) o).band);
			System.out.println("\tvenue: "+((Event) o).venue);
		}
	}
	
	
	private String OptionInput(ArrayList<String> opt, boolean hasParent) {
		for(int i=0;i<opt.size();i++) {
			System.out.println(i+1 + ". " + opt.get(i));
		}
		if(hasParent) {
			System.out.println("b. Back");
			System.out.println("m. Menu");
		}
		System.out.println("\nSelect an option from above.");
		
		boolean validInput=false;
		String input="";
		while(!validInput) {
			input = scanner.nextLine().toLowerCase();
			validInput=IsValidInput(opt.size(), hasParent, input);
			if(!validInput)
				PrintInvalidInput();
		}
		return input;
	}
	
	private boolean IsValidInput(int optCount, boolean hasParent, String input) {
		if(hasParent) {
			if(input.equals(BACK_INPUT) || input.equals(MENU_INPUT))
				return true;
		}else {
			try {
				int i = Integer.parseInt(input);
				if(i>0 && i<=optCount) {
					return true;
				}else {
					return false;
				}
			}catch (Exception e) {
				return false;
			}
		}
		return false;
	}
	
	private void PrintInvalidInput() {
		System.out.println("Invalid input received...");
	}

	private int IntInput(int length) {
		boolean valid=false;
		String input="";
		while(!valid) {
			try {
				input=scanner.nextLine();
				if((length!=0 && input.length()==length) || length == 0)  {
					valid=true;
				}
			}catch (Exception e) {	}
		}
		return Integer.parseInt(input);
	}
	
	private int[] DateInput() {
		boolean valid=false;
		String input="";
		String[] tokens = new String[3];
		int[] date = new int[3];
		while(!valid) {
			try {
				input=scanner.nextLine();
				tokens=input.split("-");
				date[0]=Integer.parseInt(tokens[0]);
				date[1]=Integer.parseInt(tokens[1]);
				date[2]=Integer.parseInt(tokens[2]);
				valid=true;
			}catch (Exception e) {	}
		}
		return date;
	}

}
