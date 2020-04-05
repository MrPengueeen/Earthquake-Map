import java.awt.List;
import java.util.ArrayList;


import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.mapdisplay.OpenGLMapDisplay;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.marker.SimplePolygonMarker;
import de.fhpotsdam.unfolding.providers.AbstractMapProvider;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.*;
import processing.core.PApplet;


public class markTopFiveEarthquakes extends PApplet {
	
	private UnfoldingMap map;
	
	//Top 5 earthquakes based on magnitude
			//Create the Location objects for the 5 locations
			
			Location valEq = new Location(-39.825390, -73.231522);
			Location alaskaEq = new Location(61.127151, -149.957214);
			Location sumatraEq = new Location(-0.589724, 101.343109);
			Location japanEq = new Location(40.727876, 141.257882);
			Location kamchatkaEq = new Location(56.210949, 159.346725);
			
			//Create point features
			PointFeature valFeat = new PointFeature(valEq);
			PointFeature alaskaFeat = new PointFeature(alaskaEq);
			PointFeature sumatraFeat = new PointFeature(sumatraEq);
			PointFeature japanFeat = new PointFeature(japanEq);
			PointFeature kamchatkaFeat = new PointFeature(kamchatkaEq);
	
	public void setup() {
		size(900, 900, OPENGL);
		map = new UnfoldingMap(this,  new Microsoft.HybridProvider());
		map.zoomToLevel(2);
		MapUtils.createDefaultEventDispatcher(this,  map);
		
		
		
		addFeature(valFeat, valEq, "Valvidia, Chile", "9.5", "May 22, 1960", 1960);
		addFeature(alaskaFeat, alaskaEq, "Alaska, US", "9.2", "March 27, 1964", 1964);
		addFeature(sumatraFeat, sumatraEq, "Sumatra, Indonesia", "9.1", "December 26, 2004", 2004);
		addFeature(japanFeat, japanEq, "Tohuku, Japan", "9.1", "March 11, 2011", 2011);
		addFeature(kamchatkaFeat, kamchatkaEq, "Kamchatka, Soviet Union", "9.0", "November 4, 1952", 1952);
		
		java.util.List<PointFeature> topFiveEq = new ArrayList<>();
		topFiveEq.add(valFeat);
		topFiveEq.add(alaskaFeat);
		topFiveEq.add(sumatraFeat);
		topFiveEq.add(japanFeat);
		topFiveEq.add(kamchatkaFeat);
		
		java.util.List<Marker> markers = new ArrayList<>();
		
		for(PointFeature a: topFiveEq) {
			markers.add(new SimplePointMarker(a.getLocation(), a.getProperties()));
		}
		
		for(Marker a: markers) {
			a.setStrokeColor(255);
			a.setStrokeWeight(20);
		}
		
		
		map.addMarkers(markers);
		
		
	}
	
	
	public void draw() {
		map.draw();
	}
	
	
	public static void addFeature(Feature f, Location l, String title, String magnitude, String date, int year) {
		
		f.addProperty("title", title);
		f.addProperty("magnitude", magnitude);
		f.addProperty("date", date);
		f.addProperty("year", year);
		
	
	}

}
