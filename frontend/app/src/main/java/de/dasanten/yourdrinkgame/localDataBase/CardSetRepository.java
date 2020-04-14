package de.dasanten.yourdrinkgame.localDataBase;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

import de.dasanten.yourdrinkgame.localDataBase.entitys.CardSetEntity;

public class CardSetRepository {

    private CardSetDao cardSetDao;
    private CardDao cardDao;

    public CardSetRepository(Application application) {
        CardSetDataBase dataBase = CardSetDataBase.getDatabase(application);
        cardSetDao = dataBase.getCardSetDao();
//        cardDao = dataBase.getCardDao();
    }

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
