import processing.core.PApplet;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.marker.SimplePolygonMarker;
import de.fhpotsdam.unfolding.providers.AbstractMapProvider;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.*;

public class SimpleMap extends PApplet{
	
	UnfoldingMap map;
	
	
	public void setup() {
		
		
		//Canvas size
		size(700, 700, P2D);
		//Gets a map provided by Microsoft
		AbstractMapProvider provider =  new Microsoft.HybridProvider();
		
		//Creates a new UnfoldingMap Object
		map = new UnfoldingMap(this, provider);
		
		//Latitude and Longitude of Chattogram
		double ctgLat = 22.341900;
		double ctgLong = 91.815536;
		
		//Create a Location object for Chattogram
		Location chattogram = new Location(ctgLat, ctgLong);
		map.zoomAndPanTo(10, chattogram);
		
		//Add zoom and move functionality
		MapUtils.createDefaultEventDispatcher(this, map);
		
		//Creates a SimplePointMarker object to point at Chattogram
		SimplePointMarker marker = new SimplePointMarker(chattogram);
		marker.setColor(50);
		marker.setRadius(30);
		
		//Adds the marker to the map
		map.addMarker(marker);
		
	}
	
	public void draw() {
		map.draw();
	}

}
