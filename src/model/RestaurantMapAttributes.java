package model;

import java.util.HashMap;
import java.util.Map;

import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;

public class RestaurantMapAttributes {
	
	public static Map<String, LatLong> locationMap = new HashMap<String, LatLong>();
	public static Map<String, Marker> markerMap = new HashMap<String, Marker>();
	
	// Restaurant Locations
	LatLong theBlockLocation = new LatLong(29.575883, -98.624715);
	LatLong tacoPalenqueLocation = new LatLong(29.576716, -98.593963);
	LatLong singaporeChineseIndochinaLocation = new LatLong(29.576295, -98.625766);
	LatLong whiskeyCakeLocation = new LatLong(29.593221, -98.611472);
	LatLong littleCaesarsLocation = new LatLong(29.576491, -98.632428);
	LatLong crazyCarlsLocation = new LatLong(29.575883, -98.624715);
	LatLong picnikinsPatioLocation = new LatLong(29.571706, -98.597036);
	LatLong einsteinBrosLocation = new LatLong(29.581673, -98.617404);
	LatLong greensToGoLocation = new LatLong(29.584344, -98.617356);
	LatLong chikFilALocation = new LatLong(29.584346, -98.617358);
	LatLong papaJohnsLocation = new LatLong(29.584344, -98.617356);
	LatLong subwayLocation = new LatLong(29.584344, -98.617356);
	LatLong sushicLocation = new LatLong(29.584344, -98.617356);
	LatLong steakNShakeLocation = new LatLong(29.584425, -98.618168);
	LatLong smoothieKingLocation = new LatLong(29.584533, -98.617616);
	LatLong jplStarbucksLocation = new LatLong(29.584225, -98.617825);
	LatLong hebUCSubwayLocation = new LatLong(29.583322, -98.62014);
	LatLong ucStarbucksLocation = new LatLong(29.583756, -98.620437);
	LatLong chilisLocation = new LatLong(29.583499, -98.620899);
	LatLong pandaExpressLocation = new LatLong(29.583653, -98.62068);
	LatLong tacoTacoCafeLocation = new LatLong(29.583728, -98.620543);
	LatLong mooyahLocation = new LatLong(29.583693, -98.620581);
	LatLong roadrunnerCafeLocation = new LatLong(29.585714, -98.624614);
	LatLong rowdyCurbsideLocation = new LatLong(29.585507, -98.619088);
	
	// Adding position of markers to respected restaurants
	MarkerOptions markerOptions1 = new MarkerOptions().position(theBlockLocation);
	MarkerOptions markerOptions2 = new MarkerOptions().position(tacoPalenqueLocation);
	MarkerOptions markerOptions3 = new MarkerOptions().position(singaporeChineseIndochinaLocation);
	MarkerOptions markerOptions4 = new MarkerOptions().position(whiskeyCakeLocation);
	MarkerOptions markerOptions5 = new MarkerOptions().position(littleCaesarsLocation);
	MarkerOptions markerOptions6 = new MarkerOptions().position(crazyCarlsLocation);
	MarkerOptions markerOptions7 = new MarkerOptions().position(picnikinsPatioLocation);
	MarkerOptions markerOptions8 = new MarkerOptions().position(einsteinBrosLocation);
	MarkerOptions markerOptions9 = new MarkerOptions().position(greensToGoLocation);
	MarkerOptions markerOptions10 = new MarkerOptions().position(chikFilALocation);
	MarkerOptions markerOptions11 = new MarkerOptions().position(papaJohnsLocation);
	MarkerOptions markerOptions12 = new MarkerOptions().position(subwayLocation);
	MarkerOptions markerOptions13 = new MarkerOptions().position(sushicLocation);
	MarkerOptions markerOptions14 = new MarkerOptions().position(steakNShakeLocation);
	MarkerOptions markerOptions15 = new MarkerOptions().position(smoothieKingLocation);
	MarkerOptions markerOptions16 = new MarkerOptions().position(jplStarbucksLocation);
	MarkerOptions markerOptions17 = new MarkerOptions().position(hebUCSubwayLocation);
	MarkerOptions markerOptions18 = new MarkerOptions().position(ucStarbucksLocation);
	MarkerOptions markerOptions19 = new MarkerOptions().position(chilisLocation);
	MarkerOptions markerOptions20 = new MarkerOptions().position(pandaExpressLocation);
	MarkerOptions markerOptions21 = new MarkerOptions().position(tacoTacoCafeLocation);
	MarkerOptions markerOptions22 = new MarkerOptions().position(mooyahLocation);
	MarkerOptions markerOptions23 = new MarkerOptions().position(roadrunnerCafeLocation);
	MarkerOptions markerOptions24 = new MarkerOptions().position(rowdyCurbsideLocation);
	
	Marker theBlockMarker = new Marker(markerOptions1);
	Marker tacoPalenqueMarker = new Marker(markerOptions2);
	Marker singaporeChineseIndochinaMarker = new Marker(markerOptions3);
	Marker whiskeyCakeMarker = new Marker(markerOptions4);
	Marker littleCaesarsMarker = new Marker(markerOptions5);
	Marker crazyCarlsMarker = new Marker(markerOptions6);
	Marker picnikinsPatioMarker = new Marker(markerOptions7);
	Marker einsteinBrosMarker = new Marker(markerOptions8);
	Marker greensToGoMarker = new Marker(markerOptions9);
	Marker chikFilAMarker = new Marker(markerOptions10);
	Marker papaJohnsMarker = new Marker(markerOptions11);
	Marker subwayMarker = new Marker(markerOptions12);
	Marker sushicMarker = new Marker(markerOptions13);
	Marker steakNShakeMarker = new Marker(markerOptions14);
	Marker smoothieKingMarker = new Marker(markerOptions15);
	Marker jplStarbucksMarker = new Marker(markerOptions16);
	Marker hebUCSubwayMarker = new Marker(markerOptions17);
	Marker ucStarbucksMarker = new Marker(markerOptions18);
	Marker chilisMarker = new Marker(markerOptions19);
	Marker pandaExpressMarker = new Marker(markerOptions20);
	Marker tacoTacoCafeMarker = new Marker(markerOptions21);
	Marker mooyahMarker = new Marker(markerOptions22);
	Marker roadrunnerCafeMarker = new Marker(markerOptions23);
	Marker rowdyCurbsideMarker = new Marker(markerOptions24);
	
	public RestaurantMapAttributes() {
		fillMap();
	}
	
	public void fillMap() {
		locationMap.put("The Block SA", theBlockLocation);
		locationMap.put("Taco Palenque UTSA", tacoPalenqueLocation);
		locationMap.put("Whiskey Cake", whiskeyCakeLocation);
		locationMap.put("Little Caesars Pizza", littleCaesarsLocation);
		locationMap.put("Crazy Carl's Burger Truck", crazyCarlsLocation);
		locationMap.put("Picnikins Patio Cafe", picnikinsPatioLocation);
		locationMap.put("Einstein Bros. Bagels", einsteinBrosLocation);
		locationMap.put("Greens To Go", greensToGoLocation);
		locationMap.put("Chick-fil-A", chikFilALocation);
		locationMap.put("Papa John's", papaJohnsLocation);
		locationMap.put("Subway", subwayLocation);
		locationMap.put("Sushic", sushicLocation);
		locationMap.put("Steak 'n Shake", steakNShakeLocation);
		locationMap.put("Smoothie King", smoothieKingLocation);
		locationMap.put("JPL Starbucks", jplStarbucksLocation);
		locationMap.put("H-E-B UC Subway", hebUCSubwayLocation);
		locationMap.put("UC Starbucks", ucStarbucksLocation);
		locationMap.put("Chili's", chilisLocation);
		locationMap.put("Panda Express", pandaExpressLocation);
		locationMap.put("Taco Taco Cafe", tacoTacoCafeLocation);
		locationMap.put("Mooyah", mooyahLocation);
		locationMap.put("Roadrunner Cafe", roadrunnerCafeLocation);
		locationMap.put("Rowdy Curbside Food Truck", rowdyCurbsideLocation);
		
		markerMap.put("The Block SA", theBlockMarker);
		markerMap.put("Taco Palenque UTSA", tacoPalenqueMarker);
		markerMap.put("Whiskey Cake", whiskeyCakeMarker);
		markerMap.put("Little Caesars Pizza", littleCaesarsMarker);
		markerMap.put("Crazy Carl's Burger Truck", crazyCarlsMarker);
		markerMap.put("Picnikins Patio Cafe", picnikinsPatioMarker);
		markerMap.put("Einstein Bros. Bagels", einsteinBrosMarker);
		markerMap.put("Greens To Go", greensToGoMarker);
		markerMap.put("Chick-fil-A", chikFilAMarker);
		markerMap.put("Papa John's", papaJohnsMarker);
		markerMap.put("Subway", subwayMarker);
		markerMap.put("Sushic", sushicMarker);
		markerMap.put("Smoothie King", smoothieKingMarker);
		markerMap.put("JPL Starbucks", jplStarbucksMarker);
		markerMap.put("H-E-B UC Subway", hebUCSubwayMarker);
		markerMap.put("UC Starbucks", ucStarbucksMarker);
		markerMap.put("Chili's", chilisMarker);
		markerMap.put("Panda Express", pandaExpressMarker);
		markerMap.put("Taco Taco Cafe", tacoTacoCafeMarker);
		markerMap.put("Mooyah", mooyahMarker);
		markerMap.put("Roadrunner Cafe", roadrunnerCafeMarker);
		markerMap.put("Rowdy Curbside Food Truck", rowdyCurbsideMarker);
		markerMap.put("Steak 'n Shake", steakNShakeMarker);
	}
	
	public Map<String, LatLong> getLocationMap() {
		return RestaurantMapAttributes.locationMap;
	}
	
	public Map<String, Marker> getMarkerMap(){
		return RestaurantMapAttributes.markerMap;
	}
	
}
