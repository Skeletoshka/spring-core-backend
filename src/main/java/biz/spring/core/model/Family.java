package biz.spring.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "family")
public class Family {

    @Id
    @Column(name = "family_id", nullable = false)
    @NotNull(message = "Поле \"ID семьи\" не может быть NULL")
    @Size(max = 5, message = "Поле \"ID семьи\" не может иметь более {max} символов")
    private Integer familyId;

    @Column(name = "parent_id", nullable = false)
    @NotNull(message = "Поле \"ID родителя\" не может быть NULL")
    @Size(max = 5, message = "Поле \"Наименование роли\" не может иметь более {max} символов")
    private Integer parentId;

    @Column(name = "child_id", nullable = false)
    @NotNull(message = "Поле \"ID ребенка\" не может быть NULL")
    @Size(max = 5, message = "Поле \"Наименование роли\" не может иметь более {max} символов")
    private Integer childId;

    public Family() {
    }

    public Family(Integer familyId, Integer parentId, Integer childId) {
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
