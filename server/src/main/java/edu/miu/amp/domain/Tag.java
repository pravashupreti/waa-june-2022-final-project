package edu.miu.amp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Tag extends BaseEntity {


    private String tagName;

    @ManyToMany
    private List<JobAdvertisement> jobAdvertisementList;
}
