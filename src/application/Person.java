package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Person {
	private String szName;
	private String szPhoneNum;
	private String szEmail;
	private ArrayList<Person> people;
	private ArrayList<Integer> answersM = new ArrayList<Integer>();
	
	public Person(String name)
	{
		this.szName = name;
		this.szEmail = null;
		this.answersM = null;
		this.people = new ArrayList<Person>();
	}	
	
	public void addUser()
	{
		Scanner reader = new Scanner(System.in);	
		System.out.println("Enter your first name last name(First Last):");
		setSzName(reader.nextLine());
		System.out.println("Enter your email: ");
		setSzEmail(reader.nextLine());
		System.out.println("Enter Phone Number: (XXX)XXX-XXXX) ");
		setSzPhoneNum(reader.nextLine());
		System.out.println("USER CREATED");
		try {
			File file = new File("userlist.csv");
			String user = this.szName + "," + this.szEmail;
			FileWriter fw = new FileWriter(file,true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(user);
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		reader.close();
	}
	
	public String getSzName() {
		return szName;
	}

	public void setSzName(String szName) {
		this.szName = szName;
	}

	public String getSzPhoneNum() {
		return szPhoneNum;
	}

	public void setSzPhoneNum(String szPhoneNum) {
		this.szPhoneNum = szPhoneNum;
	}

	public String getSzEmail() {
		return szEmail;
	}

	public void setSzEmail(String szEmail) {
		this.szEmail = szEmail;
	}

	public ArrayList<Integer> getAnswersM() {
		return answersM;
	}

	public void setAnswersM(ArrayList<Integer> answersM) {
		this.answersM = answersM;
	}
	
	public String toString() {
		return this.szName;
	}
	
	
	
}


