package biz.spring.core.dto;

import biz.spring.core.model.Test;
import biz.spring.core.model.TestQuestion;

import java.util.List;

public class TestDTO {

    private Integer testId;

    private String testName;

    private String testDesc;

    private List<TestQuestionDTO> testQuestions;

    public List<TestQuestionDTO> getTestQuestions() {
        return testQuestions;
    }

    public void setTestQuestions(List<TestQuestionDTO> testQuestions) {
        this.testQuestions = testQuestions;
    }

    public TestDTO() {
    }

    public TestDTO(Integer testId,
                    String testName,
                    String testDesc) {
        this.testId = testId;
        this.testName = testName;
        this.testDesc = testDesc;
    }

    public Integer getTestId() {return testId;}

    public void setTestId(Integer testId) {this.testId = testId;}

    public String getTestName() {return testName;}

    public void setTestName(String testName) {this.testName = testName;}

    public String getTestDesc() {return testDesc;}

    public void setTestDesc(String testDesc) {this.testDesc = testDesc;}

    public Test toEntity(Test test){
        test.setTestId(this.testId);
        test.setTestName(this.testName);
        test.setTestDesc(this.testDesc);
        return test;
    }
    public Test toEntity(){
        return toEntity(new Test());
    }
}
