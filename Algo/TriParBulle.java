package app; 

class TriParBulle{

    public static void main (String []args){

    int t[] = {12, 13, 1, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 14}; 
    int i, cpt, temp; 
    boolean Permut = true; 
    cpt = 13; 

    while (Permut){

        for (i=0; i< 14; i++) System.out.print(t[i] + " ");
        System.out.println(); 

        System.out.println("->");

        Permut = false; 

        for (i=0; i<cpt; i++){

            if(t[i]<t[i+1]){
                temp = t[i]; 

                t[i] = t[i+1];
                t[i+1] = temp; 
 
                Permut = true; 
            }
        }
    
        cpt--; 
        for(i=0; i<14; i++)System.out.print(t[i] + " ");
        System.out.println(); 
    }
}
}