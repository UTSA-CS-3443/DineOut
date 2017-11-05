package controller;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import model.RestaurantMapAttributes;
import model.Session;

public class MapController implements Initializable, MapComponentInitializedListener {
	
	// Map for display in mapView
	private GoogleMap map;
	
	// MapView container for map
	@FXML
	private GoogleMapView mapView;
	
	//Session 
	private Session session = new Session();
	
	//SessionController
	private SessionController sessionController = new SessionController();
	
	//LocationMap for markers / locations / etc..
	//MapAttributes only works here for some reason.
	//private RestaurantMapAttributes mapAttributes = new RestaurantMapAttributes();
	
	/**
	 * Initializes map markers and sets the MapOptions
	 */
	@Override
	public void mapInitialized() {
		
		// Set the initial properties of the map.
		MapOptions mapOptions = new MapOptions();
		mapOptions.center(new LatLong(29.583049, -98.619676))
				.mapType(MapTypeIdEnum.ROADMAP).overviewMapControl(true)
				.panControl(false)
				.rotateControl(false)
				.scaleControl(false)
				.streetViewControl(false)
				.zoomControl(false)
				.scrollWheel(true)
				.zoom(18)
				.fullscreenControl(false)
				.mapTypeControl(false);

		map = mapView.createMap(mapOptions);
		RestaurantMapAttributes mapAttributes = new RestaurantMapAttributes();
		
		//System.out.println(sessionController.getCurrentRestaurant());
		//System.out.println(sessionController.restaurantNameLabel.getText());
		
		
		
		for(Map.Entry<String, LatLong> entry : RestaurantMapAttributes.locationMap.entrySet()) {
			String key = (String) entry.getKey();
			LatLong value = entry.getValue();
			
			
			if(session.getFiveChoices().get(0).getName().toLowerCase().contains(key.toLowerCase())) {
				mapView.setCenterOnLatLong(value);
			}
		}

	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mapView.addMapInializedListener(this);
		
		
		FXMLLoader fxmlLoader = new FXMLLoader();
		try {
			Pane p = fxmlLoader.load(getClass().getResource("SessionInterface.fxml").openStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SessionController sessionController = (SessionController) fxmlLoader.getController();
		//System.out.println(sessionController.getCurrentRestaurant());
		//setInitialRestaurant();
	}
	
	/**
	 * Sets up map for first restaurant
	 */
	public void setInitialRestaurant() {
		
	}
	
	public void changeCenterMap() {
		for(Map.Entry<String, LatLong> entry : RestaurantMapAttributes.locationMap.entrySet()) {
			String key = (String) entry.getKey();
			LatLong value = entry.getValue();
			
			if(sessionController.getCurrentRestaurant().toLowerCase().contains(key.toLowerCase())) {
				mapView.setCenterOnLatLong(value);
			}
		}
	}
}
