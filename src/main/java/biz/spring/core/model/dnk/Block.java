package biz.spring.core.model.dnk;

import org.junit.jupiter.api.Tag;
import org.springframework.data.relational.core.sql.In;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "block")
public class Block {

    @Id
    @Column(name = "block_id", nullable = false)
    private Integer blockId;

    @Column(name = "block_name", nullable = false)
    @Size(max = 100, message = "\"Поле \\\"Наименование блока\\\" не может быть более {max} символов\")")
    @NotNull(message = "Поле \"Наименование блока\" не может быть NULL")
    private String blockName;

    @Column(name = "studyprogram_id", nullable = false)
    @NotNull(message = "Поле \"ИД программы обучения\" не может быть null")
    private Integer studyProgramId;

    @Column(name = "block_num", nullable = false)
    @NotNull(message = "\"Поле \\\"Нумерация блока\\\" не может быть NULL\"")
    private Integer blockNum;

    @Column(name = "block_visible", nullable = false)
    @NotNull(message = "\"Поле \\\"Отображение блока\\\" не может быть null, ну пчел, ты...\"")
    private Integer blockVisible;

    @Column(name = "capclass_id", nullable = false)
    @NotNull(message = "\"Поле \\\"Копатыч класс\\\" не может быть null\"")
    private Integer capclassId;


    public Block(){
    }


    public Block(Integer blockId,
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
