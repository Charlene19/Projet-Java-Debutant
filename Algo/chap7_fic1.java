package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;

class chap7_fic1 {
public static String recolle(String[] morceaux, String separateur) {
int l=morceaux.length;
String chaine="";
for(int i=0;i<l;i++) {
chaine=chaine.concat(morceaux[i]);
if(i!=(l-1)) chaine=chaine.concat(separateur);
}
return chaine;
}
public static void main(String[] args) {
BufferedReader Fichier=null;
BufferedWriter FicSort=null;
String ligne;
String[][] passwd=new String[100][];
int cpt=0;
ligne="x";
try {
// Ouvre le fichier
Fichier=new BufferedReader(new FileReader ("/etc/passwd"));
while(ligne!=null) {
// lit une ligne
ligne=Fichier.readLine();
if(ligne!=null) {
// Split de la ligne
passwd[cpt]=ligne.split(":");
cpt++;
}
}
// Eventuel traitement ici sur le tableau
// Fichier de sortie
FicSort=new BufferedWriter(new FileWriter ("macopie"));
cpt=0;
while(passwd[cpt]!=null) {
// On recolle les morceaux
ligne=recolle(passwd[cpt],":");
// On enregistre la ligne
FicSort.write(ligne+"\n");
cpt++;
}
}
catch (FileNotFoundException ex) {
System.out.println("Fichier absent");
}
catch (IOException ex) {
System.out.println("Erreur de lecture");
}
finally {
try {
Fichier.close();
FicSort.close();
}
catch (IOException ex) {
System.out.println("Erreur de Fermeture");
}
}
}}
