package util.ReadAndWriteFile;

import models.person.Employee;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public static List<String> readDataFile(String sourceFile) {
        List<String> strings = new ArrayList<>();
        File file = new File(sourceFile);
        FileReader fileReader = null;
        BufferedReader br = null;
        try {
            fileReader = new FileReader(file);
            br = new BufferedReader(fileReader);
            String line;
            while ((line = br.readLine()) != null) {
                strings.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return strings;
    }

   public static void writeDataFile(List<String> strings, String targetFile, boolean append) {
        File file = new File(targetFile);
        FileWriter fileWriter = null;
        BufferedWriter bw = null;
        try {
            fileWriter = new FileWriter(file,append);
            bw = new BufferedWriter(fileWriter);
            for (String s : strings) {
                bw.write(s);
                bw.newLine();
            }
            bw.close();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}
