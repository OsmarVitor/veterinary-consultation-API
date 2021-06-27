package com.selecao.hapvida.domain.service.impl;

import com.selecao.hapvida.domain.exception.EntityNotFoundException;
import com.selecao.hapvida.domain.model.Tutor;
import com.selecao.hapvida.domain.repository.TutorRepository;
import com.selecao.hapvida.domain.service.GenericService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class TutorServiceImpl implements GenericService<Tutor> {

    @Autowired private TutorRepository tutorRepository;

    @Override
    public Page<Tutor> findAll(int page, int size) {
        return tutorRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Tutor findById(long id) {
        return findTutor(id);
    }

    @Override
    public Tutor save(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    @Override
    public Tutor update(Tutor tutorUpdated, long idTutorToUpdate) {
        Tutor tutorToUpdate = findTutor(idTutorToUpdate);
        BeanUtils.copyProperties(tutorUpdated, tutorToUpdate, "id");
        return tutorRepository.save(tutorToUpdate);
    }

    @Override
    public void delete(long id) {
        Tutor tutor = findTutor(id);
        tutorRepository.delete(tutor);
    }

    private Tutor findTutor(long id) {
        return tutorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }
}
