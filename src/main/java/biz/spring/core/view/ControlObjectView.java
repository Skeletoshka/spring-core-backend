package biz.spring.core.view;

import javax.persistence.Column;

public class ControlObjectView {

    @Column(name = "controlobject_id")
    private Integer controlObjectId;

    @Column(name = "controlobject_url")
    private String controlObjectUrl;

    @Column(name = "controlobject_name")
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
