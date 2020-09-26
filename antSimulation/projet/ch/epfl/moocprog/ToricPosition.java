package ch.epfl.moocprog; 

import static ch.epfl.moocprog.app.Context.getConfig;
import static ch.epfl.moocprog.config.Config.*;
import static ch.epfl.moocprog.config.Config.WORLD_HEIGHT;
import static ch.epfl.moocprog.config.Config.WORLD_WIDTH;
import ch.epfl.moocprog.utils.Vec2d;
import java.lang.Exception;



 public final class ToricPosition{
  
    
     static int width = getConfig().getInt(WORLD_WIDTH);
     static int height = getConfig().getInt(WORLD_HEIGHT);
     
     Vec2d coord;
    

     public ToricPosition() {coord = new Vec2d(0.0, 0.0);}

     public ToricPosition(double x, double y){ coord = clampedPosition(x,y);}

     public ToricPosition (Vec2d vec2d) {  vec2d = clampedPosition(vec2d.getX(), vec2d.getY());}

     static private Vec2d clampedPosition(double x, double y) {//doit retourer un Vec2d projeté
      
        while (x < 0) { x += width; }
        while (x >= width){ x = x - width;}
        while ( y < 0){ y += height; }
        while (y >= height){ y = y - height;} 

        return new Vec2d(x, y);}
   
       public ToricPosition add(ToricPosition that){
           

        double sumX = this.coord.getX() + that.coord.getX();
        double sumY = this.coord.getY() + that.coord.getY();
           
           return new ToricPosition(clampedPosition(sumX, sumY));}


       public ToricPosition add(Vec2d vec) {
        double sumX = this.coord.getX() + vec.getX();
        double sumY = this.coord.getY() + vec.getY();
           
           return new ToricPosition(clampedPosition(sumX, sumY));}

       public Vec2d toVec2d(){ return coord;}

       public Vec2d toricVector(ToricPosition that){
           ToricPosition possibilite[] = new ToricPosition[9];
           
           possibilite [0] = that; 
           possibilite [1] = that.add(new Vec2d(0, height));
           possibilite [2] = that.add(new Vec2d(width, 0)); 
           possibilite [3] = that.add(new Vec2d(width, height));
           possibilite [4] = that.add(new Vec2d(- width, height)); 
           possibilite [5] = that.add(new Vec2d(+ width, - height));
           possibilite [6] = that.add(new Vec2d(- width, -height)); 
           possibilite [7] = that.add(new Vec2d(+ width, +height));
           possibilite [8] = that.add(new Vec2d(- width, + height)); 

           Vec2d petitVecteur = new Vec2d(possibilite[0].toVec2d().getX() - coord.getX(), possibilite[0].toVec2d().getY() - coord.getY());

           double minDistance = petitVecteur.length();
           double courranteDistance = minDistance;

           for (ToricPosition p : possibilite){
               courranteDistance = coord.distance(p.toVec2d()); 

               if (courranteDistance < minDistance){
                   minDistance = courranteDistance;
               }


           }
           return petitVecteur;
               
           }


    public double toricDistance(ToricPosition that){ 
       return this.toricVector(that).length(); 
        
     }

    public String toString(){return coord.toString();}


    }


