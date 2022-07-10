package biz.bna.core.view;

public class PostView {
    private Integer postId;

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
