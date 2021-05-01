package com.lmarsden;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.lmarsden.controller.BaseController;

@WebMvcTest(BaseController.class)
public class BaseControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testGetIndexOkResponse() throws Exception {
        mvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("The current time is")));
    }

    @Test
    public void testGetSecretOkResponse() throws Exception {
        mvc.perform(get("/secret"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("You found the secret page!")));
    }
}
