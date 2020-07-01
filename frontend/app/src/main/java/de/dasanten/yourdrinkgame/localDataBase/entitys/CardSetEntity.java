package de.dasanten.yourdrinkgame.localDataBase.entitys;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "card_set")
public class CardSetEntity {

    @PrimaryKey(autoGenerate = true)
    private int localCardSetId;

    private String globalCardSetId;

    private String name;

    private String description;

    private String type;

    private int version;

    private String adminToken;

    private String editorToken;

    private boolean isAdmin;

    private boolean isUploaded;

    private boolean isActiv;


    public CardSetEntity(String name, String description, String type, int version, String adminToken, String editorToken, boolean isAdmin, boolean isUploaded, boolean isActiv) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.version = version;
        this.adminToken = adminToken;
        this.editorToken = editorToken;
        this.isAdmin = isAdmin;
        this.isUploaded = isUploaded;
        this.isActiv = isActiv;

    }

    public boolean isActiv() {
        return isActiv;
    }

    public void setActiv(boolean activ) {
        isActiv = activ;
    }

    public int getLocalCardSetId() {
        return localCardSetId;
    }

    public void setLocalCardSetId(int localCardSetId) {
        this.localCardSetId = localCardSetId;
    }

    public String getGlobalCardSetId() {
        return globalCardSetId;
    }

    public void setGlobalCardSetId(String globalCardSetId) {
        this.globalCardSetId = globalCardSetId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getAdminToken() {
        return adminToken;
    }

    public void setAdminToken(String adminToken) {
        this.adminToken = adminToken;
    }

    public String getEditorToken() {
        return editorToken;
    }

    public void setEditorToken(String editorToken) {
        this.editorToken = editorToken;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isUploaded() {
        return isUploaded;
    }

    public void setUploaded(boolean uploaded) {
        isUploaded = uploaded;
    }
}
