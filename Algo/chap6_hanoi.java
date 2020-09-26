package app;

class chap6_hanoi {
static void deplace(int n, int a,int b, int c)
{
if(n>0) {
deplace(n-1,a,c,b);
System.out.println("De "+a+" vers "+b);
deplace(n-1,c,b,a);
}
}
public static void main(String[] args) {
deplace(3,1,2,3);
}
}
