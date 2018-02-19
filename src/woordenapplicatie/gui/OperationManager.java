package woordenapplicatie.gui;


import java.util.*;

public class OperationManager {

    private static final String REGEX = "(\\.|,| |\n)*(\\.|,| |\n)";

    public String aantalWoorden(String text){
        int WordListlength = SplitWords(text).length;
        return "Aantal unieke woorden: " + UniqueWords(SplitWords(text)).size() + '\n' +
                "Aantal woorden: " + WordListlength;
    }

    public String sorteerAction(String text){
        ArrayList<String> words = UniqueWords(SplitWords(text));
        words.sort(Collections.reverseOrder());
        String returnString = "";
        for(String s: words){
            returnString += s + '\n';
        }
        return returnString;
    }

    public String frequentieAction(String text){
        String ReturnString = "";
        Map<String, Integer> map = new HashMap<>();
        for (String w :SplitWords(text)) {
            if (!map.containsKey(w)) {
                map.put(w, 1);
            } else {
                map.put(w, map.get(w) + 1);
            }
        }
        for(Map.Entry<String, Integer> entry : entriesSortedByValues(map)){
            ReturnString += entry.getKey() + ": " + entry.getValue() + '\n';
        }
        return ReturnString;
    }

    public String concordatieAction(String defaultText) {
        Map<String, ArrayList<Integer>> hm = new HashMap<>();
        int i = 0;
        String[] lines = SplitLine(defaultText);

        for (String line: lines) {
            i++;
            ArrayList<String> uniqueWords = UniqueWords(SplitWords(line));
            for (String s : uniqueWords) {
                if (!hm.containsKey(s)) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    hm.put(s,temp);
                } else {
                    ArrayList<Integer> temp = hm.get(s);
                    temp.add(i);
                    hm.put(s,temp);
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for(Object o : hm.entrySet()){
            result.append(o + "\n");
        }
        return String.valueOf(result);
    }

    private String[] SplitWords(String text){
        text = text.toLowerCase();
        String[] words = text.split(REGEX);
        return words;
    }

    private String[] SplitLine(String text){
        return text.split("\n");
    }

    private ArrayList<String> UniqueWords(String[] text){
        ArrayList<String> UniqueWords = new ArrayList<>();
        for(String s : text){
            if(!UniqueWords.contains(s)){
                UniqueWords.add(s);
            }
        }
        return UniqueWords;
    }

    public static void main(String[] args){
        OperationManager operationManager = new OperationManager();
        operationManager.SplitWords(WoordenController.DEFAULT_TEXT);
    }

    static <K,V extends Comparable<? super V>>
    SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
                new Comparator<Map.Entry<K,V>>() {
                    @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
                        int res = e1.getValue().compareTo(e2.getValue());
                        return res != 0 ? res : 1;
                    }
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }

}
