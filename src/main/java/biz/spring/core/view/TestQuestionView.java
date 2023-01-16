package biz.spring.core.view;
import javax.persistence.Column;


public class TestQuestionView {

    @Column(name = "testquestion_id")
    private Integer testQuestionId;

    @Column(name = "testquestion_text")
    private String testQuestionText;

    @Column(name = "test_id")
    private Integer testId;


    public TestQuestionView() {
    }

    public TestQuestionView(Integer testQuestionId,
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
