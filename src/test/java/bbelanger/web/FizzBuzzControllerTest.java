package bbelanger.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(FizzBuzzController.class)
public class FizzBuzzControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void valueFifteenTest() throws Exception {
        this.mockMvc.perform(get("/fizzbuzz/15"))
        	.andExpect(status().isOk());
    }
    
    @Test
    public void integerOverflowTest() throws Exception {
        this.mockMvc.perform(get("/fizzbuzz/123123123123123123"))
        	.andExpect(status().isBadRequest());
    }
    
    @Test
    public void valueStringURLTest() throws Exception {
        this.mockMvc.perform(get("/fizzbuzz/152zzz"))
        	.andExpect(status().isBadRequest());
    }
}