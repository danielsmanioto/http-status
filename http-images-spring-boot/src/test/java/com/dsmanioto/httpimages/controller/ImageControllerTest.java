package com.dsmanioto.httpimages.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ImageControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void getImageByCodeSuccess() throws Exception {
        mvc.perform(get("/images/100"))
                .andExpect(status().isOk());
    }

    @Test
    public void getImageByCodeSuccessWithNotFound() throws Exception {
        mvc.perform(get("/images/404"))
                .andExpect(status().isOk());
    }

    @Test
    public void getImageByCodeNotFound() throws Exception {
        mvc.perform(get("/images/10"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void getImageByCodeInternalServerErrorNotFound() throws Exception {
        mvc.perform(get("/images/0"))
                .andExpect(status().isNotFound());
    }

}
