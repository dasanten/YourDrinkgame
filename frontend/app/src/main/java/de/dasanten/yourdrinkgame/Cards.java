package de.dasanten.yourdrinkgame;

import java.util.ArrayList;

public class Cards {
    ArrayList<String> Cards = new ArrayList<>();

    public Cards(){
        Cards.add("Alle Männer trinken");
        Cards.add("# ext");
        Cards.add("# tauscht sein Oberteil mit #");
        Cards.add("Alle Saufen");
        Cards.add("# und # trineken");
        Cards.add("# + # + # +#");
    }

    public ArrayList<String> getCards(){
        return this.Cards;
    }

    public String getStringForCardDisplay(String card, ArrayList<String> player){
        String cardForDisplay = "";
        ArrayList<String> playerCopy = new ArrayList<>(player);
        card +=" ";         //if deleted bug if last char is "#"
        String[] splittedCard = card.split("#");
        if (playerCopy.size() >= (splittedCard.length-1)){
            for (int i = 0; i < (splittedCard.length); i++) {
                cardForDisplay += splittedCard[i];
                if (i != (splittedCard.length - 1)) {
                    int rdm = (int) (Math.random() * playerCopy.size());
                    cardForDisplay += " " + playerCopy.get(rdm) + " ";
                    playerCopy.remove(rdm);
                }
            }

            return cardForDisplay;
        }

        return null;
    }
}
