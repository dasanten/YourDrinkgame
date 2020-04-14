package de.dasanten.yourdrinkgame.localDataBase.entitys;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "card")
public class CardEntity {
    @PrimaryKey
    private String cardId;
    private String content;
    private String type;
    private CardSetEntity cardSetEntity;
    private boolean isActiv;


    public boolean isActiv() {
        return isActiv;
    }

    public void setActiv(boolean activ) {
        isActiv = activ;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CardSetEntity getCardSetEntity() {
        return cardSetEntity;
    }

    public void setCardSetEntity(CardSetEntity cardSetEntity) {
        this.cardSetEntity = cardSetEntity;
    }
}
