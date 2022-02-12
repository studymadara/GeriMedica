package com.gerimedica.controller;

import com.gerimedica.entity.ProductDetails;
import com.gerimedica.service.ProductDeleteService;
import com.gerimedica.service.ProductFetchService;
import com.gerimedica.service.ProductUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class MainController
{
    /* this class is responsible for all user landing
        1.upload the data
        2.Fetch all data
        3.Fetch by code
        4.Delete all data
    */

    @Autowired
    ProductUploadService productUploadService;

    @Autowired
    ProductFetchService productFetchService;

    @Autowired
    ProductDeleteService productDeleteService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public @ResponseBody String uploadData(@RequestParam("file") MultipartFile csvFile) throws IOException {
        return productUploadService.uploadData(csvFile);
    }

    @RequestMapping(value = "/showAll",method = RequestMethod.POST)
    public @ResponseBody List<ProductDetails> fetchAllData() throws IOException {
        return productFetchService.getAllData();
    }

    @RequestMapping(value = "/get",method = RequestMethod.POST)
    public @ResponseBody List<ProductDetails> fetchCodeData(@RequestParam("code") @NonNull String code) throws IOException {
        return productFetchService.fetchCodeData(code);
    }

    @RequestMapping(value = "/deleteAll",method = RequestMethod.POST)
    public @ResponseBody boolean deleteAllData() throws IOException {
        return productDeleteService.deleteAllData();
    }

    @ExceptionHandler
    public String handleAnyException(Exception exception)
    {
        exception.printStackTrace();
        return "Can you try later!";
    }

}
