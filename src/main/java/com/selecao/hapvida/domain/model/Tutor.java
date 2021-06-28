package com.selecao.hapvida.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity(name = "tutor")
@Builder(builderMethodName = "newBuilder")
public class Tutor extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "phone_number", nullable = false)
  @JsonProperty("phone_number")
  private String phoneNumber;

  @Column(name = "email", nullable = false)
  private String email;

  @OneToMany(mappedBy = "tutor")
  @JsonIgnore
  private List<Animal> animals;
}
