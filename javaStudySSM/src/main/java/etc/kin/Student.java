package etc.kin;

public class Student extends Person {
	String university;
	int grade;
	String studentnumber;

	Student(String name, int age, String number, String job) {
		this.name = name;
		this.age = age;
		this.number = number;
		this.job = job;
	}
}
