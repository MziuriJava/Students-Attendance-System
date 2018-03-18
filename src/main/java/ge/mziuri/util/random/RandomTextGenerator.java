package ge.mziuri.util.random;

import java.security.SecureRandom;

public class RandomTextGenerator {

    private static final String CHARACTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static String generateRandomString(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder text = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            text.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return (text.toString());
    }
}

