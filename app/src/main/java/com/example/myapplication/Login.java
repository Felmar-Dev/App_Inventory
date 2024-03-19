package com.example.myapplication;

import android.util.Log;

import java.io.*;
import java.util.Scanner;

public class Login {
    private String user;
    private String pass;
    private static final String DATABASE_PATH = "asset/user_database.xlsx";

    public static void createUser(String username, String password) throws IOException {
        try (FileWriter fw = new FileWriter(DATABASE_PATH, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(username + "," + password);
        } catch (IOException e) {
            Log.e("Error", "An error occurred while creating the user. \n" + e);

        }
    }

    public static boolean validateUser(String username, String password) throws FileNotFoundException {
        File file = new File(DATABASE_PATH);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] credentials = scanner.nextLine().split(",");
                if (credentials[0].equals(username) && credentials[1].equals(password)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Database file not found.");
        }
        return false;
    }

}
