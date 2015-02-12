import java.util.*;

public class Freq {
    public static void main(String args[]) {
        Map<String, Integer> m = new HashMap<String, Integer>();
        for(String s: args) {
            Integer frequency = m.get(s);
            if(frequency == null) {
                frequency = 1;
            }
            else {
                frequency++;
            }
            m.put(s, frequency);
        }
        
        System.out.println(m.size() + " distinct words");
        System.out.println(m);
    }
}