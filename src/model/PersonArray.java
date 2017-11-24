package model;

import java.util.ArrayList;

//Had to extend ArrayList to access size() and other methods --Marcus
public class PersonArray {
	private ArrayList<Person> userList = new ArrayList<Person>();
	private int arraySize;
	
	public PersonArray()
	{
		
		this.userList.clear();
		this.arraySize = 0;
	}
	
	
	public void addUser(Person person)
	{
		
		this.userList.add(person);
		this.setArraySize(this.getArraySize() + 1);
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
	
	public Person getUser(int i) {
		Person person = this.userList.get(i);
		return person;
	}
	public void updatePersonArray(PersonArray p, int size) {
		this.userList.clear();
		this.userList = p.userList;
		this.arraySize = size;
		
	}
	
	
}
