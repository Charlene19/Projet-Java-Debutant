import java.util.ArrayList;

/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
class Position{ 
    private double x, y; 
 
     public Position(double x, double y){ this.x = x; this.y = y;}

     public Position(){ this(0, 0);}
 
     public Double getY(){ return y;}
     public Double getX(){return x;}
 
     public String toString(){ String str; str = ("(" + x + ", " + y + ")"); return str;}
 }
 
 class Neurone{
 
     private Position position;
     private double signalInterne; 
     protected double facteutAttenuation; 
     private ArrayList<Neurone> connexions = new ArrayList<> ();
 
     public Neurone( Position position, double facteutAttenuation){ this.position = position; this.facteutAttenuation = facteutAttenuation; this.signalInterne = getSignal();
     connexions = new ArrayList<>();}
   
     public Position getPosition(){return position;}// retourne la position du neurone 
 
     public int getNbConnexions(){return connexions.size();}//le nombre de neurones de connexions
 
     public Neurone getConnexion(int index) { 
         return connexions.get(index);
     }
 
     public double getAttenuation(){return facteutAttenuation;} //le facteur d'atténuation
 
     public double getSignal(){return signalInterne; } //et le signal stocké par l'instance courante
     
 
     public void connexion(Neurone n){ connexions.add(n);}
 
     public void recoitStimulus(double stimulus){signalInterne = stimulus*facteutAttenuation;
         for (Neurone neurone : connexions)
         neurone.recoitStimulus(signalInterne);}
 
         
     public String toString(){String str1 = " ";
       
         str1 = ("Le neurone en position " + position + " avec attenuation " + getAttenuation() + " ");
 
          if (!connexions.isEmpty()){                        
         for (Neurone neurone : connexions)
         str1 += (" en connexion avec\n\t - un neurone en position " + neurone.getPosition());
          }else{
              str1+= (" sans connexion\n");
          }
         
         return str1;}
 
 
         }
 
         class NeuroneCumulatif extends Neurone{
             private  double signalInterne; 
             private double stimulus;
 
 
             public NeuroneCumulatif(Position position, double facteutAttenuation){super(position, facteutAttenuation);}
             
         
 
            
             public void recoitStimulus(double stimulus){
                super.recoitStimulus(getSignal()/getAttenuation() + stimulus);
             }
 
 
            @Override
            public String toString(){
                return super.toString();
            }
         }
            class Cerveau {
 
             private ArrayList<Neurone> cerveau = new ArrayList<>();
             
         
                 public Cerveau(){ cerveau = new ArrayList<>();}
             
                 public int getNbNeurones(){ return cerveau.size();}
             
                 public Neurone getNeurone(int index){return cerveau.get(index);}
             
                 public void ajouterNeurone(Position position, double attenuation){  
                     cerveau.add(new Neurone(position, attenuation));}
             
                 public void ajouterNeuroneCumulatif(Position position, double attenuation){  
                     
                     cerveau.add(new NeuroneCumulatif(position, attenuation));}
  
             
                 public void stimuler(int index, double stimulus){
                     cerveau.get(index).recoitStimulus(stimulus);}
             
                 public double sonder(int index){ return cerveau.get(index).getSignal();   //retourne le signal stockée à l'index}
                    
         }
                 public void creerConnexions() {
                     if (cerveau.size() > 1){
                     cerveau.get(0).connexion(cerveau.get(1));
                 }
                 if (cerveau.size() > 2){
                     cerveau.get(0).connexion(cerveau.get(2));
                 }
                 
                 for (int i = 1; i < cerveau.size() - 2; i+=2){
                     cerveau.get(i).connexion(cerveau.get(i + 1));
                     cerveau.get(i + 1).connexion(cerveau.get(i + 2));
                 }
                     }
     
                     
                 public String toString(){String str; str = ("*----------*\nLe cerveau contient " + getNbNeurones() + " neurone(s) \n "); 
                 
                 for (Neurone neurone : cerveau){ str += neurone + "\n ";}
             str += ("*----------*");
                  return str;}
             
             
             }
         
         
 
  
/*******************************************
 * Ne pas modifier apres cette ligne
 * pour pr'eserver les fonctionnalit'es et
 * le jeu de test fourni.
 * Votre programme sera test'e avec d'autres
 * donn'ees.
 *******************************************/
public class SimulateurNeurone {

    public static void main(String[] args) {
        // TEST DE LA PARTIE 1
        System.out.println("Test de la partie 1:");
        System.out.println("--------------------");

        Position position1 = new Position(0, 1);
        Position position2 = new Position(1, 0);
        Position position3 = new Position(1, 1);

        Neurone neuron1 = new Neurone(position1, 0.5);
        Neurone neuron2 = new Neurone(position2, 1.0);
        Neurone neuron3 = new Neurone(position3, 2.0);

        neuron1.connexion(neuron2);
        neuron2.connexion(neuron3);
        neuron1.recoitStimulus(10);

        System.out.println("Signaux : ");
        System.out.println(neuron1.getSignal());
        System.out.println(neuron2.getSignal());
        System.out.println(neuron3.getSignal());

        System.out.println();
        System.out.println("Premiere connexion du neurone 1");
        System.out.println(neuron1.getConnexion(0));


        // FIN TEST DE LA PARTIE 1

        // TEST DE LA PARTIE 2
        System.out.println("Test de la partie 2:");
        System.out.println("--------------------");

        Position position5 = new Position(0, 0);
        NeuroneCumulatif neuron5 = new NeuroneCumulatif(position5, 0.5);
        neuron5.recoitStimulus(10);
        neuron5.recoitStimulus(10);
        System.out.println("Signal du neurone cumulatif  -> " + neuron5.getSignal());

        // FIN TEST DE LA PARTIE 2

        // TEST DE LA PARTIE 3
        System.out.println();
        System.out.println("Test de la partie 3:");
        System.out.println("--------------------");
        Cerveau cerveau = new Cerveau();

        // parametres de construction du neurone:
        // la  position et le facteur d'attenuation
        cerveau.ajouterNeurone(new Position(0,0), 0.5);
        cerveau.ajouterNeurone(new Position(0,1), 0.2);
        cerveau.ajouterNeurone(new Position(1,0), 1.0);

        // parametres de construction du neurone cumulatif:
        // la  position et le facteur d'attenuation
        cerveau.ajouterNeuroneCumulatif(new Position(1,1), 0.8);
        cerveau.creerConnexions();
        cerveau.stimuler(0, 10);

        System.out.println("Signal du 3eme neurone -> " + cerveau.sonder(3));
        System.out.println(cerveau);
        // FIN TEST DE LA PARTIE 3
    }
}