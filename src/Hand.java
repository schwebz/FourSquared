/**
 * Created by Schwebs on 5/3/2015.
 */
public class Hand {

    private Card[] hand = new Card[5];

    public Hand() {
    }

    /*Make an exception for when hand is full for when trying to add cards to a hand*/
    public void add(Card toAdd) {
        int i = 0;
        while (this.hand[i] == null) {
            i++;
        }
        hand[i] = toAdd;
    }

    public void clear(){
        for(int i = 0; i < 5; i++){
            this.hand[i] = null;
        }
    }

    public int getSize(){
        int i = 0;
        while (this.hand[i] == null) {
            i++;
        }
        return i;
    }


    public Card getCard(int i) {
        return hand[i];
    }

    @Override
    public String toString() {
        int i = 0;
        String toReturn = new String("[");
        while (i < 4) {
            toReturn = (toReturn + hand[i].getInfo() + ", ");
            i++;
        }
        toReturn = (toReturn + hand[51].getInfo() + "]");
        return toReturn;
    }

    public void showHand() {
        System.out.println(this.toString());
    }

}
