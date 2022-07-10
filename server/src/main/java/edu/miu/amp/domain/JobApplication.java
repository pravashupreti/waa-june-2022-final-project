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
@AllArgsConstructor
@NoArgsConstructor

public class JobApplication extends BaseEntity{

    @ManyToOne
    private JobAdvertisement jobAdvertisement;

    @ManyToMany
    private List<Student> studentList;


}
