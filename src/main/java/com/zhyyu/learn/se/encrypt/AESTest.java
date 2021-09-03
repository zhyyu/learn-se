package com.zhyyu.learn.se.encrypt;


import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

// https://www.liaoxuefeng.com/wiki/1252599548343744/1304227762667553
public class AESTest {

    private static byte[] iv = {};

    public static void main(String[] args) throws Exception {
        String plainText = "";
        String key = "";

        String encrypt = encrypt(plainText, key);
        System.out.println(encrypt);

        String source = decrypt(encrypt, key);
        System.out.println(source);
    }

    public static String encrypt(String plainText, String key) throws Exception {
        byte[] plainTextBytes = plainText.getBytes(StandardCharsets.UTF_8);
        byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");

//        SecureRandom sr = SecureRandom.getInstanceStrong();
//        byte[] iv = sr.generateSeed(16);
        IvParameterSpec ivps = new IvParameterSpec(iv);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivps);

        byte[] bytes = cipher.doFinal(plainTextBytes);
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static String decrypt(String encrypt, String key) throws Exception {
        byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
        IvParameterSpec ivps = new IvParameterSpec(iv);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivps);

        byte[] encryptBytes = Base64.getDecoder().decode(encrypt);
        byte[] sourceBytes = cipher.doFinal(encryptBytes);

        return new String(sourceBytes, "UTF-8");
    }


}
