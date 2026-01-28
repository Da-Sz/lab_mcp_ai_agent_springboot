package com.example.agent.tools.github;

import com.example.agent.tools.AgentTool;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Component;

@Component
public class GitHubMcpTools implements AgentTool {
    @Tool("Retrieves a list of issues from the repository")
    public String getIssues(String query) {
        return "List of issues...";
    }

    @Tool("Creates a new issue in the repository")
    public void createIssue(String title, String body) {
    }
}