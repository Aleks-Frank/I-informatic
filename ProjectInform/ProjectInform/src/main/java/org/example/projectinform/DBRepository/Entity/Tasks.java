package org.example.projectinform.DBRepository.Entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Data;

@Data
@DatabaseTable(tableName = "Tasks")
public class Tasks {

    @DatabaseField()
    private String id;

    @DatabaseField()
    private String nameTasks;

    @DatabaseField()
    private int countCoins;

    @DatabaseField()
    private String history;

    @DatabaseField()
    private String tasks;

    @DatabaseField()
    private String result;

    public Tasks(){}

    public Tasks(String id, String nameTasks, int countCoins, String history, String tasks, String result){
        this.id = id;
        this.nameTasks = nameTasks;
        this.countCoins = countCoins;
        this.history = history;
        this.tasks = tasks;
        this.result = result;
    }

    public String idForNumberString(){
        return this.id.substring(5);
    }

}
