package virtual.pets.amok;

import java.util.Collection;
import java.util.Scanner;

public class VirtualPetsAmokApp {

	static Shelter myShelter = new Shelter();
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("\r\n" + 
				"__________        __              _____                  __    \r\n" + 
				"\\______   \\ _____/  |_  ______   /  _  \\   _____   ____ |  | __\r\n" + 
				" |     ___// __ \\   __\\/  ___/  /  /_\\  \\ /     \\ /  _ \\|  |/ /\r\n" + 
				" |    |   \\  ___/|  |  \\___ \\  /    |    \\  Y Y  (  <_> )    < \r\n" + 
				" |____|    \\___  >__| /____  > \\____|__  /__|_|  /\\____/|__|_ \\\r\n" + 
				"               \\/          \\/          \\/      \\/            \\/\r\n" + 
				"");
		myShelter.intake(new Dog("Rover",10,10,10,10,true));
		myShelter.intake(new Dog("Beans",10,10,10,10,true));
		myShelter.intake(new Cat("Hairball",10,10,10,10));
		myShelter.intake(new Cat("Sneezy",10,10,10,10));
		myShelter.intake(new RoboCat("Pounce5000",10,10,10));
		myShelter.intake(new RoboCat("Purrtron",10,10,10));
		myShelter.intake(new RoboDog("B.A.R.K.",10,10,10));
		String menuChoice;
		do {
		displayPets();
		displayMenu();
		menuChoice = input.nextLine();
		takeAction(menuChoice);
		myShelter.tick();
		}while(!menuChoice.equalsIgnoreCase("quit"));
		System.out.println("Goodbye!");
		input.close();
	}
	
	private static void takeAction(String menuChoice) {
		if(menuChoice.equals("1")) {
			adoptionMenu();
		}else if(menuChoice.equals("2")) {
			addPetMenu();
		}else if(menuChoice.equals("3")) {
			cleanCageMenu();
		}else if(menuChoice.equals("4")) {
			myShelter.emptyLitterBox();
		}else if(menuChoice.equals("5")) {
			myShelter.feedAll();
		}else if(menuChoice.equals("6")) {
			myShelter.waterAll();
		}else if(menuChoice.equals("7")) {
			myShelter.oilAll();
		}else if(menuChoice.equals("8")) {
			myShelter.walkAll();
		}else if(menuChoice.equals("9")) {
			playMenu();
		}
	}

	private static void cleanCageMenu() {
		// TODO Auto-generated method stub
		
	}

	private static void playMenu() {
		// TODO Auto-generated method stub
		
	}

	private static void addPetMenu() {
		// TODO Auto-generated method stub
		
	}

	private static void adoptionMenu() {
		// TODO Auto-generated method stub
		
	}

	private static void displayPets() {
		Collection<Pet> petList = myShelter.getPets();
		for(Pet pet:petList) {
			System.out.print(pet);
			if(pet instanceof Dog) {
				System.out.println("\tCage Dirtiness = "+myShelter.getDirty(pet)*10+"%");
			}else if(pet instanceof Cat) {
				System.out.println("\tLitterbox Dirtiness = "+myShelter.getDirty(pet)*5+"%");
			}else {
				System.out.println();
			}
		}
		System.out.println();
	}
	
	private static void displayMenu() {
		System.out.println("What would you like to do?");
		System.out.println("[1] Adopt a pet out of the shelter");
		System.out.println("[2] Add a pet to the shelter");
		System.out.println("[3] Clean a dog cage");
		System.out.println("[4] Empty the litterbox");
		System.out.println("[5] Feed the organic pets");
		System.out.println("[6] Water the organic pets");
		System.out.println("[7] Oil the robot pets");
		System.out.println("[8] Walk the dogs");
		System.out.println("[9] Play with a pet");
		System.out.println("[Quit]");
	}

}
