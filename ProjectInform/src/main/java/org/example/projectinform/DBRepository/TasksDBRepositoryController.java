package org.example.projectinform.DBRepository;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import lombok.Data;
import org.example.projectinform.DBRepository.Entity.Tasks;

import java.sql.SQLException;

@Data
public class TasksDBRepositoryController {

    private final static String URL_DB = SearchPath.SearchPathDB();

    private ConnectionSource connectionSource = null;

    private Dao<Tasks, String> tasksFromDB = null;

    public void connect() throws SQLException {
        connectionSource = new JdbcConnectionSource(URL_DB);

        tasksFromDB = DaoManager.createDao(connectionSource, Tasks.class);
    }

    public void close() throws Exception{
        connectionSource.close();
    }

    public void createTable() throws SQLException {
        TableUtils.createTable(connectionSource, Tasks.class);
    }

    public Tasks getTasksById(String id) throws SQLException {
        return tasksFromDB.queryBuilder()
                .where()
                .eq("id", id)
                .queryForFirst();
    }
}
