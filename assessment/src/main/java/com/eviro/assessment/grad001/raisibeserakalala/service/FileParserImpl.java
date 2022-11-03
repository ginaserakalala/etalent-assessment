package com.eviro.assessment.grad001.raisibeserakalala.service;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.File;
import java.io.FileReader;
import java.net.URI;
import java.util.Base64;
import java.util.List;

public class FileParserImpl implements FileParser {
    @Override
    public void parseCSV(File csvFile) {
        try {
            FileReader filereader = new FileReader(csvFile);


            CSVParser parser = new CSVParserBuilder().withSeparator(';').build();


            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withCSVParser(parser)
                    .build();

            List<String[]> allData = csvReader.readAll();

            for (String[] row : allData) {
                for (String cell : row) {
                    System.out.print(cell + "\t");
                }
                System.out.println();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public File convertCSVDataToImage(String base64ImageData) {
        byte[] decodedBytes = Base64.getDecoder().decode(base64ImageData);
        String decodedString = new String(decodedBytes);
        File file = new File("./test.jpeg");

        return file;
    }

    @Override
    public URI createImageLink(File fileImage) {
        return null;
    }
}
