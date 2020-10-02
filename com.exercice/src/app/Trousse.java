package app;

import java.util.ArrayList;
import java.util.Collections;

/*- Creer plusieurs instances de la classe et les stocker dans un objet "ArrayList"
	- En se basant sur les elements cités au debut de ce document, trouver un moyen de trier les objets contenus dans cet objet "ArrayList".
	- Afficher la liste une fois triée
	
	Par exemple si l'ArrayList contient des objets de type Animal, 
    trier cette liste en comparant le champ "name" de chaque Animal, puis afficher la liste triée.*/
    
    class Trousse{

      static  String crayon = "crayon";
        static  String gomme = "gomme"; 
        static String stylo = "stylo";
        static String feutre = "feutre"; 
        private ArrayList <String> trousse;
        
        public static void ajouter(ArrayList trousse, String str) {

            trousse.add(str);
        }

        public static void classerCroissant(ArrayList trousse) {
            Collections.sort(trousse);
        }
        public static void classerCroissant(ArrayList trousse, int indexMin, int indexMax) {

            System.out.println("Classe avec index spécifié : \n");
            Collections.sort(trousse.subList(indexMin, indexMax));
        }

        public static void renverserOrdre(ArrayList trousse){
            Collections. sort(trousse, Collections. reverseOrder());
        }
        public static void main(String[] args) {

            ArrayList trousseList = new ArrayList<String>();

            ajouter(trousseList, crayon);
            ajouter(trousseList, feutre);
            ajouter(trousseList, stylo);
            ajouter(trousseList, gomme);

            System.out.println(trousseList.toString());

            classerCroissant(trousseList);

            System.out.println(trousseList.toString());

            classerCroissant(trousseList, 0, 2);
            System.out.println(trousseList.toString());
            
            renverserOrdre(trousseList);
            System.out.println(trousseList.toString());


        }
    }