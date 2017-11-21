package model;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.image.Image;

public class ImageCollection {
	
	public ImageCollection() {
		fillMap();
	}
	
	public static Map<String, Image> images = new HashMap<String, Image>();
	
	Image chickFilA = new Image("file:res/images/Chick_Fil_A.jpeg");
	Image chilis = new Image("file:res/images/Chilis.jpg");
	Image crazyCarls = new Image("file:res/images/Crazy_Carl's.jpeg");
	Image einsteinBros = new Image("file:res/images/Einstein_Bros.jpeg");
	Image greensToGo = new Image("file:res/images/Greens_To_Go.jpeg");
	Image littleCaesars = new Image("file:res/images/Little_Caesars.png");
	Image mooyah = new Image("file:res/images/Mooyah.jpg");
	Image pandaExpress = new Image("file:res/images/Panda_Express.jpeg");
	Image papaJohns = new Image("file:res/images/Papa_John's.jpeg");
	Image picnikinsPatio = new Image("file:res/images/Picnikins_Patio.jpeg");
	Image roadrunnerCafe = new Image("file:res/images/Roadrunner_Cafe.jpeg");
	Image rowdyCurbside = new Image("file:res/images/Rowdy_Curbside_Food_Truck.jpeg");
	Image singaporeChineseIndochina = new Image("file:res/images/Singapore.jpg");
	Image smoothieKing = new Image("file:res/images/Smoothie_King.jpeg");
	Image starbucksUC = new Image("file:res/images/Starbucks_UC.jpg");
	Image starbucks = new Image("file:res/images/Starbucks.jpeg");
	Image steakNShake = new Image("file:res/images/Steak_&_Shake.jpg");
	Image subwayUC = new Image("file:res/images/Subway_UC.jpg");
	Image subway = new Image("file:res/images/Subway.jpeg");
	Image sushic = new Image("file:res/images/Sushic.jpg");
	Image tacoPalenque = new Image("file:res/images/Taco_Palenque.jpeg");
	Image tacoTacoCafe = new Image("file:res/images/Taco_Taco_Cafe.jpg");
	Image theBlock = new Image("file:res/images/The_Block.png");
	Image whiskeyCake = new Image("file:res/images/Whiskey_Cake.jpeg");
	
	public void fillMap() {
		images.put("The Block SA", theBlock);
		images.put("Taco Palenque UTSA", tacoPalenque);
		images.put("Singapore Chinese & Indochina Restaurant", singaporeChineseIndochina);
		images.put("Whiskey Cake", whiskeyCake);
		images.put("Little Caesars Pizza", littleCaesars);
		images.put("Crazy Carl's Burger Truck", crazyCarls);
		images.put("Picnikins Patio Cafe", picnikinsPatio);
		images.put("Einstein Bros. Bagels", einsteinBros);
		images.put("Greens To Go", greensToGo);
		images.put("Chick-fil-A", chickFilA);
		images.put("Papa John's", papaJohns);
		images.put("Subway", subway);
		images.put("Sushic", sushic);
		images.put("Steak 'n Shake", steakNShake);
		images.put("Smoothie King", smoothieKing);
		images.put("JPL Starbucks", starbucks);
		images.put("H-E-B UC Subway", subwayUC);
		images.put("UC Starbucks", starbucksUC);
		images.put("Chili's", chilis);
		images.put("Panda Express", pandaExpress);
		images.put("Taco Taco Cafe", tacoTacoCafe);
		images.put("Mooyah", mooyah);
		images.put("Roadrunner Cafe", roadrunnerCafe);
		images.put("Rowdy Curbside Food Truck", rowdyCurbside);
		
	}
	

}
