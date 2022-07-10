package biz.bna.core.dto;

public class PostDTO {

    private Integer postId;

    private String postName;

    public PostDTO() {
    }

    public PostDTO(Integer postId, String postName) {
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
