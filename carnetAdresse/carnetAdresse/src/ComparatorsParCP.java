import java.util.Comparator;

class ComparatorsParCP implements Comparator<Personne> {

    @Override
    public int compare(Personne o1, Personne o2) {
       
        return Integer.compare(o1.getCode_postal(), o2.getCode_postal());
    }
}