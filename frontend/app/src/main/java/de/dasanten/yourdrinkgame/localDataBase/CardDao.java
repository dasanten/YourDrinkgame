package de.dasanten.yourdrinkgame.localDataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import de.dasanten.yourdrinkgame.localDataBase.entitys.CardEntity;
import de.dasanten.yourdrinkgame.localDataBase.entitys.CardSetEntity;

@Dao
public interface CardDao {
    @Query("Select * from card where cardSetEntity = :cardSetEntity")
    List<CardEntity> getCardList(CardSetEntity cardSetEntity);

    @Query("Select * from card where cardId = :cardId")
    CardEntity getCardById(String cardId);

    @Insert
    void insertCards(List<CardEntity> cardEntity);

    @Update
    void updateCard(CardEntity cardEntity);

    @Delete
    void deleteCard(CardEntity cardEntity);
}
