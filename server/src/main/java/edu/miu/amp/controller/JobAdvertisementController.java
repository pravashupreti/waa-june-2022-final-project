package edu.miu.amp.controller;

import edu.miu.amp.dto.JobAdvertisementDto;
import edu.miu.amp.service.JobAdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("v1/api/job-advertisements")
@CrossOrigin
public class JobAdvertisementController {
    @Autowired
    private JobAdvertisementService jobAdvertisementService;

    @GetMapping
//    @RolesAllowed({"student", "faculty"})
    public ResponseEntity<List<JobAdvertisementDto>> findAll(){
        return new ResponseEntity<>(jobAdvertisementService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @RolesAllowed({"student", "faculty"})
    public ResponseEntity<JobAdvertisementDto> getById(@PathVariable Integer id){
        return new ResponseEntity<>(jobAdvertisementService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/last10Advertisements")
    public ResponseEntity<List<JobAdvertisementDto>> findLast10Advertisement(){
        return new ResponseEntity<>(jobAdvertisementService.findFirst10Advertisement(), HttpStatus.OK);
    }


    @PostMapping
    @RolesAllowed("student")
    public ResponseEntity<JobAdvertisementDto> create(@RequestBody JobAdvertisementDto jobAdvertisementDto){
        return new ResponseEntity<> (jobAdvertisementService.save(jobAdvertisementDto), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    @RolesAllowed("student")
    public ResponseEntity<JobAdvertisementDto> update(@RequestBody JobAdvertisementDto jobAdvertisementDto, @PathVariable Integer id){
        jobAdvertisementDto.setId(id);
        return new ResponseEntity<>(jobAdvertisementService.save(jobAdvertisementDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
//    @RolesAllowed("student")
    public void delete(@PathVariable Integer id){
        jobAdvertisementService.remove(id);
    }
}
