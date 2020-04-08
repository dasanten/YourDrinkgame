package de.dasanten.yourdrinkgame.localDataBase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.ArrayList;

import de.dasanten.yourdrinkgame.localDataBase.entitys.CardSetEntity;

public class CardSetViewModel extends AndroidViewModel {

    private CardSetRepository cardSetRepository;

    public CardSetViewModel(@NonNull Application application) {
        super(application);
        this.cardSetRepository = new CardSetRepository(application);
    }

    public void insertCardSet(CardSetEntity cardSetEntity){
        cardSetRepository.setCardSet(cardSetEntity);
    }

    //TODO LocalDatabase einbinden

    public ArrayList<CardSetEntity> getSavedCardSets(){
        return cardSetRepository.getSavedCardSets();
    }
}
