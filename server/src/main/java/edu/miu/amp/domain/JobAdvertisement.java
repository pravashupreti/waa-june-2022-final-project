package edu.miu.amp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor@NoArgsConstructor
@SQLDelete(sql = "UPDATE JobAdvertisement SET delete = true where id = ?")
@Where(clause = "deleted=false")
public class JobAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;
    private String benefits;

    @Embedded
    private Address address;

    private String companyName;

    @ManyToMany
    private List<Tag> tags;

    @OneToMany
    private List<JobApplication> jobApplicationList;

    private boolean delete = Boolean.FALSE;
}
