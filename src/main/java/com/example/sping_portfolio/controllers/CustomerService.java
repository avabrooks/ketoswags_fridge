package com.example.sping_portfolio.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.sping_portfolio.controllers.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
public class CustomerService {

    public List<Customer> recipelog() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(getClass().getClassLoader()
                            .getResourceAsStream("recipelog.json"),
                    new TypeReference<List<Customer>>() {
                    });
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}