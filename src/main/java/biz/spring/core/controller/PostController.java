package biz.spring.core.controller;

import biz.spring.core.annotations.CheckAdminRole;
import biz.spring.core.annotations.CheckAnyRole;
import biz.spring.core.config.Config;
import biz.spring.core.dto.PostDTO;
import biz.spring.core.repository.PostRepository;
import biz.spring.core.service.PostService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.view.PostView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//TODO тестовый контроллер. В системе НЕ используется. Используется для примера
@RestController
@Tag(name = "Контроллер для должностей", description = "Контроллер для взаимодействия с объектом \"Должность\"")
@RequestMapping(value = "/v" + Config.CURRENT_VERSION + "/apps/refbooks",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@Transactional
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    static class GridDataOptionPost extends GridDataOption{
        @Schema(description = "" +
                "<ul>" +
                    "<li>postId - ИД должности" +
                "<ul>")
        public String getNamedFilters(){
            return super.getNamedFilters();
        }
    }

    @RequestMapping(value = "/post/getlist", method = RequestMethod.POST)
    @Operation(summary = "Метод для получения списка объектов \"Должность\"", description = "Возвращает список объектов " +
            "\"Должность\" согласно переданным параметрам")
    @CheckAdminRole
    public List<PostView> getList(@RequestBody GridDataOptionPost gridDataOptionPost){
        boolean findPost = gridDataOptionPost.getParams().get("postId") != null;
        if(!findPost){
            gridDataOptionPost.getParams().put("postId", -1);
        }
        return postService.getAll(gridDataOptionPost);
    }

    @RequestMapping(value = "/post/get", method = RequestMethod.POST)
    @Operation(summary = "Метод для получения объекта \"Должность\" по его идентификатору", description = "Возвращает " +
            "объект \"Должность\" по его идентификатору. Если идентификатора нет, возвращается пустая должность (Для " +
            "добавления)")
    @CheckAnyRole
    public PostDTO get(@RequestBody(required = false) Integer id){
        if(id == null){
            return new PostDTO();
        } else {
            PostView view = postService.getOne(id);
            PostDTO dto = new PostDTO();
            BeanUtils.copyProperties(view, dto);
            return dto;
        }
    }

    @RequestMapping(value = "/post/save", method = RequestMethod.POST)
    @Operation(summary = "Метод для сохранения объекта \"Должность\"")
    public PostView save(@RequestBody PostDTO postDTO){
        if(postDTO.getPostId() == null){
            postDTO.setPostId(postRepository.insert(postDTO.toEntity()));
        }else{
            postRepository.update(postDTO.toEntity());
        }
        return postService.getOne(postDTO.getPostId());
    }
}
