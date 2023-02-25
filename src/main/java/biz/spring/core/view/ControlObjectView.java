package biz.spring.core.view;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;

public class ControlObjectView {

    @Column(name = "controlobject_id")
    @Schema(description = "ИД контроллируемого объекта")
    private Integer controlObjectId;

    @Column(name = "controlobject_url")
    @Schema(description = "URL контроллируемого объекта")
    private String controlObjectUrl;

    @Column(name = "controlobject_name")
    @Schema(description = "Наименование контроллируемого объекта")
    private String controlObjectName;

    public ControlObjectView() {
    }

    public ControlObjectView(Integer controlObjectId,
                         String controlObjectUrl,
                         String controlObjectName) {
        this.controlObjectId = controlObjectId;
        this.controlObjectUrl = controlObjectUrl;
        this.controlObjectName = controlObjectName;
    }

    public Integer getControlObjectId() {
        return controlObjectId;
    }

    public void setControlObjectId(Integer controlObjectId) {
        this.controlObjectId = controlObjectId;
    }

    public String getControlObjectUrl() {
        return controlObjectUrl;
    }

    public void setControlObjectUrl(String controlObjectUrl) {
        this.controlObjectUrl = controlObjectUrl;
    }

    public String getControlObjectName() {
        return controlObjectName;
    }

    public void setControlObjectName(String controlObjectName) {
        this.controlObjectName = controlObjectName;
    }
}
