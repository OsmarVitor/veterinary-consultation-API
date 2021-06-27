package com.selecao.hapvida.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "veterinary")
public class Veterinary extends BaseEntity{

    @Id
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "email", nullable = false)
    private String email;

    @OneToMany(mappedBy = "veterinary")
    private List<Consultation> consultation;


}
