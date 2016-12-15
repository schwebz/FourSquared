/**
 * Created by Schwebs on 5/24/2015.
 */


public class Player {


    private Hand[] player = new Hand[5];
    private int[] check = new int[5];
    private boolean valid = true;

    public Player(){

    }

    public void reset(){
        for(int i = 0; i < 5; i++){
            player[i].clear();
        }
    }

    public boolean place(int hand, Card card){
        for(int i = 0; i < 5; i++){
            check[i] = player[i].getSize();
        }
        for(int i = 0; i < 5; i++){
            if(Math.abs(player[hand].getSize()-player[i].getSize()) > 1){
                valid = false;
                break;
            }
        }
        if(valid = false){
            valid = true;
            return false;
        }
        else {
            player[hand].add(card);
            return valid;
        }
    }

    public Card getCards(int hand, int card){
        return player[hand].getCard(card);
    }

    public void view(){
        for(int i = 0; i < 5; i++){
            player[i].showHand();
        }
    }


}
