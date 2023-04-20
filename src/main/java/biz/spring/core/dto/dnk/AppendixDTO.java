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

    @Schema(description = "ИД блока")
    private Integer blockId;

    @Schema(description = "ИД человека")
    private Integer peopleId;

    public AppendixDTO(){
    }

    public AppendixDTO(Integer appendixId,
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

    public Appendix toEntity(){
        return toEntity(new Appendix());
    }

    public Appendix toEntity(Appendix appendix){
        appendix.setAppendixId(this.appendixId);
        appendix.setAppendixName(this.appendixName);
        appendix.setAppendixPath(this.appendixPath);
        appendix.setBlockId(this.blockId);
        appendix.setPeopleId(this.peopleId);
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
