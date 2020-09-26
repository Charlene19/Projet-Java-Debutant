package ch.epfl.moocprog.gfx;

import ch.epfl.moocprog.Animal;
import ch.epfl.moocprog.Positionable;
import ch.epfl.moocprog.AntWorker;
import ch.epfl.moocprog.Anthill;
import ch.epfl.moocprog.Food;
import ch.epfl.moocprog.ToricPosition;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Affine;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface SimpleEntitySpriteRenderer<T extends Positionable> extends EntityRenderer<T> {
    Image getSprite(T entity);

    default void drawSingleSprite(Canvas canvas, T entity) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Affine oldTransform = gc.getTransform();
        Affine affine = gc.getTransform();
        affine.prepend(getTransformation(entity));

        gc.setTransform(affine);
        gc.drawImage(
            getSprite(entity),
            0, 0,
            getWidth(entity),
            getHeight(entity)
        );
        gc.setTransform(oldTransform);
    }
    
    default void displayEntityInfo(JavaFXAntSimulationCanvas canvas, T entity){
        int xOffset=25;
        int yOffset =0;
        if (entity instanceof Anthill) {
            xOffset = 50;
        }
        GraphicsContext gc = canvas.getGraphicsContext2D();
            
        for (String property : canvas.PropertySet()){
            if  (canvas.getProperty(property)){
                gc.fillText(
                    findPropertyData(entity, property),
                    entity.getPosition().toVec2d().getX()+xOffset,entity.getPosition().toVec2d().getY()+yOffset
                );
                yOffset +=15;
            }      	
        }		
    }
	
	default String findPropertyData(T entity, String property) {
		String description = "\n" + entity.toString();
		String prop = property.replaceAll("[^A-Za-z]+", ""); // remove non alphabetical characters
		String pattern ="(\\s*"+ prop + "\\s+.\\s+)(.*)";
		Pattern ptrn = Pattern.compile(pattern);
		Matcher m = ptrn.matcher(description);
		 if (m.find()) {
			 return m.group();
		 }
		 else {
			 return "";
		 }
	}


	default void displayProperty(GraphicsContext gc, String property, T entity, int xOffset, int yOffset) {
		gc.fillText(
    		property,
    		entity.getPosition().toVec2d().getX()+xOffset,entity.getPosition().toVec2d().getY()+yOffset
        );
    }
}


