package biz.spring.core.controller.dnk;

import biz.spring.core.config.Config;
import biz.spring.core.dto.dnk.AppendixDTO;
import biz.spring.core.model.dnk.Appendix;
import biz.spring.core.repository.DocumentRealRepository;
import biz.spring.core.repository.dnk.AppendixRepository;
import biz.spring.core.service.BaseService;
import biz.spring.core.service.DocumentRealService;
import biz.spring.core.service.dnk.AppendixService;
import biz.spring.core.service.dnk.EMSService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.view.dnk.AppendixView;
import biz.spring.core.response.DataResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.Date;
import java.util.List;

@RestController
@Tag(name = "Контроллер для вложения",
        description = "Контроллер для взаимодействия с объектом \"Вложения\"")
@RequestMapping(value = "/v" + Config.CURRENT_VERSION + "/apps/dnk/objects",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@Transactional
public class AppendixController {

    @Autowired
    private AppendixService appendixService;
    @Autowired
    private AppendixRepository appendixRepository;
    @Autowired
    private DocumentRealService documentRealService;
    @Autowired
    private DocumentRealRepository documentRealRepository;
    @Autowired
    private EMSService emsService;

    private static Logger logger = LoggerFactory.getLogger(AppendixController.class);

    static class GridDataOptionAppendix extends GridDataOption {
        @Schema(description = "" +
                "<ul>" +
                "<li>blockId - Блок" +
                "</ul>")
        public List<NamedFilter> getNamedFilters() {
            return super.getNamedFilters();
        }
    }

    @Operation(summary = "Метод для получения списка объектов\"Вложения\"",
            description = "Возвращает список объектов \"Вложения\" согласно переданному фильтру")
    @RequestMapping(value = "/appendix/getlist", method = RequestMethod.POST)
    public DataResponse<AppendixView> getList(@RequestBody GridDataOptionAppendix gridDataOption) {
        boolean blockFound = gridDataOption.getNamedFilters().stream().anyMatch(nf -> "blockId".equals(nf.getName()));
        if (!blockFound) {
            gridDataOption.getNamedFilters().add(new GridDataOption.NamedFilter("blockId", -1));
        }
        List<AppendixView> result = appendixService.getAll(gridDataOption);
        Integer count = appendixService.getCount(gridDataOption);
        return BaseService.buildResponse(result, gridDataOption, count);
    }

    @Operation(summary = "Метод для получения объекта \"Вложения\" по его идентификатору",
            description = "Возвращает объект \"Вложения\" по его идентификатору." +
                    " Если идентификатор пуст, возвращает объект по умолчанию")
    @RequestMapping(value = "/appendix/get", method = RequestMethod.POST)
    public AppendixDTO get(@RequestBody(required = false) Integer id) {
        if (id == null) {
            return new AppendixDTO();
        } else {
            AppendixView view = appendixService.getOne(id);
            AppendixDTO dto = new AppendixDTO();
            BeanUtils.copyProperties(view, dto);
            return dto;
        }
    }

    @Operation(summary = "Метод для сохранения объекта \"Вложения\"",
            description = "Запись с заполненным идентификатором обновляется, с пустым - вставляется")
    @RequestMapping(value = "/appendix/save", method = RequestMethod.POST)
    public AppendixView save(@RequestBody AppendixDTO appendixDTO) {
        Appendix appendix;
        if (appendixDTO.getAppendixId() == null) {
            appendix = appendixService.add(appendixDTO.toEntity());
        } else {
            appendix = appendixService.edit(appendixDTO.toEntity());
        }
        return appendixService.getOne(appendix.getAppendixId());
    }

    @Operation(summary = "Метод для удаления объекта \"Вложения\"",
            description = "Удаляются записи с переданными идентификаторами")
    @RequestMapping(value = "/appendix/delete", method = RequestMethod.POST)
    public String delete(@RequestBody int[] ids) {
        appendixService.delete(ids);
        return BaseService.STANDARD_SUCCESS;
    }

    @Operation(summary = "Метод для загрузки объекта \"Вложения\"",
        description = "Загружается вложение..")
    @RequestMapping(value = "/appendix/upload", method = RequestMethod.POST,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @CrossOrigin
    public AppendixDTO uploadFile (@RequestParam MultipartFile appendix) {
        if (appendix.isEmpty()) {
            throw new RuntimeException("Выбранный файл не может быть загружен");
        }
        AppendixDTO dto = new AppendixDTO();
        dto.setAppendixName(emsService.upload(appendix));
        logger.info(String.format("Имя файла '%s' загружено успешно.", appendix.getOriginalFilename()));
        return dto;
    }

}
