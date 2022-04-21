package cardgame;
import java.util.*;
public class Strategy extends PlayerTurn implements PlayerStrategy{

    /**
     * Declare the List and variables 
     * handcards  --- The cards which the players have
     * removecard --- The card which the player wants to remove if the card matches the value or suit 
     */
    List<Card> handcards=new ArrayList<>();
    int removecard;

    /** 
      * This method will be called by the game engine once at the very beginning (before any games
      * are started), to allow the player to set up any initial state.
      *
      * @param playerId    The id for this player, assigned by the game engine
      * @param opponentIds A list of ids for this player's opponents
      */
    @Override
    public void init(int playerId, List<Integer> opponentIds){
       this.playerId=playerId;
       this.opponentIds=opponentIds;
    }

    /**
     * It will receive cards from all the players
     * @param cards  It will store the cards assigned by the gameengine
     */

    @Override
    public void receiveInitialCards(List<Card> cards){
          handcards=cards;
    }

    /**
     * This method will checks if the player wants to draw card or not
     * if the value or suit of the card matches then it returns false , otherwise returns true
     * @param topPileCard    It store the top of the card
     * @param changedSuit    If the value is not 8 it store the null value
     */

    @Override
    public boolean shouldDrawCard(Card topPileCard, Card.Suit changedSuit){

        if(changedSuit == null){
            for(Card obj : handcards){
                if(obj.getsuit()==topPileCard.getSuit() || obj.getRank() == topPileCard.getRank()){
                    removecard = obj;
                    return false;
                }
            }
        }
        else{
            for(Card obj : handcards){
                if(changedSuit == obj.getSuit()){
                    return false;
                }
            }
        }
        

    }

    /**
     * It will receive the card if the value or suit does not match
     * It adds into handcards
     * @param drawnCard    The card which we take from the deck 
     */

    @Override
    public void receiveCard(Card drawnCard){
        handcards.add(drawnCard);
    }

    /**
     * If the card matches the value or suit then it calls playCard
     * It remove the card from the handcards
     * It returns the card which we remove from the handcards
     */

    @Override
    public Card playCard(){
        handcards.remove(removecard);
        return removecard;
    }
    

    /**
     * If the card is 8 then ask the player what suit they would like to declare.
     * It returns the random Suit value of the card 
     */

    @Override
    public Card.Suit declareSuit(){

        for(Card obj : handcards){
            if(obj.getRank() == 8){
                // Random random = new Random();
                int max = Card.Suit.values().length - 1;
                int randomSuit = random.nextInt(max);
                return Card.Suit.values()[randomSuit];
            }
        }

    }

    /**
     * It reset the game 
     */

    @Override
    public void reset(){
        handcards = null;
        removecards = null;
    }

}
