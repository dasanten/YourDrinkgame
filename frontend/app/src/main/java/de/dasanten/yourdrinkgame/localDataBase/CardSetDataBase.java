package de.dasanten.yourdrinkgame.localDataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;



import de.dasanten.yourdrinkgame.localDataBase.entitys.CardEntity;
import de.dasanten.yourdrinkgame.localDataBase.entitys.CardSetEntity;

@Database(entities = {CardSetEntity.class, CardEntity.class}, version = 1, exportSchema = false)
public abstract class CardSetDataBase extends RoomDatabase {

    private static CardSetDataBase INSTANCE;

    public abstract CardSetDao getCardSetDao();
    public abstract CardDao getCardDao();


    static synchronized CardSetDataBase getDatabase(Context context){
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    CardSetDataBase.class, "cardset_database")
                    .build();
        }
    return INSTANCE;
    }
}
