package com.charlene.entite;

class Etudiant {

    String prenom;
    String nom;
    int age;

    public Etudiant(String nom, String prenom, int age){this.nom = nom; this.prenom = prenom; this.age = age;}

    public String getPrenom() {
		return prenom;
	}

    public void setPrenom (String prenom) {
		this.prenom = prenom;
	}

    public String getNom() {
		return nom;
	}

    public void setNom (String nom) {
		this.nom = nom ;
	}

    public int getAge() {
		return age;
	}

    public void setAge (int age ) {
		this.age = age;
	}

    @Override
    public boolean equals(Object obj){
     
        Etudiant autrEtudiant = (Etudiant) obj;

    if (this.getNom().equalsIgnoreCase(autrEtudiant.getNom()) && this.getPrenom().equalsIgnoreCase(autrEtudiant.getPrenom())){
        
                return true;}else{

                return false;}
   
       
}

    @Override
    public int hashCode(){

        int result = 17;
        result = 31 * result + (nom == null ? 0 :name.hashCode());
        result = 31 * result + (prenom == null ? 0 : prenom.hashCode());
        result = 31 * result + age;

        return result;
    }

  

    @Override
    public String toString(){
        String str; 
       
        str =  getNom() + " " + getPrenom() + " " + getAge() + " ans";
        return str; 
    }

    public static void main(String []args){

        Etudiant etudiant1 = new Etudiant("Dupont", "Albert", 22);
        Etudiant etudiant2 = new Etudiant("DUPONT", "albert", 22);
        Etudiant etudiant3 = new Etudiant("Mercier", "Jean", 55);
       Etudiant etudiant4 = new Etudiant("MERCIER", "Jean", 55);

       etudiant1.equals(etudiant2);
       etudiant3.equals(etudiant2);
       etudiant3.equals(etudiant4);
       System.out.println("\n --------------------------------------- \n");
       System.out.println("Identité de l'étudiant ----> " + etudiant1);
       System.out.println("Identité de l'étudiant ----> " + etudiant2);
       System.out.println("Identité de l'étudiant ----> " + etudiant3);
       System.out.println("Identité de l'étudiant ----> " + etudiant4);
    }
    
    
}