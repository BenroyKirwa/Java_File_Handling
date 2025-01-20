package com.readfile;


import java.io.*;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {
        String filename = "src/sample.txt";
        System.out.println("This is the first implementation of reading a file with scanner.");
        System.out.println("================================================================");
        File textFile = new File(filename);
        try{
            Scanner scanner = new Scanner(new FileInputStream(args[0]));
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println(line);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found : " + args[0]);
        }
//        catch(IOException e){
//            System.out.println("Unable to read file : " + textFile.toString());
//        }

        System.out.println();
        System.out.println("This is the second implementation of reading a file with scanner.");
        System.out.println("================================================================");
        try{
            FileReader fileReader = new FileReader(args[0]);
            BufferedReader br = new BufferedReader(fileReader);
            String line;
             while((line = br.readLine()) != null){
                 System.out.println(line);
             }
             br.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found : " + args[0]);
        }
        catch (IOException e){
            System.out.println("Unable to read file : " + args[0]);
        }
    }
}