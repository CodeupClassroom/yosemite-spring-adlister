package com.codeup.yadlister;

import com.codeup.yadlister.controllers.AdController;
import com.codeup.yadlister.models.Ad;
import com.codeup.yadlister.repositories.AdRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AdController.class)
public class AdControllerTests {

    @InjectMocks
    private AdController adController;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdRepository adRepository;

    // After the Ad is being created the controller responds with a redirect
    @Test
    public void testAddAdHappyPath() throws Exception {
        Ad newAd = new Ad();
        newAd.setTitle("MacBook");
        newAd.setDescription("like new");
        mockMvc.perform(post("/ads/create", newAd))
        .andExpect(status().isOk())
        .andExpect(redirectedUrl("/ads"));
    }

}
