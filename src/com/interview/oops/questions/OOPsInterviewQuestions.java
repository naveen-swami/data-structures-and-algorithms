package com.interview.oops.questions;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

class SingletonClass {
	private static SingletonClass singletonClass_instance = null;

	private SingletonClass() {
		System.out.println("Inside zero parameterized constractor");
	}

	public static SingletonClass getSingletonClass(SingletonClass singletonClass) {
		if (singletonClass_instance == null) {
			singletonClass_instance = new SingletonClass();
		}
		return singletonClass_instance;
	}
}

class Student {
	private int id;
	private String name;
	static float marks;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	Student() {
		this.id = 5;
		this.name = "Naveen";
	}

	Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	static void display() {
		marks = 25l;
		System.out.println("Marks " + marks);
	}
}

class SchoolStudent extends Student {
	@Override
	public int getId() throws NumberFormatException {
		return super.getId();
	}
}

public class OOPsInterviewQuestions {
	// call at run the program not at object create time
	static {
		System.out.println("Inside static method");
	}

	//public static void main(String[] args) {
	// Student std = new Student();
	// System.out.println(std.getId() + " " + std.getName());
	// Student std2 = new Student(60, "Swami");
	// System.out.println(std2.getId() + " " + std2.getName());
	// Student.display();
	// System.out.println("Marks " + Student.marks);

	// want to acces singleton class
	/* SingletonClass singletonClass = new SingletonClass(singletonClass); */

	public static void main(String[] arg) {

		Scanner scan = new Scanner(System.in);

		String str = scan.nextLine();
		System.out.println(printAltString(str));
	}

	static String printAltString(String str) {

		String stringPart = "";
		String intPart = "";
		int lenght = str.length();
		for (int i = 0; i < lenght; i++) {

			if (Character.isDigit(str.charAt(i))) {

				intPart += str.charAt(i);
			} else {
				stringPart += str.charAt(i);
			}
		}
		System.out.println(stringPart);
		System.out.println(intPart);
		int a = 0;
		int b = 0;
		str = "";

		for (int i = 0; i < lenght; i++) {

			if (i % 2 == 0 && a < stringPart.length()) {
				str += stringPart.charAt(a);
				a++;
			} else if (b < intPart.length()) {
				str += intPart.charAt(b);
				b++;
			}
		}
		return str;

	}
}
