package cz.kb.openbanking.adaa.notification_subscriber.rest.controller;

import cz.kb.openbanking.adaa.notification_subscriber.rest.configuration.RestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Tests for {@link EventsApiControllerTest}.
 *
 * @author <a href="mailto:michal_madle@kb.cz">Michal Madle</a>
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RestConfig.class)
@WebMvcTest(controllers = EventsApiController.class)
public class EventsApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Tests correct request with all required headers.
     * Expectation: HTTP 204 NO_CONTENT.
     *
     * @throws Exception the exception
     */
    @Test
    public void test200Ok() throws Exception {
        mockMvc
            .perform(post("/subscriptions/" + UUID.randomUUID() + "/events")
                .header("x-correlation-id", UUID.randomUUID().toString())
                .header("Accept-Language", "CZ")
                .characterEncoding(StandardCharsets.UTF_8.name())
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"eventCount\":1}")
            )
            .andDo(print())
            .andExpect(status().isNoContent());
    }

    /**
     * Tests request without required header 'x-correlation-id'.
     * Expectation: HTTP 400 BAD_REQUEST.
     *
     * @throws Exception the exception
     */
    @Test
    public void test400BadRequest() throws Exception {
        mockMvc
            .perform(post("/subscriptions/" + UUID.randomUUID() + "/events"))
            .andDo(print())
            .andExpect(status().isBadRequest());
    }
}
