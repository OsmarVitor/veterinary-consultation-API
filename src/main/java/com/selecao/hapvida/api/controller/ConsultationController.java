package com.selecao.hapvida.api.controller;

import com.selecao.hapvida.domain.model.Consultation;
import com.selecao.hapvida.domain.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultation")
public class ConsultationController {

  @Autowired GenericService<Consultation> consultationService;

  @GetMapping
  public ResponseEntity<Page<Consultation>> findAll(
      @RequestParam(value = "page", defaultValue = "0") int page,
      @RequestParam(value = "size", defaultValue = "15") int size) {
    return ResponseEntity.ok(consultationService.findAll(page, size));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Consultation> findById(@PathVariable long id) {
    Consultation consultation = consultationService.findById(id);
    return ResponseEntity.ok(consultation);
  }

  @PostMapping
  public ResponseEntity<Consultation> create(@RequestBody Consultation consultation) {
    Consultation consultationSaved = consultationService.save(consultation);
    return ResponseEntity.status(HttpStatus.CREATED).body(consultationSaved);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Consultation> update(
      @PathVariable long id, @RequestBody Consultation consultationUpdated) {
    consultationService.update(consultationUpdated, id);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Consultation> delete(@PathVariable long id) {
    consultationService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
