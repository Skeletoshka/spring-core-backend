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

    @Column(name = "studycase_id", nullable = false)
    @NotNull(message = "Поле \"ИД кейса обучения\" не может быть null")
    private Integer studyCaseId;

    @Column(name = "block_num", nullable = false)
    @NotNull(message = "\"Поле \\\"Нумерация блока\\\" не может быть NULL\"")
    private Integer blockNum;

    @Column(name = "block_visible", nullable = false)
    @NotNull(message = "\"Поле \\\"Отображение блока\\\" не может быть null, ну пчел, ты...\"")
    private Integer blockVisible;

    @Column(name = "capclass_id", nullable = false)
    @NotNull(message = "\"Поле \\\"Копатыч класс\\\" не может быть null\"")
    private Integer capclassId;

    @Column(name = "block_desc", nullable = false)
    @Size(max = 255, message = "\"Поле \\\"Описание блока\\\" не может быть более {max} символов\")")
    private String blockDesc;

    public Block(){
    }


    public Block(Integer blockId,
                 String blockName,
                 Integer studyCaseId,
                 Integer blockNum,
                 Integer blockVisible,
                 Integer capclassId,
                 String blockDesc){
        this.blockId = blockId;
        this.blockName = blockName;
        this.studyCaseId = studyCaseId;
        this.blockNum = blockNum;
        this.blockVisible = blockVisible;
        this.capclassId = capclassId;
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

    public Integer getCapclassId() {
        return capclassId;
    }

    public void setCapclassId(Integer capclassId) {
        this.capclassId = capclassId;
    }

    public String getBlockDesc() {
        return blockDesc;
    }

    public void setBlockDesc(String blockDesc) {
        this.blockDesc = blockDesc;
    }
}
