package biz.spring.core.controller;

import biz.spring.core.config.Config;
import biz.spring.core.service.AddressService;
import biz.spring.core.view.AddressView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Tag(name = "Контроллер для адреса", description = "Контроллер для получения адреса")
@RequestMapping(value = "/v" + Config.CURRENT_VERSION + "/apps/refbooks",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@Transactional
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Operation(summary = "Возвращает список объектов \"Адрес\"",
            description = "Вовзращает список объектов согласно переданной строке. Строка должна быть от 4 символов.")
    @RequestMapping(value = "/address/find", method = RequestMethod.POST)
    public List<AddressView> find(@RequestBody SearchOptions searchOptions){
        if(searchOptions.getSearch().length() < 4){
            return new ArrayList<AddressView>();
        }else{
            return addressService.find(searchOptions.getSearch());
        }
    }

    public static class SearchOptions{

        @Schema(description = "Строка для поиска")
        private String search;

        public SearchOptions() {
        }

        public SearchOptions(String search) {
            this.search = search;
        }

        public String getSearch() {
            return search;
        }

        public void setSearch(String search) {
            this.search = search;
        }
    }
}
