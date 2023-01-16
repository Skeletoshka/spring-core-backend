package biz.spring.core.dto;

import biz.spring.core.model.PeopleTest;

public class PeopleTestDTO {

    private Integer peopletestId;

    private Integer peopleId;

    private Integer testId;

    public PeopleTestDTO() {
    }

    public PeopleTestDTO(Integer peopletestId,
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

    public PeopleTest toEntity(PeopleTest peopleTest){
        peopleTest.setPeopletestId(this.peopletestId);
        peopleTest.setPeopleId(this.peopleId);
        peopleTest.setTestId(this.testId);
        return peopleTest;
    }
}