package com.selecao.hapvida.domain.model;

import com.selecao.hapvida.domain.model.enums.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Getter
@Setter
@Entity(name = "consultation")
public class Consultation extends BaseEntity{

    @Id
    private long id;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name="animal_id", nullable = false)
    private Animal animal;

    @ManyToOne
    @JoinColumn(name="veterinary_id", nullable = false)
    private Veterinary veterinary;
}
