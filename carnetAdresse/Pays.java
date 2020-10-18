package com.carnetAdresse;



public class Pays {

    private String Pays;
    private String A2;
    private String A3;
    private int number;

    public Pays(String Pays, String A2, String A3, int number) {
        this.Pays = Pays;
        this.A2 = A2;
        this.A3 = A3;
        this.number = number;
    }

    public String getPays() {
        return Pays;
    }

    public String getA2() {
        return A2;
    }

    public String getA3() {
        return A3;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return Pays;
    }
    
    
    
}