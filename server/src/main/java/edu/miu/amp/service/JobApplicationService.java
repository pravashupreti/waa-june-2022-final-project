package edu.miu.amp.service;

import edu.miu.amp.domain.JobApplication;
import edu.miu.amp.dto.JobApplicationDto;

import java.util.List;

public interface JobApplicationService {
    List<JobApplicationDto> findAll();

    JobApplicationDto save(JobApplicationDto jobApplicationDto);

    JobApplicationDto findById(Integer id);

    void remove(Integer id);

    JobApplicationDto updateById(JobApplicationDto jobApplicationDto, Integer id);

}
