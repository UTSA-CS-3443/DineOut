package application;

import java.util.ArrayList;

//Had to extend ArrayList to access size() and other methods --Marcus
public class PersonArray {
	private ArrayList<Person> userList = new ArrayList<Person>();
	private int arraySize;
	
	public PersonArray()
	{
		
		this.userList.clear();
		this.setArraySize(0);
	}
	
	
	public void addUser(Person person)
	{
		
		this.userList.add(person);
		this.setArraySize(this.getArraySize() + 1);
	}
	
	public String getName(int i)
	{
		return this.userList.get(i).getName();
	}
	
	public String getHandle(int i)
	{
		return this.userList.get(i).getHandle();
	}


	public int getArraySize() {
		return arraySize;
	}


	public void setArraySize(int arraySize) {
		this.arraySize = arraySize;
	}
	

}
