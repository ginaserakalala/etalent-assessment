package com.eviro.assessment.grad001.raisibeserakalala.service;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.*;
import java.net.URI;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import jakarta.xml.bind.DatatypeConverter;


public class FileParserImpl implements FileParser {
    public static HashMap <String,String[]> rows = new HashMap<>();
    @Override
    public void parseCSV(File csvFile) {

        try {
            FileReader filereader = new FileReader(csvFile);


            CSVParser parser = new CSVParserBuilder().withSeparator(',').build();


            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withCSVParser(parser)
                    .build();

            List<String[]> allData = csvReader.readAll();

            for (int i= 0; i < allData.size();i++) {
                if(i == 0)
                    continue;

//                for (String cell : row) {
//                    System.out.print(cell + "\t");
//                }

                String[] data = allData.get(i);
                String fullname = data[0].toLowerCase() + " "  + data[1].toLowerCase() ;
                data = Arrays.copyOfRange(data, 2, 4);
                rows.put(fullname,data);

                System.out.println();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public File convertCSVDataToImage(String base64ImageData) {
        byte[] data = DatatypeConverter.parseBase64Binary(base64ImageData);
        String pathname;
        pathname = "C:/Pictures" + "img.png";
        File file = new File(pathname);
        try(OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))){
            outputStream.write(data);
        }
        catch (Exception e){
            e.printStackTrace();
        }





        return file;
    }

    @Override
    public URI createImageLink(File fileImage) {

        URI uri = fileImage.toURI();
        System.out.println(uri);

        return uri;
    }
}
