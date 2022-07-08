package edu.miu.amp.service.impl;

import edu.miu.amp.domain.JobAdvertisement;
import edu.miu.amp.dto.JobAdvertisementDto;
import edu.miu.amp.repository.JobAdvertisementRepository;
import edu.miu.amp.service.JobAdvertisementService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service @AllArgsConstructor
public class JobAdvertisementServiceImpl implements JobAdvertisementService {
    @Autowired
    private JobAdvertisementRepository jobAdvertisementRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<JobAdvertisementDto> findAll() {
        List<JobAdvertisement> jobAdvertisements = jobAdvertisementRepository.findAll();
        List<JobAdvertisementDto> jobAdvertisementsDto = jobAdvertisements.stream()
                .map(ja -> toDto(ja))
                .collect(Collectors.toList());
        return jobAdvertisementsDto;
    }



    @Override
    public JobAdvertisementDto save(JobAdvertisementDto jobAdvertisementDto) {
        JobAdvertisement jobAdvertisement = toEntity(jobAdvertisementDto);
        return toDto(jobAdvertisementRepository.save(jobAdvertisement));
    }

    @Override
    public JobAdvertisementDto findById(Integer id) {
        var jobAdvertisement = jobAdvertisementRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("JobAdvertisement with id %s does not exists", id)));
        JobAdvertisementDto jobAdvertisementDto = toDto(jobAdvertisement);
        return jobAdvertisementDto;
    }

    @Override
    public void remove(Integer id) {
        jobAdvertisementRepository.deleteById(id);

    }

    @Override
    public JobAdvertisementDto updateById(JobAdvertisementDto jobAdvertisementDto,Integer id) {
        JobAdvertisement jobAdvertisement = toEntity(jobAdvertisementDto);
        jobAdvertisementRepository.findById(id).map(jobAdvertisement1 -> {
            jobAdvertisement1.setAddress(jobAdvertisement.getAddress());
            jobAdvertisement1.setBenefits(jobAdvertisement.getBenefits());
            jobAdvertisement1.setDescription(jobAdvertisement.getDescription());
            jobAdvertisement1.setCompanyName(jobAdvertisement.getCompanyName());
            jobAdvertisement1.setJobApplicationList(jobAdvertisement.getJobApplicationList());
            jobAdvertisement1.setTags(jobAdvertisement.getTags());
            return jobAdvertisementRepository.save(jobAdvertisement);
        });
        return toDto(jobAdvertisement);
    }

    public JobAdvertisementDto toDto(JobAdvertisement jobAdvertisement){
        JobAdvertisementDto jobAdvertisementDto = modelMapper.map(jobAdvertisement, JobAdvertisementDto.class);
        return jobAdvertisementDto;
    }

    public JobAdvertisement toEntity(JobAdvertisementDto jobAdvertisementDto){
        JobAdvertisement jobAdvertisement = modelMapper.map(jobAdvertisementDto, JobAdvertisement.class);
        return jobAdvertisement;
    }
}
