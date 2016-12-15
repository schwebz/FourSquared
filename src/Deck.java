/**
 * Created by Schwebs on 4/27/2015.
 */

import java.util.Random;

public class Deck {
    private Card[] deck = new Card[52];
    private int[] vals = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
    private String[] name = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    private String[] suit = {"Spade", "Club", "Heart", "Diamond"};

    public Deck() {
        initDeck();
    }

    public void initDeck() {
        for (int i = 0; i < 52; i++) {
            deck[i] = null;
        }
        for (int i = 0; i < vals.length; i++) {
            for (int k = 0; k < suit.length; k++) {
                add(new Card(name[i], suit[k], vals[i], ((i * suit.length) + k)));
            }
        }
        for (int l = 0; l < 51; l++) {
            if (deck[l].getName() == "Ace") {
                deck[l].setAceAlt(11);
            }
        }
    }

    public void add(Card toAdd) {
        int i = 0;
        while (deck[i] != null) {
            i++;
        }
        deck[i] = toAdd;
    }

    @Override
    public String toString() {
        int i = 0;
        String toReturn = new String("[");
        while (i < 51) {
            if (deck[i] != null) {
                toReturn = (toReturn + deck[i].getInfo() + ", ");
            }
            i++;
        }
        if (deck[51] != null) {
            toReturn = (toReturn + deck[51].getInfo() + "]");
        } else {
            int j = toReturn.length();
            if (j < 2) {
                return "[]";
            }
            toReturn = toReturn.substring(0, j - 2);
            toReturn = (toReturn + "]");
        }
        return toReturn;
    }

    public void displayDeck() {
        System.out.println(this.toString());
    }

    public void shuffle() {
        boolean check = true;
        Random random = new Random();
        int idx;
        int tag = -1;
        Card temp;
        while (check) {
            idx = random.nextInt(52);
            if (idx == 51) {
                tag = deck[0].getSerial();
                check = false;
            }
            temp = deck[0];
            for (int i = 0; i < idx; i++) {
                deck[i] = deck[i + 1];
            }
            deck[idx] = temp;
        }
        while (true) {
            idx = random.nextInt(52);
            if (deck[0].getSerial() == tag) {
                break;
            }
            temp = deck[0];
            for (int i = 0; i < idx; i++) {
                deck[i] = deck[i + 1];
            }
            deck[idx] = temp;
        }
    }

    public void altShuffle() {
        int k = 0;
        while (k < 51 && deck[k] != null) {
            k++;
        }
        int idx = -1;
        Random random = new Random();
        for (int i = (k - 1); i > 0; i--) {
            idx = random.nextInt(i);
            Card temp = deck[idx];
            deck[idx] = deck[i];
            deck[i] = temp;

        }
    }

    public int getFirstSerial() {
        return deck[0].getSerial();
    }

    public Card draw() {
        Card toReturn = null;
        int j = 0;
        while (deck[0] == null && j < 52) {
            int i = 0;
            while (i < 51) {
                deck[i] = deck[i + 1];
                i++;
            }
            j++;
            deck[51] = null;
        }
        toReturn = deck[0];
        int i = 0;
        while (i < 51) {
            deck[i] = deck[i + 1];
            i++;
        }
        deck[51] = null;
        return toReturn;
    }

    public static void main(String[] args) {
        Deck testDeck = new Deck();
        System.out.println(testDeck.deck[51].getSerial());
        testDeck.displayDeck();
        //testDeck.shuffle();
        testDeck.displayDeck();
        testDeck.altShuffle();
        testDeck.displayDeck();
        int[] testing = new int[52];
        /*for(int i =0; i < 100000; i++){
            //testDeck.initDeck();
            testDeck.shuffle();
            testing[testDeck.getFirstSerial()]++;
        }
        for(int i = 0; i < 52; i++) {
            System.out.println("Serial: " + i + " = " + testing[i] + " \n");
        }*/
        int[] testing2 = new int[52];
        /*for(int i =0; i < 100000; i++){
            //testDeck.initDeck();
            testDeck.altShuffle();
            testing2[testDeck.getFirstSerial()]++;
        }
        for(int i = 0; i < 52; i++) {
            System.out.println("Serial: " + i + " = " + testing2[i] + " \n");
        }*/
        testDeck.draw();
        testDeck.displayDeck();
        testDeck.draw();
        testDeck.displayDeck();
        System.out.println("DONE");
        testDeck.altShuffle();
        testDeck.displayDeck();
        for (int i = 0; i < 49; i++) {
            testDeck.altShuffle();
            testDeck.displayDeck();
            testDeck.draw();
        }
        testDeck.displayDeck();
        testDeck.draw();
        testDeck.displayDeck();
        testDeck.draw();
        testDeck.displayDeck();

    }
}
