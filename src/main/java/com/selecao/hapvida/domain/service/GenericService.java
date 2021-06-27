package com.selecao.hapvida.domain.service;

import org.springframework.data.domain.Page;

public interface GenericService<T> {

    Page<T> findAll(int page, int size);

    T findById(long id);

    T save(T entity);

    T update(T entityUpdated, long idEntityToUpdate);

    void delete(long id);
}
