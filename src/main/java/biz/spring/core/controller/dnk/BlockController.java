package biz.spring.core.controller.dnk;

import biz.spring.core.config.Config;
import biz.spring.core.dto.dnk.BlockDTO;
import biz.spring.core.model.dnk.Block;
import biz.spring.core.service.BaseService;
import biz.spring.core.service.dnk.BlockService;
import biz.spring.core.view.dnk.BlockView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Контроллер для блоков", description = "Контроллер для работы с таблицей \"Блоки\"")
@RequestMapping(value = "/v" + Config.CURRENT_VERSION + "/apps/dnk/studyprogram",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@Transactional
public class BlockController {

    @Autowired
    private BlockService blockService;


    @RequestMapping(value = "/block/get", method = RequestMethod.POST)
    @Operation(summary = "Возвращает объект \"Блоки\"",
            description = "Возвращает объект \"Блоки\" по его идентификатору. При отсутствии идентификатора - " +
                    "возвращается объект с полями по умолчанию")
    public BlockDTO get(@RequestBody(required = false) Integer id){
        if(id == null){
            return new BlockDTO();
        } else {
            BlockView view = blockService.getOne(id);
            BlockDTO dto = new BlockDTO();
            BeanUtils.copyProperties(view, dto);
            return dto;
        }
    }
    @RequestMapping(value = "/block/save", method = RequestMethod.POST)
    @Operation(summary = "Метод для сохранения объекта \"Блоки\"",
            description = "Запись с заполненным идентификатором обновляется, а с пустым вставляется")
    public BlockView save(@RequestBody BlockDTO blockDTO){
        Block block;
        if(blockDTO.getBlockId()==null){
            block = blockService.add(blockDTO.toEntity());
        }else {
            block = blockService.edit(blockDTO.toEntity());
        }
        return blockService.getOne(block.getBlockId());
    }

    @RequestMapping(value = "/block/delete", method = RequestMethod.POST)
    @Operation(summary = "Метод для удаления объекта \"Блоки\"",
            description = "Удаляются записи с переданными идентификаторами")
    public String delete(@RequestBody int[] ids){
        blockService.delete(ids);
        return BaseService.STANDARD_SUCCESS;
    }
}