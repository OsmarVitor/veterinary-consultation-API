package com.selecao.hapvida.api.controller;

import com.selecao.hapvida.domain.model.Veterinary;
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
@RequestMapping("/veterinary")
public class VeterinaryController {

  @Autowired private GenericService<Veterinary> veterinaryService;

  @GetMapping
  public ResponseEntity<Page<Veterinary>> findAll(
      @RequestParam(value = "page", defaultValue = "0") int page,
      @RequestParam(value = "size", defaultValue = "15") int size) {
    return ResponseEntity.ok(veterinaryService.findAll(page, size));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Veterinary> findById(@PathVariable long id) {
    Veterinary veterinary = veterinaryService.findById(id);
    return ResponseEntity.ok(veterinary);
  }

  @PostMapping
  public ResponseEntity<Veterinary> create(@RequestBody Veterinary veterinary) {
    Veterinary veterinarySaved = veterinaryService.save(veterinary);
    return ResponseEntity.status(HttpStatus.CREATED).body(veterinarySaved);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Veterinary> update(
      @PathVariable long id, @RequestBody Veterinary veterinaryUpdated) {
    veterinaryService.update(veterinaryUpdated, id);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Veterinary> delete(@PathVariable long id) {
    veterinaryService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
