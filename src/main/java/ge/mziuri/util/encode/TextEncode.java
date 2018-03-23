package ge.mziuri.util.encode;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TextEncode {

    public static String textEncode(String text){
        byte[] inputeText = new byte[0];
        MessageDigest messageDigest = null;

        try {
            inputeText = text.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {
            messageDigest = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        messageDigest.update(inputeText);

        byte[] digest = messageDigest.digest();
        String encodedText= DatatypeConverter.printHexBinary(digest).toLowerCase();
        return encodedText;
    }

}
