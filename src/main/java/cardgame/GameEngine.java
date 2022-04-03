package cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameEngine {

    


    public static void main(String args[]){
        Game game = new Game();
        GameEngine gameEngine = new GameEngine();

        List<Card> Deck= new ArrayList<>(); 
        Deck= Card.getDeck();
        Collections.shuffle(Deck);
        Strategy player1 = new Strategy(); 
        Strategy player2 = new Strategy(); 
        Strategy player3 = new Strategy(); 
        Strategy player4 = new Strategy(); 
        game.start(player1,player2,player3,player4);
        
    }
}