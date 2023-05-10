package biz.spring.core.controllers.dnk;

import biz.spring.core.config.Config;
import biz.spring.core.controllers.IntegratedTest;
import biz.spring.core.dto.dnk.AppendixDTO;
import biz.spring.core.utils.GridDataOption;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AppendixControllerTest extends IntegratedTest {

    @Test
    @Rollback
    @Transactional
    public void getListTest() throws Exception {

        GridDataOption gridDataOption = new GridDataOption.Builder()
                .setRowCount(10)
                .setPage(1)
                .setParam("appendixId", 1)
                .setOrderBy("appendixId")
                .build();

        this.mockMvc.perform(post("/v" + Config.CURRENT_VERSION + "/apps/dnk/objects/appendix/getlist")
                        .content(new ObjectMapper().writeValueAsString(gridDataOption))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"appendixId\":1")));
    }

    @Test
    @Rollback
    @Transactional
    public void getTest() throws Exception {
        this.mockMvc.perform(post("/v" + Config.CURRENT_VERSION + "/apps/dnk/objects/appendix/get")
                        .content("1")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"appendixId\":1")));
    }
    @Test
    @Transactional
    @Rollback
    public void saveTest() throws Exception {
        AppendixDTO dto = new AppendixDTO(null, "Тестовый отчётный материал 4",
                "Тестовый отчётный материал 4.txt");
        this.mockMvc.perform(post("/v" + Config.CURRENT_VERSION + "/apps/dnk/objects/appendix/save")
                .content(new ObjectMapper().writeValueAsString(dto))
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"appendixName\":\"Тестовый отчётный материал 4\"")));

    }

    @Test
    @Rollback
    @Transactional
    public void uploadTest() throws Exception {
        MockMultipartFile file
                = new MockMultipartFile(
                "file",
                "Тестовый отчётный материал 4.txt",
                MediaType.APPLICATION_OCTET_STREAM_VALUE,
                "Тестовый текст".getBytes()
        );
        this.mockMvc.perform(multipart("/v" + Config.CURRENT_VERSION + "/apps/dnk/objects/appendix/upload")
                        .file(file)
                        .contentType(MediaType.MULTIPART_FORM_DATA_VALUE))
                .andExpect(status().isOk());
    }
}
