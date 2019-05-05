package regex.ex4;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Reg_4 {

    public static String getHash(String input, String algorithm, String encoding)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest;
        digest = getMessageDigest(algorithm);
        digest.reset();
        digest.update(input.getBytes(encoding));
        byte[] hash = digest.digest();
        StringBuilder hexString = new StringBuilder();
        StringBuilder hex = new StringBuilder();
        for (byte var : hash) {
            hex.append(Integer.toHexString(0xFF & var));
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
            hex.setLength(0);
        }
        return hexString.toString();
    }

    private static MessageDigest getMessageDigest(String algorithm) throws NoSuchAlgorithmException {
        MessageDigest digest;
        switch (algorithm) {
            case "MD5":
                digest = MessageDigest.getInstance(algorithm);
                break;
            case "SHA-256":
                digest = MessageDigest.getInstance(algorithm);
                break;
            case "SHA-512":
                digest = MessageDigest.getInstance(algorithm);
                break;
            default:
                throw new NoSuchAlgorithmException("Not found input algorithm");
        }
        return digest;
    }

}
