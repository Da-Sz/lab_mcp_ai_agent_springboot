package com.example.agent.web;

import com.example.agent.BacklogAgent;
import com.example.agent.mcp.McpHttpClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.Map;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AgentControllerIT {

    @Autowired
    WebTestClient web;

    @MockBean
    BacklogAgent backlogAgent;

    @Test
    void should_call_endpoint() {
        when(backlogAgent.handle(anyString()))
                .thenReturn("Issue created successfully: {number=1}");

        web.post().uri("/api/run")
                .contentType(MediaType.TEXT_PLAIN)
                .bodyValue("Create a task to add OpenTelemetry")
                .exchange()
                .expectStatus().isOk();
    }
}
