package com.eviro.assessment.grad001.raisibeserakalala.service;

import com.eviro.assessment.grad001.raisibeserakalala.model.UserAccount;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.net.URI;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
//import jakarta.xml.bind.DatatypeConverter;


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
        try {
            fileImage = new File("C:\\path\\to\\test.txt");
            System.out.println(fileImage.toURI());
        } catch (Exception exception) {
            System.out.println("exception");
        }

        UserAccount link = new UserAccount();

        // I want to somehow get the imagine link here to the model side link.getImagelink();

        return fileImage.toURI();
    }
}

