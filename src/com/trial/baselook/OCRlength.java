package com.trial.baselook;

/**
 * Codility test noon.com
 *
 * Created by adityaprasann on 25/12/16.
 */
public class OCRlength {

    public static void main(String... args){
        String S = "A2Le";
        String T = "2pL1";
        int SLength = 0;
        int TLength = 0;

        String[] SParts = S.split("[^\\d]+");
        String[] TParts = T.split("[^\\d]+");

        for(int i = 0; i < SParts.length; i++) {
            if(!SParts[i].equals("")){
                SLength += Integer.parseInt(SParts[i]);
            }
        }

        for(int i = 0; i < TParts.length; i++) {
            if(!TParts[i].equals("")){
                TLength += Integer.parseInt(TParts[i]);
            }
        }

        for(int i = 0; i < S.length(); i++) {
            if(!Character.isDigit(S.charAt(i))){
                SLength += 1;
            }
        }

        for(int i = 0; i < T.length(); i++) {
            if(!Character.isDigit(T.charAt(i))){
                TLength += 1;
            }
        }

        System.out.println(SLength);
        System.out.println(TLength);

        if(TLength != SLength) {
            System.out.println("lenght is diff");
            System.exit(-1);
        }

        char[] sArray = S.toCharArray();
        char[] sArrayFiltered = new char[SLength];
        int sIndex = 0;
        for(int i = 0; i < sArray.length; i++) {
            if(Character.isDigit(sArray[i])) {
                int numOfTimes = Character.getNumericValue(sArray[i]);
                for(int x=0;x<numOfTimes;x++){
                    sArrayFiltered[sIndex+x] = '?';
                }
                sIndex += Character.getNumericValue(sArray[i]);
            } else {
                sArrayFiltered[sIndex] = sArray[i];
                sIndex++;
            }
        }
        System.out.println(sArrayFiltered);

        char[] tArray = T.toCharArray();
        char[] tArrayFiltered = new char[TLength];
        int tIndex = 0;
        for(int i = 0; i < tArray.length; i++) {
            if(Character.isDigit(tArray[i])) {
                int numOfTimes = Character.getNumericValue(tArray[i]);
                for(int x=0;x<numOfTimes;x++){
                    tArrayFiltered[tIndex+x] = '?';
                }
                tIndex += Character.getNumericValue(tArray[i]);
            } else {
                tArrayFiltered[tIndex] = tArray[i];
                tIndex++;
            }
        }
        System.out.println(tArrayFiltered);

        for(int idx=0; idx<sArrayFiltered.length; idx++){
            char sChar = sArrayFiltered[idx];
            char tChar = tArrayFiltered[idx];
            if(sChar == '?' || tChar == '?')
                continue;
            else{
                if(sChar != tChar)
                    System.out.println("Voilated " + sChar + "   " + tChar);
            }
        }


    }

}
