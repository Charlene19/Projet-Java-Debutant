
import java.util.ArrayList;
import java.util.Random;

/*******************************************
 * Completez le programme Ã  partir d'ici.
 *******************************************/
class Postulant{
		
	private final String nom;
	private int nbElecteurs;
	
	public Postulant(String nom, int nbElecteurs){
		
		this.nom = new String (nom);
		this.nbElecteurs = nbElecteurs;
		
	}
	
	public Postulant(String nom){
		
		this.nom = new String (nom);
		this.nbElecteurs = 0;
		
	}
	
	public Postulant(Postulant postulant){
				
		this.nom = postulant.getNom();
		this.nbElecteurs = postulant.getVotes();
		
	}
	
	public String getNom(){
		
		return new String(this.nom);
		
	}
	
	public int getVotes(){
		
		return this.nbElecteurs;
		
	}
	
	public void elect(){
		
		this.nbElecteurs++;
		
	}
	
	public void init(){
		
		this.nbElecteurs = 0;
		
	}
	
}

class Scrutin{
	
	private ArrayList<Postulant> listePostulants;
	private ArrayList<Vote> votes;
	private int maxVotants;
	private int date;
	
	public Scrutin(ArrayList<Postulant> postulants, int maxVotants, int date, boolean init){
		
		this.listePostulants = new ArrayList<Postulant>();
		for(Postulant p : postulants){
			
			if (init){
				
				Postulant newPostulant = new Postulant (p);
				newPostulant.init();
				
				this.listePostulants.add(newPostulant);
				
			} else {
				
				this.listePostulants.add(new Postulant (p));
				
			}
			
			
			
		}
		
		this.maxVotants = maxVotants;
		this.date = date;
		
		this.votes = new ArrayList<Vote>();
	}
	
	public Scrutin(ArrayList<Postulant> postulants, int maxVotants, int date){
		
		this.listePostulants = new ArrayList<Postulant>();
		for(Postulant p : postulants){

			Postulant newPostulant = new Postulant(p);
			newPostulant.init();
			
			this.listePostulants.add(newPostulant);

		}
		
		this.maxVotants = maxVotants;
		this.date = date;
		this.votes = new ArrayList<Vote>();
	}
	
	public int calculerVotants(){
		
		int totalVotants = 0;
		
		for(Postulant p : this.listePostulants){
			
			totalVotants += p.getVotes();
			
		}
		
		return totalVotants;
		
	}
	
	public String gagnant(){
		
		String gagnant = "";
		int maxVotes = 0;
		
		for (Postulant p : this.listePostulants){
			
			if(p.getVotes() >= maxVotes){
				
				maxVotes = p.getVotes();
				gagnant = p.getNom();
				
			}
			
		}
				
		return gagnant;
	}
	
	public void resultats(){
		
		String str = "";
		
		if(this.calculerVotants() == 0){
			
			str += "Scrutin annulé, pas de votants\n";
			
		} else {
		
			str += "Taux de participation -> ";
			str += String.format("%.1f", (double)this.calculerVotants() / this.maxVotants * 100);
			str += " pour cent\n";
			str += "Nombre effectif de votants -> ";
			str += this.calculerVotants() + "\n";
			str += "Le chef choisi est -> ";
			str += this.gagnant();
			str += "\n\nRépartition des electeurs\n";
			
			for (Postulant p : this.listePostulants){
				
				str += p.getNom() + " -> ";
				str += String.format("%.1f",(double) p.getVotes() / this.calculerVotants()*100);
				str += " pour cent des électeurs\n";
				
			}
			
		}
		
		System.out.println(str);
		
		
	}
	
	public void compterVotes(){
		
		for (Postulant p : this.listePostulants){
			
			p.init();
			
		}
		
		for(Vote vote : this.votes){
			
			
			if (!vote.estInvalide()){
				
				String nom = vote.getNom();
				
				for (Postulant p : this.listePostulants){					
					
					if(nom.equals(p.getNom())){
						
						p.elect();
						
					}
					
				}
				
			}
			
		}
		
	}
	
	public void simuler(double participation, int jour){
		
		int nbVotants = (int) Math.ceil(this.maxVotants * participation);
		
		
		for (int i = 0; i < nbVotants; i++){
			
			int candNum = Utils.randomInt(this.listePostulants.size());
			
			if(i%3 == 0){
				
				Postulant p = this.listePostulants.get(candNum);
				
				BulletinElectronique newBulletin = new BulletinElectronique(p.getNom(),jour,this.date);
				
				System.out.println(newBulletin);
				
				this.votes.add(newBulletin);
				
			} else if (i%3 == 1){
				
				Postulant p = this.listePostulants.get(candNum);
				
				boolean signature = this.signature(i);	
				
				BulletinPapier newBulletin = new BulletinPapier(p.getNom(),jour,this.date,signature);
				
				System.out.println(newBulletin);
				
				this.votes.add(newBulletin);
				
				
			} else if (i%3 == 2){
				
				Postulant p = this.listePostulants.get(candNum);
				
				boolean signature = this.signature(i);	
				
				BulletinCourrier newBulletin = new BulletinCourrier(p.getNom(),jour,this.date,signature);
				
				System.out.println(newBulletin);
				
				this.votes.add(newBulletin);
				
				
			}
				
				
			
		}
		
		
	}
	
	private boolean signature(int i){
		
		return !(i%2 == 0);
		
	}
	
}

abstract class Vote{
	
	private final String nom;
	private final int date;
	private final int dateLimite;
	
	public Vote(String nom, int date, int dateLimite){
		
		this.nom = new String(nom);
		this.date = date;
		this.dateLimite = dateLimite;
		
	}
	
	abstract public boolean estInvalide();
	
	public int getDate(){
		
		return this.date;
		
	}
	
	public String getNom(){
		
		return new String(this.nom);
		
	}
	
	public String getPostulant(){
		
		return this.getNom();
		
	}
	
	public int getDateLimite(){
		
		return this.dateLimite;
		
	}
	
	public String toString(){
		
		String str = " ";
		str += "pour " + this.nom;
		
		if(!this.estInvalide()){
			
			str += " -> valide";
			
		} else {
			
			str += " -> invalide";
			
		}
		
		return str;
		
	}
	
}

interface CheckBulletin{
	
	boolean checkDate();
	
}

class BulletinElectronique extends Vote implements CheckBulletin{

	public BulletinElectronique(String nom, int date, int dateLimite) {
		
		super(nom, date, dateLimite);
		
	}
	
	public boolean checkDate(){
		
		return !(super.getDate() > super.getDateLimite()-2);
		
	}

	@Override
	public boolean estInvalide() {
		
		return !this.checkDate();
		
	}
	
	public String toString(){
		
		String str = "";
		
		str += "vote electronique pour ";
		str += super.getNom() + " -> ";
		
		if(this.estInvalide()){
			
			str += "invalide";
			
		} else {
			
			str += "valide";
			
		}
		
		return str;
		
	}
	
	
	
}

class BulletinPapier extends Vote{
	
	private boolean signature = false;

	public BulletinPapier(String nom, int date, int dateLimite, boolean signature) {
		
		super(nom, date, dateLimite);
		this.signature = signature;
		
	}

	@Override
	public boolean estInvalide() {

		return !this.signature;
	}
	
	
	public String getNom(){
		
		return super.getNom();
		
	}
	
	public int getDateLimite(){
		
		return super.getDateLimite();
		
	}
	
	public String toString(){
		
		String str = "";
		
		str += "vote par bulletin papier pour ";
		str += super.getNom() + " -> ";
		
		if(this.estInvalide()){
			
			str += "invalide";
			
		} else {
			
			str += "valide";
			
		}
		
		return str;
		
	}
	
	
	
}

class BulletinCourrier extends BulletinPapier implements CheckBulletin{

	public BulletinCourrier(String nom, int date, int dateLimite, boolean signature) {
		
		super(nom, date, dateLimite, signature);
		
	}
	
	public boolean estInvalide() {

		return super.estInvalide() || !this.checkDate();
		
	}
	
	public boolean checkDate(){
		
		return !(super.getDate() > super.getDateLimite());
		
	}
	
	public String toString(){
			
			String str = "";
			
			str += "envoi par courrier d'un vote par bulletin papier pour ";
			str += super.getNom() + " -> ";
			
			if(this.estInvalide()){
				
				str += "invalide";
				
			} else {
				
				str += "valide";
				
			}
			
			return str;
			
	}
	
}



/*******************************************
 * Ne pas modifier les parties fournies
 * pour pr'eserver les fonctionnalit'es et
 * le jeu de test fourni.
 * Votre programme sera test'e avec d'autres
 * donn'ees.
 *******************************************/

class Utils {

    private static final Random RANDOM = new Random();

    // NE PAS UTILISER CETTE METHODE DANS LES PARTIES A COMPLETER
    public static void setSeed(long seed) {
        RANDOM.setSeed(seed);
    }

    // gÃ©nÃ¨re un entier entre 0 et max (max non compris)
    public static int randomInt(int max) {
        return RANDOM.nextInt(max);
    }
}

/**
 * Classe pour tester la simulation
 */

class Votation {

    public static void main(String args[]) {
        Utils.setSeed(20000);
        // TEST 1
        System.out.println("Test partie I:");
        System.out.println("--------------");

        ArrayList<Postulant> postulants = new ArrayList<Postulant>();
        postulants.add(new Postulant("Tarek Oxlama", 2));
        postulants.add(new Postulant("Nicolai Tarcozi", 3));
        postulants.add(new Postulant("Vlad Imirboutine", 2));
        postulants.add(new Postulant("Angel Anerckjel", 4));

        // 30 -> nombre maximal de votants
        // 15 jour du scrutin
        Scrutin scrutin = new Scrutin(postulants, 30, 15, false);

        scrutin.resultats();

        // FIN TEST 1

        // TEST 2
        System.out.println("Test partie II:");
        System.out.println("---------------");

        scrutin = new Scrutin(postulants, 20, 15);
        // tous les bulletins passent le check de la date
        // les parametres de simuler sont dans l'ordre:
        // le pourcentage de votants et le jour du vote
        scrutin.simuler(0.75, 12);
        scrutin.compterVotes();
        scrutin.resultats();

        scrutin = new Scrutin(postulants, 20, 15);
        // seuls les bulletins papier non courrier passent
        scrutin.simuler(0.75, 15);
        scrutin.compterVotes();
        scrutin.resultats();

        scrutin = new Scrutin(postulants, 20, 15);
        // les bulletins electroniques ne passent pas
        scrutin.simuler(0.75, 15);
        scrutin.compterVotes();
        scrutin.resultats();
        //FIN TEST 2

    }
}