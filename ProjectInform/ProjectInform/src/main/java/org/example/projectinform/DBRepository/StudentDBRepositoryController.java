package org.example.projectinform.DBRepository;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import lombok.Data;
import org.example.projectinform.DBRepository.Entity.Student;

import java.sql.SQLException;

@Data
public class StudentDBRepositoryController {

    private final static String URL_DB = SearchPath.SearchPathDB();

    private ConnectionSource connectionSource = null;

    private Dao<Student, String> studentFromDB = null;

    public void connect() throws SQLException{
        connectionSource = new JdbcConnectionSource(URL_DB);

        studentFromDB = DaoManager.createDao(connectionSource, Student.class);
    }

    public void saveStudent(Student student) throws SQLException{
        studentFromDB.create(student);
    }

    public void close() throws Exception{
        connectionSource.close();
    }

    public void Print(){
        System.out.println(URL_DB);
    }

    public void createTale() throws SQLException {
        TableUtils.createTable(connectionSource, Student.class);
    }

    public Student getStudentByFourParameters(String role, int classStudent, String login, String password) throws SQLException {
        return studentFromDB.queryBuilder()
                .where()
                .eq("role", role)
                .and()
                .eq("classStudent", classStudent)
                .and()
                .eq("login", login)
                .and()
                .eq("password", password)
                .queryForFirst();
    }

}
