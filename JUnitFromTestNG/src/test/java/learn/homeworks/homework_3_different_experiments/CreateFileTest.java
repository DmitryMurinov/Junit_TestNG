package learn.homeworks.homework_3_different_experiments;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.io.*;
import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Dima on 03.05.2016.
 */

@RunWith(Parameterized.class)
public class CreateFileTest extends TestBase {

    @Parameters(name = "fileName:{0}")
    public static Collection<Object[]> paths(){
        List<Object[]> fileName = new ArrayList<Object[]>();
        for (int i = 0; i < 5; i++){
            fileName.add(new Object[]{"/test_" + System.currentTimeMillis() + "_" + randomInt() + ".txt"});
        }
        return fileName;
    }

    private String fileName;

    public CreateFileTest(String fileName){
        this.fileName = fileName;
    }

    //В этом тесте мы проверяем, что можно создать файл

    @Test
    public void createEmptyFile() throws IOException {

        File file;

        boolean fileCreated = false;

        try {

            file = new File(tempDir.getRoot() + fileName);
            if (!file.exists()) {
                fileCreated = file.createNewFile();
            }

            System.out.println("test 1 copy done, with filename: " + fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }

        assertThat("File not created", fileCreated, is (true));
    }

    private static int randomInt() {
        return new Random().nextInt();
    }

}
