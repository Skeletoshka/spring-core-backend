package biz.spring.core.controllers;

import biz.spring.core.payload.request.LoginRequest;
import biz.spring.core.payload.response.JwtResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
public class IntegratedTest {

    static public Logger logger = LoggerFactory.getLogger(IntegratedTest.class);

    public MockMvc mockMvc;

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    WebApplicationContext webApplicationContext;

    static boolean start = false;

    @BeforeEach
    void beforeRunTest(){

        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .defaultRequest(post("/")
                        .header("Authorization","Bearer b70cd02a-7933-11ed-a1eb-0242ac120002")
                        .header("Content-Type", "application/json;charset=UTF-8"))
                .apply(springSecurity())
                .build();
        if(!start) {
            onStart();
            start = true;
        }
    }

    protected void onStart() {

    }
}
