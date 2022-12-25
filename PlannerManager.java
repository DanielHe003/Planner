/*
 * Name: Daniel He
 * Solar ID: 114457594
 * Homework #1
 * Email: daniel.he@stonybrook.edu
 * Course: CSE214
 * Recitation #: R01 TA:Ulfeen Ayevan & Wesley Mui  
 */

import java.util.Scanner;

public class PlannerManager {
	/*
	* The main class is a switch case which prints out a menu of different options 
	* and then the user has the option of choosing a selection which then will implement
	* the appropriate selection.
	* 
	* @author Daniel He
	* email: daniel.he@stonybrook.edu
	* 114457594
	*/
	public static void main(String[] args) {
		Planner planner = new Planner();
		Planner BackupPlanner = null;
		Scanner scanner = new Scanner(System.in);
		String scan = "";

		while (scan != "Q") {
			mainMenu();
			System.out.printf("%nEnter a selection: ");
			scan = scanner.nextLine().toUpperCase();
			System.out.println();

			switch (scan) {
			//Adds a new course into the list.
			case "A":
				try {
					if(planner.size()>=50) {
						throw new FullPlannerException();
					}
				System.out.print("Enter course name: ");
				String name = scanner.nextLine();
								
				System.out.print("Enter department: ");
				String department = scanner.nextLine();
				
				System.out.print("Enter course code: ");
				String stringcode = scanner.nextLine();
				int code = Integer.parseInt(stringcode);
				
				System.out.print("Enter course section: ");
				String stringsection = scanner.nextLine();
				byte section = Byte.parseByte(stringsection);
				
				System.out.print("Enter instructor: ");
				String instructor = scanner.nextLine();
				
				System.out.print("Enter position: ");
				String stringposition = scanner.nextLine();
				int position = Integer.parseInt(stringposition);
				
				Course tempcourse = new Course(name, department, code, section, instructor);
				planner.addCourse(tempcourse, position-1);
				System.out.printf("\n%s %d.%02d successfully added to the planner.\n",tempcourse.getDEPARTMENT(),
						tempcourse.getCODE(),tempcourse.getSECTION());
					break;
					
				}catch(NumberFormatException e){
					System.out.printf("%nInvalid value, please enter a valid value!%n");
					break;
				}catch(IllegalArgumentException e) {
					System.out.printf("%nPlease enter correct values! Returning to the main menu.%n");
					break;
					
				}catch(FullPlannerException e){
					System.out.printf("%nThe planner is full!%n");
					break;
				}
				
			//Displays information of a Course at the given position.
			case "G": 
				System.out.print("Enter position: ");
				String pos = scanner.nextLine();
				System.out.println();
				int position = Integer.parseInt(pos);
				
				Course a = planner.getCourse(position-1);
	
				System.out.printf("%-6s%-27s%-11s%-5s%-8s%-10s", "No.", "Course Name",
						 "Department", "Code", "Section", "Instructor\n"
						 + "---------------------------------------------------------------------------\n");

				System.out.printf("  %-4s%-27s%-11s%-5s%7s%2s\n", position, a.getNAME(), 
						a.getDEPARTMENT(), a.getCODE(), "0" + a.getSECTION(), a.getINSTRUCTOR());
				break;
				
			//Removes the Course at the given position.
			case "R":
				try{
					System.out.print("Enter position: ");
					String e = scanner.nextLine();
					int positions = Integer.parseInt(e);
					if(planner.getCourse(positions) == null)
						throw new IllegalArgumentException();
					if(positions>50 || positions<1)
						throw new IllegalArgumentException();
					planner.removeCourse(positions);
					break;
				}catch(IllegalArgumentException e){
					System.out.println();
					System.out.println("That course is not there or the position is invalid!");
					break;
				}
	
			//Displays all courses in the list.
			case "P":
				planner.printAllCourses();
				break;
	
			//Displays courses that match the given department code.
			case "F":
				System.out.print("Enter department code: ");
				String e = scanner.nextLine();
				System.out.println();
				Planner.filter(planner, e);
				break;
	
			//Determines whether the course with the given attributes is in the list.
			case "L":
				try {
					System.out.print("Enter course name: ");
					String name = scanner.nextLine();
									
					System.out.print("Enter department: ");
					String department = scanner.nextLine();
					
					System.out.print("Enter course code: ");
					String stringcode = scanner.nextLine();
					int code = Integer.parseInt(stringcode);
					
					System.out.print("Enter course section: ");
					String stringsection = scanner.nextLine();
					byte section = Byte.parseByte(stringsection);
					
					System.out.print("Enter instructor: ");
					String instructor = scanner.nextLine();
			
					Course c = new Course(name, department, code, section, instructor);
					if(planner.findPosition(c) >= 0 || planner.findPosition(c)<50) {
						System.out.printf("\n%s %d.%02d is found in the planner at position %d.\n",
								c.getDEPARTMENT(),c.getCODE(),c.getSECTION(),planner.findPosition(c));
					}else{
						System.out.println("The course is not on the planner!");
					}
				}catch(NumberFormatException c) {
					System.out.println("The course does not exist or the data was entered incorrectly!");
					break;
				}
				break;
	
			//Determines the number of courses in the Planner.
			case "S":
					System.out.println("There are "+planner.size()+" courses in the planner.");
					break;
		
			//Creates a copy of the given Planner. Changes to the copy will not affect the original and vice versa.
			case "B":
				BackupPlanner = (Planner)planner.clone();
				System.out.println("Created a backup of the current planner.");
				break;
		
			//Displays all the courses from the backed-up list.
			case "PB":
				if(BackupPlanner==null) {
					System.out.println("There is no courses backed up.");
					break;
				}else{
					BackupPlanner.printAllCourses();
				}
				break;
			
			//Reverts the current Planner to the backed up copy.
			case "RB":
				if (BackupPlanner == null || BackupPlanner.size() == 0) {
					System.out.println("There is no backup!");
				}else{
					Planner newBackUp = (Planner)BackupPlanner.clone();
					planner = newBackUp;
					System.out.print("Planner successfully reverted to the backup copy.");
					System.out.println();
					break;
				}
				break;
				
			//Terminates the program.
			case "Q":
				System.out.println("Program terminating successfully...");
				return;
			default:
				System.out.printf("Please enter a choice on the list!\n");
				break;
				}
			}		
		scanner.close();
		}
		
		public static void mainMenu() {
			System.out.println();
			System.out.println("(A) Add Course");
			System.out.println("(G) Get Course");
			System.out.println("(R) Remove Course");
			System.out.println("(P) Print Courses in Planner");
			System.out.println("(F) Filter by Department Code");
			System.out.println("(L) Look For Course");
			System.out.println("(S) Size");
			System.out.println("(B) Backup");
			System.out.println("(PB) Print Courses in Backup");
			System.out.println("(RB) Revert to Backup");
			System.out.println("(Q) Quit");
		}
}