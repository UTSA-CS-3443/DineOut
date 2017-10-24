package application;

import java.util.ArrayList;

//Had to extend ArrayList to access size() and other methods --Marcus
@SuppressWarnings("rawtypes")
public class PersonArray extends ArrayList {
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
