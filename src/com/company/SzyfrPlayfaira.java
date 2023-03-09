package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SzyfrPlayfaira {
    char[][] keyValue = new char[5][5];
    LinkedList<Character> alfabet = new LinkedList<>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'K', 'L', 'M', 'N', 'O', 'P','Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'));
    public void run(){
        System.out.println(alfabet.size());
        generateKey("BORAWSKI");
        String input = "AMOR PATRIAE NOSTRA LEX";
        input = input.replace(" ", "");
        System.out.println("Zaszyfrowany: "+splitLetters(input));
        System.out.println();
    }
    public String splitLetters(String input){
        List<String> doubleLetters = new ArrayList<>();
        for(int i = 0; i < input.length(); i+=2){
            doubleLetters.add(""+input.charAt(i) + input.charAt(i+1));
        }

        System.out.println(doubleLetters);
        String score = "";
        for (String doubleLetter : doubleLetters) {
            score += findIndex(doubleLetter);
        }
        return score;
    }
    public String findIndex(String input){
        String output = "";
        char a = input.charAt(0);
        char b = input.charAt(1);
        int[] firstIndex = new int[]{0,0};
        int[] secondIndex = new int[]{0,0};
        for(int i = 0; i < 5; i++){
            for(int z = 0; z < 5; z++){
               if(keyValue[i][z] == a){
                   firstIndex[0] = i;
                   firstIndex[1] = z;
               }
               if(keyValue[i][z] == b){
                   secondIndex[0] = i;
                   secondIndex[1] = z;
                }
            }
        }

        if (firstIndex[0] != secondIndex[0] && firstIndex[1] != secondIndex[1]){
            output+= (keyValue[firstIndex[0]][secondIndex[1]]);
            output+=(keyValue[secondIndex[0]][firstIndex[1]]);
        }
        if(firstIndex[1] == secondIndex[1]){
            if ((firstIndex[0] + 1) < 5) output+=(keyValue[firstIndex[0]+1][firstIndex[1]]);
            else output+=(keyValue[0][firstIndex[1]]);
            if ((secondIndex[0] + 1) < 5) output+=(keyValue[secondIndex[0]+1][secondIndex[1]]);
            else output+=(keyValue[0][secondIndex[1]]);
        }
        if(firstIndex[0] == secondIndex[0]){
            if ((firstIndex[1] + 1) < 5) output+=(keyValue[firstIndex[0]][firstIndex[1] + 1]);
            else output+=(keyValue[firstIndex[0]][0]);
            if ((secondIndex[1] + 1) < 5) output+=(keyValue[secondIndex[0]][secondIndex[1] + 1]);
            else output+=(keyValue[secondIndex[0]][0]);
        }
        return output;
    }

    public void generateKey(String key){
        List<Character> usedLetters = new ArrayList<>();
        List<Character> cipher = new ArrayList<>();
        char[] test = key.toCharArray();
        for (int i = 0; i < test.length; i++){
            if (!usedLetters.contains(test[i])){
                cipher.add(test[i]);
                usedLetters.add(test[i]);
            }
        }
        for (Character usedLetter : usedLetters) {
            alfabet.remove(usedLetter);
        }
        int column = 0;
        int row = 0;
        for(int i = 0; i < cipher.size(); i++){
            keyValue[row][column] = cipher.get(i);
            column++;
            if (column == 5){
                column = 0;
                row +=1;
            }
        }
        for(int i = 0; i < alfabet.size(); i++){
            keyValue[row][column] = alfabet.get(i);
            column+=1;
            if (column == 5){
                column = 0;
                row +=1;
            }
        }
        System.out.println("Tabela:");
        for (char[] chars : keyValue) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println("");
        }
    }
}
