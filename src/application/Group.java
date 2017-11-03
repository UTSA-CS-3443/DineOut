package application;

import java.io.BufferedWriter;
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
	
	//<<CONTSTUCTOR>>
	public Group(String name, PersonArray users)
	{
		this.groupName = name;
		this.listOfUsers = users;
		this.finishedVoting = false;
		this.selectedRest = -100;
		fillRandomList();
		
		
	}
	
	
	//Return the random 5 restaurants
	public ArrayList<Restaurant> getFiveChoices() {
		return fiveChoices;
	}

	
	//Select 5 random restaurants from the list of restaurants 
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
	
	//Creates String the the groupname first then the 5 indices of the restaurant array
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
	
	// Creates a string with the user handle and a NULL vote for each of the 5 restaurants
	public String createUserString(Person person)
	{
		String userString = person.getHandle() + ":" +"NULL:NULL:NULL:NULL:NULL";
		return userString;
	}
	
	
	
	//Prints all user strings
	public String listOfUsersString()
	{
		String list = "";
		for(int i = 0; i < this.listOfUsers.getArraySize(); i++ )
		{
			list += createUserString(listOfUsers.getUser(i)) + "\n";
		}
		return list;
	}
	
	
	
	// Create a text file title groupname.txt and save it into the group folder
	//for future searches
	public void groupToTextfile()
	{
		String file = this.groupName + ".txt";
		String pathToFile = "Groups/"+file;
		
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			String content = this.createGroupString() +"\n" + this.listOfUsersString();
					
			fw = new FileWriter(pathToFile);
			bw = new BufferedWriter(fw);
			bw.write(content);

		} catch (IOException e) {

			e.printStackTrace();
		}finally {
				try {
					if (bw != null)
						bw.close();

					if (fw != null)
						fw.close();

				} catch (IOException ex) {

					ex.printStackTrace();
				}
		}
	
	}
}
	
