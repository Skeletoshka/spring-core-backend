package biz.spring.core.view;
import javax.persistence.Column;


public class TestHistoryView {

    @Column(name = "testhistory_id")
    private Integer testHistoryId;

    @Column(name = "people_id")
    private Integer peopleId;

    @Column(name = "testquestion_id")
    private Integer testQuestionId;

    @Column(name = "answer_id")
    private Integer answerId;


    public TestHistoryView() {
    }

    public TestHistoryView(Integer testHistoryId, Integer peopleId, Integer testQuestionId, Integer answerId) {
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