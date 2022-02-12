package com.gerimedica.service;

import com.gerimedica.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDeleteService
{
    @Autowired
    ProductDao productDao;

    public boolean deleteAllData()
    {
        productDao.deleteAll();
        return true;
    }

}
