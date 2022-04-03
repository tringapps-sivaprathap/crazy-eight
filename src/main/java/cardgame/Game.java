package cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cardgame.Card.Rank;
import cardgame.Card.Suit;

public class Game extends Strategy{

    List<Card> Deck= new ArrayList<>(); 
    List<Card> drawpile=new ArrayList<>();
    List<Card> discardpile=new ArrayList<>();
 //   Deck = Card.getDeck();
    List<Card> player1card = new ArrayList<>();
    List<Card> player2card = new ArrayList<>();
    List<Card> player3card = new ArrayList<>();
    List<Card> player4card = new ArrayList<>();

   /* public List<Card> getCard(){
        Collections.shuffle(Deck);
        List<Card> tempcard = new ArrayList<>(); 
        for(int i = 0; i < 5 ; i++)
        {
            tempcard.add(Deck.get(i));
            Deck.remove(i);
        }

        return tempcard;

    }*/




    /**
     * Assign 5 cards to each player
     */
    public void getCard(){

        Deck = Card.getDeck();
        for(int i=0;i<=16;i+=4){
            player1card.add(Deck.get(i));
            Deck.remove(i);       
            player2card.add(Deck.get(i+1));
            Deck.remove(i+1);
            player3card.add(Deck.get(i+2));
            Deck.remove(i+2);
            player4card.add(Deck.get(i+3));
            Deck.remove(i+3);
        }


        //drawpile = 32 (remaining cards from the deck)
        drawpile=Deck;
        System.out.println("deck " + Deck.size());
        for(int i = 0 ; i < player1card.size(); i++){
            System.out.println(player1card.get(i).getSuit() + " " + player1card.get(i).getRank());
        }
        System.out.println("---------------------");
        for(int i = 0 ; i < player2card.size(); i++){
            System.out.println(player2card.get(i).getSuit() + " " + player2card.get(i).getRank());
        }
        System.out.println("---------------------");
        for(int i = 0 ; i < player3card.size(); i++){
            System.out.println(player3card.get(i).getSuit() + " " + player3card.get(i).getRank());
        }
        System.out.println("---------------------");
        for(int i = 0 ; i < player4card.size(); i++){
            System.out.println(player4card.get(i).getSuit() + " " + player4card.get(i).getRank());
        }
        
    }
    
    public void start(Strategy player1, Strategy player2,Strategy player3,Strategy player4) {
       // player1card=getCard();
      //  player2card=getCard();
      //  player3card=getCard();
       // player4card=getCard();
        getCard();
        player1.receiveInitialCards(player1card);
        player2.receiveInitialCards(player2card);
        player3.receiveInitialCards(player3card);
        player4.receiveInitialCards(player4card);
        
        Card topcard;

        do{
            Collections.shuffle(drawpile);
            topcard = drawpile.get(0);
        }while(topcard == );
        
        drawpile.remove(0);
        System.out.println("top card " + topcard.getSuit() + " " + topcard.getRank());
        discardpile.add(topcard);


        
        Suit changedSuit = null;
        boolean drewAcard = player1.shouldDrawCard(topcard, changedSuit);
        System.out.println(drewAcard);

        
    }
}



























/*

   // List<Card> Deck=new ArrayList<>();
    List<Card> drawpile = new ArrayList<>(); 
    List<Card> player1card = new ArrayList<>();
    List<Card> player2card = new ArrayList<>();
    List<Card> player3card = new ArrayList<>();
    List<Card> player4card = new ArrayList<>();

    // List<ArrayList<Card>> playerscard = new ArrayList<>();
 
    List<Card> fn(){
    drawpile = Card.getDeck();
    Collections.shuffle(drawpile);
    player1card.add(drawpile.get(0));
    return player1card;
    }
}
  //  System.out.println(player1card);

    // void gamecall(){
    // for(int i=0;i<=16;i+=4){
    //     player1card.add(drawpile.get(i));
    //     drawpile.remove(i);       
    //     player2card.add(drawpile.get(i+1));
    //     drawpile.remove(i+1);
    //     player3card.add(drawpile.get(i+2));
    //     drawpile.remove(i+2);
    //     player4card.add(drawpile.get(i+3));
    //     drawpile.remove(i+3);
    // }
    // playerscards.add(player1card);
    // playerscards.add(player2card);
    // playerscards.add(player3card);
    // playerscards.add(player4card);

    // Card topcard = drawpile.remove(20);
    // Suit changesuit = null;
    // for(PlayerStrategy obj : playerscards){
    //     boolean drewcard = obj.shouldDrawCard(topcard,changesuit);

    //     if(drewcard){
    //         receiveCard(obj);
    //     }
    //     else
    //     {
    //         topcard = playCard(obj);
    //     }
    //     declareSuit();

    //     if(obj == null){
    //         System.out.println(obj + "wins");
    //     }
    //     else{


    //     }
    // }

    // }s
*/


    


    

