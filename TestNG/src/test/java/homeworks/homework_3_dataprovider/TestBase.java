package homeworks.homework_3_dataprovider;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by Dima on 03.05.2016.
 */

public class TestBase {

    public String dirName = "murinov_homework_3_copy";

    public static Path pathToFile;

    @BeforeMethod
    public void createTempDirectory() throws IOException {
        pathToFile = Files.createTempDirectory(dirName);
    }

    @AfterMethod
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
