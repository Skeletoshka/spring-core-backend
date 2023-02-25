package biz.spring.core.model.dnk;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "test")
public class Test {
    @Id
    @Column(name = "test_id", nullable = false)
    @NotNull(message = "Поле \"ИД теста\" не может быть NULL")
    private Integer testId;

    @Column(name = "test_name", nullable = false)
    @NotNull(message = "Поле \"Название теста\" не может быть NULL")
    @Size(max = 100, message = "Поле \"Название теста\" не может иметь более {max} символов")
    private String testName;

    @Column(name = "test_desc", nullable = true)
    @Size(max = 300, message = "Поле \"Описание теста\" не может иметь более {max} символов")
    private String testDesc;

    public Test() {
    }

    public Test(Integer testId,
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
