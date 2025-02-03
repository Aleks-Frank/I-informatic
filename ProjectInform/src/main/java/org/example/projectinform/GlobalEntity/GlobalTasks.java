package org.example.projectinform.GlobalEntity;

import lombok.Data;
import org.example.projectinform.DBRepository.Entity.Tasks;

@Data
public class GlobalTasks {

    public static Tasks globalTasks = null;

}
