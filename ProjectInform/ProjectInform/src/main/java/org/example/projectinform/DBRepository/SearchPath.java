package org.example.projectinform.DBRepository;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class SearchPath {

    private static String path;

    public static String SearchPathDB(){
        Path path = Paths.get("src/main/resources/DB/DatabaseStudent.db");
        String resource = path.toAbsolutePath().toString();
        return "jdbc:sqlite:" + resource;
    }

}