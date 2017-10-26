package application;

import java.util.ArrayList;

public class Person {
	private String handle;
	private ArrayList<Integer> answersM;
	
	public Person(String handle)
	{
		this.handle = handle;
		this.answersM = new ArrayList<Integer>();

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
	

	
	}


