package biz.spring.core.view;

import javax.persistence.Column;

public class TestView{

    @Column(name = "test_id")
    private Integer testId;

    @Column(name = "test_name")
    private String testName;

    @Column(name = "test_desc")
    private String testDesc;

    public TestView() {
    }

    public TestView(Integer testId,
                    String testName,
                    String testDesc) {
        this.testId = testId;
        this.testName = testName;
        this.testDesc = testDesc;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestDesc() {
        return testDesc;
    }

    public void setTestDesc(String testDesc) {
        this.testDesc = testDesc;
    }
}
