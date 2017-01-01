package com.trial.baselook;

/**
 * Created by adityaprasann on 25/12/16.
 *
 *
 * You need to define a valid password for an email but the only restrictions are:

 The password must contain one uppercase character
 The password should not have numeric digit

 Now, given a String, find the length of the longest substring which is a valid password. For e.g Input Str = "a0Ba" , the output should be 2 as "Ba" is the valid substring.
 *
 * Codility test noon.com
 *
 */
import java.util.*;
public class Stringpass {

    public static void main(String... args){
        final String input = "a0Ba";

        final int answer = Arrays.stream(input.split("[0-9]+"))
                .filter(s -> s.matches("(.+)?[A-Z](.+)?"))
                .sorted((s1, s2) -> s2.length() - s1.length())
                .findFirst()
                .orElse("")
                .length();

        System.out.println(answer);
    }
}
