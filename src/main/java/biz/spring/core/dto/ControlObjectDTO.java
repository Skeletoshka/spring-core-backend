package biz.spring.core.dto;

public class ControlObjectDTO {

    private Integer controlObjectId;

    private String controlObjectUrl;

    private String controlObjectName;

    public ControlObjectDTO() {
    }

    public ControlObjectDTO(Integer controlObjectId,
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
