package com.gerimedica.dao;

import com.gerimedica.entity.ProductDetails;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductDaoTest
{
    @Autowired
    ProductDao productDao;

    @BeforeEach
    public void fillData()
    {
        ProductDetails productDetails= ProductDetails.builder()
                .code("VIraj")
                .codeListCode("codeListCOde")
                .displayValue("displayValue")
                .fromDate(LocalDate.now())
                .build();

        productDao.save(productDetails);
    }


    @Test
    public void testPassFindByCode()
    {
        List<ProductDetails> productList= productDao.findByCode("VIraj");
        assertFalse(productList.isEmpty());
    }

    @Test
    public void testFailFindByCode()
    {
        List<ProductDetails> productList= productDao.findByCode("Test");
        assertTrue(productList.isEmpty());
    }
}