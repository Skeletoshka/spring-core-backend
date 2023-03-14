package biz.spring.core.view.dnk;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;

public class BlockView {

    @Schema(description = "ИД блока")
    @Column(name = "block_id")
    private Integer blockId;

    @Schema(description = "Наименование блока")
    @Column(name = "block_name")
    private String blockName;

    @Schema(description = "ИД программы обучения")
    @Column(name = "studyprogram_id")
    private Integer studyProgramId;

    @Schema(description = "Нумерация блока")
    @Column(name = "block_num")
    private Integer blockNum;

    @Schema(description = "Видимость блока")
    @Column(name = "block_visible")
    private Integer blockVisible;

    @Schema(description = "ИД классификатора")
    @Column(name = "capclass_id")
    private Integer capclassId;

    public BlockView(){
    }

    public BlockView(Integer blockId,
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
}

