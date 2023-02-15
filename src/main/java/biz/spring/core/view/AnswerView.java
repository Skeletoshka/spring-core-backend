package biz.spring.core.view;

import javax.persistence.Column;

public class AnswerView {

    @Column(name = "answer_id")
    private Integer answerId;

    @Column(name = "testquestion_id")
    private Integer TestQuestionId;

    @Column(name = "answer_text")
    private String answerText;

    @Column(name = "answer_right")
    private Integer answerRight;

    public AnswerView() {
    }

    public AnswerView(Integer answerId, Integer testQuestionId, String answerText, Integer answerRight) {
        this.answerId = answerId;
        TestQuestionId = testQuestionId;
        this.answerText = answerText;
        this.answerRight = answerRight;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public Integer getTestQuestionId() {return TestQuestionId;}

    public void setTestQuestionId(Integer testQuestionId) {TestQuestionId = testQuestionId;}

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
}