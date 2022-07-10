package edu.miu.amp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Department extends BaseEntity{

    private String departmentName;
    private Boolean delete = Boolean.FALSE;


}
