package de.dasanten.yourdrinkgame.localDataBase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

import de.dasanten.yourdrinkgame.localDataBase.entitys.CardSetEntity;

@Dao
public interface CardSetDao {

    @Query("Select * from card_set")
    LiveData<List<CardSetEntity>> getSavedCardSets();

    @Query("Select * from card_set where name like :search")
    List<CardSetEntity> searchCardSetByName(String search);
    @Insert
    void insertCardSet(CardSetEntity cardSetEntity);

    @Update
    void updateCardSet(CardSetEntity cardSetEntity);

    @Delete
    void deleteCardSet(CardSetEntity cardSetEntity);
}
