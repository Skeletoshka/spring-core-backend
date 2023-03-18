package biz.spring.core.service;

import biz.spring.core.controller.PostController;
import biz.spring.core.model.Post;
import biz.spring.core.repository.PostRepository;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.utils.Query;
import biz.spring.core.view.PostView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class PostService extends BaseService<Post>{

    @Autowired
    private PostRepository postRepository;

    @PostConstruct
    public void init(){
        init(postRepository);
    }

    private final String mainSql = "" +
            "SELECT * " +
            "FROM post " +
            "WHERE 1=1 " +
            "/*POST_PLACEHOLDER*/";

    private final String mainSqlForOne = "" +
            "SELECT * " +
            "FROM post " +
            "WHERE post_id = :id";

    public List<PostView> getAll(GridDataOption gridDataOption){
        boolean findPost = gridDataOption.getNamedFilters().stream().anyMatch(nf -> "postId".equals(nf.getName()) && !nf.getValue().equals(-1));
        return new Query<PostView>(mainSql)
                .setLimit(gridDataOption.buildPageRequest())
                .setOrderBy(gridDataOption.getOrderBy())
                .setParams(gridDataOption.buildParams())
                .injectSqlIf(findPost, "/*POST_PLACEHOLDER*/", " AND post_id = :postId")
                .forClass(PostView.class)
                .execute();
    }

    public PostView getOne(Integer id){
        return new Query<PostView>(mainSqlForOne)
                .forClass(PostView.class)
                .executeOne(id);
    }

}
