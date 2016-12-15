/**
 * Created by Schwebs on 4/27/2015.
 */
public class Card {
    private String name;
    private int value;
    private String suit;
    private int aceAlt = 0;
    private int serial;

    public Card(String name, String suit, int value, int serial) {
        this.name = name;
        this.value = value;
        this.suit = suit;
        this.serial = serial;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public String getName() {
        return (name);
    }

    public String getSuit() {
        return (suit);
    }

    public int getValue() {
        return value;
    }

    public String getInfo() {
        return ("" + name + " of " + suit + "s");
    }

    public int getSerial() {
        return serial;
    }

    public int getAceAlt() {
        return aceAlt;
    }

    public void setAceAlt(int val) {
        aceAlt = val;
    }
}
