import java.util.*;

public class Deal {
    
    public static void main(String args[]) {
        if(args.length < 2) {
            System.out.println("Usage: Deal hands cards");
            return;
        }
        
        int numHands = Integer.parseInt(args[0]);
        int numCards = Integer.parseInt(args[1]);
        
        String[] suits = {"spades", "hearts", "diamonds", "clubs"};
        String[] rank = {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", 
                            "jack", "queen", "king"};
        
        // Prepare the deck.
        List<String> deck = new ArrayList<String>();
        for(int i = 0; i < suits.length; i++) {
            for(int j = 0; j < rank.length; j++) {
                deck.add(rank[j] + " of " + suits[i]);
            }
        }
        
        // Shuffle the deck.
        Collections.shuffle(deck);
        
        if(numCards * numHands > deck.size()) {
            System.out.println("Not enough cards!!");
            return;
        }
        
        // Distribute the cards.
        for(int i = 0; i < numHands; i++) {
            System.out.println(dealHand(deck, numCards));
        }
    }
    
    public static <E> List<E> dealHand(List<E> deck, int numCards) {
        int deckSize = deck.size();
        List<E> handView = deck.subList(deckSize - numCards, deckSize);
        List<E> hand = new ArrayList<E>(handView);
        handView.clear();
        return hand;
    }
}