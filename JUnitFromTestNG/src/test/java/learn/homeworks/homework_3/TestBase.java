package learn.homeworks.homework_3;

import learn.homeworks.Categories.HomeWorkCategories;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Dima on 03.05.2016.
 */

public class TestBase implements HomeWorkCategories {

    @Rule
    @Category(PositiveTests.class)
    public TemporaryFolder tempDir = new TemporaryFolder();

}
