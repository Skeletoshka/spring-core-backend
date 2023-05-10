package biz.spring.core.dto.dnk;

import biz.spring.core.model.dnk.Appendix;
import io.swagger.v3.oas.annotations.media.Schema;

public class AppendixDTO {

    @Schema(description = "ИД вложения")
    private Integer appendixId;

    @Schema(description = "Наименование вложения")
    private String appendixName;

    @Schema(description = "Путь вложения")
    private String appendixPath;
    public AppendixDTO(){
    }

    public AppendixDTO(Integer appendixId,
                    String appendixName,
                    String appendixPath) {
        this.appendixId = appendixId;
        this.appendixName = appendixName;
        this.appendixPath = appendixPath;
    }

    public Appendix toEntity(){
        return toEntity(new Appendix());
    }

    public Appendix toEntity(Appendix appendix){
        appendix.setAppendixId(this.appendixId);
        appendix.setAppendixName(this.appendixName);
        appendix.setAppendixPath(this.appendixPath);
        return appendix;
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
