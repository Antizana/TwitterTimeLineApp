package com.edwincodex.twitter.timeline.controllers;

import com.edwincodex.twitter.timeline.dao.PortfolioDao;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PortfolioController.class)
public class PortfolioControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PortfolioDao portfolioDao;

    @Test
    public void testCalledWithNoProfileIdMustReturnMethodNotAllowed()  {
        RequestBuilder request = get("/profile/");
        String errorMessage = "Method Not Allowed";
        MvcResult result = null;
        try {
            result = mvc.perform(request).andReturn();
            assertEquals(errorMessage, result.getResponse().getContentAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCalledWithProfileId()  {
        try {
            mvc.perform(get("/profile/117"))
                    .andExpect(content().string("Aliquip consectetur"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
















