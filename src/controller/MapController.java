package controller;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import model.RestaurantMapAttributes;

public class MapController implements Initializable, MapComponentInitializedListener {
	
	// Map for display in mapView
	private GoogleMap map;
	
	// MapView container for map
	@FXML
	private GoogleMapView mapView;
	
	//String holds current restaurant, passed from SessionController
	private String currentRestaurant;
	
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
				.zoom(19)
				.mapTypeControl(false);
		map = mapView.createMap(mapOptions);
		@SuppressWarnings("unused")
		RestaurantMapAttributes mapAttributes = new RestaurantMapAttributes();
		changeMarker();
		changeCenterMap();
	}
	
	/**
	 * Loads restaurant name from SessionController on new stage creation
	 * @param text The name of a restaurant
	 */
	public void loadCurrentRestaurant(String text) {
		currentRestaurant = text;
	}
	
	/**
	 * Returns current restaurant name being displayed on SessionInterface
	 * @return Current restaurant name
	 */
	public String getCurrentRestaurant() {
		return currentRestaurant;
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mapView.addMapInializedListener(this);
	}
	
	public GoogleMap getMap() {
		return map;
	}
	
	
	public void changeMarker() {
		for(Map.Entry<String, Marker> entry : RestaurantMapAttributes.markerMap.entrySet()) {
			String key = (String) entry.getKey();
			Marker value = entry.getValue();
			
			if(currentRestaurant.toLowerCase().equals(key.toLowerCase())) {
				map.addMarker(value);
			}
		}
	}
	
	public void changeCenterMap() {
		for(Map.Entry<String, LatLong> entry : RestaurantMapAttributes.locationMap.entrySet()) {
			String key = (String) entry.getKey();
			LatLong value = entry.getValue();
			double lat = value.getLatitude();
			double lon = value.getLongitude();
			if(currentRestaurant.toLowerCase().equals(key.toLowerCase())) {
				mapView.setCenter(lat, lon);
			}
		}
	}
}
