package biz.spring.core.view.dnk;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;

public class DirectionView {

    @Column(name = "direction_id")
    @Schema(description = "ИД направления")
    private Integer directionId;

    @Column(name = "direction_name")
    @Schema(description = "Имя направления")
    private String directionName;

    @Column(name = "direction_desc")
    @Schema(description = "Описание направления")
    private String directionDesc;

    public DirectionView() {
    }

    public DirectionView(Integer directionId,
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
