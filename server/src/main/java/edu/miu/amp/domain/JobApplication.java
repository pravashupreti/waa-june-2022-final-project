package edu.miu.amp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Data @Entity
@AllArgsConstructor@NoArgsConstructor
@SQLDelete(sql = "UPDATE JobApplication SET delete = true where id = ?")
@Where(clause = "deleted=false")
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private JobAdvertisement jobAdvertisement;

    @ManyToMany
    private List<Student> studentList;

    private boolean deleted = Boolean.FALSE;

}
