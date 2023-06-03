package biz.spring.core.model;


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
    private Integer appendixId;

    @Column(name = "appendix_name", nullable = false)
    @NotNull(message = "Поле \"Наименование вложения\" не может быть пустым")
    @Size(max = 100, message = "Поле \"Наименование вложения\" не может иметь больше {max} символов")
    private String appendixName;

    @Column(name = "appendix_path", nullable = false)
    @NotNull(message = "Поле \"Ссылка вложения\" не может быть пустым")
    @Size(max = 100, message = "Поле \"Ссылка вложения\" не может иметь больше {max} символов")
    private String appendixPath;

    public Appendix() {
    }

    public Appendix(Integer appendixId,
                    String appendixName,
                    String appendixPath) {
        this.appendixId = appendixId;
        this.appendixName = appendixName;
        this.appendixPath = appendixPath;
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
}
