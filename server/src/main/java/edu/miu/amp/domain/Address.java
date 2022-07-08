package edu.miu.amp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor@NoArgsConstructor
@Embeddable
public class Address {

    private String city;
    private String state;
    private String zip;
}
