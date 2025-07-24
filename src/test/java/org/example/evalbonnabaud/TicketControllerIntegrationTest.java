package org.example.evalbonnabaud;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class TicketControllerIntegrationTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @BeforeEach
    void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    @WithMockUser(roles = "ADMINISTRATEUR")
    void resolveTicketAsAdmin_shouldReturn200() throws Exception {
        String ticketJson = """
                {
                    "id": 1,
                    "titre": "CICD",
                    "description": "Improve CICD Workflow",
                    "priorite": {
                        "id": 1,
                        "nom": "IMMEDIAT"
                    }
                }""";

        mvc.perform(put("/api/ticket/resolve/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(ticketJson))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "USER")
    void resolveTicketAsUser_shouldReturn403() throws Exception {
        String ticketJson = """
                {
                    "id": 1,
                    "titre": "CICD",
                    "description": "Improve CICD Workflow",
                    "priorite": {
                        "id": 1,
                        "nom": "IMMEDIAT"
                    }
                }""";

        mvc.perform(put("/api/ticket/resolve/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(ticketJson))
                .andExpect(status().isForbidden());
    }
}
