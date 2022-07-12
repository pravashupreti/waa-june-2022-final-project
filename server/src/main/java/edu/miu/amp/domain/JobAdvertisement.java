package edu.miu.amp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
//@SQLDelete(sql = "UPDATE job_advertisement SET delete = true where id = ?")
//@Where(clause = "deleted=false")
public class JobAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @Nullable
    @Column(columnDefinition = "text")

    private String description;

    @Nullable
    private String benefits;

    @Embedded
    @Nullable
    private Address address;

    private String companyName;

    @ManyToMany
    private List<Tag> tags;

    @ManyToOne
    @JoinColumn(name = "createdBy")
    private Student createdBy;

    @OneToMany(mappedBy = "jobAdvertisement")
    private List<JobApplication> jobApplicationList;

    @ColumnDefault("false")
    private boolean delete;
}
