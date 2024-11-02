
/*
 *create the class Course with the below Attributes.

courseId- int
courseName- String
courseAdmin- String
quiz- int
handson -int

The above methods should be private ,write getter and
setter and parametrized constructor as required.

create class courseProgram with main method.

implement two static methods-
   findAvgOfQuizByAdmin method:this method will take array
of Course objects and a String  value as input parameters.
This method will find out Average (as int) of Quiz questions
for given Course Admin (String parametre passed)
This method will return Average if found.if there is no course
that matches then the method should return 0.

sortCourseByHandsOn method:
This method will take an Array of Course Objects and int
value as input parameters.
This methods should return an Array of Course objects in an
ascending order of their  handson which are less than the
given handson(int parameter passed) value. if there is no
such course then the method should return null.

The above mentioned static methods should be called from
main methods.

for findAvgOfQuizByAdmin method: The main method
should print the average if the returned value is not 0.
if the returned value is 0 then it should print "No Course
found."


for sortCourseByHandsOn method:
                        the  main method should print the name
of the Course from the returned Course object Array if the
returned value is not null.if the returned value is null then
it should print "No Course found with mentioned attribute."

input1:
111
kubernetes
Nisha
40
10

321
cassandra
Roshini
30
15

457
Apache Spark
Nisha
30
12

987
site core
Tirth
50
20

Nisha
17

output1:
35
kubernetes
Apache Spark
cassandra

input2:
111
kubernetes
Nisha
40
10
321
cassandra
Roshini
30
15
457
Apache Spark
Nisha
30
12
987
site core
Tirth
50
20
Shubhamk
5

output 2:
No Course found
No Course found with mentioned attributes.

 */
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class P2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();

		Course courses[] = new Course[n];

		for (int i = 0; i < n; i++) {
			int cId = sc.nextInt();
			sc.nextLine();
			String cName = sc.nextLine();
			String cAdmin = sc.nextLine();
			int quiz = sc.nextInt();
			sc.nextLine();
			int handson = sc.nextInt();
			sc.nextLine();

			courses[i] = new Course(cId, cName, cAdmin, quiz, handson);

		}
		String admin = sc.nextLine();

		int handson = sc.nextInt();
		sc.nextLine();

		int avg = findAvgValueOfQuizByAdmin(courses, admin);

		if (avg == 0) {
			System.out.println("No Such Course Admin is Exists ");
		} else {
			System.out.println(avg);
		}

		Course[] sortCourse = sortCourseByHandsOn(courses, handson);
		if (sortCourse == null) {
			System.out.println("No Such handsons are less Than the thresshold ");
		} else {
			for (Course c : sortCourse) {
				System.out.println(c.getCourseName());
			}
		}

	}

	public static int findAvgValueOfQuizByAdmin(Course[] courses, String admin) {
		int avg = 0, count = 0;
		for (Course c : courses) {
			if (c.getCourseAdmin().equalsIgnoreCase(admin)) {
				avg += c.getQuiz();
				count++;
			}
		}
		avg = avg / count;
		return avg;
	}

	public static Course[] sortCourseByHandsOn(Course[] courses, int handson) {
		Course arr[] = new Course[0];
		for (Course c : courses) {
			if (c.getHandson() < handson) {
				arr = Arrays.copyOf(arr, arr.length + 1);
				arr[arr.length - 1] = c;
			}
		}

		Arrays.sort(arr, Comparator.comparingInt(Course::getHandson));
		return arr;

	}

}

//courseId- int
//courseName- String
//courseAdmin- String
//quiz- int
//handson -int

class Course {
	private int courseId;
	private String courseName;
	private String courseAdmin;
	private int quiz;
	private int handson;

	public Course(int courseId, String courseName, String courseAdmin, int quiz, int handson) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseAdmin = courseAdmin;
		this.quiz = quiz;
		this.handson = handson;
	}

	public int getCourseId() {
		return courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public String getCourseAdmin() {
		return courseAdmin;
	}

	public int getQuiz() {
		return quiz;
	}

	public int getHandson() {
		return handson;
	}
}

