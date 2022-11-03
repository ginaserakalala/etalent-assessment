package com.eviro.assessment.grad001.raisibeserakalala.controller;

import com.eviro.assessment.grad001.raisibeserakalala.service.FileParser;
import com.eviro.assessment.grad001.raisibeserakalala.service.FileParserImpl;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.*;

import java.io.File;


@RestController
@RequestMapping("/v1/api/image")

public class ImageController {
    FileParserImpl fpi = new FileParserImpl();

    public ImageController(){
        File csvfile = new File("/Users/ginaserakalala/Downloads/etalent_assessment/1664806858150-GraduateDev_AssessmentCsv_v2.csv");
        fpi.parseCSV(csvfile);
    }


    @GetMapping(value = "/{name}/{surname}/{filename:[a-zA-Z]+.[a-zA-Z]+}")
    //tMapping("/spring-web/{fileName:[a-z-]+}-{version:\d\.\d\.\d}{extension:\.[a-z]+}")
    public FileSystemResource gethttpImageLink(@PathVariable String name, @PathVariable String surname, @PathVariable String filename) {
        String[] data = FileParserImpl.rows.get(name.toLowerCase() + " " + surname.toLowerCase());
        File convertedfile = fpi.convertCSVDataToImage(data[1]);
        String ext = data[0].split("/")[1];
        File target = new File("./" + filename + "." + ext);
        return new FileSystemResource("/Users/ginaserakalala/Downloads/etalent_assessment/1664806858150-GraduateDev_AssessmentCsv_v2.csv");



    }
}