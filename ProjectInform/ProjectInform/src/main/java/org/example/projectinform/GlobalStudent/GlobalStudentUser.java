package org.example.projectinform.GlobalStudent;

import lombok.Data;
import lombok.Setter;
import org.example.projectinform.DBRepository.Entity.Student;

@Data
@Setter
public class GlobalStudentUser {

    public static Student globalStudent;

}
