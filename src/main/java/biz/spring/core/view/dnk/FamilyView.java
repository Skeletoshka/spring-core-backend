package biz.spring.core.view.dnk;

import javax.persistence.Column;

public class FamilyView {

    @Column(name = "family_id")
    private Integer familyId;

    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "child_id")
    private Integer childId;

    public FamilyView() {
    }

    public FamilyView(Integer familyId, Integer parentId, Integer childId) 
    {
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
        this.childId = childId;
    }
}
