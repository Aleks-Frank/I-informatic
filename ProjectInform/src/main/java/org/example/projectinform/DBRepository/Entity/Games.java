package org.example.projectinform.DBRepository.Entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Data;

@DatabaseTable(tableName = "Games")
public class Games {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField()
    private String nameGame;

    @DatabaseField()
    private int countCoins;

    @DatabaseField()
    private String urlGame;

    @DatabaseField()
    private String urlResult;

    public Games(){};

    public Games(int id, String nameGame, int countCoins, String urlGame, String urlResult){
        this.id = id;
        this.nameGame = nameGame;
        this.countCoins = countCoins;
        this.urlGame = urlGame;
        this.urlResult = urlResult;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameGame() {
        return nameGame;
    }

    public void setNameGame(String nameGame) {
        this.nameGame = nameGame;
    }

    public int getCountCoins() {
        return countCoins;
    }

    public void setCountCoins(int countCoins) {
        this.countCoins = countCoins;
    }

    public String getUrlGame() {
        return urlGame;
    }

    public void setUrlGame(String urlGame) {
        this.urlGame = urlGame;
    }

    public String getUrlResult() {
        return urlResult;
    }

    public void setUrlResult(String urlResult) {
        this.urlResult = urlResult;
    }
}
