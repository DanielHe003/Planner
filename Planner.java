/*
 * Name: Daniel He
 * Solar ID: 114457594
 * Homework #1
 * Email: daniel.he@stonybrook.edu
 * Course: CSE214
 * Recitation #: R01 TA:Ulfeen Ayevan & Wesley Mui  
 */

/*
* The Planner class implements a planner object with a array of Course objects. 
* 
* @author Daniel He
* email: daniel.he@stonybrook.edu
* 114457594
*/
public class Planner {
	final int MAX_COURSES = 50;
	Course array[];
	public int COUNT;
	
	/*
	* Constructs an instance of the Planner with no Course objects in it.
	* 
	* <dt>Postcondition: 
	* 	<dd>This Planner has been initialized to an empty list of Courses.
	*/	
	 public Planner() {
		 array = new Course[MAX_COURSES];
	 }
	 
	/*
	* Determines the number of courses currently in the list.
	* 
	* <dt> Preconditions:
	* 	<dd> This Planner has been instatiated.
	* 
	* @return
	* 	The number of Courses in this Planner.
	*/	
	 
	 public int size() {
		return COUNT;
	 }
	 
	 /*
	 * Determines the number of courses currently in the list.
	 * 
	 * @param newCourse
	 * 		The new course to add to the list
	 * @param position 
	 * 		The position (preference) of this course on the list
	 * 
	 * <dt> Preconditions:
	 * 	<dd>This Course object has been instantiated and 1 <= position <= items_currently_in_list + 1.
	 * 		 The number of Course objects in this Planner is less than MAX_COURSES.
	 * 
	 * <dt> Postconditions:
	 * 	<dd>The new Course is now listed in the correct preference on the list. All Courses that were 
	 * 		originally greater than or equal to position are moved back one position. (e.g. If there 
	 * 		are 5 Courses in a Planner, positioned 1-5, and you insert a Course in position 4, the new 
	 * 		Course would be placed in position 4, the Course that was in position 4 will be moved to 
	 * 		position 5, and the Course that was in position 5 will be moved to position 6.)
	 * 
	 * @exception IllegalArgumentException
	 * 		Indicates that position is not within the valid range.
	 * 
	 * @exception FullPlannerExpcetion
	 * 		Indicates that there is no more room in the Planner to record an additional Course.
	 */
	 public void addCourse(Course newCourse, int position) {
		 try {
			 if(position > MAX_COURSES || position<0)
				 throw new IllegalArgumentException();
			 if(this.size()==MAX_COURSES)
				throw new FullPlannerException(); 
			 if(this.getCourse(position) != null) {
				 for(int i = COUNT; i>=position; i--) {
					 if(i>0) {
						 array[i]=array[i-1];
					 }
				 }
				 array[position]=newCourse;
			 }else if (this.getCourse(position) == null){
				 array[COUNT]=newCourse;
			 }else if(position>COUNT) {
				 array[COUNT]=newCourse;
			 }
			 COUNT++;

		 }catch(IllegalArgumentException e){
			 System.out.println();
			 System.out.printf("That position is not within the valid range!\n");
		 }
		 catch(FullPlannerException e){
			 System.out.printf("There is no more room in the Planner to record an additional Course!\n");
		 }
	}
	 /*
	 * Works just like public void addCourse(Course newCourse, int position), 
	 * except adds to the end of the list.
	 */
	 public void addCourse(Course newCourse) {
		 addCourse(newCourse, size() + 1);
	 }
	 
	 /*
	 * Removes a course from the planner.
	 * 
	 * @param position 
	 * 		The position in the Planner where the Course will be removed from.
	 * 		
	 * <dt> Preconditions:
	 * 	<dd>This Planner has been instantiated and 1 <= position <= items_currently_in_list.
	 * 
	 * <dt> Postconditions:
	 * 	<dd>The Course at the desired position has been removed. All Courses that were 
	 * 		originally greater than or equal to position are moved backward one position. 
	 * 		(e.g. If there are 5 Courses in a Planner, positioned 1-5, and you remove the 
	 * 		Course in position 4, the item that was in position 5 will be moved to position 4.)
	 * 
	 * @exception IllegalArgumentException
	 * 		Indicates that position is not within the valid range.
	 */ 
	 public void removeCourse(int position) {
		 try {
			 if(position>MAX_COURSES-1 || position <0)
				 throw new IllegalArgumentException();
			 position-=1;
			 if(array[position] == null) { 
				 System.out.println("There is no course in that position!");
				 return;
			 }else if(array[position] != null) {
				 Course temp = this.getCourse(position);
				 for(int i = position; i<array.length-1; i++) {
					 array[i] = array[i+1];
					 if(array[i+1] == null) {
						 break;
					 }
				 }
				 System.out.printf("\n%s %d.%02d was successfully removed from the planner.\n",
						 temp.getDEPARTMENT(),temp.getCODE(),temp.getSECTION());
				 COUNT-- ;
			 }
			 }catch(IllegalArgumentException e){
				 System.out.printf("\nThat position is not within the valid range or there is no course there!\n");
			 }catch(ArrayIndexOutOfBoundsException e){
				 System.out.println("The position you have entered is not in the planner!");
			 }
	 }
	 
	 /*
	 * Determines the number of courses currently in the list.
	 * 
	 * @param position 
	 * 		Position of the Course to retrieve.
	 * 
	 * <dt> Preconditions:
	 * 	<dd>The Planner object has been instantiated and 1 <= position <= items_currenyly_in_list.
	 * 
	 * @return
	 * 	The Course at the specified position in this Planner object.
	 * 
	 * @exception IllegalArgumentException
	 * 		Indicates that position is not within the valid range.
	 */
	 public Course getCourse(int position) {
		try {
			if(position>MAX_COURSES || position<0)
				throw new IllegalArgumentException();
			return array[position];
		}
		catch(IllegalArgumentException e){
			 System.out.println("That position is not within the valid range!");
		} return array[position];
	 }
	 
	 /*
	 * Prints all Courses that are within the specified department.
	 * 
	 * @param planner 
	 * 		The list of courses to search in
	 * @param department
	 * 		The 3 letter department code for a Course
	 * 
	 * <dt> Preconditions:
	 * 	<dd>This Planner object has been instantiated.
	 * 
	 * <dt> Postconditions:
	 * 	<dd>Displays a neatly formatted table of each course filtered from the Planner. 
	 * 		Keep the preference numbers the same.
	 */
	 public static void filter(Planner planner, String department) {
				 boolean notempty = false;
				 for(int i=0; i<planner.size(); i++) {
					 Course course = planner.getCourse(i);
					 if(course.getDEPARTMENT().equals(department)) {
						 notempty = true;
						 break;
					 }
				 }
				 if(notempty == true){
					 System.out.printf("%-6s%-27s%-11s%-5s%-8s%-10s", "No.", "Course Name",
							 "Department", "Code", "Section", "Instructor\n"
							 + "---------------------------------------------------------------------------\n");
				 
					 for(int i=0; i<planner.size(); i++) {
						 Course course = planner.getCourse(i);
						 if (course.getDEPARTMENT().equals(department)) {
							System.out.printf("  %-4s%-27s%-11s%-5s%7s%2s\n", i + 1, course.getNAME(), 
									course.getDEPARTMENT(), course.getCODE(), "0" + course.getSECTION(), course.getINSTRUCTOR());
							System.out.println();
						 }
					 }
				 }
				 if(notempty == false) {
					 System.out.println("The planner does not have that course!");
					 return;
				 }
	}
	 
	/*
	 * Prints a neatly formatted table of each item in the list with its 
	 * position number as shown in the sample output.
	 * 
	 * <dt> Preconditions:
	 * 	<dd> This Planner has been instantiated.
	 * 
	 * <dt> Postconditions:
	 * 	<dd> Displays a neatly formatted table of each course from the Planner.
	 * 
	*/
	 public void printAllCourses() {
		 System.out.print(this.toString());
	}
	 
	/*
	 * Determines the number of courses currently in the list.
	 * 
	 * @param newCourse
	 * 		The new course to add to the list
	 * @param position 
	 * 		The position (preference) of this course on the list
	 * 
	 * <dt> Preconditions:
	 * 	<dd>This Course object has been instantiated and 1 <= position <= items_currently_in_list + 1.
	 * 		 The number of Course objects in this Planner is less than MAX_COURSES.
	 * 
	 * <dt> Postconditions:
	 * 	<dd>The new Course is now listed in the correct preference on the list. All Courses that were 
	 * 		originally greater than or equal to position are moved back one position. (e.g. If there 
	 * 		are 5 Courses in a Planner, positioned 1-5, and you insert a Course in position 4, the new 
	 * 		Course would be placed in position 4, the Course that was in position 4 will be moved to 
	 * 		position 5, and the Course that was in position 5 will be moved to position 6.)
	 * 
	 * @exception IllegalArgumentException
	 * 		Indicates that position is not within the valid range.

	 * @exception FullPlannerExpcetion
	 * 		Indicates that there is no more room in the Planner to record an additional Course.
	 *
	 * @return
	 * 	The number of Courses in this Planner.
	 */
	 public int findPosition(Course course) {
			for (int i = 0; i < array.length; i++) {
				if (array[i].getNAME().equals(course.getNAME()))
				return i+1;
		}
			return 0;
	 }
	 
	/*
	 * Checks whether a certain Course is already in the list.
	 * 
	 * @param course
	 * 		The Course we are looking for
	 *
	 * <dt> Preconditions:
	 * 	<dd>This Planner and Course has both been instantiated.
	 * 
	 * @return
	 * 	True if the Planner contains this Course, false otherwise.
	 */
	 public boolean exists (Course course) {
		 for (int i = 0; i < this.size(); i++) {
			 if (array[i].getNAME().equals(course.getNAME()))
				 return true;
		 }
		 return false;
		 }
	 
	/*
	 * Creates a copy of this Planner. Subsequent changes to the copy will not affect the original and vice versa.
	 * 
	 * <dt> Preconditions:
	 * 	<dd>This Planner object has been instantiated.
	 * 
	 * @return
	 * 	A copy (backup) of this Planner object.
	 */
	 public Object clone() {
		 Planner planner = new Planner();
		 for(int i=0; i<this.size(); i++) 
			planner.array[i]=(Course)array[i].clone();
		 planner.COUNT=this.COUNT;
		 return planner;
		 }
	 
	/*
	 * Gets the String representation of this Planner object, which is a neatly formatted table of each Course 
	 * in the Planner on its own line with its position number as shown in the sample output.
	 * 
	 * @return
	 * 	The String representation of this Planner object.
	*/
	 public String toString() {
		 String STRING = String.format("%-6s%-27s%-11s%-5s%-8s%-10s", "No.", "Course Name",
				 "Department", "Code", "Section", "Instructor\n"
				 + "---------------------------------------------------------------------------\n");
		for (int i = 0; i < COUNT; i++) {
			Course course = this.getCourse(i);
			STRING += String.format("  %-4s%-27s%-11s%-5s%7s%2s\n", i + 1, course.getNAME(), 
					course.getDEPARTMENT(), course.getCODE(), "0" + course.getSECTION(), course.getINSTRUCTOR());
		}
		 return STRING;
	 }
}