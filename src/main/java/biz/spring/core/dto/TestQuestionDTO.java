package biz.spring.core.dto;


import biz.spring.core.model.TestQuestion;

public class TestQuestionDTO {

    private Integer testQuestionId;

    private String testQuestionText;

    private Integer testId;


    public TestQuestionDTO() {
    }

    public TestQuestionDTO(Integer testQuestionId,
                            String testQuestionText,
                            Integer testId) {
        this.testQuestionId = testQuestionId;
        this.testQuestionText = testQuestionText;
        this.testId = testId;
    }

    public Integer getTestQuestionId() {
        return testQuestionId;
    }

    public void setTestQuestionId(Integer testQuestionId) {
        this.testQuestionId = testQuestionId;
    }

    public String getTestQuestionText() {
        return testQuestionText;
    }

    public void setTestQuestionText(String testQuestionText) {
        this.testQuestionText = testQuestionText;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public TestQuestion toEntity(TestQuestion testQuestion){
        testQuestion.setTestQuestionId(this.testQuestionId);
        testQuestion.setTestQuestionText(this.testQuestionText);
        testQuestion.setTestId(this.testId);
        return testQuestion;
    }

}