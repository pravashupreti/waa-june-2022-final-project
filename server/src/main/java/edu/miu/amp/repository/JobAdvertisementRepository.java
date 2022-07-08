package edu.miu.amp.repository;

import edu.miu.amp.domain.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobAdvertisementRepository extends JpaRepository<JobAdvertisement, Integer> {
}
