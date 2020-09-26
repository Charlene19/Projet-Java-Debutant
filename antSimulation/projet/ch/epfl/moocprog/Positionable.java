package ch.epfl.moocprog; 

public class Positionable{

    ToricPosition position; 
    double x, y;


     public Positionable(){this.x = 0.0; this.y = 0.0;}

     public Positionable(ToricPosition position){ this.position = position;}

     public ToricPosition getPosition(){ return position;}

     final protected void setPosition(ToricPosition position){this.position = position;}

     public String toString(){String str = " "; 
     str = (" Position : " + position); return str;}
}