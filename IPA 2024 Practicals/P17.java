
//Create a class Student with below attributes:
//
//rollNo - int
//name - String
//subject - String
//grade - char
//date - String [DD/MM/YYYY]
//
//
//
//The above attributes should be private.Write Getter and Setter and parametrized constructor as required.
//
//
//Create class Solution with main method.
//****************************************************************************
//Implement one static method: findStudentByGradeAndMonth Solution Class.
//
//
//findStudentByGradeAndMonth Method:
//
//This method will take an array of Student objects, char value as grade and int value as month 
//for input parameters.The method will find out all Students from the given grade and month. 
//This method will return array of Student object assending based on their rollNo if found. 
//If there is no Student that matches then the method should return null.
//
//for this method- main method should print Student name, subject and total student found [The 
//length of the list], if the returned value is not null. If the returned value is null then 
//main method should print "No student found".
//
//
//NOTE:
//	1. For Taking char as input use sc.nextLine().charAt(0)
//	2. To match/check the month You havee to convert int month in the parameter to String.
//	3. No need to count the Student array if return not null just print the array length.
//
//
//****************************************************************************
//
//
//
//Consider the below input and output:
//
//
//input1:
//
//111
//Arijit
//Math
//B
//22/09/2023
//101
//Priyanka
//English
//A
//30/03/2022
//107
//Shreosi
//History
//C
//13/05/2022
//105
//Tatan
//Physics
//A
//27/03/2022
//A
//3
//
//
//output1:
//
//Priyanka
//English
//Tatan
//Physics
//2
//
//
//
//
//
//input2:
//
//111
//Sohel
//Math
//B
//22/09/2022
//101
//Priyanka
//English
//A
//30/03/2022
//107
//Gopa
//History
//C
//12/05/2022
//105
//Kamal
//Physics
//A
//27/03/2022
//A
//7
//
//output 2:
//
//No student found
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class P17 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		List<Students> students = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int rollNo = sc.nextInt();
			sc.nextLine();
			String name = sc.nextLine();
			String subject = sc.nextLine();
			char grade = sc.nextLine().charAt(0);
			String date = sc.nextLine();

			students.add(new Students(rollNo, name, subject, grade, date));
		}

		char grade = sc.nextLine().charAt(0);
		int month = sc.nextInt();
		sc.nextLine();
		List<Students> list = findStudentByGradeAndMonth(students, grade, month);
		if(list == null )
		{
			System.out.println("No Such Record Exists ");
		}
		else {
			for(Students s : list)
			{
				System.out.println(s.getName());
				System.out.println(s.getSubject());
			}			
			System.out.println(list.size());
		}
		
	}

	public static List<Students> findStudentByGradeAndMonth(List<Students> students, char grade, int month) {
		List<Students> list = new ArrayList();
		for (Students s : students) {
			String d[] = s.getDate().split("/");
			int m = Integer.parseInt(d[1]);
			if (s.getGrade() == grade && m == month) {
				list.add(s);
			}
		}

		return list.isEmpty() ? null : list;
	}
}

class Students {
	private int rollNo;
	private String name;
	private String subject;
	private char grade;
	private String date;

	public Students(int rollNo, String name, String subject, char grade, String date) {
		this.rollNo = rollNo;
		this.name = name;
		this.subject = subject;
		this.grade = grade;
		this.date = date;
	}

	public int getRollNo() {
		return rollNo;
	}

	public String getName() {
		return name;
	}

	public String getSubject() {
		return subject;
	}

	public char getGrade() {
		return grade;
	}

	public String getDate() {
		return date;
	}
}
//4
//111
//Arijit
//Math
//B
//22/09/2023
//101
//Priyanka
//English
//A
//30/03/2022
//107
//Shreosi
//History
//C
//13/05/2022
//105
//Tatan
//Physics
//A
//27/03/2022
//A
//3