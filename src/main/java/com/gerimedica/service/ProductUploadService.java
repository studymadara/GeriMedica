package com.gerimedica.service;

import com.gerimedica.dao.ProductDao;
import com.gerimedica.entity.ProductDetails;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductUploadService
{
    @Autowired
    ProductDao productDao;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    //1.get data
    //2.convert into pojo
    //3.save data
    public String uploadData(MultipartFile file) throws IOException
    {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(file.getInputStream(),"UTF-8"));

        CSVParser csvParser=new CSVParser(bufferedReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

        Iterable<CSVRecord> csvRecords=csvParser.getRecords();

        List<ProductDetails> productDetailsList=new ArrayList<>();



        ProductDetails productDetails;

        for (CSVRecord csvRecord:csvRecords)
        {
            productDetails=ProductDetails.builder()
                    .source(csvRecord.get("source"))
                    .codeListCode(csvRecord.get("codeListCode"))
                    .code(csvRecord.get("code"))
                    .displayValue(csvRecord.get("displayValue"))
                    .longDescription(csvRecord.get("longDescription"))
                    .fromDate(getLocalDate(csvRecord,"fromDate"))
                    .toDate(getLocalDate(csvRecord,"toDate"))
                    .sortingPriority(getInteger(csvRecord,"sortingPriority"))
                    .build();

            productDetailsList.add(productDetails);
        }

        productDao.saveAll(productDetailsList);

        return "All Data Added SuccessFully!";
    }


    public LocalDate getLocalDate(CSVRecord csvRecord,String paramName)
    {
        return csvRecord.get(paramName).trim().length()!=0?LocalDate.parse(csvRecord.get(paramName),formatter):null;
    }

    public Integer getInteger(CSVRecord csvRecord,String paramName)
    {
        return csvRecord.get(paramName).trim().length()!=0?Integer.parseInt(csvRecord.get(paramName)):null;
    }
}
