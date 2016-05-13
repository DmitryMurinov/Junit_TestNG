package learn.homeworks.homework_3;


import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Dima on 03.05.2016.
 */

public class CreateFileTest extends TestBase {

    @Test
    @Category({PositiveTests.class, SmokeTests.class})
    public void createEmptyFile() throws IOException {

        File file;

        try {

            file = new File(tempDir.getRoot() + "/test1.txt");
            if (!file.exists()) {
                file.createNewFile();
            }

            System.out.println("test 1 done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Category(PositiveTests.class)
    public void createFileWithData() throws IOException {

        FileOutputStream fos = null;
        File file;
        String content = "This is the text content";

        try {

            file = new File(tempDir.getRoot() + "/test2.txt");
            fos = new FileOutputStream(file);

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
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
    }

    @Test
    @Category(NegativeTest.class)
    public void createFileWrongPath() {

        File file;

        try {

            file = new File(tempDir.getRoot() + "/!@#$%^&*()///test3.txt");
            if (!file.exists()) {
                file.createNewFile();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("test 3");
        }
    }

}
