import java.util.Random;

public class DeckOfCards {
    public  static String[] suits = {"club","heart","spade","daimond"};
   public static String[] ranks = {"2","3","4","5","6","7","8","9","10","A","j","k","Q"};
   private static String[] cards = new String[52];
    public static String[] getCards(){
    int i = 0;
        for(String suit:suits)
        {
            for(String card:ranks)
            {
                cards[i] = card+""+suit;
                i++;
            }
        }
        return cards;
    }
    public void suffleCards(){
        Random random = new Random();
        for( int i=0;i<cards.length;i++){
            int index = random.nextInt(52);
            String temp = cards[index];
            cards[index]=cards[i];
            cards[i]=temp;
        }
    }
    public void display(String [][] cards){
        int i = 1;
        for(String[] player:cards){
            System.out.println(" player"+(i++));
            for(String card:player){
                System.out.print((card +""));
            }
            System.out.println();
        }

    }
    public String[][] distribute(int players,int card ){
        String playerCards[][] = new String[players][card];
        int k = 0;
        for(int i=0;i<players;i++){
            for( int j=0;j<card;j++){
                playerCards[i][j]=cards[k];
                k++;
            }
        }
        return playerCards;
    }
    public static void main(String[] args){
        DeckOfCards deckOfCards = new DeckOfCards();
        getCards();
        deckOfCards.suffleCards();
        String play[][] = deckOfCards.distribute(4,9);
        deckOfCards.display(play);
    }
}
