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
			MainMenu();
			break;
		case "2":
			VenueMenu(true);
			MainMenu();
			break;
		case "3":
			BandMenu(true);
			MainMenu();
			break;
		case "4":
			EventMenu(true);
			MainMenu();
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
		
		switch(OptionInput(opt, false))
		{
		case "1":
			ListUsers("",true,true,true);
			UserMenu(true);
			MainMenu();
			break;
		case "2":
			VenueMenu(true);
			UserMenu(true);
			MainMenu();
			break;
		case "3":
			ListUsers("",true,false,false);
			UserMenu(true);
			MainMenu();
			break;
		case "4":
			ListUsers(scanner.nextLine(),true,false,false);
			UserMenu(true);
			MainMenu();
			break;
		case "5":
			UserMenu(true);
			MainMenu();
			break;
		case "6":
			ListUsers("",false,true,false);
			UserMenu(true);
			MainMenu();
			break;
		case "7":
			ListUsers(scanner.nextLine(),false,true,false);
			UserMenu(true);
			MainMenu();
			break;
		case "8":
			UserMenu(true);
			MainMenu();
			break;
		case "9":
			ListUsers("",false,false,true);
			UserMenu(true);
			MainMenu();
			break;
		case "10":
			ListUsers(scanner.nextLine(),false,false,true);
			UserMenu(true);
			MainMenu();
			break;
		case "11":
			UserMenu(true);
			MainMenu();
			break;
		case "12":
			UserMenu(true);
			MainMenu();
			break;
		case "b":
			break;
		case "m":
			MainMenu();
			break;
		default:
			MainMenu();
			break;
		}
	}
	
	private void ListUsers(String search, boolean art, boolean org, boolean fan) {
		try {
		if(art) {
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
	
	private void VenueMenu(boolean hasParent){
		
	}
	private void BandMenu(boolean hasParent){
		
	}
	private void EventMenu(boolean hasParent){
		
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
			input = scanner.nextLine();
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

}
