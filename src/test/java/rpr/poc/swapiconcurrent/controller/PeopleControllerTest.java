package rpr.poc.swapiconcurrent.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import rpr.poc.swapiconcurrent.fixtures.PeopleVoFixture;
import rpr.poc.swapiconcurrent.service.PeopleService;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Unit test for People Controller.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = PeopleController.class, secure = false)
public class PeopleControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PeopleService peopleService;

    private final String ENDPOINT_URL = "/application/api/people";

    @Test
    public void testFindAllSuccess() throws Exception {
        given(peopleService.findAll()).willReturn(PeopleVoFixture.getPeopleVoList(3));
        mvc.perform(get(ENDPOINT_URL)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().json(PeopleVoFixture.getPeopleJsonList(3)));
        verify(peopleService).findAll();
    }

}
