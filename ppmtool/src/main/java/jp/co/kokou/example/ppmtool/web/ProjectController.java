package jp.co.kokou.example.ppmtool.web;

import jp.co.kokou.example.ppmtool.domain.Project;
import jp.co.kokou.example.ppmtool.services.ProjectService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @NonNull
    private final ProjectService service;

    @Autowired
    public ProjectController(@NonNull ProjectService service) {
        this.service = service;
    }

    @RequestMapping("")
    public ResponseEntity<Project> createNewProject(@RequestBody Project project) {
        Project created = service.saveOrUpdate(project);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
}
