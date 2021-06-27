package com.selecao.hapvida.domain.service;

import org.springframework.data.domain.Page;

public interface TutorService<T> {

    Page<T> findAll(int page, int size);

    T findById(long id);

    T save(T tutor);

    T update(T tutorUpdated, long idTutorToUpdate);

    void delete(long id);
}
