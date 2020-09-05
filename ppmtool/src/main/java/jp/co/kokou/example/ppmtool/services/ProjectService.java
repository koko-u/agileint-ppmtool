package jp.co.kokou.example.ppmtool.services;

import jp.co.kokou.example.ppmtool.domain.Project;
import jp.co.kokou.example.ppmtool.repository.ProjectRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @NonNull
    private final ProjectRepository repository;

    @Autowired
    public ProjectService(@NonNull ProjectRepository repository) {
        this.repository = repository;
    }

    public Project saveOrUpdate(@NonNull Project project) {
        return repository.save(project);
    }
}
