package biz.spring.core.service;

import biz.spring.core.model.Post;
import biz.spring.core.repository.PostRepository;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.utils.OrmUtils;
import biz.spring.core.utils.Query;
import biz.spring.core.validator.PostValidator;
import biz.spring.core.view.PostView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class PostService extends BaseService<Post>{

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostValidator postValidator;
    @PostConstruct
    public void init(){
        init(postRepository, postValidator);
    }

    @Value("classpath:/script/post/mainSQL.sql")
    Resource mainSQL;

    @Value("classpath:/script/post/mainSqlForOne.sql")
    Resource mainSqlForOne;

    public List<PostView> getAll(GridDataOption gridDataOption){
        boolean findPost = gridDataOption.getNamedFilters().stream().anyMatch(nf -> "postId".equals(nf.getName()) && !nf.getValue().equals(-1));
        return new Query<PostView>(mainSQL)
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
