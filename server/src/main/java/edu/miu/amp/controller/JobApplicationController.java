package edu.miu.amp.controller;
import edu.miu.amp.dto.JobApplicationDto;
import edu.miu.amp.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/api/job-applications")
public class JobApplicationController {
    @Autowired
    private JobApplicationService jobApplicationService;

    @GetMapping
    public ResponseEntity<List<JobApplicationDto>> findAll(){
        return new ResponseEntity<>(jobApplicationService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobApplicationDto> getById(@PathVariable Integer id){
        return new ResponseEntity<>(jobApplicationService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<JobApplicationDto> create(@RequestBody JobApplicationDto jobApplicationDto){
        return new ResponseEntity<> (jobApplicationService.save(jobApplicationDto), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<JobApplicationDto> update(@RequestBody JobApplicationDto jobApplicationDto, @PathVariable Integer id){
        jobApplicationDto.setId(id);
        return new ResponseEntity<>(jobApplicationService.save(jobApplicationDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        jobApplicationService.remove(id);
    }
}
