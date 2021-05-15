package com.example.virtuace;

import java.util.Arrays;
import java.util.Objects;

public class Task2 {
    public static void main(String[] args) {

        System.out.println(textFormatter("555 Straight Stave Ave, San Francisco, CA 94104"));
        System.out.println(textFormatter("444 Ave Maria Stairway St., San Francisco, CA 94104"));
        System.out.println(textFormatter("9032 Flave Steep Str, San Francisco, CA 94104"));
        System.out.println("\n");
        System.out.println(regexFormatter("555 Ave Straight Stave Ave, San Francisco, CA 94104"));
        System.out.println(regexFormatter("444 Ave Maria Stairway St., San Francisco, CA 94104"));
        System.out.println(regexFormatter("9032 Flave Steep Str, San Francisco, CA 94104"));
    }

    public static String regexFormatter(String inputString){
        String outputString = inputString.replaceAll("\\sAve[.]\\b\\S", " Avenue");
        outputString = outputString.replaceAll("\\sAve\\b\\S", " Avenue,");
        outputString = outputString.replaceAll("\\s\\bStr[.]", " Street");
        outputString = outputString.replaceAll("\\s\\bStr\\b", " Street");
        outputString = outputString.replaceAll("\\s\\bSt[.]", " Street");
        outputString = outputString.replaceAll("\\s\\bSt\\b", " Street");
        return outputString;
    }

    public static String textFormatter(String inputString) {
        String outputString = inputString;
        String[] formattedString = outputString.split(",");
        String[] toReplaceString = formattedString[0].split(" ");
        String replacedString = "";
        int repIndex = toReplaceString.length-1;
        if(Objects.equals(toReplaceString[repIndex], "Ave.")){
            replacedString = toReplaceString[repIndex].replace("Ave.", "Avenue");
        } else if (Objects.equals(toReplaceString[repIndex], "Ave")) {
            replacedString = toReplaceString[repIndex].replace("Ave", "Avenue");
        }

        switch (toReplaceString[repIndex]) {
            case "Str.":
                replacedString = toReplaceString[repIndex].replace("Str.", "Street");
                break;
            case "Str":
                replacedString = toReplaceString[repIndex].replace("Str", "Street");
                break;
            case "St.":
                replacedString = toReplaceString[repIndex].replace("St.", "Street");
                break;
            case "St":
                replacedString = toReplaceString[repIndex].replace("St", "Street");
        }

        toReplaceString[repIndex] = replacedString;
        final String[] tempString = {""};
        Arrays.stream(toReplaceString).forEachOrdered(s -> tempString[0] += " " + s);
        formattedString[0] = tempString[0];
        tempString[0] = "";
        Arrays.stream(formattedString).forEachOrdered(s -> tempString[0] += s + ",");

        tempString[0] = tempString[0].substring(0, tempString[0].length() - 1);

        outputString = tempString[0];
        return outputString;
    }
}
