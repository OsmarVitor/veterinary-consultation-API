package com.selecao.hapvida.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity(name = "animal")
public class Animal extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "breed", nullable = false)
  private String breed;

  @Column(name = "date", nullable = false)
  @JsonFormat(pattern = "dd-MM-yyyy")
  private LocalDate date;

  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "tutor_id", nullable = false)
  private Tutor tutor;

  @OneToMany(mappedBy = "animal")
  @JsonIgnore
  private List<Consultation> consultations;
}
