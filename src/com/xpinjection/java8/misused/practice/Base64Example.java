package com.xpinjection.java8.misused.practice;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Base64;
import java.util.UUID;

/**
 * Created by Sergey on 5/23/17.
 */
public class Base64Example {
    public static void main(String args[]) {
        try {

            // Encode using basic encoder
            String string = "TutorialsPoint?java8";
            System.out.println("string: " + string);
            byte[] bytes = string.getBytes("utf-8");
            System.out.println("bytes: " + Arrays.toString(bytes));

            System.out.println();
            String base64encodedString = Base64.getEncoder().encodeToString(bytes);
            System.out.println("Base64 Encoded String (Basic) :" + base64encodedString);

            // Decode
            byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);

            System.out.println("Original String: " + new String(base64decodedBytes, "utf-8"));
            base64encodedString = Base64.getUrlEncoder().encodeToString(bytes);
            System.out.println("Base64 Encoded String (URL) :" + base64encodedString);

            StringBuilder stringBuilder = new StringBuilder();

            System.out.println();
            for (int i = 0; i < 10; ++i) {
                stringBuilder.append(UUID.randomUUID().toString());
            }

            byte[] mimeBytes = stringBuilder.toString().getBytes("utf-8");
            String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
            System.out.println("Base64 Encoded String (MIME) :" + mimeEncodedString);

        } catch (UnsupportedEncodingException e) {
            System.out.println("Error :" + e.getMessage());
        }
    }
}
