package virtual.pets.amok;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class VirtualPetsAmokApp {

	static Shelter myShelter = new Shelter();
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("\r\n" + "__________        __              _____                  __    \r\n"
				+ "\\______   \\ _____/  |_  ______   /  _  \\   _____   ____ |  | __\r\n"
				+ " |     ___// __ \\   __\\/  ___/  /  /_\\  \\ /     \\ /  _ \\|  |/ /\r\n"
				+ " |    |   \\  ___/|  |  \\___ \\  /    |    \\  Y Y  (  <_> )    < \r\n"
				+ " |____|    \\___  >__| /____  > \\____|__  /__|_|  /\\____/|__|_ \\\r\n"
				+ "               \\/          \\/          \\/      \\/            \\/\r\n" + "");
		myShelter.intake(new Dog("Rover", 10, 10, 10, 10, true));
		myShelter.intake(new Dog("Beans", 10, 10, 10, 10, true));
		myShelter.intake(new Cat("Hairball", 10, 10, 10, 10));
		myShelter.intake(new Cat("Sneezy", 10, 10, 10, 10));
		myShelter.intake(new RoboCat("Pounce5000", 10, 10, 10));
		myShelter.intake(new RoboCat("Purrtron", 10, 10, 10));
		myShelter.intake(new RoboDog("B.A.R.K.", 10, 10, 10));
		String menuChoice;
		do {
			displayPets();
			displayMenu();
			menuChoice = input.nextLine();
			takeAction(menuChoice);
			myShelter.tick();
		} while (!menuChoice.equalsIgnoreCase("quit"));
		System.out.println("Goodbye!");
		input.close();
	}

	private static void takeAction(String menuChoice) {
		if (menuChoice.equals("1")) {
			adoptionMenu();
		} else if (menuChoice.equals("2")) {
			addPetMenu();
		} else if (menuChoice.equals("3")) {
			cleanCageMenu();
		} else if (menuChoice.equals("4")) {
			myShelter.emptyLitterBox();
		} else if (menuChoice.equals("5")) {
			myShelter.feedAll();
		} else if (menuChoice.equals("6")) {
			myShelter.waterAll();
		} else if (menuChoice.equals("7")) {
			myShelter.oilAll();
		} else if (menuChoice.equals("8")) {
			myShelter.walkAll();
		} else if (menuChoice.equals("9")) {
			playMenu();
		}
	}

	private static void cleanCageMenu() {
		boolean exitMenu = false;
		Collection<Pet> pets = myShelter.getPets();
		ArrayList<Canine> canines = new ArrayList<>();
		for (Pet aPet : pets) {
			if (aPet instanceof Canine) {
				canines.add((Canine) aPet);
			}
		}
		int cageToClean = 0;
		while (!exitMenu) {
			try {
				System.out.println("Which cage would you like to clean?");
				for (int i = 1; i <= canines.size(); i++) {
					Pet aPet = (Pet) canines.get(i - 1);
					System.out.println("[" + i + "] " + aPet.getName() + " with cage dirtiness "
							+ myShelter.getDirty(aPet) * 10 + "%");
				}
				String menuChoice = input.nextLine();
				cageToClean = Integer.parseInt(menuChoice) - 1;
				exitMenu = true;
			} catch (NumberFormatException e) {
				System.out.println("Enter a cage number");
			}
		}
		myShelter.cleanCage((Pet) canines.get(cageToClean));
		System.out.println("You clean the cage.\n");

	}

	private static void playMenu() {
		boolean exitMenu = false;
		ArrayList<Pet> pets = new ArrayList<>(myShelter.getPets());
		Pet petToPlay = null;
		while (!exitMenu) {
			try {
				System.out.println("Which pet would you like to play with?");
				for (int i = 1; i <= pets.size(); i++) {
					System.out.println("[" + i + "] " + pets.get(i - 1).getName() + " with boredom of "
							+ pets.get(i - 1).getBoredom());
				}
				String menuChoice = input.nextLine();
				petToPlay = pets.get(Integer.parseInt(menuChoice) - 1);
				exitMenu = true;
			} catch (NumberFormatException e) {
				System.out.println("Enter a number");
			}
		}
		petToPlay.play();
		System.out.println("You play with " + petToPlay.getName() + ".\n");
	}

	private static void addPetMenu() {
		System.out.println("Answer a couple of questions for pet intake.");
		String menuChoice;
		int petSpecies = 0;
		while (!((petSpecies == 1) || (petSpecies == 2) || (petSpecies == 3) || (petSpecies == 4))) {
			try {
				System.out.println("What is the species of pet?");
				System.out.println("[1] Dog\n[2] Cat\n[3] Robot Dog\n[4] Robot Cat");
				menuChoice = input.nextLine();
				petSpecies = Integer.parseInt(menuChoice);
			} catch (NumberFormatException e) {
				System.out.println("Enter a number");
			}
		}
		System.out.println("What is the pet's name?");
		String petName = input.nextLine();
		if (petSpecies == 1) {
			Dog petToIntake = new Dog(petName, 10, 10, 10, 10, false);
			myShelter.intake(petToIntake);
		} else if (petSpecies == 2) {
			Cat petToIntake = new Cat(petName, 10, 10, 10, 10);
			myShelter.intake(petToIntake);
		} else if (petSpecies == 3) {
			RoboDog petToIntake = new RoboDog(petName, 10, 10, 10);
			myShelter.intake(petToIntake);
		} else if (petSpecies == 4) {
			RoboCat petToIntake = new RoboCat(petName, 10, 10, 10);
			myShelter.intake(petToIntake);
		}
		System.out.println(petName + " now has a home in the shelter.\n");
	}

	private static void adoptionMenu() {
		boolean exitMenu = false;
		ArrayList<Pet> pets = new ArrayList<>(myShelter.getPets());
		Pet petToAdopt = null;
		while (!exitMenu) {
			try {
				System.out.println("Which pet is being adopted?");
				for (int i = 1; i <= pets.size(); i++) {
					System.out.println("[" + i + "] " + pets.get(i - 1).getName());
				}
				String menuChoice = input.nextLine();
				petToAdopt = pets.get(Integer.parseInt(menuChoice) - 1);
				exitMenu = true;
			} catch (NumberFormatException e) {
				System.out.println("Enter a number");
			}
		}
		myShelter.adopt(petToAdopt);
		System.out.println(petToAdopt.getName() + " found a new home!\n");
	}

	private static void displayPets() {
		Collection<Pet> petList = myShelter.getPets();
		for (Pet pet : petList) {
			System.out.print(pet);
			if (pet instanceof Dog) {
				System.out.println("\tCage Dirtiness = " + myShelter.getDirty(pet) * 10 + "%");
			} else if (pet instanceof Cat) {
				System.out.println("\tLitterbox Dirtiness = " + myShelter.getDirty(pet) * 5 + "%");
			} else {
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
