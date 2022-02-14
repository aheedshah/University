import java.util.*;

public class Hand{
    private final ArrayList<Card> hand = new ArrayList<>();
    private final String[] ranks =
            {"Royal Flush", "Straight Flush", "4-of-a-kind",
                "Full House", "Flush", "Straight",
                "3-of-a-kind", "2 Pair", "1 Pair", "High Card"};

    public void addCard(Card c){
        if(hand.size() < 5){
            hand.add(c);
        }
    }

    public String getHandRank() {
        if (hand.size() != 5) {
            return "Incorrect hand size";
        }
        //sort the hand
        hand.sort(new SortCards());

        int numberOfSameSuits = 0;
        //Checking how many same cards of the same suit we have.
        for (Card card : hand) {
            if (hand.get(0).getSuit().equals(card.getSuit())) {
                numberOfSameSuits++;
            }
        }
        if(numberOfSameSuits==5){
            //royal flush (J,Q,K,A,10 all of the same suit)
            //Number of checks: 2. 1. Check if they're all of the same suit and 2. Check if they are from 10-A
            ////If the card's numeric value + 4 is equal to 14, then it's a royal flush
            if(hand.get(0).getNumericValue()+4 == 14){
                return ranks[0];
                //straight flush (5 cards in a row all of the same suit e.g. 3S, 4S, 5S, 6S, 7S)
                //Number of checks: 2. 1. Check if they're all the same suit and in a row. e.g. 1,2,3,4
                //If the card's numeric value + 4 is equal to the last card, then it's a straight flush
            } else if(hand.get(0).getNumericValue()+4 == hand.get(4).getNumericValue()){
                return ranks[1];
                //flush (All cards are in the same suit e.g. 3H, 7H, 9H, JH, KH)
                //Number of checks: 1. 1 Check: Check if all of them are of the same suit
            } else{
                return ranks[4];
            }
        }

        //Adding values of cards into the arraylist below which is then put into a hashmap.
        List<String> list = new ArrayList<>();
        for (Card card : hand) {
            list.add(card.getValue());
        }
        Map<String, Integer> map = new HashMap<>();
        //Keeping count of how many times a number has been put into the hashmap
        for(String r: list){
            if(map.containsKey(r)) {
                map.put(r, map.get(r) + 1);
            } else {
                map.put(r, 1);
            }
        }

        //4 of a kind (4 cards with the same value e.g. 9S, 9C, 9H, 9D, 7D)
        //Number of checks: 1. Check if at least 4 of them are the same number.
        if (map.size() == 2) {
            if (String.valueOf(map.values()).charAt(1)=='4' || String.valueOf(map.values()).charAt(4)=='4') {
                return ranks[2];
                //full house (3 of a kind and a pair e.g. 7S, 7H, 7D, 4C, 4H)
                //Number of checks: 2. 1. Check if 3 of them are of the same number and the 2 remaining are also the same number
            } else if((String.valueOf(map.values()).charAt(1)=='3' && String.valueOf(map.values()).charAt(4)=='2') ||
                    (String.valueOf(map.values()).charAt(1)=='2' && String.valueOf(map.values()).charAt(4)=='3')){
                return ranks[3];
            }
        }

        //one pair ( a pair of cards with the same value e.g. 7D, 7H, 4S, 6H, 8H)
        //Number of checks: 1. Check if one pair of cards have the same value
        if(map.size()==4){
            return ranks[8];
        }

        //straight (A run of values in different suits e.g. 3H, 4D, 5H, 6C, 7S)
        //Number of checks: 1. Check if all their values are +1 than the one before
        if(hand.get(0).getNumericValue()+4==hand.get(4).getNumericValue()){
            return ranks[5];
        }

        //3 of a kind (3 cards with the same value and two others e.g. 7D, 7H, 7C, 2H, KS)
        //Number of checks: 1. Check if 3 cards have the same values
        if(map.size()==3) {
            if((String.valueOf(map.values()).charAt(1)=='3' ||
                    String.valueOf(map.values()).charAt(4)=='3') ||
                    String.valueOf(map.values()).charAt(7)=='3') {
                return ranks[6];
                //two pair (2 pairs of matched values e.g. 7D, 7H, 4S, 4C, 2D)
                //Number of checks: 1. Check if two pairs have the same value
            } else if((String.valueOf(map.values()).charAt(1)=='2' ||
                    String.valueOf(map.values()).charAt(4)=='2') ||
                    String.valueOf(map.values()).charAt(7)=='2') {
                return ranks[7];
            }
        }
        //high card (None of the other hands match, the highest value of the card)
        //Number of checks: None. If it's neither of the top cards, return high card.\
        return ranks[9];
    }

    //ToString method
    public String toString() {
        StringBuilder output = new StringBuilder();
        for(Card c: hand){
            if(c.getSuit().equals("Hearts") || c.getSuit().equals("Diamonds")) {
                output.append("\u001B[31m[ ").append(c.getValue()).append(" , ").append(c.getSuit()).append(" ] \u001B[0m");
            }
            else {
                output.append("[ ").append(c.getValue()).append(" , ").append(c.getSuit()).append(" ] ");
            }
        }
        return output.toString();
    }
}