package com.gerimedica.controller;

import com.gerimedica.entity.ProductDetails;
import com.gerimedica.service.ProductDeleteService;
import com.gerimedica.service.ProductFetchService;
import com.gerimedica.service.ProductUploadService;
import org.assertj.core.api.BDDAssumptions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MainControllerTest {

    @LocalServerPort
    private int port;

    TestRestTemplate testRestTemplate=new TestRestTemplate();
    HttpHeaders httpHeaders=new HttpHeaders();

    @Test
    @Disabled
    void uploadData() {
    }

    @Test
    void fetchAllData() throws Exception {
        HttpEntity<String> httpEntity=new HttpEntity<String>(null,httpHeaders);
        ResponseEntity<String> responseEntity=testRestTemplate
                .exchange(createURLWithPort("/showAll"), HttpMethod.POST,httpEntity,String.class);

        String actual=responseEntity.getBody().toString();

        assertEquals(actual,"[]");
    }

    @Test
    @Disabled
    void fetchCodeData() {
    }

    @Test
    @Disabled
    void deleteAllData() {
    }


    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}