package biz.spring.core.controllers.dnk;

import biz.spring.core.config.Config;
import biz.spring.core.controllers.IntegratedTest;
import biz.spring.core.dto.dnk.BlockDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ConcurrentModificationException;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
public class BlockControllerTest extends IntegratedTest {

    @Test
    @Transactional
    @Rollback
    public void getTest() throws Exception{
        this.mockMvc.perform(post("/v" + Config.CURRENT_VERSION + "/apps/dnk/studyprogram/block/get")
                .content("1")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"blockId\":1")));
    }
    @Test
    @Transactional
    @Rollback
    public void saveTest() throws Exception{
        BlockDTO blockDTO = new BlockDTO(null, "Тестовый1", 2, 1, 1, 1, "Тестовый блок");
        this.mockMvc.perform(post("/v" + Config.CURRENT_VERSION + "/apps/dnk/studyprogram/block/save")
                .content(new ObjectMapper().writeValueAsString(blockDTO))
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"blockName\":\"Тестовый1\"")));

        this.mockMvc.perform(post("/v" + Config.CURRENT_VERSION + "/apps/dnk/studyprogram/block/get")
                .content("4")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"blockId\":4")))
                .andExpect(content().string(containsString("\"blockName\":\"Тестовый1\"")));
    }
}
