package com.selecao.hapvida.domain.service.impl;

import com.selecao.hapvida.domain.exception.EntityNotFoundException;
import com.selecao.hapvida.domain.model.Animal;
import com.selecao.hapvida.domain.model.Tutor;
import com.selecao.hapvida.domain.repository.AnimalRepository;
import com.selecao.hapvida.domain.repository.TutorRepository;
import com.selecao.hapvida.domain.service.GenericService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class AnimalServiceImpl implements GenericService<Animal> {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private GenericService<Tutor> tutorService;


    @Override
    public Page<Animal> findAll(int page, int size) {
        return animalRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Animal findById(long id) {
        return findAnimal(id);
    }

    @Override
    public Animal save(Animal animal) {
        tutorService.findById(animal.getTutor().getId());
        return animalRepository.save(animal);
    }

    @Override
    public Animal update(Animal animalUpdated, long idAnimalToUpdate) {
        Animal animalToUpdate = findAnimal(idAnimalToUpdate);
        BeanUtils.copyProperties(animalUpdated, animalToUpdate, "id", "tutor");
        return animalRepository.save(animalToUpdate);
    }

    @Override
    public void delete(long id) {
        animalRepository.delete(findAnimal(id));
    }

    private Animal findAnimal(long id) {
        return animalRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }
}
