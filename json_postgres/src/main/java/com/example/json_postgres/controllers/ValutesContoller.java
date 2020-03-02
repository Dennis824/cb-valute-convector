package com.example.json_postgres.controllers;

import com.example.json_postgres.entities.Valute;
import com.example.json_postgres.repositories.ValutesRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

@RestController
public class ValutesContoller {


    private final static Logger logger = LoggerFactory.getLogger(ValutesContoller.class);
    private ValutesRepository valutesRepository;

    @Autowired
    public ValutesContoller(ValutesRepository valutesRepository) {
        this.valutesRepository = valutesRepository;
    }

    @RequestMapping("json")
public void json(){
        //get json data from resources

        URL url = this.getClass().getClassLoader().getResource("currentvalutes.json");


        if(url!=null){
            File jsonFile = new File(url.getFile());

            ObjectMapper objectMapper = new ObjectMapper();

            try {
                List<Valute> valute = objectMapper.readValue(jsonFile, new TypeReference<List<Valute>>() { });
                valutesRepository.saveAll(valute);
                logger.info("all records saved.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            logger.warn("url is null.");
        }


}
}
