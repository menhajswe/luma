package utils;

import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class TestPasswordGenerator {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileReader.class);
    private TestPasswordGenerator() {
        // Constructor
    }

    private static String emailGenerator() {
        return "test" + randomIntGenerator() + "@test.com";
    }

    private static String passwordGenerator() {
        return "Test@" + randomIntGenerator();
    }

    private static int randomIntGenerator() {
        return (int) (Math.random() * 1000);
    }

    public static void emailAndPasswordWriterToFile() throws IOException {
        String email = emailGenerator();
        String password = passwordGenerator();
        Map<String, String> emailAndPassword = Map.of("email", email, "password", password);
        // Write email and password to a file
        try (FileWriter fileWriter = new FileWriter(new File("src/test/resources/email_password.txt"), true);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {
            writer.write(emailAndPassword.get("email") + "," + emailAndPassword.get("password"));
            writer.newLine(); // Ensure each pair is on a new line
        } catch (IOException e) {
            LOGGER.error(() -> "An error occurred." + e.getMessage());
        }
    }
}
