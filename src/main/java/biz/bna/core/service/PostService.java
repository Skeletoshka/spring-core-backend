package biz.bna.core.service;

import biz.bna.core.model.Post;
import biz.bna.core.repository.PostRepository;
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

    public List<PostView> getAll(){
        List<Post> posts = postRepository.getAll();
        List<PostView> postViews = new ArrayList<>();
        posts.forEach(post -> {
            PostView view = new PostView();
            BeanUtils.copyProperties(post, view);
            postViews.add(view);
        });
        return postViews;
    }

    public void save(Post post){
        postRepository.insert(post);
    }
}
