package controller;

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

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import model.Session;

public class MapController implements Initializable, MapComponentInitializedListener {
	
	// Map for display in mapView
	private GoogleMap map;
	
	// MapView container for map
	@FXML
	private GoogleMapView mapView;
	
	//Session 
	private Session session = new Session();
	
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
		//map.addMarker(theBlockMarker);
		//mapView.setCenterOnLatLong(theBlockLocation);
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mapView.addMapInializedListener(this);
		setInitialRestaurant();
	}
	
	/**
	 * Sets up map for first restaurant
	 */
	public void setInitialRestaurant() {
		String name = session.getFiveChoices().get(0).getName();
		System.out.println(name);
	}

}
