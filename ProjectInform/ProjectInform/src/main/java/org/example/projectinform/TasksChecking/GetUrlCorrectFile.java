package org.example.projectinform.TasksChecking;

import org.example.projectinform.GlobalEntity.GlobalTasks;

public class GetUrlCorrectFile {

    public static String getUrlCorrectFile(){
        String nameTasks = GlobalTasks.globalTasks.getResult();
        System.out.println(nameTasks);
        return "src/main/resources/FileCor/" + nameTasks + ".docx";
    }

}
