package de.dasanten.yourdrinkgame.localDataBase;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;


import de.dasanten.yourdrinkgame.localDataBase.entitys.CardEntity;
import de.dasanten.yourdrinkgame.localDataBase.entitys.CardSetEntity;

@Database(entities = {CardSetEntity.class}, version = 1, exportSchema = false)
public abstract class CardSetDataBase extends RoomDatabase {

    private static CardSetDataBase INSTANCE;

    public abstract CardSetDao getCardSetDao();
//    public abstract CardDao getCardDao();


    static synchronized CardSetDataBase getDatabase(Context context){
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    CardSetDataBase.class, "cardset_database")
//                    .fallbackToDestructiveMigration()
//                    .addCallback(roomCallback)
                    .build();
        }
    return INSTANCE;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDBAsyncTask(INSTANCE).execute();
        }
    };
    private static class PopulateDBAsyncTask extends AsyncTask<Void, Void, Void>{
        private CardSetDao cardSetDao;

        private PopulateDBAsyncTask(CardSetDataBase dataBase){
            cardSetDao = dataBase.getCardSetDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            CardSetEntity one = new CardSetEntity("test", "as", 1, "as", "as", false, true,true);
            CardSetEntity two = new CardSetEntity("test auch", "as", 1, "as", "as", false, true,true);
            cardSetDao.insertCardSet(one);
            cardSetDao.insertCardSet(two);
            return null;
        }
    }
}
