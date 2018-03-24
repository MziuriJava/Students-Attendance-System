package ge.mziuri.TestingWordDocument;

import java.io.File;

public class Testingsavingfiles {
    ClassLoader classLoader = getClass().getClassLoader();
    File fi = new File(classLoader.getResource("Test.txt").getFile());


}
