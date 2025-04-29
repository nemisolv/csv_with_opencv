package com.vht.csv;

import com.vht.csv.util.CsvUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CsvTest {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User(null , "Alice", "alice@example.com"),
                new User(2L, "Bob", "bob@example.com"),
                new User(3L, "Charlie", "charlie@example.com")
        );

        byte[] csvBytes = CsvUtil.writeCsvToByteArrayFromList(users);
//        String csvString = new String(csvBytes); // Hiển thị nội dung CSV
        // write to local file
        String fileName = "users.csv";
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.write(csvBytes);
            System.out.println("CSV file created: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

}
