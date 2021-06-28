package com.selecao.hapvida.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.selecao.hapvida.domain.model.enums.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Getter
@Setter
@Entity(name = "consultation")
@Builder(builderMethodName = "newBuilder")
public class Consultation extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "date", nullable = false)
  @JsonFormat(pattern = "dd-MM-yyyy")
  private LocalDate date;

  @Enumerated(EnumType.STRING)
  private Status status;

  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "animal_id", nullable = false)
  private Animal animal;

  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "veterinary_id", nullable = false)
  private Veterinary veterinary;
}
