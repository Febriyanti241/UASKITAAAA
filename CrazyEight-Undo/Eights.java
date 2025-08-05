import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


/**
 * Simulates a game of Crazy Eights.
 * See https://en.wikipedia.org/wiki/Crazy_Eights.
 */

public class Eights {

        private int banyakPermainan;
        private List <Player> listPemain;
        private Hand drawPile;
        private Hand discardPile;
        private Scanner in;
    
        /**
         * Initializes the state of the game.
         */
        public Eights() {
            this.in = new Scanner(System.in);
        }

        public void initGame(){
            Deck deck = new Deck("Deck");
            deck.shuffle();

            for(Player pemain: listPemain){
                pemain.newHand();
                deck.deal(pemain.getHand(), 5);
            }
    
            // turn one card face up
            discardPile = new Hand("Discards");
            deck.deal(discardPile, 1);
    
            // put the rest of the deck face down
            drawPile = new Hand("Draw pile");
            deck.dealAll(drawPile);
        }
    
        /**
         * Returns true if either hand is empty.
         */
        public boolean isDone() {
            for(Player pemain: listPemain){
                if(pemain.getHand().isEmpty()) return true;
            }
            return false;
        }
        /**
         * Moves cards from the discard pile to the draw pile and shuffles.
         */
        public void reshuffle() {
            // save the top card
            Card prev = discardPile.popCard();
    
            // move the rest of the cards
            discardPile.dealAll(drawPile);
    
            // put the top card back
            discardPile.addCard(prev);
    
            // shuffle the draw pile
            drawPile.shuffle();
        }
    
        /**
         * Returns a card from the draw pile.
         */
        public Card drawCard() {
            if (drawPile.isEmpty()) {
                reshuffle();
            }
            return drawPile.popCard();
        }
    
        /**
         * Switches players.
         */
        public Player nextPlayer(Player current) {
            int pointer =0;
            for(int i=0; i<listPemain.size(); i++){
                if(listPemain.get(i).equals(current)){
                    pointer = i+1;
                }
            }
            if(pointer == listPemain.size()){
                return listPemain.get(0);
            }
            return listPemain.get(pointer);
        }
    
        /**
         * Displays the state of the game.
         */
        public void displayState(Player current) {
            current.display();
            discardPile.display();
            System.out.println("Draw pile: " + drawPile.size() + " cards");
        }

        public Card undo(HumanPlayer undoers){
            if(undoers.undoUsed == true){
                return null;
            }
            Card lastPlayed = discardPile.popCard(discardPile.size()-1);
            undoers.getHand().addCard(lastPlayed);
            undoers.undoUsed = true;
            return  lastPlayed;
        }

        public HumanPlayer prevPlayer(Player current){
            int pointer = 0;
            for(Player p : listPemain){
                if(p.equals(current)){
                    if(pointer==0){
                        pointer = listPemain.size();
                    }
                    while(true){
                        if(!(listPemain.get(pointer-1) instanceof HumanPlayer)){
                            pointer--;
                            if(pointer==0){
                                pointer = listPemain.size()-1;
                            }
                        }else{
                            return (HumanPlayer) listPemain.get(pointer-1);
                        }
                    }

                }
                pointer++;
            }
            return null;
        }
    
        /**
         * One player takes a turn.
         */
        public boolean takeTurn(Player player) {
            Card prev = discardPile.lastCard();
            Card next = null;
            if(player instanceof HumanPlayer){
                next = ((HumanPlayer) player).play(this, prev, in);
                if(next == null){
                    System.out.println("MELAKUKAN UNDO!");
                    Player undoers = prevPlayer(player);
                    Card dibalikin = undo((HumanPlayer) undoers);
                    if(dibalikin == null){
                        System.out.println("Undo sudah dipakai");
                        return true;
                    }
                    System.out.println("Berhasil mengambil kembali kartu "+dibalikin.toString());
                    return false;
                } else{
                    System.out.println(player.getName() + " plays " + next);
                    System.out.println();
                }

            } else if(player instanceof AIPayerAdvance){
                next = ((AIPayerAdvance) player).play(this, prev);
                System.out.println(player.getName() + " plays " + next);
                System.out.println();
                in.nextLine();
            } else if(player instanceof AIPlayerLast){
                next = ((AIPlayerLast) player).play(this, prev);
                System.out.println(player.getName() + " plays " + next);
                System.out.println();
                in.nextLine();
            }
            
            discardPile.addCard(next);
            return true;
        }
    
        /**
         * Plays the game.
         */
        public Player playGame() {
            while(banyakPermainan!=0){
                initGame();
                Player player = listPemain.get(0);
                // keep playing until there's a winner
                while (!isDone()) {
                    displayState(player);
                    boolean normal = takeTurn(player);
                    if(normal==false){
                        player = prevPlayer(player);
                    }else{
                        player = nextPlayer(player);
                    }

                }
                for(Player pemain: listPemain){
                    pemain.setScore();
                }
                banyakPermainan-=1;
            }
            Player winner = null;
            for(Player pemain: listPemain){
                pemain.displayScore();
                if(winner == null){
                    winner=pemain;
                }else if(pemain.getScore() > winner.getScore()){
                    winner = pemain;
                }
            }
            return winner;
        }

        public void setBanyakPermainan(int banyakPermainan){
            this.banyakPermainan = banyakPermainan;
        }

        public void setPlayer(List <Player> listPemain){
            this.listPemain = listPemain;
        }
    
        /**
         * Creates the game and runs it.
         * @throws IOException 
         */
        public static void main(String[] args) throws IOException {
            File highScore = new File("highscores-eight.txt");
            Map<String, String> readFile = new HashMap<>();

            try(BufferedReader reader = new BufferedReader(new FileReader(highScore))){
                String line;
                while ( (line = reader.readLine()) != null) {
                    String[] arr = line.split(" ");
                    if(arr.length == 2){
                        readFile.put(arr[0], arr[1]);
                        int angka = Integer.parseInt(arr[1]);
                    }else{
                        throw new ExceptionFormatTidakSesuai("Satu baris lebih dari 2 nilai");
                    }
                }
            }
            catch(ExceptionFormatTidakSesuai ex){
                throw new ExceptionFormatTidakSesuai("Format penulisan tidak sesuai");
            }
            catch(NumberFormatException ex){
                throw new ExceptionFormatTidakSesuai("Ada score yang bukan angka");
            }
            catch (FileNotFoundException ex) {
                System.out.println("Exception: File not found");
            }

            Eights game = new Eights();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Berapa kali ingin bermain? ");
            int input = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Berapa orang yang ingin bermain? ");
            int banyakPemain = scanner.nextInt();
            scanner.nextLine();

            ArrayList <Player> playerPilihan = new ArrayList<>();
            for(int i=0; i<banyakPemain; i++){
                System.out.println("Pilih tipe Player "+ i+1 + " (1. Manusia 2. AI)");
                int tipePlayer = scanner.nextInt();
                scanner.nextLine();

                if(tipePlayer==1){
                    System.out.println("Masukkan nama player: ");
                    String namaHuman = scanner.nextLine();
                    playerPilihan.add(new HumanPlayer(namaHuman));
                }
                else if(tipePlayer==2){
                    System.out.println("Masukkan tipe AI (1. Tipe last 2. Tipe Advanced) ");
                    int tipeAI = scanner.nextInt();
                    scanner.nextLine();

                    if(tipeAI==1){
                        playerPilihan.add(new AIPlayerLast());
                    }else if(tipeAI==2){
                        playerPilihan.add(new AIPayerAdvance());
                    }
                }
            }
            game.setPlayer(playerPilihan);

            game.setBanyakPermainan(input);
            Player winner = game.playGame();

            

            try(BufferedWriter writer = new BufferedWriter(new FileWriter(highScore))){
                boolean finded = false;
                for(Map.Entry<String, String> entry : readFile.entrySet()){
                    if(entry.getKey().equalsIgnoreCase(winner.getName())){
                        finded = true;
                        int score = Integer.parseInt(entry.getValue());
                        score+=1;
                        String scoreStr = String.valueOf(score);
                        readFile.put(entry.getKey(), scoreStr);
                    }
                    writer.write(entry.getKey()+" "+entry.getValue());
                    writer.newLine();
                }
                if(!finded){
                    writer.write(winner.getName() +" 1");                    
                }
            }
            catch (FileNotFoundException ex) {
                System.out.println("Exception: File not found");
            }
        }
}