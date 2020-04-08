package de.dasanten.yourdrinkgame.localDataBase;

import android.app.Application;

import java.util.ArrayList;

import de.dasanten.yourdrinkgame.localDataBase.entitys.CardSetEntity;

public class CardSetRepository {

    CardSetDao cardSetDao;
    CardDao cardDao;

    CardSetRepository(Application application) {
        CardSetDataBase dataBase = CardSetDataBase.getDatabase(application);
        cardSetDao = dataBase.getCardSetDao();
        cardDao = dataBase.getCardDao();
    }

    public void setCardSet (CardSetEntity cardSetEntity){
        cardSetDao.insertCardSet(cardSetEntity);
    }

    public ArrayList<CardSetEntity> getSavedCardSets(){
        return cardSetDao.getSavedCardSets();
    }
}
