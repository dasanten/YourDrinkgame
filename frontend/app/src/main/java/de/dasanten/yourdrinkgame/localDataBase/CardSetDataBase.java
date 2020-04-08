package de.dasanten.yourdrinkgame.localDataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import de.dasanten.yourdrinkgame.localDataBase.entitys.CardEntity;
import de.dasanten.yourdrinkgame.localDataBase.entitys.CardSetEntity;

@Database(entities = {CardSetEntity.class, CardEntity.class}, version = 1, exportSchema = false)
public abstract class CardSetDataBase extends RoomDatabase {

    abstract public CardSetDao getCardSetDao();
    abstract public CardDao getCardDao();
    private static volatile CardSetDataBase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(1);

    static CardSetDataBase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (CardSetDataBase.class){
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CardSetDataBase.class, "cardset_database")
                            .build();
                }
            }
        }
    return INSTANCE;
    }
}
