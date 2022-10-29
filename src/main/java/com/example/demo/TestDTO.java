package com.example.demo;

import java.util.List;

public class TestDTO {
    private String str;
    private int number;

    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }

    private List<String> strings;
    private TestDTO testDTO;
    private List<TestDTO> testDTOList;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public TestDTO() {
    }

    public TestDTO getTestDTO() {
        return testDTO;
    }

    public void setTestDTO(TestDTO testDTO) {
        this.testDTO = testDTO;
    }

    public List<TestDTO> getTestDTOList() {
        return testDTOList;
    }

    public void setTestDTOList(List<TestDTO> testDTOList) {
        this.testDTOList = testDTOList;
    }

    @Override
    public String toString() {
        return "TestDTO{" +
                "str='" + getStr() + '\'' +
                ", number=" + this.getNumber() +
                ", strings=" + this.getStrings() +
                ", testDTO=" + this.getTestDTO() +
                ", testDTOList=" + this.getTestDTOList() +
                '}';
    }
}
