import java.util.Scanner;

public class HumanPlayer extends Player{
    public Card prevPlayed = null;
    public boolean undoUsed = false;

    HumanPlayer(String name){
        super(name);
    }

    public Card play(Eights eights, Card prev, Scanner in) {
        boolean bisaMain = posible(prev);
        System.out.println("\n\n\n"+bisaMain+"\n\n\n");
        if(!bisaMain){
            System.out.println("Mengambil kartu lagi agar bisa main");
        }
        while (!bisaMain) {
            drawForMatch(eights, prev);
            bisaMain = posible(prev);
        }
        
        eights.displayState(this);
        System.out.println("Tuliskan kartu yang ingin dimainkan ");
        String kartu = in.nextLine();

        if(kartu.equalsIgnoreCase("undo")){
            return null;
        }

        Card objCard = checkCard(kartu);
        while(objCard==null || !cardMatches(prev, objCard)){
            System.out.println("Kartu tidak ditemukan/tidak dapat dimainkan, silahkan pilih kartu lain!");
            System.out.println("Tuliskan kartu yang ingin dimainkan ");
            kartu = in.nextLine();
            objCard = checkCard(kartu);
        }
        for(int i=0; i<getHand().size(); i++){
            if(getHand().getCard(i).equals(objCard)){
                if(cardMatches(prev, objCard)){
                    return getHand().popCard(i);
                }
            }
        }
        prevPlayed = objCard;
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

    public Card checkCard(String kartu){
        for (int i = 0; i < getHand().size(); i++) {
            Card card = getHand().getCard(i);
            if(card.toString().equalsIgnoreCase(kartu)){
                return card;
            }
        }
        return null;
    }

}
