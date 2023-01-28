package biz.spring.core.dto;


import biz.spring.core.model.Answer;
import biz.spring.core.model.Test;
import biz.spring.core.model.TestHistory;

public class TestHistoryDTO {

    private Integer testHistoryId;

    private Integer peopleId;

    private Integer testQuestionId;

    private Integer answerId;


    public TestHistoryDTO() {
    }

    public TestHistoryDTO(Integer testHistoryId, Integer peopleId, Integer testQuestionId, Integer answerId) {
        this.testHistoryId = testHistoryId;
        this.peopleId = peopleId;
        this.testQuestionId = testQuestionId;
        this.answerId = answerId;
    }

    public Integer getTestHistoryId() {
        return testHistoryId;
    }

    public void setTestHistoryId(Integer testHistoryId) {
        this.testHistoryId = testHistoryId;
    }

    public Integer getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(Integer peopleId) {
        this.peopleId = peopleId;
    }

    public Integer getTestQuestionId() {
        return testQuestionId;
    }

    public void setTestQuestionId(Integer testQuestionId) {
        this.testQuestionId = testQuestionId;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public TestHistory toEntity(TestHistory testHistory){
        testHistory.setTestHistoryId(this.testHistoryId);
        testHistory.setPeopleId(this.peopleId);
        testHistory.setTestQuestionId(this.testQuestionId);
        testHistory.setAnswerId(this.answerId);
        return testHistory;
    }

    public TestHistory toEntity(){
        return toEntity(new TestHistory());
    }
}