package biz.spring.core.controllers.dnk;

import biz.spring.core.config.Config;
import biz.spring.core.controllers.IntegratedTest;
import biz.spring.core.dto.dnk.StudyCaseDTO;
import biz.spring.core.utils.GridDataOption;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class StudyCaseControllerTest extends IntegratedTest {

    @Test
    @Rollback
    @Transactional
    public void getListTest() throws Exception {

        GridDataOption gridDataOption = new GridDataOption.Builder()
                .setRowCount(10)
                .setPage(1)
                .setParam("studyCaseId", 1)
                .setOrderBy("studyCaseId")
                .build();

        this.mockMvc.perform(post("/v" + Config.CURRENT_VERSION + "/apps/dnk/studyprogram/studycase/getlist")
                .content(new ObjectMapper().writeValueAsString(gridDataOption))
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"studyCaseId\":1")));
    }

    @Test
    @Transactional
    @Rollback
    public void getTest() throws Exception{
        this.mockMvc.perform(post("/v" + Config.CURRENT_VERSION + "/apps/dnk/studyprogram/studycase/get")
                .content("1")
                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"studyCaseId\":1")));
    }

    @Test
    @Transactional
    @Rollback
    public void saveTest() throws Exception{
        StudyCaseDTO studyCaseDTO = new StudyCaseDTO(null, 1, "Лучший подарок Backend-разработчику", "Хоть убей, не понимаю", 1, 1);
        this.mockMvc.perform(post("/v" + Config.CURRENT_VERSION + "/apps/dnk/studyprogram/studycase/save")
                .content(new ObjectMapper().writeValueAsString(studyCaseDTO))
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"studyCaseName\":\"Лучший подарок Backend-разработчику\"")));

        this.mockMvc.perform(post("/v" + Config.CURRENT_VERSION + "/apps/dnk/studyprogram/studycase/get")
                .content("4")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"studyCaseId\":4")))
                .andExpect(content().string(containsString("\"studyCaseName\":\"Лучший подарок Backend-разработчику\"")));
    }
}
