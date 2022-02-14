/**
 * This class is the main class of the cards
 * and brings all other classes together.*/
public class CardMain {
    public static void main(String[] args) {
        //Shuffles the deck
        Deck d = new Deck(true);

        /*FULLY SHUFFLED HAND!*/
//        Deals a new hand from the shuffled deck
        Hand h = new Hand();
        for(int i = 0; i<5; i++) {
            h.addCard(d.deal());
        }
        System.out.println(h);
        System.out.println(h.getHandRank());


        //JUST UNCOMMENT THE CODE BELOW FOR DIFFERENT HANDS
        /*1. Hand for a royal flush*/
//        Hand h = new Hand();
//        h.addCard(d.dealSpecificCard("10", "Hearts"));
//        h.addCard(d.dealSpecificCard("J", "Hearts"));
//        h.addCard(d.dealSpecificCard("A", "Hearts"));
//        h.addCard(d.dealSpecificCard("K", "Hearts"));
//        h.addCard(d.dealSpecificCard("Q", "Hearts"));
//        System.out.println("Should Return Royal Flush. Returns: " + h.getHandRank());

        /*2. Hand for a Straight Flush*/
//        Hand h = new Hand();
//        h.addCard(d.dealSpecificCard("6", "Hearts"));
//        h.addCard(d.dealSpecificCard("7", "Hearts"));
//        h.addCard(d.dealSpecificCard("8", "Hearts"));
//        h.addCard(d.dealSpecificCard("9", "Hearts"));
//        h.addCard(d.dealSpecificCard("10", "Hearts"));
//        System.out.println("Should Return Straight Flush. Returns: " + h.getHandRank());

        /*3. Hand for four of a kind*/
//        Hand h = new Hand();
//        h.addCard(d.dealSpecificCard("7", "Hearts"));
//        h.addCard(d.dealSpecificCard("7", "Diamonds"));
//        h.addCard(d.dealSpecificCard("7", "Clubs"));
//        h.addCard(d.dealSpecificCard("7", "Spades"));
//        h.addCard(d.dealSpecificCard("9", "Hearts"));
//        System.out.println("Should Return Four of a kind. Returns: " + h.getHandRank());

        /*4. Hand for Full House*/
//        Hand h = new Hand();
//        h.addCard(d.dealSpecificCard("2", "Diamonds"));
//        h.addCard(d.dealSpecificCard("2", "Spades"));
//        h.addCard(d.dealSpecificCard("2", "Hearts"));
//        h.addCard(d.dealSpecificCard("8", "Clubs"));
//        h.addCard(d.dealSpecificCard("8", "Hearts"));
//        System.out.println("Should Return Full House. Returns: " + h.getHandRank());

        /*5. Hand for Flush*/
//        Hand h = new Hand();
//        h.addCard(d.dealSpecificCard("3", "Hearts"));
//        h.addCard(d.dealSpecificCard("7", "Hearts"));
//        h.addCard(d.dealSpecificCard("9", "Hearts"));
//        h.addCard(d.dealSpecificCard("J", "Hearts"));
//        h.addCard(d.dealSpecificCard("K", "Hearts"));
//        System.out.println("Should Return Flush. Returns: " + h.getHandRank());

        /*6. Hand for Straight*/
//        Hand h = new Hand();
//        h.addCard(d.dealSpecificCard("6", "Hearts"));
//        h.addCard(d.dealSpecificCard("7", "Clubs"));
//        h.addCard(d.dealSpecificCard("8", "Hearts"));
//        h.addCard(d.dealSpecificCard("9", "Diamonds"));
//        h.addCard(d.dealSpecificCard("10", "Spades"));
//        System.out.println(h);
//        System.out.println("Should Return Straight. Returns: " + h.getHandRank());

        /*7. Hand for Three of a Kind*/
//        Hand h = new Hand();
//        h.addCard(d.dealSpecificCard("2", "Diamonds"));
//        h.addCard(d.dealSpecificCard("2", "Spades"));
//        h.addCard(d.dealSpecificCard("2", "Hearts"));
//        h.addCard(d.dealSpecificCard("K", "Clubs"));
//        h.addCard(d.dealSpecificCard("8", "Hearts"));
//        System.out.println(h);
//        System.out.println("Should Return three of a kind. Returns: " + h.getHandRank());

        /*8. Hand for Two Pair*/
//        Hand h = new Hand();
//        h.addCard(d.dealSpecificCard("10", "Diamonds"));
//        h.addCard(d.dealSpecificCard("10", "Spades"));
//        h.addCard(d.dealSpecificCard("5", "Hearts"));
//        h.addCard(d.dealSpecificCard("5", "Clubs"));
//        h.addCard(d.dealSpecificCard("3", "Hearts"));
//        System.out.println(h);
//        System.out.println("Should Return Two Pair. Returns: " + h.getHandRank());

        /*9. Hand for One Pair*/
//        Hand h = new Hand();
//        h.addCard(d.dealSpecificCard("7", "Diamonds"));
//        h.addCard(d.dealSpecificCard("7", "Spades"));
//        h.addCard(d.dealSpecificCard("5", "Hearts"));
//        h.addCard(d.dealSpecificCard("6", "Clubs"));
//        h.addCard(d.dealSpecificCard("3", "Diamonds"));
//        System.out.println(h);
//        System.out.println("Should Return One Pair. Returns: " + h.getHandRank());

        /*10. Hand for High Card*/
//        Hand h = new Hand();
//        h.addCard(d.dealSpecificCard("7", "Diamonds"));
//        h.addCard(d.dealSpecificCard("8", "Spades"));
//        h.addCard(d.dealSpecificCard("5", "Hearts"));
//        h.addCard(d.dealSpecificCard("J", "Clubs"));
//        h.addCard(d.dealSpecificCard("K", "Hearts"));
//        System.out.println(h);
//        System.out.println("Should Return High Card. Returns: " + h.getHandRank());
    }
}
