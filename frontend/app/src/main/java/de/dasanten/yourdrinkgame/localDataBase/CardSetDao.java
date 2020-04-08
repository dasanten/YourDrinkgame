package de.dasanten.yourdrinkgame.localDataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;

import de.dasanten.yourdrinkgame.localDataBase.entitys.CardSetEntity;

@Dao
public interface CardSetDao {

    @Query("Select * from cardSet")
    ArrayList<CardSetEntity>  getSavedCardSets();
    @Insert
    void insertCardSet(CardSetEntity cardSetEntity);
    @Update
    void updateCardSet(CardSetEntity cardSetEntity);
    @Delete
    void deleteCardSet(CardSetEntity cardSetEntity);
}
