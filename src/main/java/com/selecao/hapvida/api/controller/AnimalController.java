package com.selecao.hapvida.api.controller;

import com.selecao.hapvida.domain.model.Animal;
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
@RequestMapping("/animal")
public class AnimalController {

  @Autowired private GenericService<Animal> animalService;

  @GetMapping
  public ResponseEntity<Page<Animal>> findAll(
      @RequestParam(value = "page", defaultValue = "0") int page,
      @RequestParam(value = "size", defaultValue = "15") int size) {
    return ResponseEntity.ok(animalService.findAll(page, size));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Animal> findById(@PathVariable long id) {
    Animal animal = animalService.findById(id);
    return ResponseEntity.ok(animal);
  }

  @PostMapping
  public ResponseEntity<Animal> create(@RequestBody Animal animal) {
    Animal animalSaved = animalService.save(animal);
    return ResponseEntity.status(HttpStatus.CREATED).body(animalSaved);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Animal> update(@PathVariable long id, @RequestBody Animal animalUpdated) {
    animalService.update(animalUpdated, id);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Animal> delete(@PathVariable long id) {
    animalService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
