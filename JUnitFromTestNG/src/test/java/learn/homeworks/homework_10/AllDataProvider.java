package learn.homeworks.homework_10;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import learn.homeworks.Model.FileData;
import org.junit.runners.model.FrameworkMethod;

import com.tngtech.java.junit.dataprovider.DataProvider;

public class AllDataProvider {

    @DataProvider
    public static Object[] dataSourceLoader(FrameworkMethod testMethod) throws IOException {
        DataSource ds = testMethod.getAnnotation(DataSource.class);
        if (ds == null) {
            throw new Error("Test method has no @DataSource annotation: " + testMethod.getName());
        }
        switch (ds.type()) {
            case GENERATE:
                return GenerateData(ds.value());

            case FILE:
                return loadDataFromFile(ds.value());

            default:
                throw new Error("Data source type is not supported: " + ds.type());
        }
    }

    private static Object[][] GenerateData(String value) throws IOException {
        return fileNames(value);
    }

    private static Object[] loadDataFromFile(String filePath) throws IOException {
        return filedataJSON(filePath);
    }

    public static Object[][] fileNames(String count) {

        List<Object[]> fileName = new ArrayList<Object[]>();

        int totalNames = Integer.valueOf(count);

        for (int i = 0; i < totalNames; i++) {
            fileName.add(new Object[]{"/test_" + System.currentTimeMillis() + "_" + randomInt() + ".txt", ""});
        }
        return (Object[][]) fileName.toArray(new Object[][]{});
    }

    private static int randomInt() {
        return new Random().nextInt();
    }


    private static Object[][] loadDataFromInputStream(InputStream input) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(input));

        List<Object[]> userData = new ArrayList<Object[]>();
        String line = in.readLine();
        while (line != null) {
            userData.add(line.split(";"));
            line = in.readLine();
        }

        in.close();

        return (Object[][]) userData.toArray(new Object[][]{});
    }

    public static Object[][] filedataJSON(String filePath) throws IOException {

        try
                (
                        BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)))
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

            List<Object[]> obj = fileDatas.stream().map(( o ) -> new Object[]{o}).collect(Collectors.toList());

            return (Object[][]) obj.toArray(new Object[][]{});
        }
    }

}
