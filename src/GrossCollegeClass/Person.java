package GrossCollegeClass;

//person class
public class Person {

	// variables
	int studentID;
	String studentFirst;
	String studentLast;

	// constructors
	public Person(int id, String studentFirst, String studentLast) {
		super();
		studentID = id;
		this.studentFirst = studentFirst;
		this.studentLast = studentLast;
	}

	public Person() {
		super();
			}

	// tostring() method

	public String toString() {
		return this.getstudentFirst() + " " + this.getstudentLast();
	}

	// getter and setter of Person class
	public int getstudentID() {
		return studentID;
	}

	public void setstudentID(int id) {
		studentID = id;
	}

	public String getstudentFirst() {
		return studentFirst;
	}

	public void setstudentFirst(String studentFirst) {
		this.studentFirst = studentFirst;
	}

	public String getstudentLast() {
		return studentLast;
	}

	public void setstudentLast(String studentLast) {
		this.studentLast = studentLast;
	}

}