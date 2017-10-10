package application;

import java.util.ArrayList;

public class Person {
	private String szName;
	private String szPhoneNum;
	private String szEmail;
	private String szPassword;
	private ArrayList<Integer> answersM = new ArrayList<Integer>();


	public Person(String name, String phone, String email)
	{
		this.szName = name;
		this.szEmail = email;
		this.szPhoneNum = phone;
		this.szPassword = null;
		this.answersM = null;
	}
	
}


