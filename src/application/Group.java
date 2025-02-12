package application;

import model.*;
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
		this.selectedRest = 0;
		this.fiveChoices.clear();
	}
	
	public Group(String name) {
		this.groupName = name;
	}
	
	public Group() {}
	
	public void updateGroup(PersonArray users) {
		this.listOfUsers.updatePersonArray(users, users.getArraySize());
	}
	
	public void sendInviteTweets() {

		TwitterClass Vote = new TwitterClass(this);
		for(int i = 0; i <= this.listOfUsers.getArraySize()-1; i++)
		{
			Vote.sendInviteTweet(this.listOfUsers.getHandle(i));
		}
		
	}
	
	//Return the random 5 restaurants
	public ArrayList<Restaurant> getFiveChoices() {
		return fiveChoices;
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
				SCANNER.close();   
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		System.out.println("User: " + person.getHandle() + " DOES NOT EXIST");
		return false;
	}
	
	public int findUserIndex(String name) {
		for(int i = 0; i<this.listOfUsers.getArraySize(); i++)
		{
			if(this.listOfUsers.getHandle(i).equals(name))
				return i;
		}
		return -1;
	}
	
	
	
	
	//Replaces the users string with there votes
	public void vote(String handle, int[] newVotes) {
		String file = this.groupName + ".txt";
		String pathToFile = "Groups/"+file;
		Person personToSearch = new Person("NULL");
		
		
		for(int index = 0; index<=this.listOfUsers.getArraySize()-1; index++) {
			if(this.listOfUsers.getHandle(index).equals(handle)) {
				personToSearch = this.listOfUsers.getUser(index);
				break;
			}
		}
		
		
		
		//if user exist in file
		if(this.findUserInFile(personToSearch))
		{
			
			//Create files
			File inputFile = new File(pathToFile);
			File tempFile = new File("Groups/myTempFile.txt");

			BufferedReader reader;
			
			//Remove line from text file
			try {
				reader = new BufferedReader(new FileReader(inputFile));
				BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
				String lineToRemove = this.createUserString(personToSearch);
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
			personToSearch.setAnswersM(newVotes);
			try(FileWriter fw = new FileWriter(pathToFile, true);
				    BufferedWriter bw = new BufferedWriter(fw);
				    PrintWriter out = new PrintWriter(bw))
				{
				    out.println(this.createUserString(personToSearch));
				    
				} catch (IOException e) {
					e.printStackTrace();
				}
			
			TwitterClass Vote = new TwitterClass(this);
			Vote.sendThanksTweet(personToSearch.getHandle());
		
			
		} else
			System.out.println("USER DOES NOT EXIST");
		
		
	}
	
	public Group createGroupFromTxt()
	{
		ArrayList<Restaurant> choices = new ArrayList<Restaurant>();
		PersonArray usersFromText = new PersonArray();
		//create scanner  and text file
		Scanner SCANNER;
		String txtFile = "Groups/" + this.groupName + ".txt";	
		File file = new File(txtFile);
			
		int lineNum = 1;
		
		//Scan through file and save users to group
		try {
			SCANNER = new Scanner(file);
			
			//Loop through text file
			while(SCANNER.hasNextLine())
			{
				Person currentUser = new Person("NULL");
				int[] newAns = new int[5];
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
			    }
			    else {
			    		currentUser.setHandle(strArray[0]);
				    	for( int i = 1; i <= 5; i++) 
				    	{
			    			int j = Integer.parseInt(strArray[i]);
			    			newAns[i-1] = j;
				    	}
				    	currentUser.setAnswersM(newAns);
				    	usersFromText.addUser(currentUser);
			    }
			    
			}
			Group group1 = new Group(this.groupName, usersFromText);
			group1.setFiveChoices(choices);	
			SCANNER.close();
			return group1;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// Group did not exist
		Group group1 = new Group(null, null);
		return group1;
	}

	public boolean allUsersVoted()
	{
		Scanner SCANNER;
		String txtFile = "Groups/" + this.groupName + ".txt";	
		File file = new File(txtFile);
		
		//create dummy variables for person, int array, and person array
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
			    		lineNum = 2;
			    		continue;
			    }
			    else {
				    	for( int i = 1; i <= 5; i++) {
			    			int j = Integer.parseInt(strArray[i]);
			    			if(j == 0)
			    				return false;
			    			
				    	}
			    }
			    
			}
			SCANNER.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public void sendAllUsersAns(boolean send) {
		if(send == true)
		{
			TwitterClass newSend = new TwitterClass(this);
			for(int i = 0; i<= this.listOfUsers.getArraySize()-1; i++)
			{
				newSend.sendFinalAns(this.listOfUsers.getUser(i).getHandle());
			}
		}
	}
	
	
	//TODO: When all users have voted send tweeet to all users thanking them
	
	public void setGroupName(String text){
		this.groupName = text;
	}
	public String getGroupName(){
		return this.groupName;
	}
	
	public void setFiveChoices(ArrayList<Restaurant> choices) {
		this.fiveChoices = choices;
	}
	
	public int getSelectedRest() {
		return this.selectedRest;
	}
	
	public PersonArray getListOfUsers() {
		return this.listOfUsers;
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

	
	public int calcVotes()
	{
		Scanner SCANNER;
		String txtFile = "Groups/" + this.groupName + ".txt";	
		File file = new File(txtFile);
		int [] sumVotes = {0,0,0,0,0};
		
		//create dummy variables for person, int array, and person array
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
			    		lineNum = 2;
			    		continue;
			    }
			    else {
				    	for( int i = 1; i <= 5; i++) {
			    			int j = Integer.parseInt(strArray[i]);
			    			sumVotes[i-1] += j;
			    			
			    			
				    	}
			    }
			    
			}
			int maxVotes = 0;
			int iRest = -1;
			for(int m = 0; m<5; m++)
			{
				if(sumVotes[m] >= maxVotes)
				{
					maxVotes = sumVotes[m];
					iRest = m;
				}
			}
			SCANNER.close();
			return iRest;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public void setSelectedRest(int selectedRest) {
		this.selectedRest = selectedRest;
	}
	

}
	
