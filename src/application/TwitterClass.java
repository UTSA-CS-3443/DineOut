package application;
import twitter4j.util.*;
import twitter4j.*;
import twitter4j.management.*;
import twitter4j.api.*;
import twitter4j.conf.*;
import twitter4j.json.*;
import twitter4j.auth.*;

public class TwitterClass {

			private String consumerKey;
			private String consumerSecret;
			private String accessToken;
			private String accessTokenSecret;
			private PersonArray userList;
			private Restaurant selectedRestaurant;
			
			public TwitterClass(PersonArray users, Restaurant selected) {
				this.consumerKey="q1PHv8z2xR6jAgRXGcP1vZ3d2";
				this.consumerSecret="pnpB1tWk61yUCl6QmEw8e1b8hqBxsY1Alg2fkiuRK8OQLe82Ju";
				this.accessToken="3776551345-6os2NODhS0IZadIWIDns8Y8uIIwPt70OsNi6mqt";
				this.accessTokenSecret="D5hM1gshMGo3RUFNvdhBgIr99o5iqbxn8msWqbgpe2jQQ";
				this.selectedRestaurant = selected;
				this.userList = users;
				
			}
			
			
			public void sendTweet()
			{
				
				AccessToken accessToken = new AccessToken(ACCESS_TOKEN, ACCESS_TOKEN_SECRET);
			    OAuthAuthorization authorization = new OAuthAuthorization(ConfigurationContext.getInstance(), CONSUMER_KEY, CONSUMER_SECRET, accessToken);
			    Twitter twitter = new TwitterFactory().getInstance(authorization);
				
				
				
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
