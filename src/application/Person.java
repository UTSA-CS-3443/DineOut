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
	private String name;
	private String handle;
	private ArrayList<Person> people;
	private ArrayList<Integer> answersM;
	
	public Person(String name, String handle)
	{
		this.name = name;
		this.handle = handle;
		this.answersM = new ArrayList<Integer>();
		this.people = new ArrayList<Person>();
	}	
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHandle() {
		return this.handle;
	}

	public void setHandle(String handle) {
		this.handle = handle;
	}

	public void setAnswersM(ArrayList<Integer> answersM) {
		this.answersM = answersM;
	}
	
	public String toString() {
		return this.name + " " + this.handle;
	}
	
	
	
}


