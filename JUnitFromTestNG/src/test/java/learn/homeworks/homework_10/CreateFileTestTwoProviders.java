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
    @UseDataProvider("fileNames")
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

    @DataProvider
    public static Object[][] fileNames() {
        List<Object[]> fileName = new ArrayList<Object[]>();
        for (int i = 0; i < 5; i++) {
            fileName.add(new String[]{"/test_" + System.currentTimeMillis() + "_" + randomInt() + ".txt", ""});
        }
        return (Object[][]) fileName.toArray(new Object[][]{});
    }

    //В этом тесте мы проверяем, что можно создать файл и записать в него данные (размер файла с записанными данными
    //больше 0

    @Test
    @UseDataProvider("filedataJSON")//    , dependsOnMethods = "createEmptyFile")
    public void createFileWithData(FileData filedata) throws IOException {

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

    //В следующем тесте проверяем, что система не даст создать файл при не корректном пути и выбросит исключение.
    //Если система не выбрасывает правильно исключение, то тест падает

    @Test
    public void createFileWrongPath() {

        File file;
        IOException exception = null;

        try {

            file = new File(tempDir.getRoot() + "/!@#$%^&*()///test3.txt");
            if (!file.exists()) {
                file.createNewFile();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("test 3 copy");

            assertThat("There are no message about wrong path or message in a wrong language",
                    e.getMessage(), is ("Синтаксическая ошибка в имени файла, имени папки или метке тома"));

            exception = e;
        } finally {
            if(!exception.getMessage().equals("Синтаксическая ошибка в имени файла, имени папки или метке тома")){
                System.out.println("There are no message from system or wrong message");
                System.out.println("Message from System: " + exception.getMessage());
                System.exit(1);
            }
        }
    }

    private static int randomInt() {
        return new Random().nextInt();
    }

    @DataProvider
    public static Object[] filedataJSON() throws IOException {

        try
                (
                        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/filedata.json")))
                ) {
            String json = "";
            String line = reader.readLine();

            while (line != null) {
                json += line;
                line = reader.readLine();
            }

            Gson gson = new Gson();

            List<Object> fileDatas = gson.fromJson(json, new TypeToken<List<FileData>>() {
            }.getType());

            System.out.println(fileDatas);

            return (Object[]) fileDatas.toArray(new Object[]{});
        }
    }
}
