package application;
import twitter4j.*;
import twitter4j.auth.*;

public class TwitterClass {

			private String consumerKey;
			private String consumerSecret;
			private String accessToken;
			private String accessTokenSecret;
			private PersonArray userList;
			private Restaurant selectedRestaurant;
			private String groupName;
			
			public TwitterClass(Group group) {
				this.consumerKey="YXRc3rKIpIz3vxxS9qjgp4ndQ";
				this.consumerSecret="zmnmimOKqfB0fILN0VcrJB0TGyZB2339kECPk02cF0sVmkGTOb";
				this.accessToken="922922886708506625-jz5RY1aAZq9id2CDEpO45tHpXMfQc4v";
				this.accessTokenSecret="9X5App0pwzeZ1mvXrtPlZre85zYCPq0T5KPjPhpUs4oTH";
				this.selectedRestaurant = GlobalRestList.ALL_REST.getRestaurantList().get(group.getSelectedRest());
				this.userList = group.getListOfUsers();
				this.groupName = group.getGroupName();
				
			}
			
			
			public void sendInviteTweet(String handle)
			{
				TwitterFactory factory = new TwitterFactory();
				Twitter twitter = factory.getInstance();
				twitter.setOAuthConsumer(this.consumerKey, this.consumerSecret);
				AccessToken accessToken = new AccessToken(this.accessToken, this.accessTokenSecret);
				twitter.setOAuthAccessToken(accessToken);
				
				String twitterName =  handle;
				User user = null;
				
				try {
					user = twitter.showUser(twitterName);
				} catch (TwitterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
	
				String name = user.getName();
				String thanks = "Hello " + name + ", you have been invited to DineOut! You can login to DineOut ";
				String thanksCont = "using the group name: #"+this.groupName+". Your user name is: " + twitterName;
				String thanksLast = ". Please go to the DineOut App and vote on where you want to Dine Out!";

				String directMessage = thanks + thanksCont + thanksLast;
				
				try {
					DirectMessage message = twitter.sendDirectMessage(twitterName, directMessage);
				} catch (TwitterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
			public void sendThanksTweet(String handle)
			{
				TwitterFactory factory = new TwitterFactory();
				Twitter twitter = factory.getInstance();
				twitter.setOAuthConsumer(this.consumerKey, this.consumerSecret);
				AccessToken accessToken = new AccessToken(this.accessToken, this.accessTokenSecret);
				twitter.setOAuthAccessToken(accessToken);
				
				String twitterName =  handle;
				User user = null;
				
				try {
					user = twitter.showUser(twitterName);
				} catch (TwitterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
	
				String name = user.getName();
				String thanks = "Hello " + name + ", Thanks for using DineOut! Your vote has been submitted and a restaurant";
				String thanksCont = " will be selected shortly and sent in the next message";

				String directMessage = thanks + thanksCont;
				
				try {
					DirectMessage message = twitter.sendDirectMessage(twitterName, directMessage);
				} catch (TwitterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				

			
			public void sendFinalAns(String handle)
			{
				TwitterFactory factory = new TwitterFactory();
				Twitter twitter = factory.getInstance();
				twitter.setOAuthConsumer(this.consumerKey, this.consumerSecret);
				AccessToken accessToken = new AccessToken(this.accessToken, this.accessTokenSecret);
				twitter.setOAuthAccessToken(accessToken);
				
				String twitterName =  handle;
				User user = null;
				
				try {
					user = twitter.showUser(twitterName);
				} catch (TwitterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
	
				String name = user.getName();
				String thanks = "Hello " + name + ", The results are in. The Group #" + this.groupName + " has chosen to meet at " ;
				String thanksCont = this.selectedRestaurant.getName() + " located at " + this.selectedRestaurant.getAddress() + ".";
				String thanksLast = " Thanks for using DineOut!";

				String directMessage = thanks + thanksCont + thanksLast;
				
				try {
					DirectMessage message = twitter.sendDirectMessage(twitterName, directMessage);
				} catch (TwitterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			public String getHandle(int i)
			{
				return this.userList.getHandle(i);
			}
					
			
			
			public Restaurant getSelectedRestaurant() {
				return selectedRestaurant;
			}

			public void setSelectedRestaurant(Restaurant selectedRestaurant) {
				this.selectedRestaurant = selectedRestaurant;
			}



			public String getConsumerKey() {
				return consumerKey;
			}

			public void setConsumerKey(String consumerKey) {
				this.consumerKey = consumerKey;
			}

			public String getConsumerSecret() {
				return consumerSecret;
			}

			public void setConsumerSecret(String consumerSecret) {
				this.consumerSecret = consumerSecret;
			}

			public String getAccessToken() {
				return accessToken;
			}

			public void setAccessToken(String accessToken) {
				this.accessToken = accessToken;
			}

			public String getAccessTokenSecret() {
				return accessTokenSecret;
			}

			public void setAccessTokenSecret(String accessTokenSecret) {
				this.accessTokenSecret = accessTokenSecret;
			}

			public PersonArray getUserList() {
				return userList;
			}

			public void setUserList(PersonArray userList) {
				this.userList = userList;
			}
			
	
}
