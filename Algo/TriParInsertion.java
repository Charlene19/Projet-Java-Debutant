package app; 

class TriParInsertion {

    public static void main(String [] args) {
        int t[]={48,17,25,9,34};
        int i,j,mem,pos,cpt;
        cpt=5;
        for(i=1;i<cpt;i++) {
        mem=t[i];
        pos=i-1;
        System.out.println();

        while((pos>=0) && (t[pos]>mem)) {
        t[pos+1]=t[pos];
        pos--;
        }
        System.out.println();
        t[pos+1]=mem;
        for(j=0;j<cpt;j++) System.out.print(t[j]+" ");
        }
        System.out.println();
        }
        }
    

   
    
    
