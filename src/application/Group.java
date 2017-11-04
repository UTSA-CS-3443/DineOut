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
import java.util.Random;
import java.util.Scanner;

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
		String answers = ":" + person.getVote(0) + ":" + person.getVote(1) + ":" + person.getVote(2) +":" + person.getVote(3) +":" + person.getVote(4);
		String userString = person.getHandle()+answers;
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
	public boolean groupToTextfile()
	{
		String file = this.groupName + ".txt";
		String pathToFile = "Groups/"+file;
		
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		if( this.groupFileExist() == false) {

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
			return true;
		}
		else
			return false;
	
	}
	
	
	//Checks if group file exist
	public boolean groupFileExist()
	{
		String file = this.groupName + ".txt";
		String pathToFile = "Groups/"+file;
		
		File f = new File(pathToFile);
		if(f.exists() && !f.isDirectory()) { 
		    return true;
		}
		return false;
	}
	
	
	//Returns true if the username is in the textfile
	public boolean findUserInFile(Person person)
	{
		String txtFile = "Groups/" + this.groupName + ".txt";
		File file = new File(txtFile);
		
		if(this.groupFileExist())
		{
			Scanner SCANNER;
			try {
				SCANNER = new Scanner(file);
				while(SCANNER.hasNextLine()){
				    String str = SCANNER.nextLine();
				    String[] strArray = str.split(":");
				    if(person.getHandle().equals(strArray[0]))
				    {
				    		return true;
				    }
				}
				    
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("User: " + person.getHandle() + " DOES NOT EXIST");
		return false;
	}
	
	
	
	
	//Replaces the users string with there votes
	public void vote(Person person, int[] newVotes) {
		String file = this.groupName + ".txt";
		String pathToFile = "Groups/"+file;
		
		//if user exist in file
		if(this.findUserInFile(person))
		{
			
			//Create files
			File inputFile = new File(pathToFile);
			File tempFile = new File("Groups/myTempFile.txt");

			BufferedReader reader;
			
			//Remove line from text file
			try {
				reader = new BufferedReader(new FileReader(inputFile));
				BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
				String lineToRemove = this.createUserString(person);
				String currentLine;

				while((currentLine = reader.readLine()) != null) {
				    // trim newline when comparing with lineToRemove
				    String trimmedLine = currentLine.trim();
				    if(trimmedLine.equals(lineToRemove)) continue;
				    writer.write(currentLine + System.getProperty("line.separator"));
				}
				writer.close(); 
				reader.close(); 
				boolean successful = tempFile.renameTo(inputFile);
				
			} catch (IOException e) {
				e.printStackTrace();
			}

			//set the persons new votes
			person.setAnswersM(newVotes);
			try(FileWriter fw = new FileWriter(pathToFile, true);
				    BufferedWriter bw = new BufferedWriter(fw);
				    PrintWriter out = new PrintWriter(bw))
				{
				    out.println(this.createUserString(person));
				    
				} catch (IOException e) {
					e.printStackTrace();
				}

			
			
		} else
			System.out.println("USER DOES NOT EXIST");
		
		
	}
	
	//TODO: Create Group Object from txt file
	
	//TODO: If person array != 0 skip user
	
	//TODO: Send text when vote
	
	//TODO: When all users have voted send tweeet to all users thanking them
	
}
	
