import java.util.Scanner;

public class AIPlayerLast extends Player{
    AIPlayerLast(){
        super("AI Player Last");
    }

    public Card play(Eights eights, Card prev) {
        boolean bisaMain = this.posible(prev);
        while (!this.posible(prev)) {
            this.drawForMatch(eights, prev);
        }
        if(!bisaMain){
            System.out.println("Mengambil kartu lagi agar bisa main");
        }
        eights.displayState(this);
        Card objCard = getPlayCard(prev);
        for(int i=0; i<getHand().size(); i++){
            if(getHand().getCard(i).equals(objCard)){
                if(cardMatches(prev, objCard)){
                    return getHand().popCard(i);
                }
            }
        }
        return objCard;
    }

    public boolean posible(Card prev){
        for(int i=0; i<getHand().size(); i++){
            if(cardMatches(getHand().getCard(i), prev)){
                return true;
            }
        }
        return false;
    }

    public Card drawForMatch(Eights eights, Card prev) {
        while (true) {
            Card card = eights.drawCard();
            System.out.println(this.getName() + " draws " + card);
            getHand().addCard(card);
            if (cardMatches(prev, card)) {
                return card;
            }
        }
    }

    public Card getPlayCard(Card prev){
        Card lastCard = null;
        for (int i = 0; i < getHand().size(); i++) {
            Card card = getHand().getCard(i);
            if(cardMatches(prev, card)){
                lastCard = card;
            }
        }
        return lastCard;
    }
}
