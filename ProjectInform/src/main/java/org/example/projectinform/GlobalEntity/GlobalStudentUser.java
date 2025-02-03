package org.example.projectinform.GlobalEntity;

import lombok.Data;
import lombok.Setter;
import org.example.projectinform.DBRepository.Entity.Student;

@Data
@Setter
public class GlobalStudentUser{

    public static Student globalStudent = null;

    public static String getFirstName(){
        return globalStudent.getFirstName();
    }

    public static String getLastName(){
        return globalStudent.getLastName();
    }

    public static void setCountCoins(int countCoins){
        globalStudent.setCountCoins(countCoins);
    }

    public static int getCountCoins(){
        return globalStudent.getCountCoins();
    }

}
