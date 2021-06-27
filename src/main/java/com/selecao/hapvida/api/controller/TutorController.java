package com.selecao.hapvida.api.controller;

import com.selecao.hapvida.domain.model.Tutor;
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
@RequestMapping("/tutor")
public class TutorController {

  @Autowired private GenericService<Tutor> tutorService;

  @GetMapping
  public ResponseEntity<Page<Tutor>> findAll(
      @RequestParam(value = "page", defaultValue = "0") int page,
      @RequestParam(value = "size", defaultValue = "15") int size) {
    return ResponseEntity.ok(tutorService.findAll(page, size));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Tutor> findById(@PathVariable long id) {
    Tutor tutor = tutorService.findById(id);
    return ResponseEntity.ok(tutor);
  }

  @PostMapping
  public ResponseEntity<Tutor> create(@RequestBody Tutor tutor) {
    Tutor tutorSaved = tutorService.save(tutor);
    return ResponseEntity.status(HttpStatus.CREATED).body(tutorSaved);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Tutor> update(@PathVariable long id, @RequestBody Tutor tutorUpdated) {
    tutorService.update(tutorUpdated, id);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Tutor> delete(@PathVariable long id) {
    tutorService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
