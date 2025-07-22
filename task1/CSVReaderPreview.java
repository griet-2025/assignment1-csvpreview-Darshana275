package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReaderPreview {

    public static void main(String[] args) {
        // TO DO: Write your code below 
        String filePath = "dataset/dataset.csv";
        String line;
        int recordCount = 0;
        int columnCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            System.out.println("=== Data Preview ===\n");

            // Read Header
            if ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                columnCount = columns.length;

                System.out.println("Columns:");
                for (String col : columns) {
                    System.out.print(col + "\t");
                }
                System.out.println("\nTotal Columns: " + columnCount);
                System.out.println("\nFirst 5 Records:\n");
            }

            // Read Records
            int previewLimit = 5;
            while ((line = br.readLine()) != null) {
                recordCount++;
                String[] data = line.split(",");

                if (recordCount <= previewLimit) {
                    for (String value : data) {
                        System.out.print(value + "\t");
                    }
                    System.out.println();
                }
            }

            System.out.println("\nTotal Records (excluding header): " + recordCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
