package learn.homeworks.homework_3;


import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by Dima on 03.05.2016.
 */

public class CreateFileTest extends TestBase {

    @Test
    @Category({PositiveTests.class, SmokeTests.class})
    public void createEmptyFile() throws IOException {

        File file;
        boolean fileCreated = false;

        try {

            file = new File(tempDir.getRoot() + "/test1.txt");
            if (!file.exists()) {
                fileCreated = file.createNewFile();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        assertThat("File not created", fileCreated, is (true));
        System.out.println("test 1 done");

    }

    @Test
    @Category(PositiveTests.class)
    public void createFileWithData() throws IOException {

        FileOutputStream fos = null;
        File file = null;
        boolean fileCreated = false;
        String content = "This is the text content";

        try {

            file = new File(tempDir.getRoot() + "/test2.txt");
            fos = new FileOutputStream(file);

            // if file doesnt exists, then create it
            if (!file.exists()) {
                fileCreated = file.createNewFile();
            }

            // get the content in bytes
            byte[] contentInBytes = content.getBytes();

            fos.write(contentInBytes);
            fos.flush();
            fos.close();

            System.out.println("test 2 done");

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

    @Test
    @Category(NegativeTest.class)
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

}
