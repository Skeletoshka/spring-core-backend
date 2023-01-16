package biz.spring.core.view;

import javax.persistence.Column;

public class PeopleTestView {

    @Column(name = "peopletest_id")
    private Integer peopletestId;

    @Column(name = "people_id")
    private Integer peopleId;

    @Column(name = "test_id")
    private Integer testId;

    public PeopleTestView() {
    }

    public PeopleTestView(Integer peopletestId,
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