package biz.spring.core.dto.dnk;

import biz.spring.core.model.dnk.Block;
import io.swagger.v3.oas.annotations.media.Schema;

public class BlockDTO {

    @Schema(description = "ИД Блока")
    private Integer blockId;

    @Schema(description = "Наименование Блока")
    private String blockName;

    @Schema(description = "ИД программы обучения")
    private Integer studyProgramId;

    @Schema(description = "Нумерация блока")
    private Integer blockNum;

    @Schema(description = "Видимость Блока")
    private Integer blockVisible;

    @Schema(description = "ИД классификатора")
    private Integer capclassId;

    public BlockDTO(){
    }

    public BlockDTO(Integer blockId,
                    String blockName,
                    Integer studyProgramId,
                    Integer blockNum,
                    Integer blockVisible,
                    Integer capclassId){
        this.blockId = blockId;
        this.blockName = blockName;
        this.studyProgramId = studyProgramId;
        this.blockNum = blockNum;
        this.blockVisible = blockVisible;
        this.capclassId = capclassId;
    }

    public Integer getBlockId() {
        return blockId;
    }

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public Integer getStudyProgramId() {
        return studyProgramId;
    }

    public void setStudyProgramId(Integer studyProgramId) {
        this.studyProgramId = studyProgramId;
    }

    public Integer getBlockNum() {
        return blockNum;
    }

    public void setBlockNum(Integer blockNum) {
        this.blockNum = blockNum;
    }

    public Integer getBlockVisible() {
        return blockVisible;
    }

    public void setBlockVisible(Integer blockVisible) {
        this.blockVisible = blockVisible;
    }

    public Integer getCapclassId() {
        return capclassId;
    }

    public void setCapclassId(Integer capclassId) {
        this.capclassId = capclassId;
    }

    public Block toEntity() { return toEntity(new Block()); }

    public Block toEntity(Block entity){
        entity.setBlockId(this.blockId);
        entity.setBlockName(this.blockName);
        entity.setStudyProgramId(this.studyProgramId);
        entity.setBlockNum(this.blockNum);
        entity.setBlockVisible(this.blockVisible);
        entity.setCapclassId(this.capclassId);
        return entity;
    }
}
