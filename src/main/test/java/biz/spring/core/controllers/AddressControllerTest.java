package biz.spring.core.controllers;

import biz.spring.core.config.Config;
import biz.spring.core.controller.AddressController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AddressControllerTest extends IntegratedTest{

    @Test
    @Transactional
    @Rollback
    public void findTest() throws Exception{
        AddressController.SearchOptions options = new AddressController.SearchOptions();
        options.setSearch("Ветлу");
        this.mockMvc.perform(post("/v" + Config.CURRENT_VERSION + "/apps/refbooks/address/find")
                        .content(new ObjectMapper().writeValueAsString(options))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"streetName\":\"Ветлужская\"")))
                .andExpect(content().string(not(containsString("\"streetName\":\"Попова\""))))
                .andExpect(content().string(not(containsString("\"streetName\":\"Красноводская\""))))
                .andExpect(content().string(not(containsString("\"streetName\":\"Шоссе космонавтов\""))));
    }

}
