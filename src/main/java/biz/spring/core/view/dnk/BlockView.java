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
    @Column(name = "studycase_id")
    private Integer studyCaseId;

    @Schema(description = "Нумерация блока")
    @Column(name = "block_num")
    private Integer blockNum;

    @Schema(description = "Видимость блока")
    @Column(name = "block_visible")
    private Integer blockVisible;

    @Schema(description = "ИД классификатора")
    @Column(name = "capclass_id")
    private Integer capClassId;

    @Schema(description = "Описание блока")
    @Column(name = "block_desc")
    private String blockDesc;

    public BlockView(){
    }

    public BlockView(Integer blockId,
                     String blockName,
                     Integer studyCaseId,
                     Integer blockNum,
                     Integer blockVisible,
                     Integer capClassId,
                     String blockDesc){
        this.blockId = blockId;
        this.blockName = blockName;
        this.studyCaseId = studyCaseId;
        this.blockNum = blockNum;
        this.blockVisible = blockVisible;
        this.capClassId = capClassId;
        this.blockDesc = blockDesc;
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

    public Integer getStudyCaseId() {
        return studyCaseId;
    }

    public void setStudyCaseId(Integer studyCaseId) {
        this.studyCaseId = studyCaseId;
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

    public Integer getCapClassId() {
        return capClassId;
    }

    public void setCapClassId(Integer capClassId) {
        this.capClassId = capClassId;
    }

    public String getBlockDesc() {
        return blockDesc;
    }

    public void setBlockDesc(String blockDesc) {
        this.blockDesc = blockDesc;
    }
}

