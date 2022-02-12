package com.gerimedica.service;

import com.gerimedica.dao.ProductDao;
import com.gerimedica.entity.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductFetchService
{
    @Autowired
    ProductDao productDao;

    public List<ProductDetails> getAllData()
    {
        return productDao.findAll();
    }

    public List<ProductDetails> fetchCodeData(String code)
    {
        return productDao.findByCode(code);
    }

}
