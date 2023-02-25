package biz.spring.core.model.dnk;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "testhistory")
public class TestHistory {
    @Id
    @Column(name = "testhistory_id", nullable = false)
    @NotNull(message = "Поле \"ИД истори ответа\" не может быть NULL")
    private Integer testHistoryId;

    @Column(name = "people_id", nullable = false)
    @NotNull(message = "Поле \"ИД пользователя\" не может быть NULL")
    private Integer peopleId;

    @Column(name = "testquestion_id", nullable = false)
    @NotNull(message = "Поле \"ИД вопрос теста\" не может быть NULL")
    private Integer testQuestionId;

    @Column(name = "answer_id", nullable = false)
    @NotNull(message = "Поле \"ИД ответа\" не может быть NULL")
    private Integer answerId;


    public TestHistory() {
    }

    public TestHistory(Integer testHistoryId, Integer peopleId, Integer testQuestionId, Integer answerId) {
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
}
