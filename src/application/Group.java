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
	private int selectedRest;
	
	//<<CONTSTUCTOR>>
	public Group(String name, PersonArray users)
	{
		this.groupName = name;
		this.listOfUsers = users;
		this.finishedVoting = false;
		this.selectedRest = -100;
		this.fiveChoices.clear();
		
		
	}
	
	
	
	//Return the random 5 restaurants
	public ArrayList<Restaurant> getFiveChoices() {
		return fiveChoices;
	}

	
	//Select 5 random restaurants from the list of restaurants 
	public ArrayList<Restaurant> fillRandomList() {
		Random rand = new Random();
		ArrayList<Restaurant> tempList = new ArrayList<Restaurant>();
		int i = rand.nextInt(GlobalRestList.ALL_REST.getRestaurantList().size() - 1);
		int count = 0;
		
		while (count < 5) {
			Restaurant tempRest = GlobalRestList.ALL_REST.getRestaurantList().get(i);
			if (tempRest.isSelected() == false) { // meaning its false
				tempList.add(tempRest);
				GlobalRestList.ALL_REST.getRestaurantList().get(i).setSelected(true);
				count++;
			}
			i = rand.nextInt(GlobalRestList.ALL_REST.getRestaurantList().size() - 1);
		}
		return tempList;
	}
	
	//Creates String the the groupname first then the 5 indices of the restaurant array
	public String createGroupString()
	{
		String groupString = "#"+ this.groupName + ":";
		
		for(int i =0; i<this.fiveChoices.size(); i++)
		{
			Restaurant one = this.fiveChoices.get(i);
			String oneName = one.getName();
			
			for(int j = 0; j < GlobalRestList.ALL_REST.getRestaurantCount(); j++)
			{
				Restaurant two = GlobalRestList.ALL_REST.getRestaurantList().get(j);
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
		File file1 = new File(pathToFile);
		
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		if( this.groupFileExist() == true) {
			file1.delete();
		}

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
	public Group createGroupFromTxt()
	{
		Group group1 = new Group(this.groupName, this.listOfUsers);
		ArrayList<Restaurant> choices = new ArrayList<Restaurant>();
		
		//create scanner  and text file
		Scanner SCANNER;
		String txtFile = "Groups/" + this.groupName + ".txt";	
		File file = new File(txtFile);
		
		//create dummy variables for person, int array, and person array
		PersonArray usersFromText = new PersonArray();
		Person currentUser = new Person("NULL");
		int[] newAns = new int[5];
		
		
		int lineNum = 1;
		
		//Scan through file and save users to group
		try {
			SCANNER = new Scanner(file);
			
			//Loop through text file
			while(SCANNER.hasNextLine())
			{
			    String str = SCANNER.nextLine();
			    String[] strArray = str.split(":");
			    if(lineNum == 1)
			    {
			    		for( int i = 1; i <= 5; i++) {
			    			int j = Integer.parseInt(strArray[i]);
			    			Restaurant newRest = GlobalRestList.ALL_REST.getRestaurant(j);
			    			choices.add(newRest);
			    		}
			    		lineNum = 2;
			    		group1.setFiveChoices(choices);
			    }
			    else {
			    		currentUser.setHandle(strArray[0]);
				    	for( int i = 1; i <= 5; i++) {
			    			int j = Integer.parseInt(strArray[i]);
			    			newAns[i-1] = j;
			    			
				    	}
				    	currentUser.setAnswersM(newAns);
				    	usersFromText.addUser(currentUser);
			    	
			    }
			    
			}
			return group1;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// Group did not exist
		group1.setGroupName("NULL");
		return group1;
	}
	//TODO: Return the user index of group object 
	
	//TODO: If person array != 0 skip user
	
	//TODO: Send text when vote
	
	//TODO: When all users have voted send tweeet to all users thanking them
	
	public void setGroupName(String text){
		this.groupName = text;
	}
	
	public void setFiveChoices(ArrayList<Restaurant> choices) {
		this.fiveChoices = choices;
	}
	
}
	
