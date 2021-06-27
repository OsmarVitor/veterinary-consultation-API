package com.selecao.hapvida.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity(name = "animal")
public class Animal extends BaseEntity{

    @Id
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "breed", nullable = false)
    private String breed;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name="tutor_id", nullable = false)
    private Tutor tutor;

    @OneToMany(mappedBy = "animal")
    private List<Consultation> consultations;
}
