package edu.miu.amp.service.impl;

import edu.miu.amp.domain.JobApplication;
import edu.miu.amp.dto.JobApplicationDto;
import edu.miu.amp.repository.JobApplicationRepository;
import edu.miu.amp.service.JobApplicationService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class JobApplicationServiceImpl implements JobApplicationService {
    @Autowired
    private JobApplicationRepository jobApplicationRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<JobApplicationDto> findAll() {
        List<JobApplication> jobApplications = jobApplicationRepository.findAll();
        List<JobApplicationDto> jobApplicationDtos = jobApplications.stream()
                .map(ja -> toDto(ja))
                .collect(Collectors.toList());
        return jobApplicationDtos;
    }



    @Override
    public JobApplicationDto save(JobApplicationDto jobApplicationDto) {
        JobApplication jobApplication = toEntity(jobApplicationDto);
        return toDto(jobApplicationRepository.save(jobApplication));
    }

    @Override
    public JobApplicationDto findById(Integer id) {
        var jobApplication = jobApplicationRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("JobApplication with id %s does not exists", id)));
        JobApplicationDto jobApplicationDto = toDto(jobApplication);
        return jobApplicationDto;
    }

    @Override
    public void remove(Integer id) {
        jobApplicationRepository.deleteById(id);

    }

    @Override
    public JobApplicationDto updateById(JobApplicationDto jobApplicationDto,Integer id) {
       JobApplication jobApplication = toEntity(jobApplicationDto);
       jobApplicationRepository.findById(id).map(jobApplication1 -> {
           jobApplication1.setJobAdvertisement(jobApplication.getJobAdvertisement());
           jobApplication1.setStudentList(jobApplication.getStudentList());
           return jobApplicationRepository.save(jobApplication);
       });
       return toDto(jobApplication);
    }

    public JobApplicationDto toDto(JobApplication jobApplication){
        JobApplicationDto jobApplicationDto = modelMapper.map(jobApplication, JobApplicationDto.class);
        return jobApplicationDto;
    }

    public JobApplication toEntity(JobApplicationDto jobApplicationDto){
        JobApplication jobApplication = modelMapper.map(jobApplicationDto, JobApplication.class);
        return jobApplication;
    }
}
