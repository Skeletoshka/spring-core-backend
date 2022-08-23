package biz.bna.core.controller;

import biz.bna.core.dto.PostDTO;
import biz.bna.core.model.Post;
import biz.bna.core.service.PostService;
import biz.bna.core.view.PostView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/post",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/getlist", method = RequestMethod.POST)
    public List<PostView> getList(){
        return postService.getAll();
    }

    //TODO найти как десериализовать объект String в Int
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public PostDTO get(@RequestBody(required = false) String id){
        if(id == null){
            return new PostDTO();
        } else {
            PostView view = postService.getOne(Integer.parseInt(id));
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
