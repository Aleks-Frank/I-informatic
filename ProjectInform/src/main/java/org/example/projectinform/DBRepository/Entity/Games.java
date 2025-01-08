package org.example.projectinform.DBRepository.Entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Data;

@Data
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

}
