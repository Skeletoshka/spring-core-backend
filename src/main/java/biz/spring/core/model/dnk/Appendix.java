package biz.spring.core.model.dnk;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "appendix")
public class Appendix {

    @Id
    @Column(name = "appendix_id", nullable = false)
    @NotNull(message = "Поле \"ИД вложения\" не может быть пустым")
    private Integer appendixId;

    @Column(name = "appendix_name", nullable = false)
    @NotNull(message = "Поле \"Наименование вложения\" не может быть пустым")
    @Size(max = 100, message = "Поле \"Наименование вложения\" не может иметь больше {max} символов")
    private String appendixName;

    @Column(name = "appendix_path", nullable = false)
    @NotNull(message = "Поле \"Ссылка вложения\" не может быть пустым")
    @Size(max = 100, message = "Поле \"Ссылка вложения\" не может иметь больше {max} символов")
    private String appendixPath;

    @Column(name = "block_id", nullable = false)
    @NotNull(message = "Поле \"ИД блока\" не может быть NULL")
    private Integer blockId;

    @Column(name = "people_id", nullable = false)
    @NotNull(message = "Поле \"ИД человека\" не может быть NULL")
    private Integer peopleId;

    public Appendix() {
    }

    public Appendix(Integer appendixId,
                    String appendixName,
                    String appendixPath,
                    Integer blockId,
                    Integer peopleId) {
        this.appendixId = appendixId;
        this.appendixName = appendixName;
        this.appendixPath = appendixPath;
        this.blockId = blockId;
        this.peopleId = peopleId;
    }

    public Integer getAppendixId() {
        return appendixId;
    }

    public void setAppendixId(Integer appendixId) {
        this.appendixId = appendixId;
    }

    public String getAppendixName() {
        return appendixName;
    }

    public void setAppendixName(String appendixName) {
        this.appendixName = appendixName;
    }

    public String getAppendixPath() {
        return appendixPath;
    }

    public void setAppendixPath(String appendixPath) {
        this.appendixPath = appendixPath;
    }

    public Integer getBlockId() {
        return blockId;
    }

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
    }

    public Integer getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(Integer peopleId) {
        this.peopleId = peopleId;
    }
}
