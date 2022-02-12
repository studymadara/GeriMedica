package com.gerimedica.service;

import com.gerimedica.dao.ProductDao;
import org.apache.commons.csv.CSVRecord;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.ModelExtensionsKt;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductUploadServiceTest
{
    private ProductUploadService productUploadService;
    @Mock
    ProductDao productDao;
    @Mock
    CSVRecord csvRecord;

    @BeforeEach
    public void setData()
    {
        productUploadService=new ProductUploadService();
    }

    @Test
    @Disabled
    void uploadData()
    {

    }

    @Test
    @Disabled
    void testSuccessLocalDate()
    {
        Assertions.assertThat(productUploadService.getLocalDate(csvRecord,"testName")).isNull();
    }

    @Test
    @Disabled
    void getInteger() {
    }
}