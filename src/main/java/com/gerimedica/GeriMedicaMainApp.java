package com.gerimedica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class GeriMedicaMainApp
{
    public static void main(String args[])
    {
        SpringApplication.run(GeriMedicaMainApp.class,args);
    }
}
