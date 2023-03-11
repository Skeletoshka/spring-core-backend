package biz.spring.core.view.dnk;

import javax.persistence.Column;

public class BlockView {

    @Column(name = "block_id")
    private Integer blockId;

    @Column(name = "block_name")
    private String blockName;

    @Column(name = "studyprogram_id")
    private Integer studyProgramId;

    @Column(name = "block_num")
    private Integer blockNum;

    @Column(name = "block_visible")
    private Integer blockVisible;

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

