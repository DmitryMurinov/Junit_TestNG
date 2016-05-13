package homeworks.homework_3;

import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by Dima on 03.05.2016.
 */

public class TestBase {

    public String dirName = "murinov_homework_3";

    public static Path pathToFile;

    @BeforeClass(groups = {"positive"})
    public void createTempDirectory() throws IOException {
        pathToFile = Files.createTempDirectory(dirName);
    }

    @AfterClass(groups = {"positive"})
    public void deleteTempDirectory() throws IOException {
        File index = new File(pathToFile.toString());
        String[]entries = index.list();
        for(String filename: entries){
            File currentFile = new File(index.getPath(), filename);
            currentFile.delete();
        }
        Files.delete(pathToFile);
    }

}
