package org.example.projectinform.DBRepository.Entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Data;

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

    public String toString(){
        return result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameTasks() {
        return nameTasks;
    }

    public void setNameTasks(String nameTasks) {
        this.nameTasks = nameTasks;
    }

    public int getCountCoins() {
        return countCoins;
    }

    public void setCountCoins(int countCoins) {
        this.countCoins = countCoins;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getTasks() {
        return tasks;
    }

    public void setTasks(String tasks) {
        this.tasks = tasks;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
