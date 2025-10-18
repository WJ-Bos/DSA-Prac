package classes.problems.strings;

import java.util.*;

public class Strings {

    public static void main(String[] args) {

        System.out.println("Hello World");
        System.out.println(reverseString("Hello World"));

        String[] words = {
                "listen", "silent", "enlist",
                "rat", "tar", "art",
                "evil", "vile", "veil", "live",
                "dusty", "study"
        };

        System.out.println(groupAnagrams(words));
    }

    private static String reverseString(String str) {
        char[] charArray = str.toCharArray();
        int start = 0;
        int end = charArray.length - 1;

        while (start < end) {
            char temp = charArray[start];
            charArray[start]  = charArray[end];
            charArray[end] = temp;

            start++;
            end--;
        }

        return String.valueOf(charArray);
    }

    private static List<List<String>> groupAnagrams(String[] words) {
        if(words == null || words.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String word : words){
            String fs = getFrequencyString(word);
            if(map.containsKey(fs)){
                map.get(fs).add(word);
            }else{
                ArrayList<String> list = new ArrayList<>();
                list.add(word);
                map.put(fs,list);
            }
        }

       return new ArrayList<>(map.values());
    }

    private static String getFrequencyString(String string){

        int[] frequencies = new int[26];

        for(char c : string.toCharArray()){
            frequencies[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        char ch = 'a';
        for(int i : frequencies){
            sb.append(ch);
            sb.append(i);
            ch++;
        }
        return sb.toString();
    }

}
