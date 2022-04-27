package Lesson5;

import javax.xml.soap.MimeHeaders;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

    }

    public static AppData read() {

        AppData appData = new AppData();
        File file = new File("File.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            appData.setHeader(reader.readLine().split(";"));
            List<Integer[]> integers = new ArrayList<>();
            String str;

            while ((str = reader.readLine()) != null) {
                String[] strArray = str.split(";");
                Integer[] intArray = new Integer[strArray.length];
                for (int i = 0; i < strArray.length; i++) {
                    intArray[i] = Integer.parseInt(strArray[i]);
                }
                integers.add(intArray);
            }

            appData.setData((Integer[][]) integers.toArray());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return appData;
    }



    public static void save(AppData appData) {
        File file = new File("File.txt");

        StringBuffer stringBuffer = new StringBuffer();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {

           for (String header : appData.getHeader()) {
               stringBuffer.append(header);
               stringBuffer.append(";");
           }


            writer.write(stringBuffer.toString());
            writer.write("\n");

            stringBuffer.delete(0, stringBuffer.length());

            for (int i = 0; i < appData.getData().length; i++) {
                for (int j = 0; j < appData.getData()[i].length; j++) {
                    stringBuffer.append(appData.getData()[i][j]);
                    stringBuffer.append("\n");
                }
                writer.write(stringBuffer.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


