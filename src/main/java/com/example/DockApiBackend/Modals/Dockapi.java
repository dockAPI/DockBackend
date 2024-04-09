package com.example.DockApiBackend.Modals;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "dockapi")
@Data
public class Dockapi {
    private String projectName;
    private String description;


    private String githubLink;

    private String dockerLink;
    private String dockerCommand;
    private String environmentalDetails;
    private String documentationLink;

    @Id
    @Indexed(unique = true)
    private int githubId;
    private String email;
    public Dockapi(String projectName, String description,
                   String githubLink, String dockerLink,
                   String dockerCommand, String environmentalDetails,
                   String documentationLink,int githubId,String email) {
        this.projectName = projectName;
        this.description = description;
        this.githubLink = githubLink;
        this.dockerLink = dockerLink;
        this.dockerCommand = dockerCommand;
        this.environmentalDetails = environmentalDetails;
        this.documentationLink = documentationLink;
        this.githubId = githubId;
        this.email = email;
    }
}
