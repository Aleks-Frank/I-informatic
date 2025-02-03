package org.example.projectinform.GlobalEntity;

import lombok.Data;
import lombok.Setter;
import org.example.projectinform.DBRepository.Entity.Games;

@Data
@Setter
public class GlobalGame {

    public static Games globalGame = null;

}
