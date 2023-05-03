package biz.spring.core.controllers.dnk;

import biz.spring.core.config.Config;
import biz.spring.core.controllers.IntegratedTest;
import biz.spring.core.dto.dnk.WorkGroupDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class WorkGroupControllerTest extends IntegratedTest {

    @Test
    @Transactional
    @Rollback
    public void getTest() throws Exception{
        this.mockMvc.perform(post("/v" + Config.CURRENT_VERSION + "/apps/dnk/objects/workgroup/get")
                        .content("1")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"workGroupId\":1")));
    }
    @Test
    @Transactional
    @Rollback
    public void saveTest() throws Exception{
        WorkGroupDTO workGroupDTO = new WorkGroupDTO(null, "Тест1111", 2, "Новая группа Тест1111");
        this.mockMvc.perform(post("/v" + Config.CURRENT_VERSION + "/apps/dnk/objects/workgroup/save")
                        .content(new ObjectMapper().writeValueAsString(workGroupDTO))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"workGroupName\":\"Тест1111\"")));

        this.mockMvc.perform(post("/v" + Config.CURRENT_VERSION + "/apps/dnk/objects/workgroup/get")
                        .content("9")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"workGroupId\":9")))
                .andExpect(content().string(containsString("\"workGroupName\":\"Тест1111\"")));
    }
}
