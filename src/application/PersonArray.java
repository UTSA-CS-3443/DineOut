package application;

import java.util.ArrayList;

public class PersonArray {
	private ArrayList<Person> userList = new ArrayList<Person>();
	
	
	public PersonArray()
	{
		
		this.userList.clear();
	}
	
	
	public void addUser(Person person)
	{
		
		this.userList.add(person);
	}
	

}
