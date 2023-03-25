package biz.spring.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @Column(name = "post_id", nullable = false)
    private Integer postId;

    @Column(name = "post_name", nullable = false)
    @NotNull(message = "Поле \"Наименование должности\" не может быть пустым")
    @Size(max = 20, message = "Поле \"Наименование должности\" не может иметь больше {max} символов")
    private String postName;

    public Post() {
    }

    public Post(Integer postId,
                String postName) {
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
