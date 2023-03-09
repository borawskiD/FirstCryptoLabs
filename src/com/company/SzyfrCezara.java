package com.company;

public class SzyfrCezara {

    private final char[] polskiAlfabet = {'A', 'Ą', 'B', 'C','Ć', 'D','E', 'Ę','F', 'G','H', 'I','J', 'K','L', 'Ł','M', 'N','Ń','O', 'Ó','P', 'R','S', 'Ś','T', 'U','W', 'Y','Z', 'Ź','Ż'};
    private final char[] angielskiAlfabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    public void run(){
        System.out.println("Zadanie numer 1 \n");
        System.out.println("Przesuniecie: 3");
        System.out.println("Polski alfabet:");
        cezar(polskiAlfabet,3, "Dominik", "Borawski");
        System.out.println("Angielski alfabet:");
        cezar(angielskiAlfabet,3, "Dominik", "Borawski");
        System.out.println("\nZadanie numer 2");
        int numerAgenta = 100 % 24;
        System.out.println("Przesuniecie: " + numerAgenta);
        cezar(angielskiAlfabet,numerAgenta, "Dominik", "Borawski");

    }
    private void cezar(char[] alfabet, int przesuniecie, String imie, String nazwisko){
        char[] imieTab = imie.toCharArray();
        char[] surnameTab = nazwisko.toCharArray();
        String changedName = "";
        String changedSurname = "";
        for (char c : imieTab) {
            int index = indexOf(c,alfabet) + przesuniecie;
            if (index >= alfabet.length){
                index = index - alfabet.length;
            }
            changedName += alfabet[index];
        }
        for (char c : surnameTab) {
            int index = indexOf(c,alfabet) + przesuniecie;
            if (index >= alfabet.length){
                index = index - alfabet.length;
            }
            changedSurname += alfabet[index];
        }
        System.out.println(imie + " -> " + changedName);
        System.out.println(nazwisko + " -> " + changedSurname);
    }

    public int indexOf(char letter, char[] tab){
        int count = 0;
        for (char c : tab) {
            if (c == Character.toUpperCase(letter)) return count;
            count++;
        }
        //not found
        return -1;
    }

}
