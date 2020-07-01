package de.dasanten.yourdrinkgame.localDataBase.entitys;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "card", foreignKeys = @ForeignKey(entity = CardSetEntity.class,
        parentColumns = "localCardSetId",
        childColumns = "card_set_id",
        onDelete = CASCADE))
public class CardEntity {

    @PrimaryKey(autoGenerate = true)
    private int localCardId;

    private String globalId;

    private String content;

    private String type;

    @ColumnInfo(name = "card_set_id")
    private int cardSetId;

    private boolean isActiv;


    public CardEntity(String globalId, String content, String type, int cardSetId, boolean isActiv) {
        this.globalId = globalId;
        this.content = content;
        this.type = type;
        this.cardSetId = cardSetId;
        this.isActiv = isActiv;
    }

    public boolean isActiv() {
        return isActiv;
    }

    public void setActiv(boolean activ) {
        isActiv = activ;
    }

    public int getLocalCardId() {
        return localCardId;
    }

    public void setLocalCardId(int localCardId) {
        this.localCardId = localCardId;
    }

    public String getGlobalId() {
        return globalId;
    }

    public void setGlobalId(String globalId) {
        this.globalId = globalId;
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

    public int getCardSetId() {
        return cardSetId;
    }

    public void setCardSetId(int cardSetId) {
        this.cardSetId = cardSetId;
    }
}
