package org.shevchenko.core;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ResourceLoader {

    public static String loadResource(String fileName) throws Exception {
        return new String(Files.readAllBytes(
                Paths.get(ResourceLoader.class.getResource(fileName).toURI())));
    }
}
