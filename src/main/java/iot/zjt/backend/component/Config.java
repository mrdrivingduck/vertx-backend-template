package iot.zjt.backend.component;

import java.io.File;
import java.io.IOException;

import org.ini4j.InvalidFileFormatException;
import org.ini4j.Wini;

/**
 * The configuration component.
 * 
 * @author Mr Dk.
 * @since 2020/03/09
 */
public class Config {

    private static Wini ini = null;

    /**
     * Initialize the configuration from file.
     * 
     * @throws IOException
     * @throws InvalidFileFormatException
     */
    public static void init() throws IOException, InvalidFileFormatException {
        ini = new Wini(new File("config/config.ini"));
    }

    /**
     * @return The configuration object.
     */
    public static Wini getConfig() {
        return ini;
    }
}