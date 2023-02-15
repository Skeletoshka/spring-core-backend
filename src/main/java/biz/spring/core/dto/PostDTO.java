package biz.spring.core.dto;

import biz.spring.core.model.Post;

public class PostDTO {

    private Integer postId;

    private String postName;

    public PostDTO() {
    }

    public PostDTO(Integer postId, String postName) {
        this.postId = postId;
        this.postName = postName;
    }

    public Post toEntity(){
        return toEntity(new Post());
    }

    public Post toEntity(Post post){
        post.setPostId(this.postId);
        post.setPostName(this.postName);
        return post;
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
