package org.domingus.logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Writter {

    private Path path;

    public Writter (String path) {
        this.path =  Paths.get(path);
    }

    public void write(String message){
        try {
            Files.write(path, message.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
