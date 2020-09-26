package app; 

class Tri_Shell{

    public static void main(String[] args) {

int t[]={48,17,25,9,34,12,28,1,4,98,0,33,48,10,11,9,25};
int i,j,n=0,mem,pos,cpt;
cpt=t.length;
while(n<cpt) n=3*n+1; //calcul de mon pas un = 3 un +1
while(n!=0) {
n=n/3;
for(i=n;i<cpt;i++) {
mem=t[i];
j=i;
while(j>(n-1) && t[j-n]>mem) {
t[j]=t[j-n];
j=j-n;
}
t[j]=mem;
}
for(j=0;j<cpt;j++) System.out.print(t[j]+" ");
System.out.println();
}
}
}
