package biz.spring.core.dto.dnk;

import biz.spring.core.model.dnk.Direction;
import io.swagger.v3.oas.annotations.media.Schema;

public class DirectionDTO {

    @Schema(description = "ИД направления")
    private Integer directionId;

    @Schema(description = "Имя направления")
    private String directionName;

    @Schema(description = "Описание направления")
    private String directionDesc;

    public DirectionDTO() {
    }

    public DirectionDTO(Integer directionId,
                         String directionName,
                         String directionDesc) {
        this.directionId = directionId;
        this.directionName = directionName;
        this.directionDesc = directionDesc;
    }

    public Direction toEntity(){
        return toEntity(new Direction());
    }

    public Direction toEntity(Direction direction){
        direction.setDirectionId(this.directionId);
        direction.setDirectionName(this.directionName);
        direction.setDirectionDesc(this.directionDesc);
        return direction;
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
