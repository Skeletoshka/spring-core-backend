package biz.spring.core.view;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;

public class PostView {

    @Column(name = "post_id")
    @Schema(description = "ИД должности")
    private Integer postId;

    @Column(name = "post_name")
    @Schema(description = "Наименование должности")
    private String postName;

    public PostView() {
    }

    public PostView(Integer postId, String postName) {
        this.postId = postId;
        this.postName = postName;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }
}
