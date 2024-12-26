package org.example.projectinform.GlobalEntity;

import lombok.Data;
import lombok.Setter;
import org.example.projectinform.DBRepository.Entity.Student;

@Data
@Setter
public class GlobalStudentUser {

    public static Student globalStudent;

}
