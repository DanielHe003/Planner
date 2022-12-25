/*
 * Name: Daniel He
 * Solar ID: 114457594
 * Homework #1
 * Email: daniel.he@stonybrook.edu
 * Course: CSE214
 * Recitation #: R01 TA:Ulfeen Ayevan & Wesley Mui  
 */

/*
* The Course class creates a new Course Object and implements methods to get and set different Course parameters. 
* 
* @author Daniel He
* email: daniel.he@stonybrook.edu
* 114457594
*/
public class Course {
	
	private String NAME;
	private String DEPARTMENT;
	private int CODE;
	private byte SECTION;
	private String INSTRUCTOR;
	
	/*
	 * Constructs an Course objects with null or 0 fields.
	 * 
	 * <dt> Postconditions:
	 * 	<dd> The course has been initialized with empty fields.
	 * 
	 */
	public Course() {
		NAME = null;
		DEPARTMENT = null;
		CODE = 0;
		SECTION = 0;
		INSTRUCTOR = null;
	}
	
	/*
	 * Does the same thing as the Course() method but uses user inputted fields to set the fields.
	 * 
	 * @param NAME
	 * 		New name for the course
	 * @param DEPARTMENT 
	 * 		New department for the course
	 * @param CODE
	 * 		New code for the course
	 * @param SECTION 
	 * 		New section for the course
	 * @param INSTRUCTOR
	 * 		New instructor for the course
	 * 
	 */
	public Course(String NAME, String DEPARTMENT, int CODE, byte SECTION, String INSTRUCTOR) {
		this.NAME = NAME;
		this.DEPARTMENT = DEPARTMENT;
		this.CODE = CODE;
		this.SECTION = SECTION;
		this.INSTRUCTOR = INSTRUCTOR;
	}
	
	/*
	 * Replaces the string name with the parameter string
	 * 
	 * @param NAME
	 * 		New name for the course
	 * 
	 * <dt> Preconditions:
	 * 	<dd>This Course object has been instantiated.
	 * 
	 * <dt> Postconditions:
	 * 	<dd>The new Course now has a new NAME field with the parameter string.
	 * 
	 */
	public void setNAME(String NAME){
		this.NAME = NAME;
	}
	
	/*
	 * returns the string name
	 * 
	 * <dt> Preconditions:
	 * 	<dd> This Course object has been instantiated.
	 * 
	 * @return
	 * 	The Course name
	 * 
	 */
	public String getNAME() {
		return NAME;
	}
	
	/*
	 * Replaces the string department with the parameter string
	 * 
	 * @param DEPARTMENT
	 * 		New department for the course
	 * 
	 * <dt> Preconditions:
	 * 	<dd>This Course object has been instantiated.
	 * 
	 * <dt> Postconditions:
	 * 	<dd>The new Course now has a new DEPARTMENT field with the parameter string.
	 * 
	 */
	public void setDEPARTMENT(String DEPARTMENT){
		this.DEPARTMENT = DEPARTMENT;
	}
	
	/*
	 * returns the string department
	 * 
	 * <dt> Preconditions:
	 * 	<dd> This Course object has been instantiated.
	 * 
	 * @return
	 * 	The Course department
	 * 
	 */
	public String getDEPARTMENT() {
		return DEPARTMENT;
	}
	
	/*
	 * Replaces the integer CODE with the parameter integer
	 * 
	 * @param CODE
	 * 		New code for the course
	 * 
	 * <dt> Preconditions:
	 * 	<dd>This Course object has been instantiated.
	 * 
	 * <dt> Postconditions:
	 * 	<dd>The new Course now has a new CODE field with the parameter integer.
	 * 
	 */
	public void setCODE(int CODE){
		if(CODE<=0) {
			throw new IllegalArgumentException("CODE can't be smaller than 0.");
		}
		this.CODE = CODE;
	}
	
	/*
	 * returns the integer code
	 * 
	 * <dt> Preconditions:
	 * 	<dd> This Course object has been instantiated.
	 * 
	 * @return
	 * 	The Course code
	 * 
	 */
	public int getCODE() {
		return CODE;
	}
	
	/*
	 * Replaces the byte SECTION with the parameter byte
	 * 
	 * @param SECTION
	 * 		New section for the course
	 * 
	 * <dt> Preconditions:
	 * 	<dd>This Course object has been instantiated.
	 * 
	 * <dt> Postconditions:
	 * 	<dd>The new Course now has a new SECTION field with the parameter byte.
	 * 
	 */
	public void setSECTION(byte SECTION){
		if(SECTION<=0) {
			throw new IllegalArgumentException("SECTION can't be smaller than 0.");
		}
		this.SECTION = SECTION;
	}
	
	/*
	 * returns the byte section
	 * 
	 * <dt> Preconditions:
	 * 	<dd> This Course object has been instantiated.
	 * 
	 * @return
	 * 	The Course section
	 * 
	 */
	public byte getSECTION() {
		return SECTION;
	}
	
	/*
	 * Replaces the string INSTRUCTOR with the parameter string
	 * 
	 * @param INSTRUCTOR
	 * 		New instructor for the course
	 * 
	 * <dt> Preconditions:
	 * 	<dd>This Course object has been instantiated.
	 * 
	 * <dt> Postconditions:
	 * 	<dd>The new Course now has a new INSTRUCTOR field with the parameter string.
	 * 
	 */
	public void setINSTRUCTOR(String INSTRUCTOR){
		this.INSTRUCTOR = INSTRUCTOR;
	}
	
	/*
	 * returns the string instructor
	 * 
	 * <dt> Preconditions:
	 * 	<dd> This Course object has been instantiated.
	 * 
	 * @return
	 * 	The Course instructor
	 * 
	 */
	public String getINSTRUCTOR() {
		return INSTRUCTOR;
	}
	
	/*
	 * Constructs and returns an Course objects with the exact same fields but a different reference
	 * 
	 * <dt> Preconditions:
	 * 	<dd>A Course object has been instantiated.
	 * 
	 * <dt> Postconditions:
	 * 	<dd>The new Course is now listed with the same fields but in a difference reference
	 * 
	 * @return
	 * 	a Course with the same parameters but difference references
	 */
    public Object clone(){
		Course tempCourse = new Course();
		tempCourse.setCODE(CODE);
		tempCourse.setDEPARTMENT(DEPARTMENT);
		tempCourse.setINSTRUCTOR(INSTRUCTOR);
		tempCourse.setNAME(NAME);
		tempCourse.setSECTION(SECTION);
        return tempCourse;
    }
    
    /*
	 * Compares two difference courses to see if they have the same fields.
	 * 
	 * @param obj
	 * 	The object which we are comparing
	 * 
	 * <dt> Preconditions:
	 * 	<dd>Two instantiated courses.
	 * 
	 * @return
	 * 	a boolean value which answers if the two courses have the same fields.
	 */
	public boolean equals(Object obj) {
		if(obj instanceof Course != true) {
			return false;
		} else if((NAME == ((Course)obj).getNAME() && DEPARTMENT == ((Course)obj).getDEPARTMENT() && 
				CODE == ((Course)obj).getCODE() && SECTION == ((Course)obj).getSECTION() && 
				INSTRUCTOR == ((Course)obj).getINSTRUCTOR()) == true) {
			return true;
		}
		return false;
	}

}
