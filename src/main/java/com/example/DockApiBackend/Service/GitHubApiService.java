package com.example.DockApiBackend.Service;// GitHubApiService.java

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GitHubApiService {

    private static final String GITHUB_API_URL = "https://api.github.com/user";
    private static final String GITHUB_API_HEADER_AUTH = "Authorization";

    public boolean isValidGitHubToken(String token) {
        try {
            // Set the token in the request header
            HttpHeaders headers = new HttpHeaders();
            headers.set(GITHUB_API_HEADER_AUTH, "Bearer " + token);
            HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

            // Make a request to GitHub API
            ResponseEntity<String> response = getRestTemplate().exchange(GITHUB_API_URL, HttpMethod.GET, entity, String.class);

            // Check the response status
            return response.getStatusCode() == HttpStatus.OK;
        } catch (Exception e) {
            // Log the exception or handle it as needed
            e.printStackTrace();
            return false;
        }
    }

    private RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
