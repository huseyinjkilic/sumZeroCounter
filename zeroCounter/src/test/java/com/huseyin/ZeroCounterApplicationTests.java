package com.huseyin;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ZeroCounterApplicationTests {
	
	@Autowired
	ApplicationContext ctx;

    @Autowired
    private MockMvc mvc;

    @Test
    public void getFour() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/data/3,-2,0,1,0,4,7,0,-3,2,-8,8").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("4")));
    }
    
    @Test
    public void getThree() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/data/3,-2,0,1,0,2,-3").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("3")));
    }
    
    @Test
    public void getZero() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/data/1,4,7,-3,2,-8").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("0")));
    }
    
    @Test
    public void getZeroForShortArray() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/data/0").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("0")));
    }
    
    @Test
    public void getOne() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/data/0,0,0").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("1")));
    }

}
