package app;

class Tri_Exercice {
 
 public static void main(String [] args){
    int [] t = {5, 7, 45, 53}; 
    int i, j, temp, cpt, pos; 
   
    cpt = 4;
    
    for (i = 1; i< cpt; i++){ 
        temp = t[i];     
        pos = i-1; 

    System.out.print(t[i]); 
    System.out.println(); 
    
while ((t[pos]>=0) && (t[pos]> temp))
{
    t[pos+1] = t[pos];
    pos--;

System.out.println(); 
   
t[pos+1] = temp;

for (j = 0; j< cpt; j++);
System.out.print(t[j]);
System.out.println();
    }
    
    
    }}
}
