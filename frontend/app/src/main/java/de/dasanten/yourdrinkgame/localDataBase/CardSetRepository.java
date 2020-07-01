package de.dasanten.yourdrinkgame.localDataBase;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

import de.dasanten.yourdrinkgame.localDataBase.entitys.CardEntity;
import de.dasanten.yourdrinkgame.localDataBase.entitys.CardSetEntity;

public class CardSetRepository {

    private CardSetDao cardSetDao;
    private CardDao cardDao;

    public CardSetRepository(Application application) {
        CardSetDataBase dataBase = CardSetDataBase.getDatabase(application);
        cardSetDao = dataBase.getCardSetDao();
        cardDao = dataBase.getCardDao();
    }

    //Card Set Database functions
    public void insetCardSet (CardSetEntity cardSetEntity){
        new InsertCardSetAsnycTask(cardSetDao).execute(cardSetEntity);
    }

    public void updateCardSet (CardSetEntity cardSetEntity){
        new UpdateCardSetAsnycTask(cardSetDao).execute(cardSetEntity);
    }

    public void deleteCardSet (CardSetEntity cardSetEntity) {
        new DeleteCardSetAsnycTask(cardSetDao).execute(cardSetEntity);
    }

    public LiveData<List<CardSetEntity>> getSavedCardSets(){
        return cardSetDao.getSavedCardSets();
    }

    // Card Database functions
    public void insertCards (CardEntity cardEntity){
        new InsertCardAsnycTask(cardDao).execute(cardEntity);
    }

    public void updateCard (CardEntity cardEntity){
        new UpdateCardAsnycTask(cardDao).execute(cardEntity);
    }

    public void deleteCard (CardEntity cardEntity){
        new DeleteCardAsnycTask(cardDao).execute(cardEntity);
    }

    public LiveData<List<CardEntity>> getCardsOfCardSet(int cardSetId){
        return cardDao.getCardList(cardSetId) ;
    }



    private static class InsertCardAsnycTask extends AsyncTask<CardEntity, Void, Void> {
        private CardDao cardDao;

        private  InsertCardAsnycTask(CardDao cardDao){
            this.cardDao = cardDao;
        }


        @Override
        protected Void doInBackground(CardEntity... cardEntities) {
            cardDao.insertCards(cardEntities[0]);
            return null;
        }
    }

    private static class UpdateCardAsnycTask extends AsyncTask<CardEntity, Void, Void> {
        private CardDao cardDao;

        private  UpdateCardAsnycTask(CardDao cardDao){
            this.cardDao = cardDao;
        }

        @Override
        protected Void doInBackground(CardEntity... cardEntities) {
            cardDao.updateCard(cardEntities[0]);
            return null;
        }
    }

    private static class DeleteCardAsnycTask extends AsyncTask<CardEntity, Void, Void> {
        private CardDao cardDao;

        private  DeleteCardAsnycTask(CardDao cardDao){
            this.cardDao = cardDao;
        }

        @Override
        protected Void doInBackground(CardEntity... cardEntities) {
            cardDao.deleteCard(cardEntities[0]);
            return null;
        }
    }


    private static class InsertCardSetAsnycTask extends AsyncTask<CardSetEntity, Void, Void> {
        private CardSetDao cardSetDao;

        private  InsertCardSetAsnycTask(CardSetDao cardSetDao){
            this.cardSetDao = cardSetDao;
        }

        @Override
        protected Void doInBackground(CardSetEntity... cardSetEntities) {
            cardSetDao.insertCardSet(cardSetEntities[0]);
            return null;
        }
    }

    private static class UpdateCardSetAsnycTask extends AsyncTask<CardSetEntity, Void, Void> {
        private CardSetDao cardSetDao;

        private  UpdateCardSetAsnycTask(CardSetDao cardSetDao){
            this.cardSetDao = cardSetDao;
        }

        @Override
        protected Void doInBackground(CardSetEntity... cardSetEntities) {
            cardSetDao.updateCardSet(cardSetEntities[0]);
            return null;
        }
    }

    private static class DeleteCardSetAsnycTask extends AsyncTask<CardSetEntity, Void, Void> {
        private CardSetDao cardSetDao;

        private  DeleteCardSetAsnycTask(CardSetDao cardSetDao){
            this.cardSetDao = cardSetDao;
        }

        @Override
        protected Void doInBackground(CardSetEntity... cardSetEntities) {
            cardSetDao.deleteCardSet(cardSetEntities[0]);
            return null;
        }
    }



}
