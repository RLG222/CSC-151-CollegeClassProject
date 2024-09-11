package GrossCollegeClass;

import java.util.ArrayList;
//student class
public class GrossStudent extends Person {

	// variables
	String major;
	ArrayList<Double> examGrades;

	// constructors
	public GrossStudent(int id, String studentFirst, String studentLast, String major) {
		super(id, studentFirst, studentLast);
		this.major = major;
	}

	public GrossStudent() {
		super();
	
	}

	// add exam grade to arraylist
	public void addExamGrade(Double grade) {
		this.getExamGrades().add(grade);
	}

	// get exam grade of particular index
	public Double getExamGrade(int index) {
		return this.getExamGrades().get(index);
	}

	// get the average of all grades
	public Double getGradeAverage() {
		Double total = 0.0;
		for (int i = 0; i < this.getExamGrades().size(); i++) {
			total += this.getExamGrade(i);
		}

		return total / this.getExamGrades().size();
	}

	// get char grade
	public char getLetterGrade() {
		Double grade = this.getGradeAverage();
		if (grade >= 90)
			return 'A';
		else if (grade >= 80)
			return 'B';
		else if (grade >= 70)
			return 'C';
		else if (grade >= 50)
			return 'D';
		else
			return 'E';
	}

	// tostring() method
	public String toString() {
		return "Student studentID: " + this.getstudentID() + "\nName: " + this.getstudentFirst() + " " + this.getstudentLast() + "\nMajor: "
				+ this.getMajor() + "\nAverage: " + this.getGradeAverage() + "\nGrade: " + this.getLetterGrade();
	}

	// getters and setters
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public ArrayList<Double> getExamGrades() {
		return examGrades;
	}

	public void setExamGrades(ArrayList<Double> examGrades) {
		this.examGrades = examGrades;
	}

}
