package biz.spring.core.dto;

import biz.spring.core.model.Answer;

public class AnswerDTO {

    private Integer answerId;

    private Integer testQuestionId;

    private String answerText;

    private Integer answerRight;

    public AnswerDTO() {
    }

    public AnswerDTO(Integer answerId, Integer testQuestionId, String answerText, Integer answerRight) {
        this.answerId = answerId;
        this.testQuestionId = testQuestionId;
        this.answerText = answerText;
        this.answerRight = answerRight;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public Integer getTestQuestionId() {return testQuestionId;}

    public void setTestQuestionId(Integer testQuestionId) {this.testQuestionId = testQuestionId;}

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public Integer getAnswerRight() {
        return answerRight;
    }

    public void setAnswerRight(Integer answerRight) {
        this.answerRight = answerRight;
    }

    public Answer toEntity(Answer answer){
        answer.setAnswerId(this.answerId);
        answer.setTestQuestionId(this.testQuestionId);
        answer.setAnswerText(this.answerText);
        answer.setAnswerRight(this.answerRight);
        return answer;
    }
}