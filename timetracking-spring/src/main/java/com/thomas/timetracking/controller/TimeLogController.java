package com.thomas.timetracking.controller;

import com.thomas.timetracking.model.TimeLog;
import com.thomas.timetracking.repository.ProjectRepository;
import com.thomas.timetracking.repository.TimeLogRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/project/logs")
public class TimeLogController {

    private final TimeLogRepository timeLogRepository;
    private final ProjectRepository projectRepository;

    public TimeLogController(TimeLogRepository timeLogRepository, ProjectRepository projectRepository) {
        this.timeLogRepository = timeLogRepository;
        this.projectRepository = projectRepository;
    }


    @GetMapping("/{id}")
    public List<TimeLog> listLogs(@PathVariable Long id){
        return timeLogRepository.findAllByProjectId(id);

    }

    @PostMapping("/{id}/logtime")
    public Optional<TimeLog> createLog (@PathVariable Long id) {
        return projectRepository.findById(id).map(projectFound -> {
            TimeLog timelog = new TimeLog();
            timelog.setProject(projectFound);
            return timeLogRepository.save(timelog);
        });
    }
}
