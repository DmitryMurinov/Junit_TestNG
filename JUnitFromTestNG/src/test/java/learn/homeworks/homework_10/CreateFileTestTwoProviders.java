package learn.homeworks.homework_10;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import learn.homeworks.Model.FileData;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static learn.homeworks.homework_10.DataSource.Type.FILE;
import static learn.homeworks.homework_10.DataSource.Type.GENERATE;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by Dima on 03.05.2016.
 */

@RunWith(DataProviderRunner.class)
public class CreateFileTestTwoProviders extends TestBase {

    //В этом тесте мы проверяем, что можно создать файл

    @Test
    @UseDataProvider(value = "dataSourceLoader", location = AllDataProvider.class)
    @DataSource(value = "5", type = GENERATE)
    public void createEmptyFile(String fileName, String s) throws IOException {

        File file;

        boolean fileCreated = false;

        try {

            file = new File(tempDir.getRoot() + fileName);

            System.out.println(file.exists());

            if (!file.exists()) {
                fileCreated = file.createNewFile();
            }

            System.out.println("test 1 copy done, with filename: " + fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }

        assertThat("File not created", fileCreated, is(true));
    }

    //В этом тесте мы проверяем, что можно создать файл и записать в него данные (размер файла с записанными данными
    //больше 0

    @Test
    @UseDataProvider(value = "dataSourceLoader", location = AllDataProvider.class)
    @DataSource(value = "src/test/resources/filedata.json", type = FILE)
    public void createFileWithData(FileData filedata, FileData empty) throws IOException {

        FileOutputStream fos = null;
        File file = null;
        boolean fileCreated = false;
        String content = filedata.getData();

        System.out.println(content);

        try {

            file = new File(tempDir.getRoot() + "/test2.txt");

            // if file doesnt exists, then create it
            if (!file.exists()) {
                fileCreated = file.createNewFile();
            }

            fos = new FileOutputStream(file);

            // get the content in bytes
            byte[] contentInBytes = content.getBytes();

            fos.write(contentInBytes);
            fos.flush();
            fos.close();

            System.out.println("test 2 copy done");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        assertThat("File not created", fileCreated, is (true));
        long fileSize = 0;
        if(file != null){fileSize = file.length();}
        assertTrue(fileSize > 0);
    }
}
