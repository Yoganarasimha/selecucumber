package org.example;

import org.apache.logging.log4j.LogManager;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        String p = System.getProperty("user.dir");
        System.out.println(p);
        Path base = Paths.get(p);

        StringBuilder sb = new StringBuilder("image");
        sb.append(System.currentTimeMillis());
        Path img = base.resolve("images").resolve(sb.toString());
        System.out.println(img.toAbsolutePath().toString());
        System.out.println(img.toString());

    }
}
