package biz.spring.core.controller;

import biz.spring.core.annotations.CheckAdminRole;
import biz.spring.core.annotations.CheckAnyRole;
import biz.spring.core.dto.PostDTO;
import biz.spring.core.model.Post;
import biz.spring.core.repository.PostRepository;
import biz.spring.core.service.PostService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.view.PostView;
import org.junit.jupiter.api.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(value = "Контроллер для должностей")
@RequestMapping(value = "/api/post",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@Transactional
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    static class GridDataOptionPost extends GridDataOption{
        public GridDataOptionPost(){
            super("" +
                    "postId - ИД должности");
        }
    }

    @RequestMapping(value = "/getlist", method = RequestMethod.POST)
    @Tag(value = "Метод для получения списка объектов \"Должность\"")
    @CheckAdminRole
    public List<PostView> getList(@RequestBody GridDataOptionPost gridDataOptionPost){
        boolean findPost = gridDataOptionPost.getParams().get("postId") != null;
        if(!findPost){
            gridDataOptionPost.getParams().put("postId", -1);
        }
        return postService.getAll(gridDataOptionPost);
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @Tag(value = "Метод для получения объекта \"Должность\" по его идентификатору")
    @CheckAnyRole
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
    @Tag(value = "Метод для сохранения объекта \"Должность\"")
    public PostView save(@RequestBody PostDTO postDTO){
        if(postDTO.getPostId() == null){
            postDTO.setPostId(postRepository.insert(postDTO.toEntity()));
        }else{
            postRepository.update(postDTO.toEntity());
        }
        return postService.getOne(postDTO.getPostId());
    }
}
