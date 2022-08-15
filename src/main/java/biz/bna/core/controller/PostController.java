package biz.bna.core.controller;

import biz.bna.core.service.PostService;
import biz.bna.core.view.PostView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/getlist", method = RequestMethod.POST)
    public List<PostView> getList(){
        return postService.getAll();
    }
}
