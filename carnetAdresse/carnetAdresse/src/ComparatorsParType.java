import java.util.Comparator;

class ComparatorsParType implements Comparator<Personne> {

    @Override
    public int compare(Personne o1, Personne o2) {
       if (o1.getType() == o2.getType()){
        return  1;
       }else { return 0;
       
    }
}
}
    