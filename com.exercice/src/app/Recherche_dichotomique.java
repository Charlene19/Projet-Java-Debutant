package app;

class Recherche_dichotomique {

    public static void main(String []args){

        int [] t = {1, 2 ,3 , 4, 5, 6, 7, 8};
        int d,f,m,rech;
        //le nombre que je recherche
        rech=15;
//mon point de départ que j'initialise sur mo tableau à l'indice 0        
d=0;
//variable qui prend la valeur de mon tableau à moins 1
f=t.length-1;

//sans le cast ça ne fonctionne pas 
do {
m=(int)((d+f)/2);
System.out.println("d="+d+", f="+f+", m="+m+", t[m]="+t[m]);
if(rech>t[m]) d=m+1;
else f=m-1;
} while(d<=f && rech!=t[m]);
if(rech==t[m]) System.out.println(rech+" trouvé à la position "+m);
else System.out.println(rech+" n’a pas été trouvé");
}
}