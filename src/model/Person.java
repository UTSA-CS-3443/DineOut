package model;

import java.util.ArrayList;

public class Person {
	private String handle;
	private int[] answersM = new int[5];
	
	public Person(String handle)
	{
		this.handle = handle;
		for(int i = 0; i<=4; i++)
		{
			answersM[i] = 0;
		}

	}	

	public String getHandle() {
		return this.handle;
	}

	public void setHandle(String handle) {
		this.handle = handle;
	}

	public void setAnswersM(int[] answers) {
		this.answersM = answers;
	}
	
	public int getVote(int i) {
		return this.answersM[i];
	}
	
	public String getAllVotes() {
		StringBuilder sb = new StringBuilder();
		for(int i : this.answersM) {
			sb.append(i + " ");
		}
		return sb.toString();
	}
	
	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: " + this.handle);
        sb.append(", ");
        sb.append("Answers:" + getAllVotes());
        return sb.toString();
    }
	

	
}


