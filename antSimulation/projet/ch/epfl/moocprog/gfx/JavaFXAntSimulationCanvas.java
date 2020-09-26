package ch.epfl.moocprog.gfx;

import java.util.Map;
import java.util.Set;

import javafx.scene.canvas.Canvas;

public final class JavaFXAntSimulationCanvas extends JavaFXCanvasRenderingMedia {
	
	private Map<String,Boolean> debugProps;
	
	public JavaFXAntSimulationCanvas(Map<String, Boolean> debugProps, int width, int height){
		super(width, height);
		this.debugProps= debugProps;
		
	}
	
	public Boolean getProperty(String name){
		if (this.debugProps != null){
			return this.debugProps.get(name);
			
		}
		else{
			return null;
		}
		
	}
	public Set<String> PropertySet(){
		if (this.debugProps!= null){
		return this.debugProps.keySet();}
		else return null;
		
	}
	public String toStringFormat(String name){
		
		if (name.equals("Position: ")){  return "Position = %3.0f; %3.0f";}
		if (name.equals("Speed: "))   {  return "Speed = %3.1f";}
		if (name.equals("HitPoints: ")){  return "HitPoints = %d";}
		if (name.equals("LifeSpan: ")){  return "LifeSpan = %f";}
		if (name.equals("State: ")){  return "State = %s";}
		
		else return null;
	}
	

}
