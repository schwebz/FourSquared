/**
 * Created by Schwebs on 5/4/2015.
 */
public class Buffer {
    private Card card = null;

    public Buffer() {
    }

    public void add(Card toAdd) {
        card = toAdd;
    }

    public Card remove() {
        Card toReturn = card;
        card = null;
        return toReturn;
    }

    public String display() {
        if (card == null) {
            return "null";
        }
        return card.getInfo();
    }
}
