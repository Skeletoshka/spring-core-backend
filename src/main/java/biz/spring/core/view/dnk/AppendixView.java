package biz.spring.core.view.dnk;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;

public class AppendixView {
    @Column(name = "appendix_id")
    @Schema(description = "ИД вложения")
    private Integer appendixId;

    @Column(name = "appendix_name")
    @Schema(description = "Наименование вложения")
    private String appendixName;

    @Column(name = "appendix_path")
    @Schema(description = "Путь вложения")
    private String appendixPath;

    @Column(name = "block_id")
    @Schema(description = "ИД блока")
    private Integer blockId;

    @Column(name = "people_id")
    @Schema(description = "ИД человека")
    private Integer peopleId;

    public AppendixView(){
    }

    public AppendixView(Integer appendixId,
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
