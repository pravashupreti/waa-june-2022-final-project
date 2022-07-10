package edu.miu.amp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Faculty extends User {
    @Id
    private UUID id;

    @ManyToOne
    private Department department;

    @OneToMany
    private List<Comment> commentList;


}
