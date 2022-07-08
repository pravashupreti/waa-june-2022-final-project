package edu.miu.amp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor@NoArgsConstructor
@SQLDelete(sql = "UPDATE Department SET delete = true where id = ?")
@Where(clause = "deleted=false")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String departmentName;
    private Boolean delete = Boolean.FALSE;





}
