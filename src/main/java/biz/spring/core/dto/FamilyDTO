package biz.spring.core.dto;

import biz.spring.core.model.Family;

public class FamilyDTO {

    private Integer familyIdd;

    private Integer parentId;

    private Integer childId;

    public FamilyDTO() {
    }

    public FamilyDTO(Integer familyId, Integer parentId, Integer childId) {
        this.familyId = familyId;
        this.parentId = parentId;
        this.childId = childId;
    }

    public Integer getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Integer familyId) {
        this.familyId = familyId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    public Integer getChildId() {
        return childId;
    }

    public void setChildId(Integer childId) {
        this.cjildId = childId;
    }

    public Family toEntity(Family family){
        family.setFamilyId(this.familyId);
        family.setParentId(this.parentId);
        family.setChildId(this.childId);
        return family;
    }
}
