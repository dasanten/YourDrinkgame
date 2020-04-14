package de.dasanten.yourdrinkgame.localDataBase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

import de.dasanten.yourdrinkgame.localDataBase.entitys.CardSetEntity;

public class CardSetViewModel extends AndroidViewModel {

    private CardSetRepository cardSetRepository;
    private LiveData<List<CardSetEntity>> allCardSets;

    public CardSetViewModel(@NonNull Application application) {
        super(application);
        this.cardSetRepository = new CardSetRepository(application);
        allCardSets = cardSetRepository.getSavedCardSets();
    }

    public void insertCardSet(CardSetEntity cardSetEntity){
        cardSetRepository.insetCardSet(cardSetEntity);
    }

    public void updateCardSet(CardSetEntity cardSetEntity) {
        cardSetRepository.updateCardSet(cardSetEntity);
    }

    public void deleteCardSet(CardSetEntity cardSetEntity) {
        cardSetRepository.deleteCardSet(cardSetEntity);
    }

    public LiveData<List<CardSetEntity>> getAllCardSets(){
        return allCardSets;
    }
}
