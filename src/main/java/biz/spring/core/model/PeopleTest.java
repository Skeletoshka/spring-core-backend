package biz.spring.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "peopletest")
public class PeopleTest {
    @Id
    @Column(name = "peopletest_id", nullable = false)
    @NotNull(message = "Поле \"ИД теста пользователя\" не может быть NULL")
    private Integer peopletestId;

    @Column(name = "people_id", nullable = false)
    @NotNull(message = "Поле \"ИД пользователя\" не может быть NULL")
    private Integer peopleId;

    @Column(name = "test_id", nullable = false)
    @NotNull(message = "Поле \"ИД теста\" не может быть NULL")
    private Integer testId;

    public PeopleTest() {
    }

    public PeopleTest(Integer peopletestId,
                      Integer peopleId,
                      Integer testId) {
        this.peopletestId = peopletestId;
        this.peopleId = peopleId;
        this.testId = testId;
    }

    public Integer getPeopletestId() {return peopletestId;}

    public void setPeopletestId(Integer peopletestId) {this.peopletestId = peopletestId;}

    public Integer getPeopleId() {return peopleId;}

    public void setPeopleId(Integer peopleId) {this.peopleId = peopleId;}

    public Integer getTestId() {return testId;}

    public void setTestId(Integer testId) {this.testId = testId;}
}
