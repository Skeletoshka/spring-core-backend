package biz.spring.core.model.dnk;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "answer")
public class Answer {

    @Id
    @Column(name = "answer_id", nullable = false)
    private Integer answerId;

    @Column(name = "testquestion_id", nullable = false)
    @NotNull(message = "Поле \"ИД вопроса\" не может быть NULL")
    private Integer testQuestionId;



    @Column(name = "answer_text", nullable = false)
    @NotNull(message = "Поле \"Текст ответа\" не может быть NULL")
    @Size(max = 200, message = "Поле \"Текст ответа\" не может иметь более {max} символов")
    private String answerText;


    @Column(name = "answer_right", nullable = false)
    @NotNull(message = "Поле \"Правильный ответ\" не может быть NULL")
    private Integer answerRight;

    public Answer() {
    }

    public Answer(Integer answerId, Integer testQuestionId, String answerText, Integer answerRight) {
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
}


