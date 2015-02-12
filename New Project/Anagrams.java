import java.util.*;
import java.io.*;

public class Anagrams {
    
    public static void main(String args[]) {
        if(args.length < 2) {
            System.out.println("Usage: Anagrams <dictionary_file> <min_group_size>");
            return;
        }
        String dictionaryFileName = args[0];
        int minGroupSize = Integer.parseInt(args[1]);
        
        Map<String, List<String>> anagramMap = new HashMap<String, List<String>>();
        
        try {
            Scanner s = new Scanner(new File(dictionaryFileName));
            while(s.hasNext()) {
                String word = s.next();
                String sortedWord = sortWord(word);
                List<String> l = anagramMap.get(sortedWord);
                if(l == null) {
                    anagramMap.put(sortedWord, l = new ArrayList<String>());
                }
                l.add(word);
            }
        }
        catch(IOException e) {
            System.err.println(e);
            System.exit(1);
        }
        
        for(List<String> wordList: anagramMap.values()) {
            if(wordList.size() >= minGroupSize) {
                System.out.println(wordList.size() + " : " + wordList);
            }
        }
    }
    
    private static String sortWord(String word) {
        char[] a = word.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}