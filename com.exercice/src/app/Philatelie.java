import java.util.ArrayList;

class Timbre {

    public static final int ANNEE_COURANTE = 2016;
    public static final int VALEUR_TIMBRE_DEFAUT = 1;
    public static final String PAYS_DEFAUT = "Suisse";
    public static final String CODE_DEFAUT = "lambda";

    public static final int BASE_1_EXEMPLAIRES = 100;
    public static final int BASE_2_EXEMPLAIRES = 1000;
    public static final double PRIX_BASE_1 = 600;
    public static final double PRIX_BASE_2 = 400;
    public static final double PRIX_BASE_3 = 50;

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
    protected String code;
    protected int annee;
    protected String pays;
    protected double valeurFaciale;
    protected double pxDeVente;

        public Timbre(){this.code = CODE_DEFAUT; this.annee = ANNEE_COURANTE; this.pays = PAYS_DEFAUT; this.valeurFaciale = VALEUR_TIMBRE_DEFAUT;}

        public Timbre (String code, int annee, String pays, double valeurFaciale) { this.code = code; this.annee = annee; this.pays = pays; this.valeurFaciale = valeurFaciale;}

        public Timbre (String code, int annee, String pays){ this.code = code; this.annee = annee; this.pays = pays; this.valeurFaciale = VALEUR_TIMBRE_DEFAUT;}

        public Timbre (String code, int annee){ this.code = code; this.annee = annee; this.pays = PAYS_DEFAUT; this.valeurFaciale = VALEUR_TIMBRE_DEFAUT;}

        public Timbre (String code){ this.code = code; this.annee = ANNEE_COURANTE; this.pays = PAYS_DEFAUT; this.valeurFaciale = VALEUR_TIMBRE_DEFAUT; }

        public String getCode(){ return code;}  
        public void setCode(String code){ this.code = code;}
        
        public int age(){ return ANNEE_COURANTE - annee;}    

        public int getAnnee(){ return annee;}
        public void setAnne(int annee){ this.annee = annee;}

        public String getPays(){ return pays;}
        public void setPays(String pays){this.pays = pays;}

        public double getValeurFaciale(){ return valeurFaciale;}
        public void setValeurFaciale(double valeurFaciale){this.valeurFaciale = valeurFaciale;}

        public double vente() { int age = age(); 
            if (age<5){ return valeurFaciale;}else{ return valeurFaciale*age*2.5;}}
        
        public String toString(){ 

         String str  = ("Timbre de code " + this.code  + " datant de " + this.annee + " (provenance " + this.pays + ") ayant pour valeur faciale " + valeurFaciale  + " francs");
            return str; }
}

class Rare extends Timbre{ 
         
            private int nbreExemplaire; 

            public Rare (){ super(); }

            public Rare (String code, int annee, String pays, double valeurFaciale, int nbreExemplaire) { super(code, annee, pays, valeurFaciale); this.nbreExemplaire = nbreExemplaire;}

            public Rare (String code, int annee, String pays, int nbreExemplaire){ super(code, annee, pays); this.valeurFaciale = VALEUR_TIMBRE_DEFAUT; this.nbreExemplaire = nbreExemplaire;}
    
            public Rare (String code, int annee, int nbreExemplaire){ super(code, annee);this.pays = PAYS_DEFAUT; this.valeurFaciale = VALEUR_TIMBRE_DEFAUT; this.nbreExemplaire = nbreExemplaire;}
    
            public Rare (String code, int nbreExemplaire){ super(code);this.annee = ANNEE_COURANTE; this.pays = PAYS_DEFAUT; this.valeurFaciale = VALEUR_TIMBRE_DEFAUT; this.nbreExemplaire = nbreExemplaire;}

            public Rare (int nbreExemplaire){this.annee = ANNEE_COURANTE; this.pays = PAYS_DEFAUT; this.valeurFaciale = VALEUR_TIMBRE_DEFAUT; this.nbreExemplaire = nbreExemplaire;}
        
        public int getExemplaires(){ return nbreExemplaire;}
        public void setExemplaires(int nbreExemplaire){this.nbreExemplaire = nbreExemplaire;}

        public String toString( ){ 
        
            String str2 = ("Timbre de code " + this.code + " datant de " + this.annee + " (provenance " + this.pays + ") ayant pour valeur faciale " + valeurFaciale + " francs\n Nombre d'exemplaires -> " + nbreExemplaire); return str2;}

        public double vente() {// part du prix de bas si le nombre d'exemplaires est - de 100
           
                int age = super.age();

            if( nbreExemplaire < 100){return (PRIX_BASE_1 * age)/10.0;}
            //du prix de base 1 si le nombre d'exemplaires est entre 100 et 1000
            if( nbreExemplaire <1000){return (PRIX_BASE_2* age) /10.0;}
            // sinon de 50 francs. 
            else{ return (PRIX_BASE_3* age)/10.0;} 
            //le prix de base est la formule prix_base*(age_timbre/10.0)
    
        }
    }

class Commemoratif extends Timbre{

    private int age;

    public Commemoratif (String code, int annee, String pays, double valeurFaciale) { super(code, annee, pays, valeurFaciale); }

    public Commemoratif (String code, int annee, String pays){ super(code, annee, pays); }

    public Commemoratif (String code, int annee){ super(code, annee); }

    public Commemoratif (String code){ super(code); }

    public int getAge(){ return age;}
    

    public String toString() {
        String str3;
        str3 = ("Timbre de code " + this.code + " datant de " + this.annee + " (provenance " + this.pays
                + ") ayant pour valeur faciale " + valeurFaciale + " francs\nTimbre celebrant un evenement");
              return str3;}

              public double vente() { int age = age(); 
                if (age<5){ return valeurFaciale;}else{ return valeurFaciale*age*2.5*2;}}
}	
	
/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/

class Philatelie {

    public static void main(String[] args) {

        // ordre des parametres: nom, annee d'emission, pays, valeur faciale,
        // nombre d'exemplaires
        Rare t1 = new Rare("Guarana-4574", 1960, "Mexique", 0.2, 98);

        // ordre des parametres: nom, annee d'emission, pays, valeur faciale
        Commemoratif t2 = new Commemoratif("700eme-501", 2002, "Suisse", 1.5);
        Timbre t3 = new Timbre("Setchuan-302", 2004, "Chine", 0.2);

        Rare t4 = new Rare("Yoddle-201", 1916, "Suisse", 0.8, 3);


        ArrayList<Timbre> collection = new ArrayList<Timbre>();

        collection.add(t1);
        collection.add(t2);
        collection.add(t3);
        collection.add(t4);

        for (Timbre timbre : collection) {
            System.out.println(timbre);
            System.out.println("Prix vente : " + timbre.vente() + " francs");
            System.out.println();
        }
    }
}

