package biz.spring.core.model.dnk;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "direction")
public class Direction {

    @Id
    @Column(name = "direction_id", nullable = false)
    private Integer directionId;

    @Column(name = "direction_name", nullable = false)
    @NotNull(message = "Поле \"Наименование направления\" не может быть пустым")
    @Size(max = 100, message = "Поле \"Наименование направления\" не может иметь более {max} символов")
    private String directionName;

    @Column(name = "direction_desc", nullable = false)
    @Size(max = 100, message = "Поле \"Описание направления\" не может иметь более {max} символов")
    private String directionDesc;

    public Direction() {
    }

    public Direction(Integer directionId,
                     String directionName,
                     String directionDesc) {
        this.directionId = directionId;
        this.directionName = directionName;
        this.directionDesc = directionDesc;
    }

    public Integer getDirectionId() {
        return directionId;
    }

    public void setDirectionId(Integer directionId) {
        this.directionId = directionId;
    }

    public String getDirectionName() {
        return directionName;
    }

    public void setDirectionName(String directionName) {
        this.directionName = directionName;
    }

    public String getDirectionDesc() {
        return directionDesc;
    }

    public void setDirectionDesc(String directionDesc) {
        this.directionDesc = directionDesc;
    }
}
