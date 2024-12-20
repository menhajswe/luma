package utils;

import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FileReader {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileReader.class);

    private FileReader() {
        // instance
    }
    public static List<Map<String, String>> fileReader() {
        List<Map<String, String>> emailAndPasswords = new ArrayList<>();
        File file = new File("src/test/resources/email_password.txt");

        // Read email and password from the file
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] emailAndPassword = data.split(",");
                if (emailAndPassword.length == 2) {
                    Map<String, String> emailPasswordMap = Map.of("email", emailAndPassword[0], "password", emailAndPassword[1]);
                    emailAndPasswords.add(emailPasswordMap);
                }
            }
        } catch (FileNotFoundException e) {
            LOGGER.error(() -> "File not found: " + e.getMessage());
        }

        return emailAndPasswords;
    }
}
