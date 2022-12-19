package biz.spring.core.service;

import biz.spring.core.model.Post;
import biz.spring.core.repository.PostRepository;
import biz.spring.core.utils.Query;
import biz.spring.core.view.PostView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService extends BaseService<Post>{

    @Autowired
    private PostRepository postRepository;

    // Тут был Тимур
    private final String mainSql = "" +
            "SELECT * " +
            "FROM post";

    private final String mainSqlForOne = "" +
            "SELECT * " +
            "FROM post " +
            "WHERE post_id = :id";

    public List<PostView> getAll(){
        return new Query<PostView>(mainSql)
                .forClass(PostView.class)
                .execute();
    }

    public PostView getOne(Integer id){
        return new Query<PostView>(mainSqlForOne)
                .forClass(PostView.class)
                .executeOne(id);
    }

    public void save(Post post){
        postRepository.insert(post);
    }
}
