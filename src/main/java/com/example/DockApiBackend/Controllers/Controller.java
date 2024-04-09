package com.example.DockApiBackend.Controllers;

import com.example.DockApiBackend.Modals.Dockapi;
import com.example.DockApiBackend.uploadrepository.UploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dockapi/v1")
public class Controller {

    @Autowired
    private UploadRepository uploadrepository;


    //======================post request===============
    @PostMapping("/add")
    public ResponseEntity<String> addUploads(@RequestBody Dockapi dockApi) {
        try {
            // Check if githubId already exists
            if (uploadrepository.existsByGithubId(dockApi.getGithubId())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("GitHub ID already exists");
            }

            // Save upload logic here
            uploadrepository.save(dockApi);

            return ResponseEntity.ok("Upload successful");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload. Exception: " + e.getMessage());
        }
    }

    //========================get by id==============
    @GetMapping("/get/{githubId}")
    public ResponseEntity<?> getByGithubId(@PathVariable int githubId) {
        try {
            // Find data by GitHub ID
            Dockapi dockapi = uploadrepository.findByGithubId(githubId);

            if (dockapi != null) {
                return ResponseEntity.ok(dockapi);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data not found for GitHub ID: " + githubId);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch data. Exception: " + e.getMessage());
        }
    }



//===========================get request=========================

    @GetMapping("/get")
    public ResponseEntity<?> getUploads(){
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(this.uploadrepository.findAll());
    }


//=========================delete request==================
    @DeleteMapping("/delete/{githubId}")
    public ResponseEntity<?> deleteByGithubId(@PathVariable int githubId) {
        try {
            // Check if data with the given GitHub ID exists
            if (uploadrepository.existsByGithubId(githubId)) {
                // Delete data by GitHub ID
                uploadrepository.deleteByGithubId(githubId);
                return ResponseEntity.ok("Data with GitHub ID " + githubId + " deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data not found for GitHub ID: " + githubId);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete data. Exception: " + e.getMessage());
        }
    }


//==============================put request===========================
    @PutMapping("/update/{githubId}")
    public ResponseEntity<?> updateByGithubId(@PathVariable int githubId, @RequestBody Dockapi updatedDockapi) {
        try {
            // Check if data with the given GitHub ID exists
            if (uploadrepository.existsByGithubId(githubId)) {
                // Update data by GitHub ID
                Dockapi existingDockapi = uploadrepository.findByGithubId(githubId);
                existingDockapi.setProjectName(updatedDockapi.getProjectName());
                existingDockapi.setDescription(updatedDockapi.getDescription());
                existingDockapi.setGithubLink(updatedDockapi.getGithubLink());
                existingDockapi.setDockerLink(updatedDockapi.getDockerLink());
                existingDockapi.setDockerCommand(updatedDockapi.getDockerCommand());
                existingDockapi.setEnvironmentalDetails(updatedDockapi.getEnvironmentalDetails());
                existingDockapi.setDocumentationLink(updatedDockapi.getDocumentationLink());
                existingDockapi.setEmail(updatedDockapi.getEmail());

                uploadrepository.save(existingDockapi);
                return ResponseEntity.ok("Data with GitHub ID " + githubId + " updated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data not found for GitHub ID: " + githubId);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update data. Exception: " + e.getMessage());
        }
    }
}
