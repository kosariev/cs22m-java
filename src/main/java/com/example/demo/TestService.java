package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class TestService {
    private final Logger log = LoggerFactory.getLogger(TestService.class);

    public String getData() {
        return "Hello world!";
    }

    public String getDataWithParams(String firstVal, String secondVal) {
        log.info("firstVal: {}, secondVal: {}", firstVal, secondVal);
        return firstVal + secondVal;
    }

    public TestDTO getTestDTO() {
        TestDTO testDTO = new TestDTO();
        testDTO.setNumber(5);
        testDTO.setStr("Hello");
        testDTO.setStrings(Arrays.asList("AAA", "BBB", "CCC"));

        TestDTO newTestDTO = new TestDTO();
        newTestDTO.setNumber(5);
        newTestDTO.setStr("HHHH");
        testDTO.setTestDTO(newTestDTO);

        testDTO.setTestDTOList(Arrays.asList(newTestDTO, newTestDTO, newTestDTO));

        return testDTO;
    }

    public TestDTO takeJson(TestDTO testDTO) {
        log.info("Test DTO result {}", testDTO);
        return getTestDTO();
    }

}
