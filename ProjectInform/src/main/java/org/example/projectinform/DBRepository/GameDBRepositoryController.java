package org.example.projectinform.DBRepository;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import lombok.Data;
import org.example.projectinform.DBRepository.Entity.Games;

import java.sql.SQLException;

@Data
public class GameDBRepositoryController {

    private final static String URL_DB = SearchPath.SearchPathDB();

    private ConnectionSource connectionSource = null;

    private Dao<Games, String> gameFromDB = null;

    public void connect() throws SQLException {
        connectionSource = new JdbcConnectionSource(URL_DB);

        gameFromDB = DaoManager.createDao(connectionSource, Games.class);
    }

    public void saveGame(Games game) throws SQLException{
        gameFromDB.create(game);
    }

    public void close() throws Exception{
        connectionSource.close();
    }

    public Games getGameById(int id) throws SQLException {
        return gameFromDB.queryBuilder()
                .where()
                .eq("id", id)
                .queryForFirst();
    }

}
