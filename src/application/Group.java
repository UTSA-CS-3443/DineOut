package application;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Group {
	private String groupName;
	private PersonArray listOfUsers;
	private boolean finishedVoting;
	private ArrayList<Restaurant> fiveChoices = new ArrayList<Restaurant>();
	private static final RestaurantArray ALL_REST = new RestaurantArray();
	private int selectedRest;
	
	
	public Group(String name, PersonArray users)
	{
		this.groupName = name;
		this.listOfUsers = users;
		this.finishedVoting = false;
		this.selectedRest = -100;
		fillRandomList();
		
		
	}
	
	public ArrayList<Restaurant> getFiveChoices() {
		return fiveChoices;
	}

	public void fillRandomList() {
		RestaurantArray restaurants = new RestaurantArray();
		Random rand = new Random();
		int i = rand.nextInt(restaurants.getRestaurantList().size() - 1);
		int count = 0;
		while (count < 5) {
			Restaurant tempRest = restaurants.getRestaurantList().get(i);
			if (tempRest.isSelected() == false) { // meaning its false
				fiveChoices.add(tempRest);
				restaurants.getRestaurantList().get(i).setSelected(true);
				count++;
			}
			i = rand.nextInt(restaurants.getRestaurantList().size() - 1);
		}

	}
	
	public String createGroupString()
	{
		String groupString = "#"+ this.groupName + ":";
		
		for(int i =0; i<fiveChoices.size(); i++)
		{
			Restaurant one = fiveChoices.get(i);
			String oneName = one.getName();
			
			for(int j = 0; j < ALL_REST.getRestaurantCount(); j++)
			{
				Restaurant two = ALL_REST.getRestaurantList().get(j);
				String twoName = two.getName();
				
				if(oneName.equals(twoName))
				{
					groupString += j + ":";
				}
			}
		}
		return groupString.substring(0, (groupString.length()) -1 );
	}
	
	public String createUserString(Person person)
	{
		String userString = person.getHandle() + ":" +"NULL:NULL:NULL:NULL:NULL";
		return userString;
	}
	
	public void listOfUsersString()
	{
		for(int i = 0; i < this.listOfUsers.getArraySize(); i++ )
		{
			System.out.println(createUserString(listOfUsers.getUser(i)));
		}
	}
	
	public void groupToTextfile()
	{
		
		try
		{
		    String filename= "groups.txt";
		    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
		    fw.write("add a line\n");//appends the string to the file
		    fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
	}
	
	
	
	
	
	
}
