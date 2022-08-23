package biz.bna.core.service;

import biz.bna.core.model.Post;
import biz.bna.core.repository.PostRepository;
import biz.bna.core.utils.Query;
import biz.bna.core.view.PostView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService extends BaseService<Post>{

    @Autowired
    private PostRepository postRepository;

    private String mainSql = "" +
            "SELECT * " +
            "FROM post";

    private String mainSqlForOne = "" +
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
