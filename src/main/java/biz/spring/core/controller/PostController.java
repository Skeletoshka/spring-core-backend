package biz.spring.core.controller;

import biz.spring.core.dto.PostDTO;
import biz.spring.core.model.Post;
import biz.spring.core.service.PostService;
import biz.spring.core.view.PostView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/post",
        consumes = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8",
        produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/getlist", method = RequestMethod.POST)
    public List<PostView> getList(){
        return postService.getAll();
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public PostDTO get(@RequestBody(required = false) int id){
        if(id == 0){
            return new PostDTO();
        } else {
            PostView view = postService.getOne(id);
            PostDTO dto = new PostDTO();
            BeanUtils.copyProperties(view, dto);
            return dto;
        }
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public List<PostView> save(@RequestBody Post post){
        postService.save(post);
        return postService.getAll();
    }
}
