package biz.spring.core.controllers;

import biz.spring.core.config.Config;
import biz.spring.core.dto.AccessRoleDTO;
import biz.spring.core.utils.GridDataOption;
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

public class AccessRoleControllerTest extends IntegratedTest{

    @Test
    @Transactional
    @Rollback
    public void getListTest() throws Exception{
        GridDataOption gridDataOption = new GridDataOption.Builder()
                .setOrderBy("accessRoleId")
                .setRowCount(10)
                .build();

        this.mockMvc.perform(post("/v" + Config.CURRENT_VERSION + "/apps/refbooks/accessrole/getlist")
                        .content(new ObjectMapper().writeValueAsString(gridDataOption))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                //.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"accessRoleId\":1")))
                .andExpect(content().string(containsString("\"accessRoleId\":2")))
                .andExpect(content().string(containsString("\"accessRoleId\":3")));

        gridDataOption = new GridDataOption.Builder()
                .setOrderBy("accessRoleId")
                .setParam("accessRoleVisible", 1)
                .setRowCount(10)
                .build();

        this.mockMvc.perform(post("/v" + Config.CURRENT_VERSION + "/apps/refbooks/accessrole/getlist")
                        .content(new ObjectMapper().writeValueAsString(gridDataOption))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                //.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(not(containsString("\"accessRoleId\":1"))))
                .andExpect(content().string(containsString("\"accessRoleId\":2")))
                .andExpect(content().string(containsString("\"accessRoleId\":3")));
    }

    @Test
    @Transactional
    @Rollback
    public void getTest() throws Exception{
        this.mockMvc.perform(post("/v" + Config.CURRENT_VERSION + "/apps/refbooks/accessrole/get")
                        .content("1")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                //.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"accessRoleId\":1")))
                .andExpect(content().string(not(containsString("\"accessRoleId\":2"))))
                .andExpect(content().string(not(containsString("\"accessRoleId\":3"))));
    }

    @Test
    @Transactional
    @Rollback
    public void saveTest() throws Exception{
        AccessRoleDTO dto = new AccessRoleDTO(null, "TestRole", "Тестовая роль", 1);
        this.mockMvc.perform(post("/v" + Config.CURRENT_VERSION + "/apps/refbooks/accessrole/save")
                        .content(new ObjectMapper().writeValueAsString(dto))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                //.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"accessRoleId\":4")))
                .andExpect(content().string(not(containsString("\"accessRoleId\":2"))))
                .andExpect(content().string(not(containsString("\"accessRoleId\":3"))));
    }
}
