package biz.spring.core.dto;


import biz.spring.core.model.Test;
import biz.spring.core.model.TestQuestion;
import biz.spring.core.view.AnswerView;

import java.util.List;

public class TestQuestionDTO {

    private Integer testQuestionId;

    private String testQuestionText;

    private Integer testId;

    private List<AnswerDTO> Answers;

    public List<AnswerDTO> getAnswers() {
        return Answers;
    }

    public void setAnswers(List<AnswerDTO> answers) {
        Answers = answers;
    }

    private List<TestHistoryDTO> testHistories;

    public List<TestHistoryDTO> getTestHistories() {
        return testHistories;
    }

    public void setTestHistories(List<TestHistoryDTO> testHistories) {
        this.testHistories = testHistories;
    }

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

    public TestQuestion toEntity(){
        return toEntity(new TestQuestion());
    }
}