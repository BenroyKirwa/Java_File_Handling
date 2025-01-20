package com.writefile;

import java.io.*;
import java.nio.Buffer;

public class WriteFile {

    public static void main(String[] args) {
        File file = new File("test.txt");

        try{
            BufferedWriter br = new BufferedWriter(new FileWriter(file));
            br.write("This is line one.");
            br.write("\nThis is line two.");
            br.close();
        }
        catch (IOException e) {
            System.out.println("Unable to read file : " + file.toString());
        }
    }
}
