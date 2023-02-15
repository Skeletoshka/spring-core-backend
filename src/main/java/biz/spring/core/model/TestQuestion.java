package biz.spring.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "testquestion")
public class TestQuestion {

    @Id
    @Column(name = "testquestion_id", nullable = false)
    @NotNull(message = "Поле \"ИД вопрос теста\" не может быть NULL")
    private Integer testQuestionId;

    @Column(name = "testquestion_text", nullable = false)
    @NotNull(message = "Поле \"Текст вопроса теста\" не может быть NULL")
    @Size(max = 100, message = "Поле \"Текст вопроса теста\" не может иметь более {max} символов")
    private String testQuestionText;

    @Column(name = "test_id", nullable = false)
    @NotNull(message = "Поле \"ИД теста\" не может быть NULL")
    private Integer testId;


    public TestQuestion() {
    }

    public TestQuestion(Integer testQuestionId,
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
}
