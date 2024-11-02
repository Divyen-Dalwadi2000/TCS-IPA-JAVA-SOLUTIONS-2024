/*
IPA 1
Create a class Student with below attributes:

rollNo - int
name - String
subject - String
grade - char
date - String [DD/MM/YYYY]



The above attributes should be private.Write Getter and Setter and parametrized 
constructor as required.


Create class Solution with main method.
****************************************************************************
Implement one static method: findStudentByGradeAndMonth Solution Class.


findStudentByGradeAndMonth Method:

This method will take an array of Student objects, char value as grade and int value as month 
for input parameters.The method will find out all Students from the given grade and month. 
This method will return array of Student object assending based on their rollNo if found. 
If there is no Student that matches then the method should return null.

for this method- main method should print Student name, subject and total student found [The 
length of the list], if the returned value is not null. If the returned value is null then 
main method should print "No student found".


NOTE:
	1. For Taking char as input use sc.nextLine().charAt(0)
	2. To match/check the month You havee to convert int month in the parameter to String.
	3. No need to count the Student array if return not null just print the array length.


****************************************************************************



Consider the below input and output:


input1:

111
Arijit
Math
B
22/09/2023

101
Priyanka
English
A
30/03/2022

107
Shreosi
History
C
13/05/2022

105
Tatan
Physics
A
27/03/2022

A
3


output1:

Priyanka
English
Tatan
Physics
2





input2:

111
Sohel
Math
B
22/09/2022

101
Priyanka
English
A
30/03/2022

107
Gopa
History
C
12/05/2022

105
Kamal
Physics
A
27/03/2022

A
7



output 2:

No student found
*/


//Q-17 
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class P1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		Student students[] = new Student[n];

		for (int i = 0; i < n; i++) {
			int rollno = sc.nextInt();
			sc.nextLine();
			String name = sc.nextLine();
			String subject = sc.nextLine();
			char grade = sc.nextLine().charAt(0);
			String date = sc.nextLine();
			students[i] = new Student(rollno, name, subject, grade, date);
		}

//		for(Student s : students )
//		{
//			System.out.printf("\n %d %.8s %.8s %c %.5s " , s.getRollno() , s.getName() , s.getSubject(), s.getGrade() , s.getDate() );
//		}
		char g = sc.nextLine().charAt(0);
		int m = sc.nextInt();
		sc.nextLine();
		Student result[] = findStudentByGradeAndMonth(students, g, m);

		if (result != null && result.length > 0) {
			int count = 0;
			for (Student s : result) {
				System.out.printf("\n%.8s %.8s ", s.getName(), s.getSubject());
				count++;
			}
			System.out.println("\n" + count);
		} else {
			System.out.println("\n No Result Found");
		}

	}

	public static Student[] findStudentByGradeAndMonth(Student[] students, char grade, int month) {
		Student s[] = new Student[0];

		for (int i = 0; i < students.length; i++) {
			String m[] = students[i].getDate().split("/");
			if (students[i].getGrade() == grade || Integer.parseInt(m[1]) == month) {
				s = Arrays.copyOf(s, s.length + 1);
				s[s.length - 1] = students[i];
			}
		}
		if (s.length > 0) {
//			Arrays.sort(s , Comparator.comparingInt(Student::getRollno)); // sort by roll number 
			Arrays.sort(s, Comparator.comparing(Student::getName)); // sort by name
			return s;
		} else {
			return null;
		}
	}
}

class Student {
	private int rollno;
	private String name;
	private String subject;
	private char grade;
	private String date;

	public Student(int rollno, String name, String subject, char grade, String date) {
		this.rollno = rollno;
		this.name = name;
		this.subject = subject;
		this.grade = grade;
		this.date = date;
	}

	public int getRollno() {
		return rollno;
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