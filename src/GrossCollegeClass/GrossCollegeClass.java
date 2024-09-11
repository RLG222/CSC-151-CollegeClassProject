/*This is Robert Gross' Final project written on the week of July 11th, 2023. The purpose of this program
 * is to make a faux college class using the parameters required from the project. it allows the user to
 * input info about the class, as well as about the students. It then prints the info about the class to the
 * console, and the info about the students to .txt file using a FileWriter.
 * 
 */
package GrossCollegeClass;
//imports for Test
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
//GrossCollege Class
public class GrossCollegeClass {

	// main method to test student class
	public static void main(String[] args) {
//new scanner
		Scanner scan = new Scanner(System.in);
//request info about class from user
		System.out.println("Hi. Please enter the name of the class: ");
		String className = scan.nextLine();
		System.out.println("Please enter the Location of the class: ");
		String classLocation = scan.nextLine();
		System.out.println("Please enter the name of the Professor: ");
		String classProfessor = scan.nextLine();
		System.out.println("Please enter the maximum number of students: ");
//variables
		int maxStudents = scan.nextInt(); 
		int currentStudents = 0;
		boolean shouldQuit = false;

		// input stream class
		while (!shouldQuit) {
			// students arraylist
			ArrayList<GrossStudent> students = new ArrayList<>();
			// loop until enter QUIT
			while (!shouldQuit) {
				// taking student data from user
				System.out.println("Enter student information (or QUIT to quit):");
				System.out.print("First Name: ");
				String studentFirst = scan.nextLine();
				if (studentFirst.equals("QUIT"))
					break;// break if QUIT 
				System.out.print("Last Name: ");
				String studentLast = scan.nextLine();
				System.out.print("studentID number: ");
				int id = Integer.parseInt(scan.nextLine());
				System.out.print("Major: ");
				String major = scan.nextLine();
				GrossStudent s1 = new GrossStudent(id, studentFirst, studentLast, major);
				System.out.println("Enter grades for " + s1.getstudentFirst() + " " + s1.getstudentLast() + ":");
				// request exam grades and create list
				ArrayList<Double> examGrades = new ArrayList<>();
				while (true) {
					System.out.print("Enter exam grade (-1 to stop):");
					Double grade = Double.parseDouble(scan.nextLine());
					if (grade == -1)
						break; //if -1 break the list
					// add grade
					examGrades.add(grade);
				}
				s1.setExamGrades(examGrades);
				// add student
				students.add(s1); //create new student with info
				currentStudents++; // add one to students counter
			}
			if (currentStudents > maxStudents) { //if more students than max, reload program
				System.out.println("TOO MANY STUDENTS. PLEASE RELOAD AND TRY AGAIN.");
				shouldQuit = true;
			} else { //otherwise print class info to scanner and print the student info to a new txt file
				System.out.println("\nClass: " + className + "\nLocation: " + classLocation +
							"\nProfessor: " + classProfessor + "\nSize: " + currentStudents + 
							"/" + maxStudents );
				// Writing output to a file
				try {
					FileWriter fileWriter = new FileWriter("output.txt");
					PrintWriter printWriter = new PrintWriter(fileWriter);

					students.forEach(s1 -> {
						printWriter.println(s1.toString());
					});

					printWriter.close(); //close printer
					System.out.println("\n\n\nOutput written to output.txt\n\n\n");
				} catch (IOException e) {
					e.printStackTrace();
				}

				System.out.println("Press Q to quit or any other key to continue..."); //end program with q
				String key = scan.nextLine();
				shouldQuit = key.equalsIgnoreCase("Q");

			}

		}
		scan.close(); //close scanner
	}

}